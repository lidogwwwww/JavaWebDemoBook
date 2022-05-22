package com.LoginRegisterExit.servlet; /**
 * @author dog-king
 * @create 2022/4/25
 */

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "ExitUserServlet", value = "/ExitUserServlet")
public class ExitUserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        System.out.println(session.getAttribute("user"));
        session.removeAttribute("user");
        session.invalidate();
        response.sendRedirect("index.jsp");//重定向
    }
}
