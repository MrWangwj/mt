package com.mt.dao;

import com.mt.model.Good;
import com.mt.utils.JDBCUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class GoodDao {
    //表名称
    private String table = "goods";

    private QueryRunner query;

    public GoodDao(){
        this.query = new QueryRunner(JDBCUtils.getDataSource());
    }

    public List<Good> getGoodsByStoreId(int id) throws SQLException {
        String sql = "SELECT * FROM " + this.table + " WHERE store_id=?;";
        return this.query.query(sql, new BeanListHandler<Good>(Good.class), id);
    }
}
