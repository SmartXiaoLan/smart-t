<%--
  Created by IntelliJ IDEA.
  User: Smart-T
  Date: 01/03/2020
  Time: 10:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.4.1.js"></script>
    <script type="text/javascript">
        $(function () {
            $("#but").click(function () {

                $.ajax({
                    //JsonP只支持Get请求
                    type: "GET",
                    url: "http://localhost:9090/user/findUser",
                    //实现跨域访问必要的两个属性
                    dataType: "jsonp",
                    jsonp: "callback",
                    success: function (data) {
                        const list = data;
                        for (let i = 0; i < list.length; i++) {
                            console.log(list[i].userid + "---" + list[i].username + "---" + list[i].userage)
                        }
                    }
                });
            })
        })
    </script>
</head>
<body>
<button id="but">OK</button>
</body>
</html>
