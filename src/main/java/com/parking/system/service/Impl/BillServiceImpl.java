package com.parking.system.service.Impl;

import com.parking.system.dbc.DatabaseConnection;
import com.parking.system.factory.DAOFactory;
import com.parking.system.service.BillService;
import com.parking.system.vo.Bill;
import com.parking.system.vo.Car;
import com.parking.system.vo.Depot;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Set;

/**
 * Created by exphuhong
 * Date 18-2-19.
 * Start
 */
public class BillServiceImpl implements BillService {

    private Connection connection = new DatabaseConnection().getConn();
    @Override
    public List<Bill> findAllBySplit(String column, String keyWord, Integer currentPage, Integer lineSize) throws SQLException {

        return DAOFactory.getIBillDAOInstance(this.connection).findAllBySplit(column, keyWord, currentPage, lineSize);
    }

    @Override
    public Integer getAllCount(String col, String key) throws SQLException {
        return DAOFactory.getIBillDAOInstance(this.connection).getAllCount(col,key);
    }

    @Override
    public boolean Insert(Bill vo) throws SQLException {
        return DAOFactory.getIBillDAOInstance(this.connection).doCreate(vo);
    }

    @Override
    public boolean Update(Bill vo) throws SQLException {
        return DAOFactory.getIBillDAOInstance(this.connection).doUpdate(vo);
    }

    @Override
    public boolean Delete(Set ids) throws SQLException {

        return DAOFactory.getIBillDAOInstance(this.connection).doRemove(ids);
    }

}