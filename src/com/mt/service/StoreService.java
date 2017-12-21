package com.mt.service;

import com.mt.dao.StoreDao;
import com.mt.model.Store;

import java.sql.SQLException;
import java.util.List;

public class StoreService {

    public List<Store> getAllStore() throws SQLException {
        StoreDao storedao = new StoreDao();
        return  storedao.getAllStore();
    }

}
