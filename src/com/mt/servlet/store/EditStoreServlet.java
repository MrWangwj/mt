package com.mt.servlet.store;

import com.mt.model.Store;
import com.mt.model.User;
import com.mt.service.StoreService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class EditStoreServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {

            User user =(User)request.getSession().getAttribute("user");

            int id = Integer.parseInt(request.getParameter("id"));

            StoreService storeService = new StoreService();
            Store store = storeService.findStore(id);

            if (store.getUser_id() != user.getId())
                throw new Exception();

            request.setAttribute("store", store);
            request.getRequestDispatcher("/home/store/edit.jsp").forward(request, response);

        }catch (Exception e){
            e.printStackTrace();
            request.getRequestDispatcher("/home/error.jsp").forward(request, response);
        }
    }
}
