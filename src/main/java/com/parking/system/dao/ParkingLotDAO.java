package com.parking.system.dao;

import com.parking.system.vo.ParkingLot;

import java.sql.SQLException;
import java.util.List;

public interface ParkingLotDAO extends BaseDAO<Integer,ParkingLot> {
    List<ParkingLot> findAllBySplitAndParkID(Integer parkId,Integer curentPage, Integer lineSize) throws SQLException;


}
