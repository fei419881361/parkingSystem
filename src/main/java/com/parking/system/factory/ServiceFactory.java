package com.parking.system.factory;

import com.parking.system.service.AdminService;
import com.parking.system.service.CarService;
import com.parking.system.service.DepotService;
import com.parking.system.service.Impl.AdminServiceImpl;
import com.parking.system.service.Impl.CarServiceImpl;
import com.parking.system.service.Impl.DepotServiceImpl;
import com.parking.system.service.Impl.ParkingLotServiceImpl;
import com.parking.system.service.ParkingLotService;
import com.parking.system.vo.ParkingLot;

public class ServiceFactory {
    public static AdminService getIAdminServiceInstence(){
        return new AdminServiceImpl();
    }
    public static DepotService getIDepotServiceInstence(){
        return new DepotServiceImpl();
    }
    public static CarService getICarServiceInstence(){
        return new CarServiceImpl();
    }
    public static ParkingLotService getIParkingLotServiceInstence(){
        return new ParkingLotServiceImpl();
    }

}
