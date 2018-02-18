package com.parking.system.factory;

import com.parking.system.service.AdminService;
import com.parking.system.service.CarService;
import com.parking.system.service.DepotService;
import com.parking.system.service.Impl.AdminServiceImpl;
import com.parking.system.service.Impl.CarServiceImpl;
import com.parking.system.service.Impl.DepotServiceImpl;

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

}
