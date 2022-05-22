package com.UpdateBook.servlet; /**
 * @author dog-king
 * @create 2022/4/28
 */

import com.SearchBooks.entity.AllBookEntity;
import com.UpdateBook.service.UpDateBookService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "UpDateBookServlet", value = "/UpDateBookServlet")
public class UpDateBookServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String bookId=request.getParameter("editBookId");
        String bookType=request.getParameter("editBookType");
        String bookName=request.getParameter("editBookName");
        String bookAuthor=request.getParameter("editBookAuthor");
        Integer bookNum= Integer.valueOf(request.getParameter("editBookNum"));
        AllBookEntity editBookEntity=new AllBookEntity(bookId,bookType,bookName,bookAuthor,bookNum);
        UpDateBookService upDateBookService =new UpDateBookService();
        upDateBookService.UpdateBookService(editBookEntity);
    }
}
