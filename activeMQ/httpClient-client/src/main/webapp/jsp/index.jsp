<%--
  Created by IntelliJ IDEA.
  User: Smart-T
  Date: 03/03/2020
  Time: 11:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加用户</title>
</head>
<body>
<form action="/user/add" method="post">
    用户姓名:<input type="text" name="username" placeholder="10"><br/>
    用户年龄:<input type="text" name="userage" placeholder="3"><br/>
    <button type="submit">添加</button>
</form>
</body>
</html>
