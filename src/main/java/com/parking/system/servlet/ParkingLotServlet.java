package com.parking.system.servlet;


import com.parking.system.factory.ServiceFactory;
import com.parking.system.vo.Depot;
import com.parking.system.vo.ParkingLot;

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
 * 车位
 * */
@WebServlet(name = "parkingLotServlet" ,urlPatterns = "/pages/back/parkingLot/ParkingLotServlet/*")
public class ParkingLotServlet extends HttpServlet {
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
        Integer id = Integer.valueOf(req.getParameter("id"));
        System.out.println(id);
        Set<Integer> ids = new HashSet<Integer>();
        ids.add(id);
        try {
            if(ServiceFactory.getIParkingLotServiceInstence().Delete(ids)){
               return "success";
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return "fail";
    }

    private String update(HttpServletRequest req) {

        String number = req.getParameter("number");
        String postion = req.getParameter("postion");
        Integer id = Integer.valueOf(req.getParameter("id"));
        ParkingLot vo = new ParkingLot();
        vo.setId(id);
        vo.setUpdateTime(new Date());
        vo.setPosition(postion);
        vo.setNumber(Integer.valueOf(number));

        try {
            if(ServiceFactory.getIParkingLotServiceInstence().Update(vo)){
                return "success";
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "fail";
    }

    private String insertPro(HttpServletRequest req) {
        return null;
    }

    private String insert(HttpServletRequest req) {
        return null;
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
        String parkId = req.getParameter("pid");
        if(parkId==null){
            parkId = "1";
        }
        req.setAttribute("pid",parkId);
        try {
            List<ParkingLot> parkingLots = ServiceFactory.getIParkingLotServiceInstence().findAllBySplitAndParkID(Integer.valueOf(parkId),currentPage,lineSize);
            Integer allRecorders = ServiceFactory.getIParkingLotServiceInstence().getAllCount("park_id",parkId);

            req.setAttribute("allParkLots", parkingLots);
            req.setAttribute("allRecorders", allRecorders);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        req.setAttribute("url", "/pages/back/parkingLot/ParkingLotServlet/"+method);
        req.setAttribute("currentPage", currentPage);
        req.setAttribute("lineSize", lineSize);

        return "/pages/back/parkingLot/parkingLot_list.jsp";
    }
}
