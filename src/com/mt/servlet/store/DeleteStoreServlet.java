package com.mt.servlet.store;

import com.mt.model.Store;
import com.mt.model.User;
import com.mt.service.StoreService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DeleteStoreServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try{
            User user = (User)request.getSession().getAttribute("user");

            int id = Integer.parseInt(request.getParameter("id"));

            StoreService storeService = new StoreService();

            Store store = storeService.findStore(id);

            if(user.getId() != store.getUser_id())
                throw  new Exception();

            storeService.deleteStoreById(id);

            request.getRequestDispatcher("/get/myStore?id="+user.getId()).forward(request, response);
        }catch (Exception e){
            e.printStackTrace();
            request.getRequestDispatcher("/home/error.jsp").forward(request,response);
        }

    }
}
