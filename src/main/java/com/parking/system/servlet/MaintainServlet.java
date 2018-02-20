package com.parking.system.servlet;

import com.parking.system.factory.ServiceFactory;
import com.parking.system.util.Validate.ValidateUtils;
import com.parking.system.vo.Maintain;
import sun.applet.Main;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@WebServlet(name = "maintainServlet", urlPatterns = "/pages/back/maintain/MaintainServlet/*")
public class MaintainServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String path = "/pages/errors.jsp";
        String status = req.getRequestURI().substring(req.getRequestURI().lastIndexOf("/") + 1);
        if (status != null) {
            if (status.equals("maintainInfo")) {
                path = this.getMaintain(req);
            } else if (status.equals("addMaintain")) {
                path = this.addMaintain(req);
            } else if (status.equals("deleteMaintain")) {
                path = this.deleteMaintain(req);
            } else if (status.equals("updateMaintain")) {
                path = this.updateMaintain(req);
            } else if (status.equals("insertPro")) {
                path = this.insertPro();
            }
        }

        req.getRequestDispatcher(path).forward(req, resp);

    }

    private String getMaintain(HttpServletRequest request) {
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
        List<Maintain> maintainList = null;
        try {
            maintainList = ServiceFactory.getIMaintainServiceInstance().findAllBySplit(null, null, currentPage, lineSize);
            Integer allMaintains = ServiceFactory.getIMaintainServiceInstance().getAllCount(null, null);
            request.setAttribute("allMaintains", allMaintains);
            request.setAttribute("maintainList", maintainList);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        request.setAttribute("currentPage", currentPage);
        request.setAttribute("lineSize", lineSize);
        return "/pages/back/maintain/maintain_list.jsp";
    }

    private String addMaintain(HttpServletRequest request) {
        String url = "";
        String msg = "";

        String cost = request.getParameter("cost");
        String type = request.getParameter("type");
        String maintainTime = request.getParameter("maintain_time");

        if (ValidateUtils.validateEmpty(cost) && ValidateUtils.validateEmpty(type) && ValidateUtils.validateEmpty(maintainTime)) {
            Date createTime = new Date();
            Maintain maintain = new Maintain(Double.parseDouble(cost), type, maintainTime, createTime);

            try {
                boolean success = ServiceFactory.getIMaintainServiceInstance().Insert(maintain);
                if (success) {
                    msg = "增加成功";
                    url = "/pages/back/maintain/MaintainServlet/maintainInfo";
                } else {
                    msg = "增加失败";
                    url = "/pages/back/maintain/MaintainServlet/maintainInfo";
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            msg = "输入不能为空";
            url = "/pages/back/maintain/MaintainServlet/maintainInfo";
        }
        request.setAttribute("msg", msg);
        request.setAttribute("url", url);
        return "/pages/forward.jsp";
    }

    private String deleteMaintain(HttpServletRequest request) {
        String url = "";
        String msg = "";
        Integer id = Integer.valueOf(request.getParameter("id"));
        Set<Integer> ids = new HashSet<>();
        ids.add(id);
        try {
            boolean success = ServiceFactory.getIMaintainServiceInstance().Delete(ids);
            if (success) {
                msg = "删除成功";
                url = "/pages/back/maintain/maintain_list.jsp";
            } else {
                msg = "删除失败";
                url = "/pages/back/maintain/maintain_list.jsp";
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        request.setAttribute("msg", msg);
        request.setAttribute("url", url);
        return "/pages/forward.jsp";
    }

    private String updateMaintain(HttpServletRequest request) {
        String url = "";
        String msg = "";

        String id = request.getParameter("id");
        String cost = request.getParameter("cost");
        String type = request.getParameter("type");
        String maintainTime = request.getParameter("maintain_time");

        if (ValidateUtils.validateEmpty(cost) || ValidateUtils.validateEmpty(type) || ValidateUtils.validateEmpty(maintainTime)) {
            Date updateTime = new Date();
            Maintain maintain = new Maintain();
            maintain.setCost(Double.parseDouble(cost));
            maintain.setType(type);
            maintain.setMaintain_time(maintainTime);
            maintain.setUpdateTime(new Date());
            maintain.setId(Integer.parseInt(id));

            try {
                boolean success = ServiceFactory.getIMaintainServiceInstance().Update(maintain);
                if (success) {
                    msg = "更新成功";
                    url = "/pages/back/maintain/MaintainServlet/maintainInfo";
                } else {
                    msg = "更新失败";
                    url = "/pages/back/maintain/MaintainServlet/maintainInfo";
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            msg = "没有新的更改";
            url = "/pages/back/maintain/MaintainServlet/maintainInfo";
        }
        request.setAttribute("msg", msg);
        request.setAttribute("url", url);
        return "/pages/forward.jsp";
    }

    private String insertPro() {
        return "/pages/back/maintain/maintain_insert.jsp";
    }
}
