package com.parking.system.service;

import com.parking.system.vo.Depot;

import java.sql.SQLException;
import java.util.List;
import java.util.Set;

public interface DepotService {
    List<Depot> findAllBySplit(String colum, String keyWord, Integer curentPage, Integer lineSize) throws SQLException;

    List<Depot> findAll() throws SQLException;

    Integer getAllCount(String col,String key) throws SQLException;

    boolean Insert(Depot vo) throws SQLException;

    boolean Update(Depot vo) throws SQLException;

    boolean Delete(Set ids) throws SQLException;
}
