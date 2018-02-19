package com.parking.system.factory;

import com.parking.system.dao.*;
import com.parking.system.dao.Impl.*;
import com.parking.system.vo.ParkingLot;

import java.sql.Connection;

public class DAOFactory {

    /**
    * * @Author zlf
    * * @Description
    * * @Date 上午11:39 18-2-19
    *
    */
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
    /**
    * * @Author exphuhong
    * * @Description
    * * @Date 上午11:39 18-2-19
    *
    */
    public static MaintainDAO getIMaintainDAOInstance(Connection connection){
        return new MaintainDAOImpl(connection);
    }
}
