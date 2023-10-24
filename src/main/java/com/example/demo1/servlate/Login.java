package com.example.demo1.servlate;

import com.example.demo1.menagers.UserManager;
import com.example.demo1.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/login")
public class Login extends HttpServlet {

    private static final UserManager u = new UserManager();

    @Override
    protected void doGet(final HttpServletRequest req, final HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("WEB-INF/login.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(final HttpServletRequest req, final HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String age = req.getParameter("age");
        if(email != null && age != null){
            User u1 = u.getByName(email);

            if(u1 != null){
                HttpSession session = req.getSession();
                session.setAttribute("user" , u1);
                req.getRequestDispatcher("WEB-INF/home.jsp").forward(req,resp);
                return;
            }
        }
        resp.sendRedirect("/login");
    }
}
