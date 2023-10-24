<%@ page import="com.example.demo1.constants.Constants" %><%--
  Created by IntelliJ IDEA.
  User: manuk
  Date: 09.10.23
  Time: 16:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
<a href="<%=Constants.HOST%>">back</a>

<form action="/login" method="post">
    email: <input type="text" name="email">
    age: <input type="password" name="age">
    <input type="submit" value="login">
</form>


</body>
</html>
