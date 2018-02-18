package com.parking.system.service;

import com.parking.system.vo.Car;

import java.sql.SQLException;
import java.util.List;
import java.util.Set;

public interface CarService {
    List<Car> findAllBySplit(String colum, String keyWord, Integer curentPage, Integer lineSize) throws SQLException;

    Integer getAllCount(String col,String key) throws SQLException;

    boolean Insert(Car vo) throws SQLException;

    boolean Update(Car vo) throws SQLException;

    boolean Delete(Set ids) throws SQLException;


}
