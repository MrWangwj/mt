package com.mt.utils;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class UpLoad {
    ServletFileUpload fileUpload;


    //获取磁盘文件项
    public ServletFileUpload getFileUpload() {
        fileUpload = new ServletFileUpload(new DiskFileItemFactory());
        fileUpload.setHeaderEncoding("UTF-8");
        return fileUpload;
    }

    public String[] uploadFile(FileItem fileItem, String path){
        String[] data = {"1","上传成功"};

        try{
            //上传项
            InputStream is = fileItem.getInputStream();
            System.out.println(path);
            // 获得文件要上传的路径:
            OutputStream os = new FileOutputStream(path);//cs.jpg

            byte[] byts = new byte[1024];
            int len = 0;
            while ( (len = is.read(byts)) != -1 ) {
                os.write(byts, 0, len);
                os.flush();
            }
            is.close();
            os.close();
        }catch (Exception e){
            e.printStackTrace();
            data[0] = "0";
            data[1] = "上传失败";
        }
        return data;
    }
}
