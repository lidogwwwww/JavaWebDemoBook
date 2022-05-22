package com.LoanReturn.servlet; /**
 * @author dog-king
 * @create 2022/4/30
 */

import com.LoanReturn.entity.LoanRecordEntity;
import com.LoanReturn.service.HistoryRecordService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "HistoryRecordServlet", value = "/HistoryRecordServlet")
public class HistoryRecordServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       request.setCharacterEncoding("UTF-8");
        int userId= Integer.parseInt(request.getParameter("userId"));
        HistoryRecordService historyRecordService=new HistoryRecordService();
       List<LoanRecordEntity> list=historyRecordService.HistoryRecordService(userId);
       HttpSession session=request.getSession();
       session.setAttribute("HistoryLoanList",list);

    }
}
