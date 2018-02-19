package com.parking.system.factory;

import com.parking.system.service.AdminService;
import com.parking.system.service.CarService;
import com.parking.system.service.DepotService;
import com.parking.system.service.Impl.AdminServiceImpl;
import com.parking.system.service.Impl.CarServiceImpl;
import com.parking.system.service.Impl.DepotServiceImpl;
import com.parking.system.service.Impl.MaintainServiceImpl;
import com.parking.system.service.MaintainService;

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

    /**
     * * @Author exphuhong
     * * @Description
     * * @Date 上午11:27 18-2-19
     */
    public static MaintainService getIMaintainServiceInstance() {
        return new MaintainServiceImpl();
    }


}
