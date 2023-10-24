package com.example.demo1.servlate;

import com.example.demo1.menagers.CompanyManager;
import com.example.demo1.model.Company;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/deleteCompany")
public class deleteCompanyServlet extends HttpServlet {
private static final CompanyManager c = new CompanyManager();
    @Override
    protected void doGet(final HttpServletRequest req, final HttpServletResponse resp) throws ServletException, IOException {
        int companyId = Integer.parseInt(req.getParameter("id"));
        Company company = c.getById(companyId);
        company.setUserID(null);
        c.update(company);
        c.deleteCompanyById(companyId);

        resp.sendRedirect("/showCompany");
    }

}
