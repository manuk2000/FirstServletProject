package com.example.demo1.filtre;

import com.example.demo1.model.User;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(urlPatterns = {"/createCompany",  "/deleteCompany", "/deleteUser", "/showCompany", "/allUsers", "/updateCompany", "/updateuser"})
public class AuthFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;

        User user = (User) req.getSession().getAttribute("user");

        if (user == null) {
            resp.sendRedirect("/");
        }else {
            filterChain.doFilter(servletRequest, servletResponse);
        }
    }
}
