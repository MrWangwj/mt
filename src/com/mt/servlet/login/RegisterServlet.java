package com.mt.servlet.login;

import com.mt.model.User;
import com.mt.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "RegisterServlet")
public class RegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        // 获取数据
        String name = request.getParameter("name");
        String sex = request.getParameter("sex");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        // 封装数据
        User user = new User();
        user.setName(name);
        user.setSex(sex);
        user.setPhone(phone);
        user.setEmail(email);
        user.setPassword(password);
        //
        UserService userService = new UserService();
        int i;
        try {
            i = userService.addUser(user);
            response.getWriter().write(i);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
