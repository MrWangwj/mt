package com.mt.service;

import com.mt.dao.StoreDao;
import com.mt.model.Store;
import com.mt.model.User;

import java.sql.SQLException;
import java.util.List;

public class StoreService {

    StoreDao storeDao;

    public StoreService(){
        this.storeDao = new StoreDao();
    }

    public List<Store> getAllStore() throws SQLException {
        return  this.storeDao.getAllStore();
    }


    public Store findStore(int id) throws  SQLException{
        return this.storeDao.findStore(id);
    }

    public List<Store> getMyStore(User user) throws SQLException {
        return this.storeDao.getMyStore(user);
    }
}
