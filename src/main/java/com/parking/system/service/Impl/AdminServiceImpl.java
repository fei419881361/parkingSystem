package com.parking.system.service.Impl;

import com.parking.system.dbc.DatabaseConnection;
import com.parking.system.factory.DAOFactory;
import com.parking.system.service.AdminService;
import com.parking.system.vo.Admin;

import java.sql.SQLException;

public class AdminServiceImpl implements AdminService{
    private DatabaseConnection dbc = new DatabaseConnection();
    public Integer login(Admin admin) throws SQLException {
        return DAOFactory.getIAdminDAOInstance(this.dbc.getConn()).login(admin);
    }
}
