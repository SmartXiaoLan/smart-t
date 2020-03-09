<%--
  Created by IntelliJ IDEA.
  User: Smart-T
  Date: 01/03/2020
  Time: 11:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.4.1.js"></script>
    <script>
        $(function () {
            $("#but").click(function () {
                $.get("/user/findUser",function (data) {
                    // alert(data)
                    const list = data;
                    for (let i = 0 ; i < list.length ; i ++){
                        console.log(list[i].userid+"---"+list[i].username+"---"+list[i].userage)
                    }
                })
            })
        })
    </script>
</head>
<body>
    <button id="but">OK</button>
</body>
</html>
