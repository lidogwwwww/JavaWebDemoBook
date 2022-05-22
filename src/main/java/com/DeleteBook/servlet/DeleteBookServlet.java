package com.DeleteBook.servlet; /**
 * @author dog-king
 * @create 2022/4/27
 */

import com.DeleteBook.service.DeleteBookService;
import com.SearchBooks.entity.AllBookEntity;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "DeleteBookServlet", value = "/DeleteBookServlet")
public class DeleteBookServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String bookName=request.getParameter("bookName");
        String bookAuthor=request.getParameter("bookAuthor");
        AllBookEntity deleteBookEntity=new AllBookEntity("","",bookName,bookAuthor,0);
        DeleteBookService deleteBookService=new DeleteBookService();
        deleteBookService.DeleteBookService(deleteBookEntity);
    }
}
