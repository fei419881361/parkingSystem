package com.parking.system.servlet;


import com.parking.system.factory.ServiceFactory;
import com.parking.system.util.Validate.ValidateUtils;
import com.parking.system.vo.Depot;

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
 * 对停车场的增删改查
 * */
@WebServlet(name = "depotServlet" ,urlPatterns = "/pages/back/depot/DepotServlet/*")
public class DepotServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req,resp);
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String path ="/pages/errors.jsp";
        String status = req.getRequestURI().substring(req.getRequestURI().lastIndexOf("/")+1);
        if (status!=null){
            if("listSplit".equals(status)){
                path = this.listSplit(req,"listSplit");
                System.out.println(path);
            }else if("insert".equals(status)){
                path = this.insert(req,resp);
            }else if("insertPro".equals(status)){
                path = this.insertPro(req);
            }else if("update".equals(status)){
                path = this.update(req);
            }else if("delete".equals(status)){
                path = this.delete(req);
            }
        }
        System.out.println(path);
        req.getRequestDispatcher(path).forward(req,resp);
    }

    private String delete(HttpServletRequest req) {
        String msg = "";
        String url = "";
        Integer id = Integer.valueOf(req.getParameter("id"));
        System.out.println(id);
        Set<Integer> ids = new HashSet<Integer>();
        ids.add(id);
        try {
            if(ServiceFactory.getIDepotServiceInstence().Delete(ids)){
                msg = "删除成功";
                url =  "/pages/forward.jsp";
            }else {
                msg = "删除失败";
                url = "/pages/forward.jsp";
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        req.setAttribute("msg", msg);
        req.setAttribute("url", url);
        return "/pages/forward.jsp";
    }

    private String update(HttpServletRequest req) {
        String msg = "";
        String url= "";

        String park_num = req.getParameter("park_num");
        String developer = req.getParameter("developer");
        String postion = req.getParameter("postion");
        Integer id = Integer.valueOf(req.getParameter("id"));
        Depot vo = new Depot();
        vo.setId(id);
        vo.setUpdateTime(new Date());
        vo.setPosition(postion);
        vo.setDeveloper(developer);
        vo.setPark_num(park_num);
        try {
            if(ServiceFactory.getIDepotServiceInstence().Update(vo)){
                msg = "修改成功";
                url = "/pages/back/depot/depot_list.jsp";
            }else {
                msg = "修改失败";
                url = "/pages/back/depot/depot_list.jsp";
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        req.setAttribute("msg", msg);
        req.setAttribute("url", url);
        return "/pages/forward.jsp";
    }

    private String insertPro(HttpServletRequest req) {
        return "/pages/back/depot/depot_insert.jsp";
    }

    private String insert(HttpServletRequest req, HttpServletResponse resp) {
        String msg = "";
        String url = "";
        //取得页面中的数据
        String park_num = req.getParameter("park_num");
        String developer = req.getParameter("developer"); // req.getSession();中保存有管理员的名字
        String position = req.getParameter("postion");

        if (ValidateUtils.validateEmpty(park_num) && ValidateUtils.validateEmpty(developer) &&
                ValidateUtils.validateEmpty(position)) {
            Depot vo = new Depot();
            vo.setPark_num(park_num);
            vo.setDeveloper(developer);
            vo.setPosition(position);
            vo.setCreateTime(new Date());
            vo.setUpdateTime(new Date());

            try {
                if (ServiceFactory.getIDepotServiceInstence().Insert(vo)) {
                    msg = "数据增加成功";
                    url = "/pages/back/depot/DepotServlet/insertPro";
                } else {
                    msg = "输入信息有误";
                    url = "/pages/back/depot/DepotServlet/insertPro";
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            msg = "输入不能为空";
            url = "/pages/back/depot/DepotServlet/insertPro";
        }
        req.setAttribute("msg", msg);
        req.setAttribute("url", url);

        return "/pages/forward.jsp";
    }

    private String listSplit(HttpServletRequest req,String method) {
        Integer currentPage = 1;
        Integer lineSize = 5;
        try {
            String cp = req.getParameter("cp");
            String ls = req.getParameter("ls");
            if (cp != null && cp != "" && ls != null && ls != "") {
                currentPage = Integer.parseInt(cp);
                lineSize = Integer.parseInt(ls);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            List<Depot> depots = ServiceFactory.getIDepotServiceInstence().findAllBySplit("","",currentPage,lineSize);
            Integer allRecorders = ServiceFactory.getIDepotServiceInstence().getAllCount("","");
            req.setAttribute("allDepots", depots);
            req.setAttribute("allRecorders", allRecorders);
        } catch (SQLException e) {
            e.printStackTrace();
        }
       // req.setAttribute("url", "/pages/back/depot/DepotServlet/"+method);
        req.setAttribute("currentPage", currentPage);
        req.setAttribute("lineSize", lineSize);
        return "/pages/back/depot/depot_list.jsp";
    }
}
