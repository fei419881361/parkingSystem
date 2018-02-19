package com.parking.system.dao;

import com.parking.system.vo.Maintain;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by exphuhong
 * Date 18-2-19.
 * Start
 */
public interface MaintainDAO extends BaseDAO<Integer, Maintain> {
    @Override
    boolean doCreate(Maintain vo) throws SQLException;

    @Override
    List<Maintain> findAllBySplit(String colum, String keyWord, Integer curentPage, Integer lineSize) throws SQLException;

    @Override
    Integer getAllCount(String colum, String keyWord) throws SQLException;
}
