<%@ page import="com.example.demo1.model.Company" %>
<%@ page import="java.util.List" %>
<%@ page import="com.example.demo1.constants.Constants" %><%--
  Created by IntelliJ IDEA.
  User: manuk
  Date: 04.10.23
  Time: 15:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Show Companys</title>
</head>
<body>
<a href="<%=Constants.HOST%>">back</a>
<a href="/createCompany">Create company</a>
<%
    List<Company> companys = (List<Company>) request.getAttribute("companys");
%>
<table>
    <tr>
        <th>Company name</th>
        <th>old year</th>
        <th>user</th>
    </tr>
    <%for (Company company : companys) {%>
    <tr>
        <th><%=company.getName()%>
        </th>
        <th><%=company.getFild()%>
        </th>
        <th><%=company.getUserID().getName()%>
        </th>
        <th><a href="/deleteCompany?id=<%=company.getId()%>">delete</a> / <a href="/updateCompany?id=<%=company.getId()%>">update</a></th>
        <%}%>
    </tr>
</table>
</body>
</html>
