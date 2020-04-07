<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";

%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Title</title>
    <meta charset="UTF-8">
    <base href="<%=basePath%>">
    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
</head>
<body>
    <span><font color="red">${msg}</font> </span>
    <span>当前页:${result.pageIndex == null ? 0:result.pageIndex}</span>
    <span>总前页:${result.totalPage == null ? 0:result.totalPage}</span>
    <span>总条数:${result.totalNum == null ? 0:result.totalNum}</span>
    <table align="center" border="1">
        <c:forEach items="${result.result}" var="item">
            <tr>
                <td>${item.id}</td>
                <td>${item.title}</td>
                <td>${item.sell_Point}</td>
                <td>${item.price}</td>
                <td>${item.image}</td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>