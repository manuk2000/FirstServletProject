<%@ page import="com.example.demo1.model.User" %>
<%@ page import="com.example.demo1.constants.Constants" %><%--
  Created by IntelliJ IDEA.
  User: manuk
  Date: 03.10.23
  Time: 21:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update user</title>
</head>
<body>
<a href="<%=Constants.HOST%>">back</a>
<%
    User user = (User) request.getAttribute("user");
%>
    <form action="/updateuser" method="post">
        <input name="id" type="hidden" value="<%=user.getId()%>">
        name: <input type="text" name="name" value="<%=user.getName()%>"><br>
        age: <input type="text" name="age" value="<%=user.getAge()%>"><br>
        <input type="submit" value="send">
    </form>

</body>
</html>
