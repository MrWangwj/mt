package com.mt.service;

import com.mt.dao.GoodDao;
import com.mt.model.Good;

import java.sql.SQLException;
import java.util.List;

public class GoodService {
    GoodDao goodDao;

    public GoodService(){
        this.goodDao = new GoodDao();
    }

    public List<Good> getGoodsByStoreId(int id) throws SQLException{
        return this.goodDao.getGoodsByStoreId(id);
    }
}
