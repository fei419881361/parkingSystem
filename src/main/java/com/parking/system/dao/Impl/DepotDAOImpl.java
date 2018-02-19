package com.parking.system.dao.Impl;

import com.parking.system.constinfo.ResponseInfo;
import com.parking.system.dao.AbstractDAOImpl;
import com.parking.system.dao.DepotDAO;
import com.parking.system.vo.Depot;

import java.sql.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class DepotDAOImpl extends AbstractDAOImpl implements DepotDAO {
    public DepotDAOImpl(Connection conn) {
        super(conn);
    }



    public boolean doCreate(Depot vo) throws SQLException {
        String sql = "INSERT INTO depot(developer,postion,park_num,createTime,updateTime)  VALUES(?,?,?,?,?) ";
        super.pstmt = super.conn.prepareStatement(sql);
        super.pstmt.setString(1,vo.getDeveloper());
        super.pstmt.setString(2,vo.getPosition());
        super.pstmt.setString(3,vo.getPark_num());
        super.pstmt.setDate(4, new Date(vo.getCreateTime().getTime()));
        super.pstmt.setDate(5, new Date(vo.getUpdateTime().getTime()));

        return pstmt.executeUpdate()>0?ResponseInfo.SUCCESS:ResponseInfo.FAIL;
    }


    public boolean doUpdate(Depot vo) throws SQLException {
        String sql = "UPDATE depot SET developer=?,postion=?,park_num=?,updateTime=? WHERE id = ?";
        pstmt = super.conn.prepareStatement(sql);
        pstmt.setString(1,vo.getDeveloper());
        pstmt.setString(2,vo.getPosition());
        pstmt.setString(3,vo.getPark_num());
        pstmt.setDate(4, new Date(vo.getUpdateTime().getTime()));
        pstmt.setInt(5,vo.getId());
        return pstmt.executeUpdate()>0? ResponseInfo.SUCCESS:ResponseInfo.FAIL;
    }

    public Depot findById(Integer id) throws SQLException {
        String sql = "SELECT d.id,d.developer,d.postion,d.park_num,d.createTime,d.updateTime FROM depot d WHERE id = ? ";
        super.pstmt = super.conn.prepareStatement(sql);
        super.pstmt.setInt(1,id);
        ResultSet rs = super.pstmt.executeQuery();

        while(rs.next()){
            Depot depot= new Depot();
            depot.setId(rs.getInt(1));
            depot.setDeveloper(rs.getString(2));
            depot.setPosition(rs.getString(3));
            depot.setPark_num(rs.getString(4));
            depot.setCreateTime(rs.getDate(5));
            depot.setUpdateTime(rs.getDate(6));

            return depot;
        }
        return null;
    }

    public List finaAll() throws SQLException {
        List<Depot> depots = new ArrayList<Depot>();
        String sql = "SELECT d.id,d.developer,d.postion,d.park_num,d.createTime,d.updateTime FROM depot d ";
        super.pstmt = super.conn.prepareStatement(sql);
        ResultSet rs = super.pstmt.executeQuery();

        while(rs.next()){
            Depot depot= new Depot();
            depot.setId(rs.getInt(1));
            depot.setDeveloper(rs.getString(2));
            depot.setPosition(rs.getString(3));
            depot.setPark_num(rs.getString(4));
            depot.setCreateTime(rs.getDate(5));
            depot.setUpdateTime(rs.getDate(6));

            depots.add(depot);
        }
        return depots;
    }

    public List findAllBySplit(String colum, String keyWord, Integer curentPage, Integer lineSize) throws SQLException {
        List<Depot> depots = new ArrayList<Depot>();
        String sql = "SELECT d.id,d.developer,d.postion,d.park_num,d.createTime,d.updateTime FROM depot d LIMIT ?,?";
        super.pstmt = super.conn.prepareStatement(sql);
        super.pstmt.setInt(1,(curentPage-1)*lineSize);
        super.pstmt.setInt(2,lineSize);
        ResultSet rs = super.pstmt.executeQuery();

        while(rs.next()){
            Depot depot= new Depot();
            depot.setId(rs.getInt(1));
            depot.setDeveloper(rs.getString(2));
            depot.setPosition(rs.getString(3));
            depot.setPark_num(rs.getString(4));
            depot.setCreateTime(rs.getDate(5));
            depot.setUpdateTime(rs.getDate(6));
            depots.add(depot);

        }
        return depots;
    }

    public Integer getAllCount(String colum, String keyWord) throws SQLException {
        String sql = "SELECT COUNT(*) FROM depot";
        super.pstmt = super.conn.prepareStatement(sql);
        ResultSet rs = super.pstmt.executeQuery();
        if(rs.next()){
            return rs.getInt(1);
        }
        return 0;
    }

    public boolean doRemove(Set ids) throws SQLException {
        Iterator iterator = ids.iterator();
        while (iterator.hasNext()) {
            String sql = "DELETE FROM depot WHERE id = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, (Integer) iterator.next());
            if(pstmt.executeUpdate()<=0){
                return ResponseInfo.FAIL;
            }
        }
        return ResponseInfo.SUCCESS;
    }



}
