package com.parking.system.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "carServlet" ,urlPatterns = "/pages/back/CarServlet/*")
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

        }
        req.getRequestDispatcher(path).forward(req,resp);
    }
}
