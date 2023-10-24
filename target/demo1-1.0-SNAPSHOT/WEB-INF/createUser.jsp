<%@ page import="com.example.demo1.constants.Constants" %><%--
  Created by IntelliJ IDEA.
  User: manuk
  Date: 03.10.23
  Time: 20:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create User</title>
</head>
<body>
<a href="<%=Constants.HOST%>">back</a>

    <form action="/createUser" method="post" enctype="multipart/form-data">
        name: <input type="text" name="name"><br>
        age: <input type="text" name="age"><br>

        image:
        <input type="file" name="image">
        <input type="submit" value="create">

    </form>
</body>
</html>
