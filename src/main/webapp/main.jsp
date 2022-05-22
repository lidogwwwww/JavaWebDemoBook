<%--
  Created by IntelliJ IDEA.
  User: 李明霖
  Date: 2022/4/25
  Time: 12:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>图书管理系统</title>
    <style>
        body{
            margin: 0;
        }
        div{
            margin: 0;
            padding: 0;
        }
        .topDiv{
            width: 100%;
            height: 20%;
            background-color: aqua;
        }
        .leftDiv{
            float: left;
            width: 15%;
            height: 80%;
            background-color: aqua;
        }
        .middleDiv{
            float: left;
            width: 85%;
            height: 80%;
        }
        iframe{
            width:100%;
            height:100%;
            border:0;
            margin:0;
            padding:0;
        }
    </style>
    <script type="text/javascript"src="jquery-3.5.1.js"></script>
    <script>
        function searchallbook(){
            var xml=new XMLHttpRequest();
            xml.open("Post","http://localhost:8080/demo_war_exploded/SearchAllBookServlet",false);
            xml.send();
        }
    </script>
</head>
<body>
<div class="topDiv">
    <div backgroung="" style="  margin:0 auto;
            text-align:center;
            position: relative;
            left: 50%;
            top: 50%;
            transform: translate(-50%,-50%);">
    <span style="font-size:30px;"><strong>${sessionScope.get("user")},欢迎使用图书管理系统</strong></span>
    </div>
</div>
<div class="leftDiv">

    <a href="middleAllBooks.jsp" target="iframe_1"><input  type="button" id="searchallbook"value="图书信息展示" onclick="searchallbook()" style="width:100%;height:60px;"></a>
    <a href="editDeleteBook.jsp" target="iframe_1"><input type="button" value="编辑图书信息" onclick="searchallbook()" style="width:100%;height:60px;"></a><br>
    <a href="2.jsp"target="iframe_1"><input type="button" value="用户借阅记录" style="width:100%;height:60px;"></a><br>
    <a href="3.jsp"target="iframe_1"><input type="button" value="用户留言板" style="width:100%;height:60px;"></a><br>
    <a href="#"target="iframe_1"><input type="button" value="用户信息编辑" style="width:100%;height:60px;"></a><br>
    <a href="ExitUserServlet"><input type="button" name="UserAction" value="Logout"style="width:100%;height:60px;"></a><br>

</div>
<div class="middleDiv">
    <iframe name="iframe_1" >
    </iframe>
</div>
</body>
</html>
