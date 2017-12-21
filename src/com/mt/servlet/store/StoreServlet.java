package com.mt.servlet.store;

import com.mt.model.Good;
import com.mt.model.Store;
import com.mt.service.GoodService;
import com.mt.service.StoreService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class StoreServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));

        StoreService storeService = new StoreService();
        GoodService goodService = new GoodService();


        //获取店铺
        Store store = null;
        //获取店铺产品
        List<Good> goods = null;

        try {

            store = storeService.findStore(id);
            goods = goodService.getGoodsByStoreId(id);

        } catch (SQLException e) {
            e.printStackTrace();
        }

        request.setAttribute("store", store);
        request.setAttribute("goods", goods);
        request.getRequestDispatcher("/home/store/store.jsp").forward(request, response);
    }
}
