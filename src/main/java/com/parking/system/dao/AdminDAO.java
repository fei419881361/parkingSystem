package com.parking.system.dao;

import com.parking.system.vo.Admin;

import java.sql.SQLException;

public interface AdminDAO extends BaseDAO {
    Integer login(Admin admin) throws SQLException;
}
