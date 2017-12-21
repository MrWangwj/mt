package com.mt.utils;

import java.sql.Connection;
import java.sql.SQLException;
import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class JDBCUtils {

    private static final ComboPooledDataSource DATA_SOURCE = new ComboPooledDataSource();
    /**
     * 获得连接的方法
     */
    public static Connection getConnection(){
        Connection conn = null;
        try {
            conn = DATA_SOURCE.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

    public static DataSource getDataSource() {
        return DATA_SOURCE;
    }
}
