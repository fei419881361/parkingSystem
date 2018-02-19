package com.parking.system.dao.Impl;

import com.parking.system.constinfo.ResponseInfo;
import com.parking.system.dao.AbstractDAOImpl;
import com.parking.system.dao.ParkingLotDAO;
import com.parking.system.vo.ParkingLot;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class ParkingLotDAOImpl extends AbstractDAOImpl implements ParkingLotDAO{
    public ParkingLotDAOImpl(Connection conn) {
        super(conn);
    }

    public boolean doCreate(ParkingLot vo) throws SQLException {
        String sql = "INSERT INTO parking_lot(park_id,number,postion,createTime,updateTime)  VALUES(?,?,?,?,?) ";
        super.pstmt = super.conn.prepareStatement(sql);
        super.pstmt.setInt(1,vo.getPark_id());
        super.pstmt.setInt(2,vo.getNumber());
        super.pstmt.setString(3,vo.getPosition());
        super.pstmt.setDate(4, new Date(vo.getCreateTime().getTime()));
        super.pstmt.setDate(5, new Date(vo.getUpdateTime().getTime()));

        return pstmt.executeUpdate()>0? ResponseInfo.SUCCESS:ResponseInfo.FAIL;
    }

    public boolean doUpdate(ParkingLot vo) throws SQLException {
        String sql = "UPDATE parking_lot SET number=?,postion=?,updateTime=? WHERE id = ?";
        pstmt = super.conn.prepareStatement(sql);
        super.pstmt = super.conn.prepareStatement(sql);
        super.pstmt.setInt(1,vo.getNumber());
        super.pstmt.setString(2,vo.getPosition());
        super.pstmt.setDate(3, new Date(vo.getUpdateTime().getTime()));
        super.pstmt.setInt(4,vo.getId());
        return pstmt.executeUpdate()>0? ResponseInfo.SUCCESS:ResponseInfo.FAIL;
    }

    public boolean doRemove(Set<?> ids) throws SQLException {
        Iterator iterator = ids.iterator();
        while (iterator.hasNext()) {
            String sql = "DELETE FROM parking_lot WHERE id = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, (Integer) iterator.next());
            if(pstmt.executeUpdate()<=0){
                return ResponseInfo.FAIL;
            }
        }
        return ResponseInfo.SUCCESS;
    }

    public ParkingLot findById(Integer id) throws SQLException {
        return null;
    }

    public List<ParkingLot> finaAll() throws SQLException {
        return null;
    }

    public List<ParkingLot> findAllBySplit(String colum, String keyWord, Integer curentPage, Integer lineSize) throws SQLException {
        return null;
    }

    public Integer getAllCount(String colum, String keyWord) throws SQLException {
        String sql = "SELECT COUNT(*) FROM Parking_lot WHERE "+colum+" = "+keyWord;
        super.pstmt = super.conn.prepareStatement(sql);
        ResultSet rs = super.pstmt.executeQuery();
        if(rs.next()){
            return rs.getInt(1);
        }
        return 0;
    }

    public List<ParkingLot> findAllBySplitAndParkID(Integer parkId, Integer curentPage, Integer lineSize) throws SQLException {
        List<ParkingLot> parkingLots = new ArrayList<ParkingLot>();
        String sql = "SELECT p.id,p.park_id,p.number,p.postion,p.createTime,p.updateTime FROM Parking_lot p WHERE park_id = ? LIMIT ?,?";
        super.pstmt = super.conn.prepareStatement(sql);
        super.pstmt.setInt(1,parkId);
        super.pstmt.setInt(2,(curentPage-1)*lineSize);
        super.pstmt.setInt(3,lineSize);
        ResultSet rs = super.pstmt.executeQuery();

        while(rs.next()){
            ParkingLot parkingLot= new ParkingLot();
            parkingLot.setId(rs.getInt(1));
            parkingLot.setPark_id(rs.getInt(2));
            parkingLot.setNumber(rs.getInt(3));
            parkingLot.setPosition(rs.getString(4));
            parkingLot.setCreateTime(rs.getDate(5));
            parkingLot.setUpdateTime(rs.getDate(6));
            parkingLots.add(parkingLot);

        }
        return parkingLots;
    }
}
