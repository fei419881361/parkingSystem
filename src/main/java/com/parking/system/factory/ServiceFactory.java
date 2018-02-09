package com.parking.system.factory;

import com.parking.system.service.AdminService;
import com.parking.system.service.Impl.AdminServiceImpl;

public class ServiceFactory {
    public static AdminService getIAdminServiceInstence(){
        return new AdminServiceImpl();
    }
}
