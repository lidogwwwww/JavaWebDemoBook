<%--
  Created by IntelliJ IDEA.
  User: 李明霖
  Date: 2022/4/26
  Time: 23:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript"src="jquery-3.5.1.js"></script>
    <script>
        function goback(){
            window.history.go(-1);
        }
        $(function(){
            $("input").click(function (){
                if($(this).val()=="确认修改"){
                   var bookId=$("#editBookId").text();
                   var booktype=$("#editBookType").val();
                   var bookName=$("#editBookName").val();
                   var bookAuthor=$("#editBookAuthor").val();
                   var bookNum=$("#editBookNum").val();
                   alert(bookId+booktype+bookName+bookAuthor+bookNum);
                   $.ajax(
                       {
                           type:"Post",
                           url:"http://localhost:8080/demo_war_exploded/UpDateBookServlet",
                           data:{"editBookId":bookId,"editBookType":booktype,"editBookName":bookName,"editBookAuthor":bookAuthor,"editBookNum":bookNum},
                           async:false

                       }
                   );
                }
                return false;
            });
        })
    </script>
</head>
<body>

图书编号&nbsp;&nbsp;<span id="editBookId"><%=request.getParameter("bookId")%></span><br>
图书类型&nbsp;&nbsp;<input type="text"name="editBookType"id="editBookType"value="<%=request.getParameter("bookType")%>"><br>
图书名称&nbsp;&nbsp;<input type="text"name="editBookName" id="editBookName"value="<%=request.getParameter("bookName")%>"><br>
图书作者&nbsp;&nbsp;<input type="text"name="editBookAuthor"id="editBookAuthor"value="<%=request.getParameter("bookAuthor")%>"><br>
剩余数量&nbsp;&nbsp;<input type="text"name="editBookNum" id="editBookNum"value="<%=request.getParameter("bookNum")%>"><br>
<br>
<input type="button" value="确认修改">
&nbsp;&nbsp;&nbsp;&nbsp;
<input type="button" value="返回" onclick="goback()">
</body>
</html>
