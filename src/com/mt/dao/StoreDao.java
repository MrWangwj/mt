package com.mt.dao;

import com.mt.model.Store;
import com.mt.model.User;
import com.mt.utils.JDBCUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class StoreDao {

    //表名称
    private String table = "stores";

    private QueryRunner query;

    public StoreDao(){
        this.query = new QueryRunner(JDBCUtils.getDataSource());
    }


    /*
     * @return 返回所有店铺
     * @throws SQLException
     */
    public List<Store> getAllStore() throws SQLException {
        String sql = "SELECT * FROM "+this.table;
        return this.query.query(sql, new BeanListHandler<Store>(Store.class));
    }

    /*
     * @param id  通过id获取店铺
     * @return
     * @throws SQLException
     */
    public Store findStore(int id) throws SQLException {
        String sql = "SELECT * FROM "+ this.table+" WHERE id=?;";
        return this.query.query(sql, new BeanHandler<Store>(Store.class), id);
    }

    public List<Store> getMyStore(User user) throws SQLException {
        String sql = "select * from " + this.table + " where user_id = ?";
        return this.query.query(sql, new BeanListHandler<Store>(Store.class), user.getId());
    }

    public void save(Store store) throws SQLException{
        String sql = "insert into " + this.table + " (user_id, name, location, phone, image, created_at) values (?,?,?,?,?,?);";
        Object[] params = {
                store.getUser_id(),
                store.getName(),
                store.getLocation(),
                store.getPhone(),
                store.getImage(),
                store.getCreated_at()
        };
        this.query.update(sql, params);
    }

    public void deleteStoreById(int id) throws  SQLException{
        String sql = "delete from "+ this.table+ " where id=?";
        this.query.update(sql, id);
    }

    public void updateStore(Store store) throws  SQLException{
        String sql = "update " + this.table + " set name=?,location=?,phone=? where id=?";
        Object[] params = {
                store.getName(),
                store.getLocation(),
                store.getPhone(),
                store.getId(),
        };
        this.query.update(sql, params);
    }
}
