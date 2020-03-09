<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table border="1" align="center" cellspacing="0" cellpadding="0">
		<tr>
			<th>用户ID</th>
			<th>用户姓名</th>
			<th>用户年龄</th>
		</tr>
		<c:forEach items="${users }" var="user">
			<tr>
				<td>${user.userid }</td>
				<td>${user.username }</td>
				<td>${user.userage }</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>