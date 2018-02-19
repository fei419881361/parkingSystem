package com.parking.system.service;

import com.parking.system.vo.Depot;
import com.parking.system.vo.ParkingLot;

import java.sql.SQLException;
import java.util.List;
import java.util.Set;

public interface ParkingLotService {
    List<ParkingLot> findAllBySplitAndParkID(Integer parkId, Integer curentPage, Integer lineSize) throws SQLException;

    List<Depot> findAll() throws SQLException;

    Integer getAllCount(String col,String key) throws SQLException;

    boolean Insert(ParkingLot vo) throws SQLException;

    boolean Update(ParkingLot vo) throws SQLException;

    boolean Delete(Set ids) throws SQLException;
}
