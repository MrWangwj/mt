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

@WebServlet(name = "LoginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 获取数据
        String phone = request.getParameter("phone");
        String password = request.getParameter("password");
        // 封装数据
        User user = new User();
        user.setPhone(phone);
        user.setPassword(password);
        // 处理数据
        UserService userService = new UserService();
        User u;
        try {
            u = userService.login(user);
            // 页面跳转
            if (u != null) {
                // 查询到,可以登录,同时将user信息存进session
                request.getSession().setAttribute("user", u);
                request.getRequestDispatcher("/IndexServlet").forward(request, response);
            } else {
                request.setAttribute("msg", "你输入的用户名或密码有误");
                request.getRequestDispatcher("/home/login/login.jsp").forward(request, response);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
