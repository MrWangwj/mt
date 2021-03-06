package com.mt.servlet.store;

import com.mt.model.Store;
import com.mt.model.User;
import com.mt.service.StoreService;
import com.mt.utils.UpLoad;
import com.mt.utils.VenderUtils;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.fileupload.FileItem;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet(name = "SetEidtStoreServlet")
public class SetEidtStoreServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setHeader("Content-type", "text/html;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        request.setCharacterEncoding("UTF-8");
        try {
            User user = (User)request.getSession().getAttribute("user");

            int id = Integer.parseInt(request.getParameter("id"));

            StoreService storeService = new StoreService();

            Store store = storeService.findStore(id);

            if(user.getId() != store.getUser_id())
                throw  new Exception();

            System.out.println(request.getParameter("name"));
            store.setName(request.getParameter("name"));
            store.setLocation(request.getParameter("location"));
            store.setLocation(request.getParameter("phone"));

            storeService.updateStore(store);

            response.getWriter().write(VenderUtils.returnToJson(1, "修改成功", null));
        }catch (Exception e){
            e.printStackTrace();
            response.getWriter().write(VenderUtils.returnToJson(0, "修改失败", null));
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
