<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/3/3
  Time: 8:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>

<body>


<a href="/user/1">delete</a>
<form action="/user/add" method="post">
    <input type="text" name="name">
    <input type="number" name="age">
    <input type="submit">
</form>
<form action="/user/edit" method="post">
    <input type="hidden" name="_method" value="put">
    <input type="text" name="name">
    <input type="number" name="age">
    <input type="submit">
</form>

<button id="btn-json">获取json</button>

<input id="name" type="text">
<input id="age" type="text">


<script src="https://apps.bdimg.com/libs/jquery/2.1.4/jquery.min.js"></script>

<script>
    $("#btn-json").click(function (){
        alert(123);
            $.getJSON("/testAjax",function (data) {
                $("#name").val(data.name);
                $("#age").val(data.age);
            });

    })
</script>

</body>
</html>
