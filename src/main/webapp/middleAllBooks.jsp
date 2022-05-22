<%--
  Created by IntelliJ IDEA.
  User: 李明霖
  Date: 2022/4/25
  Time: 15:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
   <style>
       td{
    text-align:center;
    height:40px;
    }
   </style>
</head>
<body>
<table border="1" cellspacing="0"width="100%" >
    <tr>
        <td>图书编号</td>
        <td>图书类型</td>
        <td>图书名称</td>
        <td>图书作者</td>
        <td>库存数量</td>
        <td>借阅数量</td>
    </tr>
    <c:forEach var="list" items="${sessionScope.get('bookList')}">
    <tr>
        <td>${list.getBookId()}</td>
        <td>${list.getBookType()}</td>
        <td>${list.getBookName()}</td>
        <td>${list.getBookAuthor()}</td>
        <td>${list.getBookNum()}</td>
        <td>${list.getLoanNum()}</td>
    </tr>
    </c:forEach>
</table>
</body>
</html>
