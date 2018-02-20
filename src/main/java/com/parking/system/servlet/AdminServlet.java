package com.parking.system.servlet;

import com.parking.system.constinfo.ResponseInfo;
import com.parking.system.factory.ServiceFactory;
import com.parking.system.util.MD5Code;
import com.parking.system.util.Validate.ValidateUtils;
import com.parking.system.vo.Admin;
import com.parking.system.vo.Bill;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


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
            } else if (status.equals("getAdmin")) {
                path = this.getAdmin(req);
            } else if (status.equals("addAdmin")) {
                path = this.addAdmin(req);
            } else if (status.equals("update")) {
              //  path = this.update(req);
            } else if (status.equals("delete")) {
                path = this.delete(req);
            }

        }
        req.getRequestDispatcher(path).forward(req,resp);
    }

    private String getAdmin(HttpServletRequest request) {
        Integer currentPage = 1;
        Integer lineSize = 5;
        try {
            String cp = request.getParameter("cp");
            String ls = request.getParameter("ls");
            if (cp != null && cp != "" && ls != null && ls != "") {
                currentPage = Integer.parseInt(cp);
                lineSize = Integer.parseInt(ls);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        List<Admin> adminList = null;
        try {
            adminList = ServiceFactory.getIAdminServiceInstence().findAllBySplit(null, null, currentPage, lineSize);
            Integer allCount = ServiceFactory.getIAdminServiceInstence().getAllCount(null, null);
            request.setAttribute("allAdmins", allCount);
            request.setAttribute("adminList", adminList);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        request.setAttribute("currentPage", currentPage);
        request.setAttribute("lineSize", lineSize);
        return "/pages/back/admin/admin_list.jsp";
    }

    private String addAdmin(HttpServletRequest request) {
        String msg = "";
        String url = "";

        String name = request.getParameter("name");
        String age = request.getParameter("age");
        String sex = request.getParameter("sex");
        String work_time = request.getParameter("work_time");
        String userName = request.getParameter("userName");
        String password = request.getParameter("password");
        String phone = request.getParameter("phoneNumber");
        String level = request.getParameter("level");
        Date date = new Date();

        Admin admin = new Admin();
        admin.setAge(Integer.parseInt(age));
        admin.setLevel(Integer.parseInt(level));
        admin.setName(name);
        admin.setCreatTime(date);
        admin.setPassword(password);
        admin.setPhoneNumber(phone);
        admin.setSex(Integer.parseInt(sex));
        admin.setUserName(userName);
        admin.setWork_time(work_time);
        try {
            boolean success = ServiceFactory.getIAdminServiceInstence().Insert(admin);
            if (success) {
                msg = "插入成功";
                url = "/pages/back/AdminServlet/getAdmin";
            } else {
                msg += "插入失败";
                url = "/pages/back/AdminServlet/getAdmin";
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        request.setAttribute("msg", msg);
        request.setAttribute("url", url);
        return "/pages/forward.jsp";
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

    private String delete(HttpServletRequest request) {
        String msg = "";
        String url = "";
        Integer id = Integer.valueOf(request.getParameter("id"));
        System.out.println(id);
        Set<Integer> ids = new HashSet<Integer>();
        ids.add(id);
        try {
            if(ServiceFactory.getIAdminServiceInstence().Delete(ids)){
                msg = "删除成功";
                url =  "/pages/back/AdminServlet/getAdmin";
            }else {
                msg = "删除失败";
                url = "/pages/back/AdminServlet/getAdmin";
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        request.setAttribute("msg", msg);
        request.setAttribute("url", url);
        return "/pages/forward.jsp";
    }

}
