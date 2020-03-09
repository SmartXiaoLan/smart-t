<%--
  Created by IntelliJ IDEA.
  User: Smart-T
  Date: 29/02/2020
  Time: 15:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/user/addUser" method="POST">
    ID:<input type="text" name="userid" maxlength="3"><br/>
    姓名:<input type="text" name="username" maxlength="3"><br/>
    年龄:<input type="text" name="userage" maxlength="3"><br/>
    Email:<input type="text" name="useremail" maxlength="50"><br/>
    <button type="submit">提交</button>
</form>
</body>
</html>
