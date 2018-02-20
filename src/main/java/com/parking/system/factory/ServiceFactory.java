package com.parking.system.factory;

import com.parking.system.service.*;
import com.parking.system.service.Impl.*;

import com.parking.system.vo.ParkingLot;


public class ServiceFactory {
    /**
    * * @Author zlf
    * * @Description
    * * @Date 上午11:27 18-2-19
    *
    */
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

    /**
     * * @Author exphuhong
     * * @Description
     * * @Date 上午11:27 18-2-19
     */
    public static MaintainService getIMaintainServiceInstance() {
        return new MaintainServiceImpl();
    }

    public static BillService getIBillServiceInstance() {
        return new BillServiceImpl();
    }

}
