package com.parking.system.service.Impl;

import com.parking.system.dbc.DatabaseConnection;
import com.parking.system.factory.DAOFactory;
import com.parking.system.service.ParkingLotService;
import com.parking.system.vo.Depot;
import com.parking.system.vo.ParkingLot;

import java.sql.SQLException;
import java.util.List;
import java.util.Set;

public class ParkingLotServiceImpl implements ParkingLotService {
    private DatabaseConnection dbc = new DatabaseConnection();
    @Override
    public List<ParkingLot> findAllBySplitAndParkID(Integer parkId, Integer curentPage, Integer lineSize) throws SQLException {
        return DAOFactory.getIParkingLotDAOInstance(this.dbc.getConn()).findAllBySplitAndParkID(parkId,curentPage,lineSize);
    }

    @Override
    public List<Depot> findAll() throws SQLException {
        return null;
    }

    @Override
    public Integer getAllCount(String col, String key) throws SQLException {
        return DAOFactory.getIParkingLotDAOInstance(this.dbc.getConn()).getAllCount(col,key);
    }

    @Override
    public boolean Insert(ParkingLot vo) throws SQLException {
        return DAOFactory.getIParkingLotDAOInstance(this.dbc.getConn()).doCreate(vo);
    }

    @Override
    public boolean Update(ParkingLot vo) throws SQLException {
        return DAOFactory.getIParkingLotDAOInstance(this.dbc.getConn()).doUpdate(vo);
    }

    @Override
    public boolean Delete(Set ids) throws SQLException {
        return DAOFactory.getIParkingLotDAOInstance(this.dbc.getConn()).doRemove(ids);
    }
}