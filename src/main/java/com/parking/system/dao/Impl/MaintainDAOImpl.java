package com.parking.system.dao.Impl;

import com.parking.system.constinfo.ResponseInfo;
import com.parking.system.dao.AbstractDAOImpl;
import com.parking.system.dao.MaintainDAO;
import com.parking.system.vo.Maintain;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 * Created by exphuhong
 * Date 18-2-19.
 * Start
 */
public class MaintainDAOImpl extends AbstractDAOImpl implements MaintainDAO {
    public MaintainDAOImpl(Connection conn) {
        super(conn);
    }

    @Override
    public boolean doCreate(Maintain vo) throws SQLException {
        String sql = "insert into maintain (cost,type,maintain_time,createTime)value(?,?,?,?) ";
        pstmt = conn.prepareStatement(sql);
        pstmt.setDouble(1, vo.getCost());
        pstmt.setInt(2, vo.getType());
        pstmt.setString(3, vo.getMaintain_time());
        pstmt.setDate(4,new Date( vo.getCreateTime().getTime()));
        return pstmt.executeUpdate() > 0 ? ResponseInfo.SUCCESS : ResponseInfo.FAIL;
    }

    @Override
    public boolean doUpdate(Maintain vo) throws SQLException {

        String sql = "UPDATE maintain SET type = ?,cost = ?,maintain_time = ?,updateTime = ?";
        pstmt = super.conn.prepareStatement(sql);
        pstmt.setInt(1, vo.getType());
        pstmt.setDouble(2, vo.getCost());
        pstmt.setString(3, vo.getMaintain_time());
        pstmt.setDate(4, new Date(vo.getUpdateTime().getTime()));

        return pstmt.executeUpdate() > 0 ? ResponseInfo.SUCCESS : ResponseInfo.FAIL;
    }

    @Override
    public boolean doRemove(Set<?> ids) throws SQLException {
        Iterator iterator = ids.iterator();
        while (iterator.hasNext()) {
            String sql = "DELETE FROM maintain WHERE id = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, (Integer) iterator.next());
            if(pstmt.executeUpdate()<=0){
                return ResponseInfo.FAIL;
            }
        }
        return ResponseInfo.SUCCESS;
    }

    @Override
    public Maintain findById(Integer id) throws SQLException {
        return null;
    }

    @Override
    public List<Maintain> finaAll() throws SQLException {

        return null;
    }

    @Override
    public List<Maintain> findAllBySplit(String column, String keyWord, Integer currentPage, Integer lineSize) throws SQLException {
        String sql = "SELECT m.id,m.cost,m.type,m.maintain_time,m.createTime,m.updateTime FROM maintain m LIMIT ?,?";
        pstmt = super.conn.prepareStatement(sql);
        super.pstmt.setInt(1,(currentPage-1)*lineSize);
        super.pstmt.setInt(2,lineSize);

        ResultSet resultSet = pstmt.executeQuery();
        List<Maintain> maintains = new ArrayList<>();
        while (resultSet.next()) {
            Maintain maintain = new Maintain();
            maintain.setId(resultSet.getInt(1));
            maintain.setCost(resultSet.getDouble(2));
            maintain.setType(resultSet.getInt(3));
            maintain.setMaintain_time(resultSet.getString(4));
            maintain.setCreateTime(resultSet.getDate(5));
            maintain.setUpdateTime(resultSet.getDate(6));
            maintains.add(maintain);
        }
        return maintains;
    }

    @Override
    public Integer getAllCount(String column, String keyWord) throws SQLException {
        String sql = "SELECT COUNT(*) FROM maintain";
        pstmt = super.conn.prepareStatement(sql);
        ResultSet resultSet = pstmt.executeQuery();
        Integer count = 0;
        while (resultSet.next()) {
            count += resultSet.getInt(1);
        }
        return count;
    }
}
