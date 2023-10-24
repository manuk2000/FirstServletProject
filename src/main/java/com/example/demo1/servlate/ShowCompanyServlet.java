package com.example.demo1.servlate;

import com.example.demo1.menagers.CompanyManager;
import com.example.demo1.model.Company;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/showCompany")
public class ShowCompanyServlet extends HttpServlet {
    private static final CompanyManager c = new CompanyManager();
    @Override
    protected void doGet(final HttpServletRequest req, final HttpServletResponse resp) throws ServletException, IOException {
        List<Company> all = c.getAll("");
        req.setAttribute("companys" , all);
        req.getRequestDispatcher("WEB-INF/showCompany.jsp").forward(req,resp);
    }
}
