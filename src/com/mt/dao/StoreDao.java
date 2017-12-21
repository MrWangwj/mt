package com.mt.dao;

import com.mt.model.Store;
import com.mt.utils.JDBCUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class StoreDao {

    //表名称
    private String table = "stores";

    /*
     * @return 返回所有店铺
     * @throws SQLException
     */
    public List<Store> getAllStore() throws SQLException {
        QueryRunner query = new QueryRunner(JDBCUtils.getDataSource());
        String sql = "SELECT * FROM "+this.table;
        return query.query(sql, new BeanListHandler<Store>(Store.class));
    }
}
