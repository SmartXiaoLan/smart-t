<%--
  Created by IntelliJ IDEA.
  User: Smart-T
  Date: 04/04/2020
  Time: 16:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>你好，Solr！</h1>
    <form action="/search/searchItem" method="post">
        <input type="text" name="query">
        <button type="submit">搜索</button>
    </form>
</body>
</html>
