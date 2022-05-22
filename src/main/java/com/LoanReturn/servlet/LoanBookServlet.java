package com.LoanReturn.servlet; /**
 * @author dog-king
 * @create 2022/4/29
 */

import com.LoanReturn.entity.LoanBookEntity;
import com.LoanReturn.service.LoanBookService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet(name = "LoanBookServlet", value = "/LoanBookServlet")
public class LoanBookServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       response.setCharacterEncoding("UTF-8");
       String LoanBookId=request.getParameter("bookId");
       String LoanUserName=request.getParameter("userName");
        int LoanUserId= Integer.parseInt(request.getParameter("UserId"));
        Date date=new Date();
        LoanBookEntity loanBookEntity=new LoanBookEntity(LoanBookId,LoanUserName,date,LoanUserId);
        LoanBookService loanBookService=new LoanBookService();
        String message=loanBookService.LoanBookService(loanBookEntity);
        if(message=="false") {
            response.setContentType("application/json; charset=utf-8");//返回的格式必须设置为application/json
            response.getWriter().write("message");//写入到返回结果中
        }
    }
}
