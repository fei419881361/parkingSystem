package com.parking.system.factory;

import com.parking.system.dao.AdminDAO;
import com.parking.system.dao.DepotDAO;
import com.parking.system.dao.Impl.AdminDAOImpl;
import com.parking.system.dao.Impl.DepotDAOImpl;

import java.sql.Connection;

public class DAOFactory {
    public static AdminDAO getIAdminDAOInstance(Connection conn){
        return new AdminDAOImpl(conn);
    }
    public static DepotDAO getIDepotDAOInstance(Connection conn){
        return new DepotDAOImpl(conn);
    }
}
