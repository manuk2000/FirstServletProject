<%@ page import="com.example.demo1.model.User" %>
<%@ page import="java.util.List" %>
<%@ page import="com.example.demo1.constants.Constants" %><%--
  Created by IntelliJ IDEA.
  User: manuk
  Date: 04.10.23
  Time: 14:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create company</title>
</head>
<body>
<a href="<%=Constants.HOST%>">back</a>
    <%
        List<User> users = (List<User>) request.getAttribute("users");
    %>
    <form action="/createCompany" method="post">
        name: <input name="name" type="text" >
        old ear: <input name="fild" type="text" >
        <select name="userId">
            <%for (User user : users) {%>
                    <option value="<%=user.getId()%>"><%=user.getName()%></option>
                <%}
            %>
        </select>
        <input type="submit" value="creat">
    </form>

</body>
</html>
