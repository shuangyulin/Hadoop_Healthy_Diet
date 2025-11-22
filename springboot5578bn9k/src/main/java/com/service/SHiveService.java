package com.service;


import java.util.List;

public interface SHiveService {
    void createDatabase(String dbName) throws Exception;

    <T> void init(String dbName, String tableName, List<T> dataList) throws Exception;

    void value(String dbName, String tableName, String xColumnName, String timeType, String where, String... yColumnName) throws Exception;

    void group(String dbName, String tableName, String xColumnName, String where) throws Exception;
}

