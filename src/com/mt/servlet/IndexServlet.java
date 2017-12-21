package com.mt.servlet;

import com.mt.model.Store;
import com.mt.service.StoreService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "IndexServlet")
public class IndexServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        StoreService storeService = new StoreService();
        List<Store> list = null;
        try {
            list = storeService.getAllStore();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("产品查询错误");
        }

        request.setAttribute("list", list);
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }
}
