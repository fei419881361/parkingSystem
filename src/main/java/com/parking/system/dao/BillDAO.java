package com.parking.system.dao;

import com.parking.system.vo.Bill;

import java.sql.SQLException;

/**
 * Created by exphuhong
 * Date 18-2-19.
 * Start
 */
public interface BillDAO extends BaseDAO<Integer, Bill> {
    @Override
    boolean doCreate(Bill vo) throws SQLException;
}