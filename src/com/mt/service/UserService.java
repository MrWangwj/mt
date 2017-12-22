package com.mt.service;

import com.mt.dao.UserDao;
import com.mt.model.User;

import java.sql.SQLException;

public class UserService {
    /**
     * 注册的方法
     * @param user
     * @return
     */
    public User login(User user) throws SQLException {
        UserDao userDao = new UserDao();
        return userDao.login(user);
    }

    public int addUser(User user) throws SQLException {
        UserDao userDao = new UserDao();
        return userDao.addUser(user);
    }
}
