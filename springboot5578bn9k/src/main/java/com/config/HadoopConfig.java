package com.config;


import java.net.URI;

import org.apache.hadoop.fs.FileSystem;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * hadoop 配置
 */
@Configuration
@ConditionalOnProperty(name="hadoop.name-node")
public class HadoopConfig {

    @Value("${hadoop.name-node}")
    private String nameNode;
    
     /**
     * 配置
     */
    public org.apache.hadoop.conf.Configuration getConfiguration() {
        //读取配置文件
        org.apache.hadoop.conf.Configuration conf = new org.apache.hadoop.conf.Configuration();
        conf.set("dfs.replication", "1");
        conf.set("fs.defaultFS", nameNode);
        conf.set("mapred.job.tracker", nameNode);
        conf.set("dfs.client.use.datanode.hostname", "true");
        return conf;
    }

    /**
     * Configuration conf=new Configuration（）；
     * 创建一个Configuration对象时，其构造方法会默认加载hadoop中的两个配置文件，
     * 分别是hdfs-site.xml以及core-site.xml，这两个文件中会有访问hdfs所需的参数值，
     * 主要是fs.default.name，指定了hdfs的地址，有了这个地址客户端就可以通过这个地址访问hdfs了。
     * 即可理解为configuration就是hadoop中的配置信息。
     * @return
     */
    public FileSystem createFs() {
        try {
            URI uri = new URI(nameNode.trim());
            FileSystem fs = FileSystem.get(uri, this.getConfiguration(), "root");
            return fs;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
