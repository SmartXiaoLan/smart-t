<%--
  Created by IntelliJ IDEA.
  User: Smart-T
  Date: 09/03/2020
  Time: 11:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style type="text/css">
        table tr td{
            text-align: center;
            height: 25px;
        }
        .trbg:hover{
            background: grey;
        }
        .input{
            border-color: red;
        }
        .inputf:focus{
            background-color: red;
            color: white;
        }
    </style>
</head>
<body>
<div align="center"><table cellspacing="0" cellpadding="0" border="1" width="80%">
    <tr>
        <th>UserId</th>
        <th>UserName</th>
        <th>Age</th>
    </tr>
    <tr class="trbg">
        <td>${user.userid}</td>
        <td>${user.username}</td>
        <td>${user.userage}</td>
    </tr>
</table></div>
<hr/>
<div align="center">
    <form action="/user/updateUser" method="post">
        <input type="hidden" name="userid" value="${user.userid}">
        UserName:<input class="input inputf" type="text" name="username" value="${user.username}"><br/>
        UserAge:<input class="input inputf" type="number" name="userage" value="${user.userage}"><br/>
        <input type="submit" value="UPDATE">
    </form>
</div>
</body>
</html>
