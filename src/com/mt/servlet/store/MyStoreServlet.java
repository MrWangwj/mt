package com.mt.servlet.store;

import com.mt.model.Store;
import com.mt.model.User;
import com.mt.service.StoreService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "MyStoreServlet")
public class MyStoreServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 获取数据
        int id = Integer.parseInt(request.getParameter("id"));
        // 封装数据
        User user = new User();
        user.setId(id);
        // 处理数据
        StoreService storeService = new StoreService();
        // 存储我的所有店铺
        List<Store> stores = null;

        try {
            stores = storeService.getMyStore(user);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        request.setAttribute("stores", stores);
        request.getRequestDispatcher("/home/store/my.jsp").forward(request, response);
    }
}
