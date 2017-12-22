package com.mt.dao;

import com.mt.model.User;
import com.mt.utils.JDBCUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.sql.SQLException;

public class UserDao {

    public User login(User user) throws SQLException {
        QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
        String sql = "select * from users where phone = ? and password = ?";
        Object[] params = {
                user.getPhone(),
                user.getPassword()
        };
        User u = queryRunner.query(sql, new BeanHandler<User>(User.class), params);
        return u;
    }

    public int addUser(User user) throws SQLException {
        QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
        String sql = "insert into users (name, phone, sex, email, password) values (?,?,?,?,?)";
        Object[] params = {
                user.getName(),
                user.getPhone(),
                user.getSex(),
                user.getEmail(),
                user.getPassword()
        };
        return queryRunner.update(sql, params);
    }
}
