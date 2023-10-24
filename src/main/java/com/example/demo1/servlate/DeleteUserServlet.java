package com.example.demo1.servlate;

import com.example.demo1.menagers.CompanyManager;
import com.example.demo1.menagers.UserManager;
import com.example.demo1.model.Company;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/deleteUser")
public class DeleteUserServlet   extends HttpServlet {
    private static final CompanyManager c = new CompanyManager();
    private static final UserManager u = new UserManager();
    @Override
    protected void doGet(final HttpServletRequest req, final HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        List<Company> companysByUserId = c.getCompanysByUserId(id);
        for (Company company : companysByUserId) {
            c.deleteUserOfCompany(company);
        }
        u.deleteUserById(id);
        resp.sendRedirect("/allUsers");
    }
}
