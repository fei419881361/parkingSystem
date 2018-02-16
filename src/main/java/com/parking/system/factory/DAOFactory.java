package com.parking.system.factory;

import com.parking.system.dao.AdminDAO;
import com.parking.system.dao.CarDAO;
import com.parking.system.dao.DepotDAO;
import com.parking.system.dao.Impl.AdminDAOImpl;
import com.parking.system.dao.Impl.CarDAOImpl;
import com.parking.system.dao.Impl.DepotDAOImpl;
import com.parking.system.dao.Impl.ParkingLotDAOImpl;
import com.parking.system.dao.ParkingLotDAO;
import com.parking.system.vo.ParkingLot;

import java.sql.Connection;

public class DAOFactory {
    public static AdminDAO getIAdminDAOInstance(Connection conn){
        return new AdminDAOImpl(conn);
    }
    public static DepotDAO getIDepotDAOInstance(Connection conn){
        return new DepotDAOImpl(conn);
    }
    public static CarDAO getICarDAOInstance(Connection conn){
        return new CarDAOImpl(conn);
    }
    public static ParkingLotDAO getIParkingLotInstance(Connection conn){
        return new ParkingLotDAOImpl(conn);
    }
}
