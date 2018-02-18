package com.parking.system.servlet;

import com.parking.system.factory.ServiceFactory;
import com.parking.system.util.Validate.ValidateUtils;
import com.parking.system.vo.Car;
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

@WebServlet(name = "carServlet" ,urlPatterns = "/pages/back/cars/CarServlet/*")
public class CarServlet extends HttpServlet {
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
            } else if ("insert".equals(status)) {
                path = this.insert(req);
            } else if ("insertPro".equals(status)) {
                path = this.insertPro(req);
            } else if("update".equals(status)){
                path = this.update(req);
            } else if ("delete".equals(status)) {
                path = this.delete(req);
            }
        }
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
            if(ServiceFactory.getICarServiceInstence().Delete(ids)){
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
        String park_id = req.getParameter("park_id");
        String car_num = req.getParameter("car_num");
        String owner_name = req.getParameter("owner_name");
        String owner_phone = req.getParameter("owner_phone");

        Integer id = Integer.valueOf(req.getParameter("id"));
        System.out.println(park_id+car_num+owner_name+owner_phone+id);
        Car vo = new Car();
        vo.setId(id);
        vo.setUpdateTime(new Date());
        vo.setOwner_name(owner_name);
        vo.setOwner_phone(owner_phone);
        vo.setCar_num(car_num);
        vo.setPark_id(Integer.valueOf(park_id));
        try {
            if(ServiceFactory.getICarServiceInstence().Update(vo)){
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

        List<Depot> depots = null;
        try {
            depots = ServiceFactory.getIDepotServiceInstence().findAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        // System.out.println(depots.size());
        req.setAttribute("allPark_ids", depots);
        return "/pages/back/cars/car_insert.jsp";
    }

    private String insert(HttpServletRequest req) {
        String msg = "";
        String url = "";
        //取得页面中的数据
        String park_id = req.getParameter("park_id");
        String car_num = req.getParameter("car_num");
        String owner_name = req.getParameter("owner_name");
        String owner_phone = req.getParameter("owner_phone");

        System.out.println(park_id+car_num+owner_name+owner_phone);
        if (ValidateUtils.validateEmpty(park_id) && ValidateUtils.validateEmpty(car_num) &&
                ValidateUtils.validateEmpty(owner_name)&&ValidateUtils.validateEmpty(owner_phone)) {
            Car vo = new Car();
            vo.setPark_id(Integer.valueOf(park_id));
            vo.setCar_num(car_num);
            vo.setOwner_phone(owner_phone);
            vo.setOwner_name(owner_name);
            vo.setCreateTime(new Date());
            vo.setUpdateTime(new Date());

            try {
                if (ServiceFactory.getICarServiceInstence().Insert(vo)) {
                    msg = "数据增加成功";
                    url = "/pages/back/cars/CarServlet/insertPro";
                } else {
                    msg = "输入信息有误";
                    url = "/pages/back/cars/CarServlet/insertPro";
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            msg = "输入不能为空";
            url = "/pages/back/cars/CarServlet/insertPro";
        }
        req.setAttribute("msg", msg);
        req.setAttribute("url", url);

        return "/pages/forward.jsp";
    }

    private String listSplit(HttpServletRequest req, String method) {
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
        List<Depot> depots2 = null;
        try {
            depots2 = ServiceFactory.getIDepotServiceInstence().findAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        // System.out.println(depots.size());
        req.setAttribute("allPark_ids", depots2);
        try {
            List<Car> depots = ServiceFactory.getICarServiceInstence().findAllBySplit("","",currentPage,lineSize);
            Integer allRecorders = ServiceFactory.getIDepotServiceInstence().getAllCount("","");
            req.setAttribute("allCars", depots);
            req.setAttribute("allRecorders", allRecorders);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        req.setAttribute("url", "/pages/back/cars/CarServlet/"+method);
        req.setAttribute("currentPage", currentPage);
        req.setAttribute("lineSize", lineSize);
        System.out.println("listSplit");
        return "/pages/back/cars/car_list.jsp";
    }
}
