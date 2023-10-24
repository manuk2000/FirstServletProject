package com.example.demo1.servlate;

import com.example.demo1.constants.Constants;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

@WebServlet("/getImage")
public class GetImageServlet extends HttpServlet {
    @Override
    protected void service(final HttpServletRequest req, final HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("image");
        if(name == null || name.equals("null")){
            name = Constants.DEFAULT_iMAGES + Constants.DEFAULT_PROFILE_IMAGE;
        }else {
            name = Constants.IMAGE_DIRECTORY_PATH + name;
        }
        File file = new File( name);

        if(file.exists()){
            try(FileInputStream inputStream = new FileInputStream( file)){

                resp.setContentType("image/jpeg");
                resp.setContentLength((int) file.length());

                ServletOutputStream outputStream = resp.getOutputStream();

                byte[] bytes = new byte[1024 * 4];
                int read = -1;

                while ((read = inputStream.read(bytes)) != -1){
                    outputStream.write(bytes,0 , read);
                }

            }catch (IOException e){
                e.printStackTrace();
            }
        }

    }
}
