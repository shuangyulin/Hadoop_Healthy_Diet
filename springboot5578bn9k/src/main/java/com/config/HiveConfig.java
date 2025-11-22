package com.config;

import org.apache.commons.lang3.StringUtils;

import java.sql.*;
import java.util.*;
import java.util.Date;

public class HiveConfig {

    // 提取数据库连接信息到配置文件或常量类中
    private static final String JDBC_URL = "jdbc:hive2://localhost:10000/default";
    private static final String USER = "root";
    private static final String PASSWORD = "123456";

    /**
     * 根据xColumnName和yColumnNames创建外部表，并插入数据
     *
     * @param dataList     原始数据列表
     * @param tableName    表名
     * @param xColumnName  X轴列名
     * @param yColumnNames Y轴列名数组
     * @throws SQLException           如果 SQL 执行失败
     * @throws ClassNotFoundException 如果驱动加载失败
     */
    public static void createExternalTable(List<Map<String, Object>> dataList, String tableName, String xColumnName, String... yColumnNames) throws SQLException, ClassNotFoundException {
        // 参数校验
        if (dataList == null || dataList.isEmpty()) {
            throw new IllegalArgumentException("dataList不能为空");
        }
        if (StringUtils.isBlank(tableName)) {
            throw new IllegalArgumentException("tableName不能为空");
        }
        if (StringUtils.isBlank(xColumnName)) {
            throw new IllegalArgumentException("xColumnName不能为空");
        }

        // 定义硬编码的SQL片段为常量
        final String CREATE_EXTERNAL_TABLE_TEMPLATE = "CREATE EXTERNAL TABLE IF NOT EXISTS %s (%s) LOCATION '%s'";

        // 构建SQL语句
        StringBuilder columnDefinitions = new StringBuilder();
        columnDefinitions.append(validateColumnName(xColumnName)).append(" STRING");
        for (String yColumnName : yColumnNames) {
            if (StringUtils.isBlank(yColumnName)) {
                continue; // 跳过空的Y轴列名
            }
            String columnType = determineColumnType(dataList, yColumnName);
            columnDefinitions.append(", ").append(validateColumnName(yColumnName)).append(" ").append(columnType);
        }

        // 添加存储路径
        String tableLocation = "/user/hive/warehouse/" + tableName;
        String sql = String.format(CREATE_EXTERNAL_TABLE_TEMPLATE, validateTableName(tableName), columnDefinitions, tableLocation);

        try (Connection conn = getConnection(); Statement stmt = conn.createStatement()) {
            stmt.execute("DROP TABLE IF EXISTS " + tableName);
            stmt.execute(sql);
            insertDataIntoTable(conn, dataList, tableName, xColumnName, yColumnNames);
        } catch (SQLException e) {
            // 增强异常日志，包含完整的SQL语句
            throw new SQLException(String.format("创建外部表失败: 表名=%s, SQL=%s, 错误信息=%s", tableName, sql, e.getMessage()), e);
        }
    }

    /**
     * 插入数据到表中
     *
     * @param conn         数据库连接
     * @param dataList     原始数据列表
     * @param tableName    表名
     * @param xColumnName  X轴列名
     * @param yColumnNames Y轴列名数组
     * @throws SQLException 如果 SQL 执行失败
     */
    private static void insertDataIntoTable(Connection conn, List<Map<String, Object>> dataList, String tableName, String xColumnName, String... yColumnNames) throws SQLException {
        StringBuilder insertColumns = new StringBuilder();
        insertColumns.append(validateColumnName(xColumnName));
        for (String yColumnName : yColumnNames) {
            if (StringUtils.isBlank(yColumnName)) {
                continue; // 跳过空的Y轴列名
            }
            insertColumns.append(", ").append(validateColumnName(yColumnName));
        }

        StringBuilder placeholders = new StringBuilder();
        placeholders.append("?");
        for (int i = 1; i < yColumnNames.length + 1; i++) {
            placeholders.append(", ?");
        }

        String sql = String.format("INSERT INTO %s (%s) VALUES (%s)", validateTableName(tableName), insertColumns, placeholders);

        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            for (Map<String, Object> data : dataList) {
                int index = 1;
                pstmt.setString(index++, (String) data.get(xColumnName));
                for (String yColumnName : yColumnNames) {
                    if (StringUtils.isBlank(yColumnName)) {
                        continue; // 跳过空的Y轴列名
                    }
                    Object value = data.get(yColumnName);
                    if (value instanceof Number) {
                        pstmt.setDouble(index++, ((Number) value).doubleValue());
                    } else {
                        pstmt.setString(index++, value == null ? null : value.toString());
                    }
                }
                pstmt.executeUpdate(); // 使用 executeUpdate 替代 addBatch
            }
        }
    }

    /**
     * 确定列的数据类型
     *
     * @param dataList   原始数据列表
     * @param columnName 列名
     * @return 列的数据类型
     */
    private static String determineColumnType(List<Map<String, Object>> dataList, String columnName) {
        for (Map<String, Object> data : dataList) {
            Object value = data.get(columnName);
            if (value instanceof Number) {
                return "DOUBLE";
            } else if (value instanceof Boolean) {
                return "BOOLEAN";
            } else if (value instanceof Date) {
                return "TIMESTAMP";
            }
        }
        return "STRING"; // 默认为字符串类型
    }

    /**
     * 执行分组查询
     *
     * @param tableName    表名
     * @param xColumnName  X轴列名
     * @param yColumnNames Y轴列名数组
     * @return 查询结果列表
     * @throws SQLException           如果 SQL 执行失败
     * @throws ClassNotFoundException 如果驱动加载失败
     */
    public static List<Map<String, Object>> executeQueryValue(String tableName, String xColumnName, String... yColumnNames) throws SQLException {
        // 输入校验
        if (tableName == null || tableName.trim().isEmpty()) {
            throw new IllegalArgumentException("表名不能为空");
        }
        if (xColumnName == null || xColumnName.trim().isEmpty()) {
            throw new IllegalArgumentException("X轴列名不能为空");
        }
        if (yColumnNames == null || yColumnNames.length == 0) {
            throw new IllegalArgumentException("至少需要一个Y轴列名");
        }

        List<Map<String, Object>> resultList = new ArrayList<>();

        // 构建SQL语句
        StringBuilder columnDefinitions = new StringBuilder();
        for (String yColumnName : yColumnNames) {
            if (yColumnName == null || yColumnName.trim().isEmpty()) {
                continue; // 跳过空的Y轴列名
            }
            if (columnDefinitions.length() > 0) {
                columnDefinitions.append(",");
            }
            columnDefinitions.append("SUM(").append(validateColumnName(yColumnName)).append(") AS ").append(validateColumnName(yColumnName));
        }

        if (columnDefinitions.length() == 0) {
            throw new IllegalArgumentException("有效的Y轴列名不能为空");
        }

        String query = String.format("SELECT %s, %s FROM %s GROUP BY %s",
                validateColumnName(xColumnName),
                columnDefinitions.toString(),
                validateTableName(tableName),
                validateColumnName(xColumnName));

        try (Connection conn = getConnection(); Statement stmt = conn.createStatement()) {
            ResultSet rs = stmt.executeQuery(query);
            // 处理查询结果
            while (rs.next()) {
                Map<String, Object> rowMap = new HashMap<>();
                rowMap.put(xColumnName, rs.getObject(xColumnName));
                for (String yColumnName : yColumnNames) {
                    if (yColumnName != null && !yColumnName.trim().isEmpty()) {
                        rowMap.put(yColumnName, rs.getObject(yColumnName));
                    }
                }
                resultList.add(rowMap);
            }
        } catch (SQLException e) {
            // 记录异常日志
            System.err.println("SQL 执行失败: " + e.getMessage());
            throw new SQLException("执行分组查询失败: " + e.getMessage(), e);
        } catch (ClassNotFoundException e) {
            // 记录异常日志
            System.err.println("驱动加载失败: " + e.getMessage());
            throw new SQLException("执行分组查询失败: " + e.getMessage(), e);
        }

        return resultList;
    }

    /**
     * 验证表名合法性
     *
     * @param tableName 表名
     * @return 合法的表名
     * @throws IllegalArgumentException 如果表名非法
     */
    private static String validateTableName(String tableName) {
        if (!tableName.matches("[a-zA-Z_][a-zA-Z0-9_]*")) {
            throw new IllegalArgumentException("非法表名: " + tableName);
        }
        return tableName;
    }

    /**
     * 验证列名合法性
     *
     * @param columnName 列名
     * @return 合法的列名
     * @throws IllegalArgumentException 如果列名非法
     */
    private static String validateColumnName(String columnName) {
        if (!columnName.matches("[a-zA-Z_][a-zA-Z0-9_]*")) {
            throw new IllegalArgumentException("非法列名: " + columnName);
        }
        return columnName;
    }

    /**
     * 获取数据库连接
     *
     * @return 数据库连接对象
     * @throws SQLException           如果连接失败
     * @throws ClassNotFoundException 如果驱动加载失败
     */
    private static Connection getConnection() throws SQLException, ClassNotFoundException {
        Class.forName("org.apache.hive.jdbc.HiveDriver");
        Properties properties = new Properties();
        properties.setProperty("user", USER);
        properties.setProperty("password", PASSWORD);
        return DriverManager.getConnection(JDBC_URL, properties);
    }
}
