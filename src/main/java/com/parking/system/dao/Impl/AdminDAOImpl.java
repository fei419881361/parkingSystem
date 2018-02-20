package com.parking.system.dao.Impl;

import com.parking.system.constinfo.ResponseInfo;
import com.parking.system.dao.AbstractDAOImpl;
import com.parking.system.dao.AdminDAO;
import com.parking.system.vo.Admin;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class AdminDAOImpl extends AbstractDAOImpl implements AdminDAO {
    public AdminDAOImpl(Connection conn) {
        super(conn);
    }

    @Override
    public boolean doCreate(Admin vo) throws SQLException {
        String sql = "INSERT INTO admin (name, age, sex, work_time, userName, password, phoneNumber, level, creatTime)VALUE (?,?,?,?,?,?,?,?,?)";
        pstmt = super.conn.prepareStatement(sql);
        pstmt.setString(1, vo.getName());
        pstmt.setInt(2, vo.getAge());
        pstmt.setInt(3, vo.getSex());
        pstmt.setString(4, vo.getWork_time());
        pstmt.setString(5, vo.getUserName());
        pstmt.setString(6, vo.getPassword());
        pstmt.setString(7, vo.getPhoneNumber());
        pstmt.setInt(8, vo.getLevel());
        pstmt.setDate(9, new Date(vo.getCreatTime().getTime()));


        return pstmt.executeUpdate() > 0 ? ResponseInfo.SUCCESS : ResponseInfo.FAIL;
    }

    @Override
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

    public List<Admin> findAllBySplit(String colum, String keyWord, Integer curentPage, Integer lineSize) throws SQLException {
        List<Admin> admins = new ArrayList<Admin>();
        String sql = "SELECT a.id,a.name,a.age,a.sex,a.work_time,a.phoneNumber,a.level,a.creatTime," +
                "a.updateTime FROM admin a LIMIT ?,?";
        super.pstmt = super.conn.prepareStatement(sql);
        super.pstmt.setInt(1,(curentPage-1)*lineSize);
        super.pstmt.setInt(2,lineSize);
        ResultSet rs = super.pstmt.executeQuery();

        while(rs.next()){
            Admin admin = new Admin();
            admin.setId(rs.getInt(1));
            admin.setName(rs.getString(2));
            admin.setAge(rs.getInt(3));
            admin.setSex(rs.getInt(4));
            admin.setWork_time(rs.getString(5));
            admin.setPhoneNumber(rs.getString(6));
            admin.setLevel(rs.getInt(7));
            admin.setCreatTime(rs.getDate(8));
            admin.setUpdateTime(rs.getDate(9));
            admins.add(admin);
        }
        return admins;
    }

    public Integer getAllCount(String colum, String keyWord) throws SQLException {
        String sql = "SELECT COUNT(*) FROM admin WHERE "+colum+" LIKE ?";
        super.pstmt = super.conn.prepareStatement(sql);
        super.pstmt.setString(1,"%"+keyWord+"%");
        ResultSet rs = super.pstmt.executeQuery();
        if(rs.next()){
            return rs.getInt(1);
        }
        return 0;
    }

    public boolean doRemove(Set ids) throws SQLException {
        Iterator iterator = ids.iterator();
        while (iterator.hasNext()) {
            String sql = "DELETE FROM admin WHERE id = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, (Integer) iterator.next());
            if (pstmt.executeUpdate() <= 0) {
                return ResponseInfo.FAIL;
            }
        }
        return ResponseInfo.SUCCESS;

    }

    public Integer login(Admin vo) throws SQLException {
        String sql = "SELECT * FROM admin WHERE userName=? AND password=? ";
        super.pstmt = super.conn.prepareStatement(sql);
        super.pstmt.setString(1, vo.getUserName());
        super.pstmt.setString(2,vo.getPassword());
        ResultSet rs = super.pstmt.executeQuery();
        if (rs.next()){
            return ResponseInfo.LOGIN_SUCCESS;
        }
        return ResponseInfo.LOGIN_ERR;
    }
}
