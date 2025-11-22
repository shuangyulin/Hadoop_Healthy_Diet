package com.config;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.sql.*;
import org.apache.spark.sql.types.DataTypes;
import org.apache.spark.sql.types.StructField;
import org.apache.spark.sql.types.StructType;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static org.apache.spark.sql.functions.sum;

@Component
public class SparkConfig implements Serializable {
    // 使用volatile关键字确保多线程环境下的可见性和有序性
    private static volatile SparkSession sparkSession = null;

    /**
     * 获取SparkSession实例，使用双重检查锁定模式实现单例
     *
     * @return SparkSession实例
     */
    public static SparkSession getSparkSession() {
        if (sparkSession == null) {
            synchronized (SparkSession.class) {
                if (sparkSession == null) {
                    SparkConf conf = new SparkConf().setAppName("mySpark").setMaster("spark://localhost:7077");
                    // 设置序列化方式为KryoSerializer
                    conf.set("spark.serializer", "org.apache.spark.serializer.KryoSerializer");
                    // 设置JVM内存，避免内存不足导致启动失败
                    conf.set("spark.testing.memory", "471859200");
                    sparkSession = SparkSession.builder().config(conf).getOrCreate();
                }
            }
        }
        return sparkSession;
    }

    /**
     * 将List<Map<String, Object>>数据转换为Dataset<Row>，并进行归集和统计
     *
     * @param dataList     原始数据列表
     * @param xColumnName  X轴列名
     * @param yColumnNames Y轴列名数组
     * @return 统计后的Dataset<Row>
     */
    public static Dataset<Row> value(List<Map<String, Object>> dataList, String xColumnName, String... yColumnNames) {
        // 获取SparkSession的JavaSparkContext
        JavaSparkContext sparkContext = new JavaSparkContext(getSparkSession().sparkContext());

        // 创建一个列表来存储所有的StructField
        List<StructField> fields = new ArrayList<>();
        // 为xColumnName添加StructField
        fields.add(DataTypes.createStructField(xColumnName, DataTypes.StringType, true));
        // 为yColumnNames中的每个列名添加StructField
        for (String yColumnName : yColumnNames) {
            fields.add(DataTypes.createStructField(yColumnName, DataTypes.IntegerType, true));
        }

        // 定义schema，根据传入的列名动态创建结构类型
        StructType schema = DataTypes.createStructType(fields);

        // 将List<Map<String, Object>>转换为List<Row>
        List<Row> rows = dataList.stream()
                .map(map -> {
                    // 创建一个对象数组，用于存储Row的值
                    Object[] values = new Object[1 + yColumnNames.length];
                    values[0] = map.get(xColumnName); // xColumnName的值

                    // 遍历yColumnNames，填充剩余的值
                    for (int i = 0; i < yColumnNames.length; i++) {
                        values[i + 1] = map.get(yColumnNames[i]); // yColumnNames的值
                    }

                    return RowFactory.create(values);
                })
                .collect(Collectors.toList());

        // 将List<Row>转换为JavaRDD<Row>
        JavaRDD<Row> rowRDD = sparkContext.parallelize(rows);

        // 将JavaRDD<Row>转换为Dataset<Row>
        Dataset<Row> dataDataset = getSparkSession().createDataFrame(rowRDD, schema);

        Column[] sumExprs = Arrays.stream(yColumnNames)
                .map(col -> sum(col).alias("sum_" + col))
                .toArray(Column[]::new);
        return dataDataset.groupBy(xColumnName).agg(sumExprs[0], Arrays.copyOfRange(sumExprs, 1, sumExprs.length));
    }


    /**
     * 将List<Map<String, Object>>数据转换为Dataset<Row>，并进行归集和统计
     *
     * @param dataList   原始数据列表
     * @param columnName 列名
     * @return 统计后的Dataset<Row>
     */
    public static Dataset<Row> group(List<Map<String, Object>> dataList, String columnName) {
        // 获取SparkSession的JavaSparkContext
        JavaSparkContext sparkContext = new JavaSparkContext(getSparkSession().sparkContext());

        // 创建一个列表来存储所有的StructField
        List<StructField> fields = new ArrayList<>();
        // 为columnName添加StructField
        fields.add(DataTypes.createStructField(columnName, DataTypes.StringType, true));

        // 定义schema，根据传入的列名动态创建结构类型
        StructType schema = DataTypes.createStructType(fields);

        // 将List<Map<String, Object>>转换为List<Row>
        List<Row> rows = dataList.stream()
                .map(map -> RowFactory.create(map.get(columnName)))
                .collect(Collectors.toList());

        // 将List<Row>转换为JavaRDD<Row>
        JavaRDD<Row> rowRDD = sparkContext.parallelize(rows);

        // 将JavaRDD<Row>转换为Dataset<Row>
        Dataset<Row> dataDataset = getSparkSession().createDataFrame(rowRDD, schema);

        return dataDataset.groupBy(columnName).count();
    }
}
