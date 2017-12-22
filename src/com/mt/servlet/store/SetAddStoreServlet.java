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

@WebServlet(name = "SerAddStoreServlet")
public class SetAddStoreServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

//        response.setHeader("Content-type", "text/html;charset=UTF-8");
//        response.setCharacterEncoding("UTF-8");

        User user =(User)request.getSession().getAttribute("user");
        try {
            Store store = new Store();

            UpLoad upLoad = new UpLoad();
            String fileNewName = "";
            List<FileItem> list = upLoad.getFileUpload().parseRequest(request);

            Map<String, String> map = new HashMap<String, String>();


            for (FileItem fileItem : list){
                if (fileItem.isFormField()){
                    map.put(fileItem.getFieldName(), fileItem.getString("UTF-8"));
                }else{
                    String fileName = fileItem.getName();

                    fileNewName = System.currentTimeMillis()+"-"
                            + (int)(Math.random()*1000)
                            + fileName.substring(fileName.lastIndexOf("."));

                    String path = this.getServletContext().getRealPath("/upload/image")

                            + "/" + fileNewName;
                    String[] data =  upLoad.uploadFile(fileItem, path);

                    if(data[0].equals("0"))
                        throw  new Exception();
                }
            }

            BeanUtils.populate(store, map);
            store.setImage("/upload/image/"+fileNewName);
            store.setCreated_at(System.currentTimeMillis());
            store.setUser_id(user.getId());


            StoreService storeService = new StoreService();
            storeService.save(store);


            request.getRequestDispatcher("/get/myStore?id="+user.getId()).forward(request, response);
        }catch (Exception e){
            e.printStackTrace();
            request.getRequestDispatcher("/home/error.jsp").forward(request, response);
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
