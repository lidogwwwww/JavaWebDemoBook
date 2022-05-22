<%--
  Created by IntelliJ IDEA.
  User: 李明霖
  Date: 2022/4/29
  Time: 10:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>

        body {
            margin: 0;
        }

        #top {
            background-color: blueviolet;
            width: 100%;
            height: 20%;
            text-align: center;
            vertical-align: middle;
        }

        #list {
            width: 100%;
            height: 4%;
        }

        #body {
            background-color: paleturquoise;
            width: 100%;
            height: 76%;
        }

        li {
            float: left;
            list-style: none;
        }

        ul {
            padding: 0;
            margin: 0;
        }

        a {
            text-decoration: none;
            display: block;
            height: 40px;
            padding: 0 15px;
        }

        iframe {
            width: 100%;
            height: 95%;
            border: 0;
            margin: 0;
            padding: 0;
        }
        .hoverLi:hover{
            background-color: paleturquoise;
        }
    </style>
    <script type="text/javascript" src="jquery-3.5.1.js"></script>
    <script>
        $(function () {
            $("#02").click(function () {
                $.ajax({
                    type: "Post",
                    url: "http://localhost:8080/demo_war_exploded/SearchAllBookServlet",
                    async: false
                });
            });
            $("#03").click(function () {
                var UserId = '<%=session.getAttribute("c_userId")%>';
                $.ajax({
                    type: "Post",
                    url: "http://localhost:8080/demo_war_exploded/FindReturnBookServlet",
                    data:{"userId": UserId},
                    async: false
                });
            });
            $("#04").click(function () {
                var UserId = '<%=session.getAttribute("c_userId")%>';
                $.ajax({
                    type: "Post",
                    url: "http://localhost:8080/demo_war_exploded/HistoryRecordServlet",
                    data:{"userId": UserId},
                    async: false
                });
            });
        });
    </script>
</head>
<body>

<div id="top">
    <div style="
    text-align:center;
    position: relative;
    left: 50%;
    top: 50%;
    transform: translate(-50%,-50%);">
        <span style="font-size:30px;"><strong>${sessionScope.get("c_user")},欢迎使用图书借阅系统</strong></span>
    </div>
</div>
<div id="list">
    <ul>
        <li>&nbsp;&nbsp;|&nbsp;&nbsp;</li>
        <li><a href="#"class="hoverLi">首页</a></li>
        <li>&nbsp;&nbsp;|&nbsp;&nbsp;</li>
        <li><a href="loanBook.jsp" target="iframe_2" id="02"class="hoverLi">借阅图书</a></li>
        <li>&nbsp;&nbsp;|&nbsp;&nbsp;</li>
        <li><a href="returnBook.jsp" target="iframe_2" id="03" class="hoverLi">归还图书</a></li>
        <li>&nbsp;&nbsp;|&nbsp;&nbsp;</li>
        <li><a href="HistoryLoanRecord.jsp" target="iframe_2" id="04" class="hoverLi">历史借阅记录</a></li>
        <li>&nbsp;&nbsp;|&nbsp;&nbsp;</li>
        <li><a href="#" target="iframe_2" id="05" class="hoverLi">一起来留言</a></li>
        <li>&nbsp;&nbsp;|&nbsp;&nbsp;</li>
        <li><a href="ExitUserServlet" id="06" class="hoverLi">退出系统</a></li>
        <li>&nbsp;&nbsp;|&nbsp;&nbsp;</li>
    </ul>
</div>

<div id="body">
    <iframe name="iframe_2">
    </iframe>
</div>

</body>
</html>
