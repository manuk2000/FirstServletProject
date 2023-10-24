package com.example.demo1.servlate;

import com.example.demo1.menagers.CompanyManager;
import com.example.demo1.menagers.UserManager;
import com.example.demo1.model.Company;
import com.example.demo1.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/updateCompany")
public class updateCompanyServlet extends HttpServlet {
    private static final CompanyManager c = new CompanyManager();
    private static final UserManager u = new UserManager();
    @Override
    protected void doGet(final HttpServletRequest req, final HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        Company company = c.getById(id);
        req.setAttribute("company",company);

        List<User> all = u.getAll();
        req.setAttribute("users" , all);

        req.getRequestDispatcher("WEB-INF/updateCompany.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(final HttpServletRequest req, final HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        int id = Integer.parseInt(req.getParameter("id"));
        int fild = Integer.parseInt(req.getParameter("fild"));
        int userId = Integer.parseInt(req.getParameter("userId"));

        Company company = new Company(id, name, fild, u.getById(userId));
        c.update(company);
        resp.sendRedirect("/showCompany");
    }
}
