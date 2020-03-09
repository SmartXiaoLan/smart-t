<%--
  Created by IntelliJ IDEA.
  User: Smart-T
  Date: 24/11/2019
  Time: 10:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/user/addUser" method="post">
    用户名:<input type="text" name="username">
    用户年龄:<input type="number" name="userage">
    <input type="submit" value="添加">
</form>
</body>
</html>
