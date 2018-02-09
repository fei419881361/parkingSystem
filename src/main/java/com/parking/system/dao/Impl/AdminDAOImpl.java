package com.parking.system.dao.Impl;

import com.parking.system.constinfo.ResponseInfo;
import com.parking.system.dao.AbstractDAOImpl;
import com.parking.system.dao.AdminDAO;
import com.parking.system.vo.Admin;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Set;

public class AdminDAOImpl extends AbstractDAOImpl implements AdminDAO {
    public AdminDAOImpl(Connection conn) {
        super(conn);
    }
    public boolean doCreate(Object vo) throws SQLException {
        return false;
    }

    public boolean doUpdate(Object vo) throws SQLException {
        return false;
    }

    public Object findById(Object id) throws SQLException {
        return null;
    }

    public List finaAll() throws SQLException {
        return null;
    }

    public List findAllBySplit(String colum, String keyWord, Integer curentPage, Integer lineSize) throws SQLException {
        return null;
    }

    public Integer getAllCount(String colum, String keyWord) throws SQLException {
        return null;
    }

    public boolean doRemove(Set ids) throws SQLException {
        return false;
    }

    public Integer login(Admin vo) throws SQLException {
        String sql = "SELECT * FROM admin WHERE account=? AND pwd=? ";
        super.pstmt = super.conn.prepareStatement(sql);
        super.pstmt.setString(1, vo.getAccount());
        super.pstmt.setString(2,vo.getPwd());
        ResultSet rs = super.pstmt.executeQuery();
        if (rs.next()){
            return ResponseInfo.LOGIN_SUCCESS;
        }
        return ResponseInfo.LOGIN_ERR;
    }
}
