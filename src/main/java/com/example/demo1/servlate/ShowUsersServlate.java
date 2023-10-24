package com.example.demo1.servlate;

import com.example.demo1.menagers.UserManager;
import com.example.demo1.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/allUsers")
public class ShowUsersServlate extends HttpServlet {
    private final UserManager u = new UserManager();

    @Override
    protected void doGet(final HttpServletRequest req, final HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("keyword");
        List<User> users = null;
        if (name != null ) {
            users = u.searchByName(name);
            req.setAttribute("keyword" , name);
        } else {
            req.setAttribute("keyword" , " ");
            users = u.getAll();
        }
        req.setAttribute("users", users);
        req.getRequestDispatcher("WEB-INF/ShowUsers.jsp").forward(req, resp);
    }
}
