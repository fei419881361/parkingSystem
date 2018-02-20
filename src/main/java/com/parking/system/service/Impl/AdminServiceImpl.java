package com.parking.system.service.Impl;

import com.parking.system.dbc.DatabaseConnection;
import com.parking.system.factory.DAOFactory;
import com.parking.system.service.AdminService;
import com.parking.system.vo.Admin;
import com.parking.system.vo.Maintain;

import java.sql.SQLException;
import java.util.List;
import java.util.Set;

public class AdminServiceImpl implements AdminService{
    private DatabaseConnection dbc = new DatabaseConnection();
    public Integer login(Admin admin) throws SQLException {
        return DAOFactory.getIAdminDAOInstance(this.dbc.getConn()).login(admin);
    }

    @Override
    public List<Admin> findAllBySplit(String column, String keyWord, Integer currentPage, Integer lineSize) throws SQLException {

        return DAOFactory.getIAdminDAOInstance(this.dbc.getConn()).findAllBySplit(column, keyWord, currentPage, lineSize);
    }

    @Override
    public Integer getAllCount(String col, String key) throws SQLException {
        return DAOFactory.getIAdminDAOInstance(this.dbc.getConn()).getAllCount(col,key);
    }

    @Override
    public boolean Insert(Admin vo) throws SQLException {
        return DAOFactory.getIAdminDAOInstance(this.dbc.getConn()).doCreate(vo);
    }

    @Override
    public boolean Update(Admin vo) throws SQLException {
        return false;
    }

    @Override
    public boolean Delete(Set ids) throws SQLException {
        return DAOFactory.getIAdminDAOInstance(this.dbc.getConn()).doRemove(ids);
    }

}
