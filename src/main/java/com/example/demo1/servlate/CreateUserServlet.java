package com.example.demo1.servlate;

import com.example.demo1.constants.Constants;
import com.example.demo1.menagers.UserManager;
import com.example.demo1.model.User;
import com.google.protobuf.ExperimentalApi;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;

@WebServlet("/createUser")
@MultipartConfig(maxFileSize = 1024 * 1024 * 10,
                    maxRequestSize = 1024 * 1024 * 20,
                        fileSizeThreshold = 1024 * 1024 * 2)
public class CreateUserServlet extends HttpServlet {
    public static final UserManager u = new UserManager();
    @Override
    protected void doGet(final HttpServletRequest req, final HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("WEB-INF/createUser.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(final HttpServletRequest req, final HttpServletResponse resp) throws ServletException, IOException {
        try {
            String name = req.getParameter("name");
            int age = Integer.parseInt(req.getParameter("age"));
            Part image = req.getPart("image");
            String imageName = null;
            if (image.getSubmittedFileName().length() > 0) {
                imageName = System.nanoTime() + image.getSubmittedFileName();
                image.write(Constants.IMAGE_DIRECTORY_PATH + imageName);
            }
            u.create(new User(name, age, imageName));
        }catch (Exception e) {
            e.printStackTrace();
        }
        resp.sendRedirect("/createUser");
    }
}
