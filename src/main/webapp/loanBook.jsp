<%@ page import="javax.swing.text.Document" %><%--
  Created by IntelliJ IDEA.
  User: 李明霖
  Date: 2022/4/29
  Time: 16:24
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
        .noLoan {
            border: 0;
            color: gray;
            background-color: paleturquoise;
            font-size: 15px;
        }

        .loan {
            border: 0;
            background-color: paleturquoise;
            font-size: 15px;

        }

        .loan:hover {
            border-radius: 15px;
            background-color: #ffffff;
        }
    </style>
    <script type="text/javascript" src="jquery-3.5.1.js"></script>
    <script>
        $(function () {
            $(".loan").click(function () {

                var bookId = $(this).parent().parent().children("#bookId").text();
                var bookName = $(this).parent().parent().children("#bookName").text();
                var userName = '<%=session.getAttribute("c_user")%>';
                var UserId = '<%=session.getAttribute("c_userId")%>';
                $.ajax({
                    type: "Post",
                    url: "http://localhost:8080/demo_war_exploded/LoanBookServlet",
                    data: {"bookId": bookId, "userName": userName, "UserId": UserId},
                    async: false,
                    success:function (){
                        alert("借阅《"+bookName+"》成功");
                    },
                    error:function (){
                        alert("您正在借阅《"+bookName+"》， 不可以重复借阅哦！\ \n点击\"归还图书\"进行归还");
                    }

                });
                $.ajax({
                    type: "Post",
                    url: "http://localhost:8080/demo_war_exploded/SearchAllBookServlet",
                    async: false,
                    success: function () {
                        location.reload();
                    }
                });


            });
        });
    </script>
</head>
<body>
<table border="1" cellspacing="0" width="100%">
    <tr>
        <td>图书编号</td>
        <td>图书类型</td>
        <td>图书名称</td>
        <td>图书作者</td>
        <td>剩余数量</td>
        <td>操作</td>
    </tr>
    <c:forEach var="list" items="${sessionScope.get('bookList')}">
        <tr>
            <td id="bookId">${list.getBookId()}</td>
            <td id="bookType">${list.getBookType()}</td>
            <td id="bookName">${list.getBookName()}</td>
            <td id="bookAuthor">${list.getBookAuthor()}</td>
            <td id="residueBookNum">${list.getBookNum()-list.getLoanNum()}</td>
            <c:if test="${list.getBookNum()==list.getLoanNum()}">
                <td><input type="button" class="noLoan" value="余量不足"></td>
            </c:if>
            <c:if test="${list.getBookNum()>list.getLoanNum()}">
                <td><input type="button" class="loan" value="借阅"></td>
            </c:if>
        </tr>
    </c:forEach>
    <tr>
        <td colspan="6"bgcolor="#87ceeb">到底啦 暂无更多可供借阅的图书！</td>
    </tr>
</table>
</body>
</html>
