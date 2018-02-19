package com.parking.system.servlet;

import com.parking.system.constinfo.ResponseInfo;
import com.parking.system.factory.ServiceFactory;
import com.parking.system.util.MD5Code;
import com.parking.system.util.Validate.ValidateUtils;
import com.parking.system.vo.Admin;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;


/**
 * 对管理员的增删改查
 * */
@WebServlet(name = "adminServlet" ,urlPatterns = "/pages/back/AdminServlet/*")
public class AdminServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req,resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String path ="/pages/errors.jsp";
        String status = req.getRequestURI().substring(req.getRequestURI().lastIndexOf("/")+1);
        if(status != null){
            if("login".equals(status)){
                path = this.login(req);
            }
//            else if("logout".equals(status)){
//                path = this.logout(req);
//            }
        }
        req.getRequestDispatcher(path).forward(req,resp);
    }

    private String login(HttpServletRequest request){
        String msg = ""; //表示提示信息
        String url = ""; // 表示跳转路径
        String account = request.getParameter("userName");
        String pwd = request.getParameter("passWord");
        if(ValidateUtils.validateEmpty(account) && ValidateUtils.validateEmpty(pwd)){ //表示数据存在
            Admin vo = new Admin();
            vo.setUserName(account);
            vo.setPassword(new MD5Code().getMD5ofStr(pwd + account)); //加盐处理
            try {
                if(ServiceFactory.getIAdminServiceInstence().login(vo).equals(ResponseInfo.LOGIN_SUCCESS)){
                    request.getSession().setAttribute("account", account); // 保存aid
                    msg = "登录成功！";
                   // url = "/pages/back/index.jsp";
                    url = "/pages/back/index.jsp";
                }else {
                    msg = "登录失败，错误的ID或密码!";
                    url = "/login.jsp";
                }
            } catch (SQLException e) {
                System.out.println("login has some error");
                e.printStackTrace();

            }
        }else {
            System.out.println("数据不为空");
            msg = "数据不能为空!";
            url = "/login.jsp";
        }
        request.setAttribute("msg", msg);
        request.setAttribute("url", url);
        return "/pages/forward.jsp";
    }
}
