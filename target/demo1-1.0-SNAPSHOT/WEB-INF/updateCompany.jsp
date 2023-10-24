<%@ page import="com.example.demo1.model.Company" %>
<%@ page import="java.util.List" %>
<%@ page import="com.example.demo1.model.User" %>
<%@ page import="com.example.demo1.constants.Constants" %><%--
  Created by IntelliJ IDEA.
  User: manuk
  Date: 04.10.23
  Time: 16:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update Company</title>
</head>
<body>
<a href="<%=Constants.HOST%>">back</a>
<%
    Company company = (Company) request.getAttribute("company");
    List<User> users = (List<User>) request.getAttribute("users");
%>
<form action="/updateCompany" , method="post">
    <input name="id" type="hidden" value="<%=company.getId()%>">
    Company name<input name="name" type="text" value="<%=company.getName()%>">
    Company old yead<input name="fild" type="text" value="<%=company.getFild()%>">
    <select name="userId">
        <%for (User user : users) {%>
        <option value="<%=user.getId()%>"><%=user.getName()%>
        </option>
        <%}%>
    </select>
    <input type="submit" value="update">
</form>


</body>
</html>
