package com.parking.system.dao.Impl;

import com.parking.system.constinfo.ResponseInfo;
import com.parking.system.dao.AbstractDAOImpl;
import com.parking.system.dao.BillDAO;
import com.parking.system.vo.Bill;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Created by exphuhong
 * Date 18-2-19.
 * Start
 */
public class BillDAOImpl extends AbstractDAOImpl implements BillDAO {
    public BillDAOImpl(Connection conn) {
        super(conn);
    }

    @Override
    public boolean doCreate(Bill vo) throws SQLException {
        String sql = "INSERT into bill(park_id, in_time, out_time, bill, number, owner_name, owner_phone, createTime) VALUE (?,?,?,?,?,?,?,?)";
        pstmt = super.conn.prepareStatement(sql);
        pstmt.setInt(1, vo.getPark_id());
        pstmt.setString(2, vo.getIn_time());
        pstmt.setString(3, vo.getOut_time());
        pstmt.setDouble(4, vo.getBill());
        pstmt.setString(5, vo.getNumber());
        pstmt.setString(5, vo.getOwner_name());
        pstmt.setString(6, vo.getOwner_phone());
        pstmt.setDate(7, new Date(vo.getCreateTime().getTime()));
        return pstmt.executeUpdate() > 0 ? ResponseInfo.SUCCESS : ResponseInfo.FAIL;
    }

    @Override
    public boolean doUpdate(Bill vo) throws SQLException {
        return false;
    }

    @Override
    public boolean doRemove(Set<?> ids) throws SQLException {
        return false;
    }

    @Override
    public Bill findById(Integer id) throws SQLException {
        return null;
    }

    @Override
    public List<Bill> finaAll() throws SQLException {
        return null;
    }

    @Override
    public List<Bill> findAllBySplit(String colum, String keyWord, Integer curentPage, Integer lineSize) throws SQLException {
        String sql = "SELECT b.id,b.park_id,b.in_time,b.out_time,b.bill,b.owner_name" +
                ",b.owner_phone,b.createTime,b.updateTime FROM bill b LIMIT ?,?";
        pstmt = super.conn.prepareStatement(sql);
        ResultSet resultSet = pstmt.executeQuery();
        List<Bill> bills = new ArrayList<>();
        while (resultSet.next()) {
            Bill bill = new Bill();
            bill.setId(resultSet.getInt(1));
            bill.setPark_id(resultSet.getInt(2));
            bill.setIn_time(resultSet.getString(3));
            bill.setOut_time(resultSet.getString(4));
            bill.setBill(resultSet.getDouble(5));
            bill.setOwner_name(resultSet.getString(6));
            bill.setOwner_phone(resultSet.getString(7));
            bill.setCreateTime(resultSet.getDate(8));
            bill.setUpdateTime(resultSet.getDate(9));
            bills.add(bill);
        }
        return bills;
    }

    @Override
    public Integer getAllCount(String colum, String keyWord) throws SQLException {
        String sql = "SELECT COUNT(*)FROM bill";
        pstmt = super.conn.prepareStatement(sql);
        ResultSet resultSet = pstmt.executeQuery();
        return resultSet.next() ? resultSet.getInt(1) : 0;
    }
}
