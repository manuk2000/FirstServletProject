package com.example.demo1.servlate;

import com.example.demo1.menagers.UserManager;
import com.example.demo1.model.User;

import javax.servlet.Servlet;
import javax.servlet.ServletContextListener;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/updateuser")
public class UpdateUserServlet extends HttpServlet {
    public static final UserManager u = new UserManager();

    @Override
    protected void doGet(final HttpServletRequest req, final HttpServletResponse resp) throws ServletException, IOException {
        int i = Integer.parseInt(req.getParameter("id"));
        User user= u.getById(i);
        req.setAttribute("user" ,user );
        req.getRequestDispatcher("WEB-INF/updateUser.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(final HttpServletRequest req, final HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        int id = Integer.parseInt(req.getParameter("id"));

        int age = Integer.parseInt(req.getParameter("age"));
        String imageName = req.getParameter("imageName");
        u.update(new User(id,name , age,imageName));
        resp.sendRedirect("/allUsers");
    }
}
