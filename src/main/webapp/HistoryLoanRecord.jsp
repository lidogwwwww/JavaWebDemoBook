<%--
  Created by IntelliJ IDEA.
  User: 李明霖
  Date: 2022/4/30
  Time: 21:56
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
    </style>
</head>
<body>
<table border="1" cellspacing="0" width="100%">
    <tr>
        <td>借阅单号</td>
        <td>图书编号</td>
        <td>图书名称</td>
        <td>借阅时间</td>
        <td>借阅状态</td>
    </tr>
    <c:forEach var="list" items="${sessionScope.get('HistoryLoanList')}">
        <tr>
            <td>${list.getLoanId()}</td>
            <td>${list.getBookId()}</td>
            <td>${list.getBookName()}</td>
            <td>${list.getLoanDate()}</td>
            <td>${list.getLoanState()}</td>
        </tr>
    </c:forEach>
    <tr>
        <td colspan="6"bgcolor="#87ceeb">到底啦 已经没有更多的历史记录！</td>
    </tr>
</table>
</body>
</html>
