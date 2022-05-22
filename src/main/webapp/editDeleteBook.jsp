<%@ page import="java.lang.annotation.Documented" %>
<%@ page import="javax.swing.text.Document" %><%--
  Created by IntelliJ IDEA.
  User: 李明霖
  Date: 2022/4/26
  Time: 21:33
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
        }

        .inputButton {
            width: 130px;
        }

        a {
            text-decoration: none;
        }
    </style>
    <script type="text/javascript" src="jquery-3.5.1.js"></script>
    <script type="text/javascript" src="editDeleteBook.js"></script>
    <script>
    </script>
</head>
<body>
<span style="text-align: center">
    <div>
    图书类型&nbsp; <input type="text" id="searchBookType" name="searchBookType" class="inputButton">
    图书名称&nbsp; <input type="text" id="searchBookName" name="searchBookName" class="inputButton">
    &nbsp;图书作者 &nbsp;<input type="text" id="searchBookAuthor" name="searchBookAuthor" class="inputButton">&nbsp;&nbsp;
    <a href="editDeleteBook.jsp"><input type="submit" value="查找" onclick="search()" id="s"></a>
    </div>
    <br>
</span>
<table border="1" cellspacing="0" width="100%">
    <tr>
        <td id="aa">图书编号</td>
        <td>图书类型</td>
        <td>图书名称</td>
        <td>图书作者</td>
        <td>库存数量</td>
        <td>借阅数量</td>
        <td>操作</td>
    </tr>
    <c:forEach var="list" items="${sessionScope.get('bookList')}">
        <tr>
            <td id="bookId">${list.getBookId()}</td>
            <td id="bookType">${list.getBookType()}</td>
            <td id="bookName">${list.getBookName()}</td>
            <td id="bookAuthor">${list.getBookAuthor()}</td>
            <td id="bookNum">${list.getBookNum()}</td>
            <td>${list.getLoanNum()}</td>
            <td><a href="" id="delete">删除</a>&nbsp;<a href="editBook.jsp?bookId=${list.getBookId()}&bookType=${list.getBookType()}&bookName=${list.getBookName()}&bookAuthor=${list.getBookAuthor()}&bookNum=${list.getBookNum()}" target="iframe_1" id="edit">编辑</a></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
