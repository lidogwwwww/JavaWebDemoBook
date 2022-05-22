package com.LoanReturn.servlet; /**
 * @author dog-king
 * @create 2022/4/30
 */

import com.LoanReturn.service.ReturnBookService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "ReturnBookServlet", value = "/ReturnBookServlet")
public class ReturnBookServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        int loanId = Integer.parseInt(request.getParameter("loanId"));
        ReturnBookService returnBookService=new ReturnBookService();
        returnBookService.ReturnBookService(loanId);
    }
}
