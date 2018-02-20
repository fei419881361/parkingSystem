package com.parking.system.dao;

import com.parking.system.vo.Car;

import java.sql.SQLException;
import java.util.List;

public interface CarDAO extends BaseDAO<Integer,Car>  {
    boolean findByCarNumAndParkID(Car vo) throws SQLException;
    List<Car> findByFuzzy(String key,Integer curentPage, Integer lineSize)throws SQLException;
}
