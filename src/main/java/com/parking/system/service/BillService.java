package com.parking.system.service;

import com.parking.system.vo.Bill;
import com.parking.system.vo.Car;
import com.parking.system.vo.Depot;

import java.sql.SQLException;
import java.util.List;
import java.util.Set;

/**
 * Created by exphuhong
 * Date 18-2-19.
 * Start
 */
public interface BillService {
    List<Bill> findAllBySplit(String column, String keyWord, Integer currentPage, Integer lineSize) throws SQLException;

    Integer getAllCount(String col,String key) throws SQLException;

    boolean Insert(Bill vo) throws SQLException;

    boolean Update(Bill vo) throws SQLException;

    boolean Delete(Set ids) throws SQLException;

}
