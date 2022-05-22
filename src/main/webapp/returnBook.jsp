<%--
  Created by IntelliJ IDEA.
  User: 李明霖
  Date: 2022/4/30
  Time: 14:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <style>
        td {
            text-align: center;
            height: 40px;
            font-size: 15px;
        }

        .return {
            border: 0;
            background-color: paleturquoise;
            font-size: 15px;

        }

        .return:hover {
            border-radius: 15px;
            background-color: #ffffff;
        }
    </style>
    <script type="text/javascript" src="jquery-3.5.1.js"></script>
    <script>
        $(function () {
            $(".return").click(function () {
                var loanId = $(this).parent().parent().children("#loanId").text();
                var bookId = $(this).parent().parent().children("#bookId").text();
                var bookName = $(this).parent().parent().children("#bookName").text();
                $.ajax({
                    type: "Post",
                    url: "http://localhost:8080/demo_war_exploded/ReturnBookServlet",
                    data: {"loanId": loanId, "bookId": bookId},
                    async: false,
                    success: function () {
                        alert("感谢您归还《" + bookName + "》 ");
                    }
                });
                var UserId = '<%=session.getAttribute("c_userId")%>';
                $.ajax({
                    type: "Post",
                    url: "http://localhost:8080/demo_war_exploded/FindReturnBookServlet",
                    data: {"userId": UserId},
                    async: false,
                    success: function () {
                        location.reload();
                    }
                });
            });
        })
    </script>
</head>
<body>
<table border="1" cellspacing="0" width="100%">
    <tr>
        <td>借阅单号</td>
        <td>图书编号</td>
        <td>图书名称</td>
        <td>借阅时间</td>
        <td>借阅状态</td>
        <td>操作</td>
    </tr>
    <c:forEach var="list" items="${sessionScope.get('LoaningList')}">
            <tr>
                <td id="loanId">${list.getLoanId()}</td>
                <td id="bookId">${list.getBookId()}</td>
                <td id="bookName">${list.getBookName()}</td>
                <td id="4">${list.getLoanDate()}</td>
                <td id="5">${list.getLoanState()}</td>
                <td><input type="button" class="return" value="归还"></td>
            </tr>
    </c:forEach>
    <tr>
        <td colspan="6"bgcolor="#87ceeb">到底啦 没有可归还的图书了哦 快去借阅吧！</td>
    </tr>
</table>
</body>
</html>
