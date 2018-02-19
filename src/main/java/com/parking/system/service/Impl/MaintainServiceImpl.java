package com.parking.system.service.Impl;

import com.parking.system.dbc.DatabaseConnection;
import com.parking.system.factory.DAOFactory;
import com.parking.system.service.MaintainService;
import com.parking.system.vo.Car;
import com.parking.system.vo.Maintain;

import java.sql.SQLException;
import java.util.List;
import java.util.Set;

/**
 * Created by exphuhong
 * Date 18-2-19.
 * Start
 */
public class MaintainServiceImpl implements MaintainService {
    @Override
    public List<Maintain> findAllBySplit(String column, String keyWord, Integer currentPage, Integer lineSize) throws SQLException {
        return DAOFactory.getIMaintainDAOInstance(new DatabaseConnection().getConn()).findAllBySplit(column, keyWord, currentPage, lineSize);
    }

    @Override
    public Integer getAllCount(String col, String key) throws SQLException {
        return DAOFactory.getIMaintainDAOInstance(new DatabaseConnection().getConn()).getAllCount(col, key);
    }

    @Override
    public boolean Insert(Maintain vo) throws SQLException {

        return DAOFactory.getIMaintainDAOInstance(new DatabaseConnection().getConn()).doCreate(vo);
    }

    @Override
    public boolean Update(Maintain vo) throws SQLException {
        return DAOFactory.getIMaintainDAOInstance(new DatabaseConnection().getConn()).doUpdate(vo);
    }

    @Override
    public boolean Delete(Set ids) throws SQLException {
        return DAOFactory.getIMaintainDAOInstance(new DatabaseConnection().getConn()).doRemove(ids);
    }
}
