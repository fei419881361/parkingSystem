package com.parking.system.dao;

import com.parking.system.vo.Admin;
import com.parking.system.vo.Bill;
import com.parking.system.vo.Maintain;

import java.sql.SQLException;
import java.util.List;

public interface AdminDAO extends BaseDAO {
    Integer login(Admin admin) throws SQLException;

    boolean doCreate(Admin vo) throws SQLException;
    @Override
    List<Admin> findAllBySplit(String column, String keyWord, Integer currentPage, Integer lineSize) throws SQLException;

}
