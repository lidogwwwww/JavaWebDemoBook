function search() {
    // var searchBookName=document.getElementsByName("searchBookName")[0].values();
    // var searchBookAuthor=document.getElementsByName("searchBookAuthor")[0].values();
    // alert(searchBookName+" "+searchBookAuthor);
    var searchBookName = $("#searchBookName").val();
    var searchBookAuthor = $("#searchBookAuthor").val();
    var searchBookType = $("#searchBookType").val();
    if (searchBookName == "" && searchBookAuthor == "" && searchBookType == "") {
        $.ajax({
            type: "Post",
            url: "http://localhost:8080/demo_war_exploded/SearchAllBookServlet",
            async: false
        });
    } else {
        $.ajax({
            type: "Post",
            url: "http://localhost:8080/demo_war_exploded/searchBookServlet",
            data: {
                "searchBookName": searchBookName,
                "searchBookAuthor": searchBookAuthor,
                "searchBookType": searchBookType
            },
            async: false
        });
    }

}

$(function () {
    var bookId;
    var bookType;
    var bookName;
    var bookAuthor;
    var bookNum;
    $("a").click(function () {
        //当前超链接文本值为删除就将此行表格删除
        if ($(this).text() == "删除") {
            //获得当前删除超链接上上个父类的id为bookName的标签的文本值
            var $obj = $(this).parent().parent();
            var BookName = $obj.children("#bookName").text();
            var BookAuthor = $obj.children("#bookAuthor").text();
            if (confirm("是否删除《" + BookName + "》作者：" + BookAuthor)) {
                $obj.remove();
                $.ajax({
                    type: "Post",
                    url: "http://localhost:8080/demo_war_exploded/DeleteBookServlet",
                    data: {"bookName": BookName, "bookAuthor": BookAuthor},
                    async: false //异步是否开启 默认开启
                });
                alert("成功删除《" + BookName + "》作者：" + BookAuthor);
            }
            //组织元素默认行为 页面刷新
            return false;
        }
        if ($(this).text() == "编辑"){
            var $obj=$(this).parent().parent();
            bookId=$obj.children("#bookId").text();
            bookType=$obj.children("#bookType").text();
            bookName=$obj.children("#bookName").text();
            bookAuthor=$obj.children("#bookAuthor").text();
            bookNum=$obj.children("#bookNum").text();
        }


    });
});