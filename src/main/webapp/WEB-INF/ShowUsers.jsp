<%@ page import="com.example.demo1.menagers.UserManager" %>
<%@ page import="com.example.demo1.model.User" %>
<%@ page import="java.util.List" %>
<%@ page import="com.example.demo1.constants.Constants" %><%--
  Created by IntelliJ IDEA.
  User: manuk
  Date: 03.10.23
  Time: 19:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Show Users</title>
</head>
<body>
<a href="<%=Constants.HOST%>">back</a>
<h2><a href="/createUser">Create user</a> </h2>
<form action="/allUsers" method="get">
<%--    <%System.out.printf(request.getParameter("keyword"));%>--%>
    <input type="text" name="keyword" value="<%=request.getAttribute("keyword") %>">
    <input type="submit" value="search">
</form>
<h3>Users</h3>
<table>
    <tr>
        <th>image</th>
        <th>user id</th>
        <th>user age</th>
        <th>user name</th>
        <th>action</th>
    </tr>
        <%
            List<User> all = (List<User>) request.getAttribute("users");
            if (all != null && !all.isEmpty()) {
                for (User user : all) {
        %>
    <tr>
                <th><a href="/getImage?image=<%=user.getImageName()%>"><img src="/getImage?image=<%=user.getImageName()%>" width="70"></a></th>
                <th><%=user.getId()%></th>
                <th><%=user.getAge()%></th>
                <th><%=user.getName()%></th>
                <th><a href="/deleteUser?id=<%=user.getId()%>">delete</a>
                    /<a href="/updateuser?id=<%=user.getId()%>">update</a></th>
    </tr>

        <% }
        } %>
</table>


</body>
</html>
