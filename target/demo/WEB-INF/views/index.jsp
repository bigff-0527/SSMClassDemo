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
    <input type="text" name="username">
    <input type="number" name="age">
    <input type="submit">
</form>
<form action="/user/edit" method="post">
    <input type="hidden" name="_method" value="put">
    <input type="text" name="username">
    <input type="number" name="age">
    <input type="submit">
</form>

<form action="/testPut" method="post" id="myform">

    用户名：<input type="text" name="name" value="" id="name"/><br/>
    年龄：<input type="text" name="age" value="" id="age"/><br/>
    <input type="submit" value="testMethod"/>
</form>

<button id="btn-json">获取json</button>


<button id="btn-userList">获取userList</button>

<table id="listTable">
    <tr>
        <td>姓名</td>
        <td>年龄</td>
    </tr>
</table>

<%--<input id="name" type="text">--%>
<%--<input id="age" type="text">--%>



<script src="https://apps.bdimg.com/libs/jquery/2.1.4/jquery.min.js"></script>

<script>
    $("#btn-json").click(function (){
            $.getJSON("/testAjax",function (data) {
                $("#name").val(data.name);
                $("#age").val(data.age);
            });

    })

    $("#btn-userList").click(function (){
        $.ajax({
            url: "/user/list",
            type: "get",
            dataType:"json",
            success: function(data){
                console.log(data)
                for (var i = 0; i<data.length; i++){
                    var r = "<tr><td>"+data[i].username+"</td><td>"+data[i].age+"</td></tr>"
                    $("#listTable").append(r);
                }
            }
        });
    })

    // $(".btn-primary").click(function (){
    //     $.ajax({
    //         url: "/ajaxPut",
    //         type:"PUT",
    //         dataType:"text",
    //         data:$("#myform").serialize(),
    //         success: function(data){
    //             console.log(data)
    //         }
    //     });
    // })


</script>

</body>
</html>
