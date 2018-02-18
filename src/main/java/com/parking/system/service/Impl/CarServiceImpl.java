package com.parking.system.service.Impl;

import com.parking.system.dbc.DatabaseConnection;
import com.parking.system.factory.DAOFactory;
import com.parking.system.service.CarService;
import com.parking.system.vo.Car;

import java.sql.SQLException;
import java.util.List;
import java.util.Set;

public class CarServiceImpl implements CarService {
    private DatabaseConnection dbc = new DatabaseConnection();
    @Override
    public List<Car> findAllBySplit(String colum, String keyWord, Integer curentPage, Integer lineSize) throws SQLException {
        if (curentPage == null || lineSize == null) {
            return null;
        }
        return DAOFactory.getICarDAOInstance(this.dbc.getConn()).findAllBySplit(colum,keyWord,curentPage,lineSize);
    }

    @Override
    public Integer getAllCount(String col, String key) throws SQLException {
        return null;
    }

    @Override
    public boolean Insert(Car vo) throws SQLException {
        return  DAOFactory.getICarDAOInstance(this.dbc.getConn()).doCreate(vo);
    }

    @Override
    public boolean Update(Car vo) throws SQLException {
        return DAOFactory.getICarDAOInstance(this.dbc.getConn()).doUpdate(vo);
    }

    @Override
    public boolean Delete(Set ids) throws SQLException {
        return DAOFactory.getICarDAOInstance(this.dbc.getConn()).doRemove(ids);
    }
}
