<%--
  Created by IntelliJ IDEA.
  User: Smart-T
  Date: 24/11/2019
  Time: 11:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table border="1px" cellspacing="0" cellpadding="0px" align="center" width="100%">
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Age</th>
        <th>Edit</th>
    </tr>
    <c:forEach var="i" items="${users}">
        <tr>
            <td align="center" width="10%">${i.userid}</td>
            <td align="center" width="35%">${i.username}</td>
            <td align="center" width="15%">${i.userage}</td>
            <td align="center">
                <a href="#"><button>更新</button></a>
                <a href="/user/dropUser/${i.userid}"><button>删除</button></a>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
