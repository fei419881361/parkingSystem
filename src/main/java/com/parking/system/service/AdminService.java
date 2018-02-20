package com.parking.system.service;

import com.parking.system.vo.Admin;
import com.parking.system.vo.Bill;

import java.sql.SQLException;
import java.util.List;
import java.util.Set;

public interface AdminService {

    Integer login(Admin admin) throws SQLException;

    List findAllBySplit(String column, String keyWord, Integer currentPage, Integer lineSize) throws SQLException;

    Integer getAllCount(String col,String key) throws SQLException;

    boolean Insert(Admin vo) throws SQLException;

    boolean Update(Admin vo) throws SQLException;

    boolean Delete(Set ids) throws SQLException;
}
