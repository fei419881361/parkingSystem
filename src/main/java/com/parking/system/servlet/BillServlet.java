package com.parking.system.servlet;

import com.parking.system.factory.ServiceFactory;
import com.parking.system.util.Validate.ValidateUtils;
import com.parking.system.vo.Bill;
import com.parking.system.vo.Maintain;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

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
            }
        }
        req.getRequestDispatcher(path).forward(req, resp);
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
            vo.setPark_id(Integer.parseInt(park_id));
            vo.setNumber(number);
            vo.setOwner_name(owner_name);
            vo.setOwner_phone(owner_phone);
            vo.setCreateTime(new Date());

            try {
                boolean success = ServiceFactory.getIBillServiceInstance().Insert(vo);
                if (success) {
                    msg = "插入成功";
                    url = "/pages/back/bill/bill_list.jsp";
                } else {
                    msg = "插入失败";
                    url = "/pages/back/bill/bill_insert.jsp";
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            msg = "输入有空";
            url = "/pages/back/bill/bill_insert.jsp";
        }

        return "/pages/forward.jsp";
    }

    private String getBillInfo(HttpServletRequest request) {
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

        try {
            billList = ServiceFactory.getIBillServiceInstance().findAllBySplit(null, null, currentPage, lineSize);
            Integer allCount = ServiceFactory.getIBillServiceInstance().getAllCount(null, null);
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
    }
}
