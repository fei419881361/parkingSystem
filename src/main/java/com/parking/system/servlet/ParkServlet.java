package com.parking.system.servlet;


import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

/**
 * 对停车场的增删改查
 * */
@WebServlet(name = "parkServlet" ,urlPatterns = "/pages/back/ParkServlet/*")
public class ParkServlet extends HttpServlet {
}
