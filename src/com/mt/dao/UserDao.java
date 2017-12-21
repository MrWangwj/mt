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
}
