package com.LoginRegisterExit.servlet; /**
 * @author dog-king
 * @create 2022/4/26
 */

import com.LoginRegisterExit.entity.C_UserEntity;
import com.LoginRegisterExit.entity.UserEntity;
import com.LoginRegisterExit.entity.registerEntity;
import com.LoginRegisterExit.service.C_UserService;
import com.LoginRegisterExit.service.RegisterService;
import com.LoginRegisterExit.service.UserService;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

@WebServlet(name = "UserServlet", value = "/UserServlet")
public class UserServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("UTF-8");
        String action=req.getParameter("UserAction");
        try {
            Method method=this.getClass().getDeclaredMethod(action,HttpServletRequest.class,HttpServletResponse.class);
            method.invoke(this,req,resp);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
    protected void AdminLogin(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("UTF-8");
        resp.setHeader("Content-Type", "text/html;charset=UTF-8");
        resp.setContentType("text/html;charset=UTF-8");
        String UserName = req.getParameter("UserName");
        String Password = req.getParameter("Password");
            UserEntity userEntity = new UserEntity(UserName, Password);
            UserService userService = new UserService();
            UserEntity userResult = userService.login(userEntity);
            if (userResult != null) {
                HttpSession session = req.getSession();
                session.setAttribute("user", userEntity.getUserName());
                req.getRequestDispatcher("main.jsp").forward(req, resp);
            } else {
                resp.getWriter().write("<script language='javascript'>alert('管理员账号或密码错误！');</script>");
                resp.getWriter().write("<script language='javascript'>window.history.go(-1);</script>");
//            req.getRequestDispatcher("index.jsp").forward(req,resp);
            }


    }
    protected void UserLogin(HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("UTF-8");
        //保证servlet向客户端发送的弹窗内容编码为UTF-8
        resp.setHeader("Content-Type", "text/html;charset=UTF-8");
        resp.setContentType("text/html;charset=UTF-8");

        String UserAccount = req.getParameter("UserName");
        String Password = req.getParameter("Password");

            C_UserEntity c_userEntity = new C_UserEntity(UserAccount, Password);
            C_UserService c_userService = new C_UserService();
            C_UserEntity c_userEntityListResult = c_userService.C_userService(c_userEntity);
            if (c_userEntityListResult != null) {
                HttpSession session = req.getSession();
                session.setAttribute("c_user", c_userEntityListResult.getC_username());
                session.setAttribute("c_userId", c_userEntityListResult.getC_userId());
                req.getRequestDispatcher("user_main.jsp").forward(req, resp);
            } else {
                resp.getWriter().write("<script language='javascript'>alert('用户账号或密码错误！');</script>");
                resp.getWriter().write("<script language='javascript'>window.history.go(-1);</script>");

            }

    }
    protected void register(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException, InterruptedException {
        request.setCharacterEncoding("UTF-8");
        response.setHeader("Content-Type", "text/html;charset=UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        String username=new String(request.getParameter("re_userName").getBytes("ISO-8859-1"),"UTF-8");
        String account=request.getParameter("re_Account");
        String password=request.getParameter("re_password");
        registerEntity registerEntity=new registerEntity(username,account,password);
        RegisterService registerService=new RegisterService();
        String message=registerService.registerService(registerEntity);
        if(message =="success"){
            response.getWriter().write("<script language='javascript'>alert('注册成功！');</script>");
            request.getRequestDispatcher("index.jsp").forward(request, response);

        }
        else{
            response.getWriter().write("<script language='javascript'>alert('注册失败！ 当前用户名已经注册过了 请重新注册');</script>");
            response.getWriter().write("<script language='javascript'>window.history.go(-1);</script>");
        }

    }


}
