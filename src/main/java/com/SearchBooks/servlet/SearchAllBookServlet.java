package com.SearchBooks.servlet; /**
 * @author dog-king
 * @create 2022/4/25
 */

import com.SearchBooks.entity.AllBookEntity;
import com.SearchBooks.service.SearchAllBookService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "SearchAllBookServlet", value = "/SearchAllBookServlet")
public class SearchAllBookServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
           doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("UTF-8");
        SearchAllBookService searchAllBookService=new SearchAllBookService();
        List<AllBookEntity> list=searchAllBookService.SearchAllBookService();
        HttpSession session= request.getSession();
        session.setAttribute("bookList",list);
    }
}
