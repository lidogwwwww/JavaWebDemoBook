package com.SearchBooks.servlet; /**
 * @author dog-king
 * @create 2022/4/27
 */

import com.SearchBooks.entity.AllBookEntity;
import com.SearchBooks.service.SearchBookService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "searchBookServlet", value = "/searchBookServlet")
public class searchBookServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        String searchBookName=request.getParameter("searchBookName");
        String searchBookAuthor=request.getParameter("searchBookAuthor");
        String searchBookType=request.getParameter("searchBookType");
        SearchBookService searchBookService=new SearchBookService();
        AllBookEntity allBookEntity=new AllBookEntity("",searchBookType,searchBookName,searchBookAuthor,0);
        List<AllBookEntity> searchBookList=searchBookService.SearchBookService(allBookEntity);
        HttpSession session=request.getSession();
        for (Object obj:searchBookList)
        {
            System.out.println(obj);
        }

        session.setAttribute("bookList",searchBookList);
    }
}
