package com.parking.system.service;

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
public interface MaintainService {
    List<Maintain> findAllBySplit(String column, String keyWord, Integer currentPage, Integer lineSize) throws SQLException;

    Integer getAllCount(String col,String key) throws SQLException;

    boolean Insert(Maintain vo) throws SQLException;

    boolean Update(Maintain vo) throws SQLException;

    boolean Delete(Set ids) throws SQLException;
}
