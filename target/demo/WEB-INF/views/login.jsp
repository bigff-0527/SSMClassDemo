<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/3/10
  Time: 9:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
登录
<form id="loginData">
    用户名<input type="text" name="username">
    <br>
    密码<input type="password"  name="password">
    <br>
    <button type="button" id="btn-login" >登录</button>
</form>
<script src="https://apps.bdimg.com/libs/jquery/2.1.4/jquery.min.js"></script>
<script>
    $("#btn-login").click(function (){
        $.ajax({
            url: "/user/login",
            type: "post",
            data: $("#loginData").serialize(),
            dataType:"text",
            success: function (data){
                console.log(data);
            }
        });
    })
</script>
</body>
</html>
