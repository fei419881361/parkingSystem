package com.parking.system.service;

import com.parking.system.vo.Admin;

import java.sql.SQLException;

public interface AdminService {

    Integer login(Admin admin) throws SQLException;
}
