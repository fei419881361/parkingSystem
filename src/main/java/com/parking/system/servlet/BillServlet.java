package com.parking.system.servlet;

import com.parking.system.dbc.DatabaseConnection;
import com.parking.system.factory.DAOFactory;
import com.parking.system.factory.ServiceFactory;
import com.parking.system.util.Validate.ValidateUtils;
import com.parking.system.vo.Bill;
import com.parking.system.vo.Car;
import com.parking.system.vo.Depot;
import com.parking.system.vo.Maintain;

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

@WebServlet(name = "billServlet", urlPatterns = "/pages/back/bill/BillServlet/*")
public class BillServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String path = "/pages/errors.jsp";
        String status = req.getRequestURI().substring(req.getRequestURI().lastIndexOf("/") + 1);
        if (status != null) {
            if (status.equals("insertBill")) {
                path = this.insertBill(req);
            } else if (status.equals("listSplit")) {
                path = this.getBillInfo(req);
            } else if (status.equals("delete")) {
                path = this.deleteBillInfo(req);
            } else if (status.equals("update")) {
                path = this.updateBill(req);
            } else if (status.equals("insertPro")) {
                path = this.findAll(req);
            }
        }
        req.getRequestDispatcher(path).forward(req, resp);
    }

    private String findAll(HttpServletRequest request) {
        List<Depot> depots = null;
        try {
            depots = ServiceFactory.getIDepotServiceInstence().findAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        request.setAttribute("allPark_ids", depots);
        return "/pages/back/bill/bill_insert.jsp";
    }
    private String updateBill(HttpServletRequest request) {
        String url = "";
        String msg = "";

        String id = request.getParameter("id");
        String park_id = request.getParameter("park_id");
        String in_time = request.getParameter("in_time");
        String out_time = request.getParameter("out_time");
        String bill = request.getParameter("bill");
        String number = request.getParameter("number");
        String owner_name = request.getParameter("owner_name");
        String owner_phone = request.getParameter("owner_phone");

        if (ValidateUtils.validateEmpty(park_id) || ValidateUtils.validateEmpty(in_time) || ValidateUtils.validateEmpty(out_time)
                || ValidateUtils.validateEmpty(bill)|| ValidateUtils.validateEmpty(number)
                || ValidateUtils.validateEmpty(owner_name)|| ValidateUtils.validateEmpty(owner_phone)) {
            Date updateTime = new Date();
            Bill vo = new Bill();
            vo.setId(Integer.parseInt(id));
            vo.setBill(Double.parseDouble(bill));
            vo.setPark_id(Integer.parseInt(park_id));
            vo.setIn_time(in_time);
            vo.setOut_time(out_time);
            vo.setOwner_name(owner_name);
            vo.setOwner_phone(owner_phone);
            vo.setUpdateTime(updateTime);


            try {
                boolean success = ServiceFactory.getIBillServiceInstance().Update(vo);
                if (success) {
                    msg = "更新成功";
                    url = "/pages/back/bill/bill_list.jsp";
                } else {
                    msg = "更新失败";
                    url = "/pages/back/bill/bill_insert.jsp";
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            msg = "没有新的更改";
            url = "/pages/back/bill/bill_list.jsp";
        }
        request.setAttribute("msg", msg);
        request.setAttribute("url", url);
        return "/pages/forward.jsp";
    }

    private String insertBill(HttpServletRequest request) {
        String msg = "";
        String url = "";
        String park_id = request.getParameter("park_id");
        String in_time = request.getParameter("in_time");
        String out_time = request.getParameter("out_time");
        String bill = request.getParameter("bill");
        String number = request.getParameter("number");
        String owner_name = request.getParameter("owner_name");
        String owner_phone = request.getParameter("owner_phone");
        if (ValidateUtils.validateEmpty(park_id) && ValidateUtils.validateEmpty(in_time) && ValidateUtils.validateEmpty(out_time) &&
                ValidateUtils.validateEmpty(bill) && ValidateUtils.validateEmpty(number) &&
                ValidateUtils.validateEmpty(owner_name) && ValidateUtils.validateEmpty(owner_phone)) {

            Bill vo = new Bill();
            vo.setBill(Double.parseDouble(bill));
            vo.setIn_time(in_time);
            vo.setOut_time(out_time);
            vo.setPark_id(Integer.parseInt(park_id));
            vo.setNumber(number);
            vo.setOwner_name(owner_name);
            vo.setOwner_phone(owner_phone);
            vo.setCreateTime(new Date());

            Car car = new Car();
            car.setPark_id(Integer.parseInt(park_id));
            car.setOwner_name(owner_name);
            car.setOwner_phone(owner_phone);
            car.setCar_num(number);

            try {
                boolean flag = DAOFactory.getICarDAOInstance(new DatabaseConnection().getConn()).findByCarNumAndParkID(car);
                if (flag) {
                    bill = "0";
                    msg = "该车辆购买了车位";
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                boolean success = ServiceFactory.getIBillServiceInstance().Insert(vo);
                if (success) {
                    msg += "插入成功";
                    url = "/pages/back/bill/BillServlet/listSplit";
                } else {
                    msg += "插入失败";
                    url = "/pages/back/bill/BillServlet/listSplit";
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            msg = "输入有空";
            url = "/pages/back/bill/BillServlet/listSplit";
        }

        request.setAttribute("msg", msg);
        request.setAttribute("url", url);
        return "/pages/forward.jsp";
    }

    private String getBillInfo(HttpServletRequest request) {

        List<Depot> depots = null;
        try {
            depots = ServiceFactory.getIDepotServiceInstence().findAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        request.setAttribute("allPark_ids", depots);

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
        List<Bill> billList = null;

        String park_id = request.getParameter("park_id");
        try {
            billList = ServiceFactory.getIBillServiceInstance().findAllBySplit(null, park_id, currentPage, lineSize);
            Integer allCount = ServiceFactory.getIBillServiceInstance().getAllCount(null, park_id);
            request.setAttribute("allBills", allCount);
            request.setAttribute("billList", billList);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        request.setAttribute("currentPage", currentPage);
        request.setAttribute("lineSize", lineSize);
        return "/pages/back/bill/bill_list.jsp";
    }

    private String deleteBillInfo(HttpServletRequest request) {
        String msg = "";
        String url = "";
        Integer id = Integer.valueOf(request.getParameter("id"));
        System.out.println(id);
        Set<Integer> ids = new HashSet<Integer>();
        ids.add(id);
        try {
            if(ServiceFactory.getIBillServiceInstance().Delete(ids)){
                msg = "删除成功";
                url =  "/pages/forward.jsp";
            }else {
                msg = "删除失败";
                url = "/pages/forward.jsp";
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        request.setAttribute("msg", msg);
        request.setAttribute("url", url);
        return "/pages/forward.jsp";
    }
}