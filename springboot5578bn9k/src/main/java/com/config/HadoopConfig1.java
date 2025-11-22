package com.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FSDataInputStream;
import org.apache.hadoop.fs.FileStatus;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.io.*;
import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * Hadoop配置类，用于提供Hadoop文件系统（HDFS）的操作方法
 * 包括获取Hadoop配置、文件系统对象，以及对HDFS文件的上传、下载和列出文件等功能
 */
@Component
public class HadoopConfig1 implements Serializable {

    // Hadoop集群的NameNode地址，用于连接到HDFS
    private static final String nameNode = "hdfs://localhost:9000";

    /**
     * 获取Hadoop配置对象
     *
     * @return Configuration Hadoop配置对象，设置了HDFS的默认FS、JobTracker等信息
     */
    public static Configuration getConfiguration() {
        Configuration conf = new Configuration();
        conf.set("dfs.replication", "1");
        conf.set("fs.defaultFS", nameNode);
        conf.set("mapred.job.tracker", nameNode);
        conf.set("dfs.client.use.datanode.hostname", "true");
        return conf;
    }

    /**
     * 获取Hadoop文件系统对象
     *
     * @return FileSystem Hadoop文件系统对象，用于操作HDFS
     * @throws Exception 如果获取文件系统对象时发生错误，则抛出异常
     */
    public static FileSystem getFileSystem() throws Exception {
        return FileSystem.get(new URI(nameNode), getConfiguration());
    }

    /**
     * 创建HDFS路径，并删除已存在的路径
     *
     * @param paths 路径组件数组，用于构建最终的路径
     * @return Path 创建的路径对象
     * @throws Exception 如果创建路径或删除已存在的路径时发生错误，则抛出异常
     */
    public static Path createPath(String... paths) throws Exception {
        StringBuilder sb = new StringBuilder();
        for (String path : paths) {
            sb.append("/").append(path);
        }
        Path path = new Path(sb.toString());
        FileSystem fs = getFileSystem();
        if (fs.exists(path)) {
            fs.delete(path, true);
        }
        return path;
    }

    /**
     * 将列表数据写入本地JSON文件
     *
     * @param list      要写入的数据列表
     * @param fileNames 文件名组件数组，用于构建最终的文件名
     * @throws IOException 如果写入文件时发生错误，则抛出IOException
     */
    public static void writeLocal(List<?> list, String... fileNames) throws IOException {
        if (!CollectionUtils.isEmpty(list)) {
            ObjectMapper mapper = new ObjectMapper();
            mapper.enable(SerializationFeature.INDENT_OUTPUT); // 可选，用于格式化输出
            String localJsonFilePath = System.getProperty("user.dir") + "/" + String.join("_", fileNames) + ".json";
            Files.deleteIfExists(Paths.get(localJsonFilePath));

            try (BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(localJsonFilePath), StandardCharsets.UTF_8))) {
                String jsonContent = mapper.writeValueAsString(list);
                writer.write(jsonContent);
            }
        }
    }

    /**
     * 将列表数据上传到HDFS
     *
     * @param list  要上传的数据列表
     * @param paths 路径组件数组，用于构建最终的HDFS路径
     * @return Path 上传后的文件路径
     * @throws Exception 如果上传文件时发生错误，则抛出异常
     */
    public static Path uploadHdfs(List<?> list, String... paths) throws Exception {
        FileSystem fs = getFileSystem();
        Path path = new Path("/" + String.join("/", paths));
        try {
            if (fs.exists(path)) {
                fs.delete(path, true); // 如果文件存在，则删除
            }
            try (BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(fs.create(path)))) {
                for (Object item : list) {
                    String line = convertToLine(item);
                    writer.write(line);
                    writer.newLine();
                }
            }
        } finally {
            fs.close(); // 确保文件系统资源被释放
            return path;
        }
    }

    /**
     * 从HDFS下载文件内容到内存中
     *
     * @param path HDFS文件路径
     * @return List<String> 文件内容的字符串列表，每行内容作为一个字符串元素
     * @throws Exception 如果下载文件内容时发生错误，则抛出异常
     */
    public static List<String> downloadHdfsFileContent(Path path) throws Exception {
        FileSystem fs = getFileSystem();
        List<String> results = new ArrayList<>();
        try (FSDataInputStream inputStream = fs.open(path);
             BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
            String line;
            while ((line = reader.readLine()) != null) {
                results.add(line);
            }
        } finally {
            fs.close();
        }
        return results;
    }

    /**
     * 从HDFS下载指定后缀的文件内容到内存中
     *
     * @param outputPath HDFS输出路径
     * @param endsWith   文件名后缀
     * @return List<String> 文件内容的字符串列表，每行内容作为一个字符串元素
     * @throws Exception 如果下载文件内容时发生错误，则抛出异常
     */
    public static List<String> downloadHdfsFilesContent(Path outputPath, String endsWith) throws Exception {
        // 获取 HDFS 文件列表
        List<String> files = listHdfsFiles(outputPath);
        if (files.isEmpty()) {
            return Collections.emptyList();
        }

        List<String> content = new ArrayList<>();
        for (String file : files) {
            if (file.endsWith(endsWith)) {
                content.addAll(downloadHdfsFileContent(new Path(file)));
            }
        }
        return content;
    }

    /**
     * 列出HDFS路径下的文件列表
     *
     * @param path HDFS路径
     * @return List<String> 文件路径的字符串列表
     * @throws Exception 如果列出文件时发生错误，则抛出异常
     */
    public static List<String> listHdfsFiles(Path path) throws Exception {
        Configuration conf = getConfiguration();
        FileSystem fs = FileSystem.get(conf);
        FileStatus[] fileStatuses = fs.listStatus(path);
        List<String> files = new ArrayList<>();
        for (FileStatus status : fileStatuses) {
            if (!status.isDirectory()) {
                files.add(status.getPath().toString());
            }
        }
        return files;
    }

    /**
     * 将对象转换为字符串行
     *
     * @param item 要转换的对象
     * @return String 转换后的字符串行
     * @throws IllegalArgumentException 如果列表项类型不支持，则抛出异常
     */
    private static String convertToLine(Object item) {
        if (item instanceof Map) {
            return convertMapToLine((Map<String, Object>) item);
        } else if (item instanceof List) {
            return convertListToLine((List<?>) item);
        }
        throw new IllegalArgumentException("不支持的列表项类型: " + item.getClass());
    }

    /**
     * 将Map对象转换为字符串行
     *
     * @param map 要转换的Map对象
     * @return String 转换后的字符串行
     */
    private static String convertMapToLine(Map<String, Object> map) {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            sb.append(entry.getKey()).append("=").append(entry.getValue()).append(",");
        }
        if (sb.length() > 0) {
            sb.setLength(sb.length() - 1); // 移除最后一个逗号
        }
        return sb.toString();
    }

    /**
     * 将List对象转换为字符串行
     *
     * @param list 要转换的List对象
     * @return String 转换后的字符串行
     * @throws IllegalArgumentException 如果列表中项类型不支持，则抛出异常
     */
    private static String convertListToLine(List<?> list) {
        StringBuilder sb = new StringBuilder();
        for (Object item : list) {
            if (item instanceof Map) {
                sb.append(convertMapToLine((Map<String, Object>) item)).append("\n");
            } else {
                throw new IllegalArgumentException("列表中不支持的项类型: " + item.getClass());
            }
        }
        if (sb.length() > 0) {
            sb.setLength(sb.length() - 1); // 移除最后一个换行符
        }
        return sb.toString();
    }
}
