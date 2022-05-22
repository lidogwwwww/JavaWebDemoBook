package com.LoanReturn.servlet; /**
 * @author dog-king
 * @create 2022/4/30
 */

import com.LoanReturn.entity.LoanRecordEntity;
import com.LoanReturn.service.FindReturnBookService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "FindReturnBookServlet", value = "/FindReturnBookServlet")
public class FindReturnBookServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UtF-8");
        int userId= Integer.parseInt(request.getParameter("userId"));
        FindReturnBookService findReturnBookService =new FindReturnBookService();
        List<LoanRecordEntity> list= findReturnBookService.ReturnBookService(userId);
        HttpSession session=request.getSession();
        session.setAttribute("LoaningList",list);
    }
}
