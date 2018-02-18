package com.parking.system.service.Impl;

import com.parking.system.dbc.DatabaseConnection;
import com.parking.system.factory.DAOFactory;
import com.parking.system.service.DepotService;
import com.parking.system.vo.Depot;

import java.sql.SQLException;
import java.util.List;
import java.util.Set;

public class DepotServiceImpl implements DepotService{
    private DatabaseConnection dbc = new DatabaseConnection();
    public List<Depot> findAllBySplit(String colum, String keyWord, Integer curentPage, Integer lineSize) throws SQLException {
        if (curentPage == null || lineSize == null) {
            return null;
        }
        return DAOFactory.getIDepotDAOInstance(this.dbc.getConn()).findAllBySplit(colum,keyWord,curentPage,lineSize);
    }

    @Override
    public List<Depot> findAll() throws SQLException {
        return DAOFactory.getIDepotDAOInstance(new DatabaseConnection().getConn()).finaAll();
    }

    public Integer getAllCount(String col, String key) throws SQLException {
        return DAOFactory.getIDepotDAOInstance(this.dbc.getConn()).getAllCount(col,key);
    }

    public boolean Insert(Depot vo) throws SQLException {
        return DAOFactory.getIDepotDAOInstance(this.dbc.getConn()).doCreate(vo);
    }

    public boolean Update(Depot vo) throws SQLException {
        return DAOFactory.getIDepotDAOInstance(this.dbc.getConn()).doUpdate(vo);
    }

    public boolean Delete(Set ids) throws SQLException {
        return DAOFactory.getIDepotDAOInstance(this.dbc.getConn()).doRemove(ids);
    }
}
