package com.parking.system.dao.Impl;

import com.parking.system.constinfo.ResponseInfo;
import com.parking.system.dao.AbstractDAOImpl;
import com.parking.system.dao.CarDAO;
import com.parking.system.vo.Car;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class CarDAOImpl extends AbstractDAOImpl implements CarDAO {
    public CarDAOImpl(Connection conn) {
        super(conn);
    }

    public boolean doCreate(Car vo) throws SQLException {
        String sql = "INSERT INTO car(park_id,car_num,owner_name,owner_phone,createTime,updateTime)  VALUES(?,?,?,?,?,?) ";
        super.pstmt = super.conn.prepareStatement(sql);
        super.pstmt.setInt(1,vo.getPark_id());
        super.pstmt.setString(2,vo.getCar_num());
        super.pstmt.setString(3,vo.getOwner_name());
        super.pstmt.setString(4,vo.getOwner_phone());
        super.pstmt.setDate(5, new Date(vo.getCreateTime().getTime()));
        super.pstmt.setDate(6, new Date(vo.getUpdateTime().getTime()));

        return pstmt.executeUpdate()>0? ResponseInfo.SUCCESS:ResponseInfo.FAIL;
    }

    public boolean doUpdate(Car vo) throws SQLException {
        String sql = "UPDATE car SET park_id=?,car_num=?,owner_name=?,owner_phone=?,createTime=?,updateTime=? WHERE id = ?";
        pstmt = super.conn.prepareStatement(sql);
        pstmt.setInt(1,vo.getPark_id());
        pstmt.setString(2,vo.getCar_num());
        pstmt.setString(3,vo.getOwner_name());
        pstmt.setString(4,vo.getOwner_phone());
        pstmt.setDate(5, new Date(vo.getCreateTime().getTime()) );
        pstmt.setDate(6, new Date(vo.getUpdateTime().getTime()));
        pstmt.setInt(7,vo.getId());
        return pstmt.executeUpdate()>0? ResponseInfo.SUCCESS:ResponseInfo.FAIL;
    }

    public boolean doRemove(Set<?> ids) throws SQLException {
        Iterator iterator = ids.iterator();
        while (iterator.hasNext()) {
            String sql = "DELETE FROM car WHERE id = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, (Integer) iterator.next());
            if(pstmt.executeUpdate()<=0){
                return ResponseInfo.FAIL;
            }
        }
        return ResponseInfo.SUCCESS;
    }


    public Car findById(Integer id) throws SQLException {
       return null;
    }

    public List<Car> finaAll() throws SQLException {
        return null;
    }

    public List<Car> findAllBySplit(String colum, String keyWord, Integer curentPage, Integer lineSize) throws SQLException {
        List<Car> cars = new ArrayList<Car>();
        String sql = "SELECT c.id,c.park_id,c.car_num,c.owner_name,c.owner_phone,c.createTime,c.updateTime FROM car c LIMIT ?,?";
        super.pstmt = super.conn.prepareStatement(sql);
        super.pstmt.setInt(1,(curentPage-1)*lineSize);
        super.pstmt.setInt(2,lineSize);
        ResultSet rs = super.pstmt.executeQuery();

        while(rs.next()){
            Car car= new Car();
            car.setId(rs.getInt(1));
            car.setPark_id(rs.getInt(2));
            car.setCar_num(rs.getString(3));
            car.setOwner_name(rs.getString(4));
            car.setOwner_phone(rs.getString(5));
            car.setCreateTime(rs.getDate(6));
            car.setUpdateTime(rs.getDate(7));
            cars.add(car);

        }
        return cars;
    }

    public Integer getAllCount(String colum, String keyWord) throws SQLException {
        return null;
    }

    public Car findByCarNumAndParkID(Car vo) throws SQLException {
        String sql = "SELECT c.id,c.owner_name,c.owner_phone,c.createTime,c.updateTime FROM car c" +
                " WHERE car_num = ? AND park_id= ?";
        super.pstmt = super.conn.prepareStatement(sql);
        pstmt.setString(1,vo.getCar_num());
        pstmt.setInt(2,vo.getPark_id());

        ResultSet rs = pstmt.executeQuery();
        while (rs.next()) {
            vo.setId(rs.getInt(rs.getInt(1)));
            vo.setOwner_name(rs.getString(2));
            vo.setOwner_phone(rs.getString(3));
            vo.setCreateTime(rs.getDate(4));
            vo.setUpdateTime(rs.getDate(5));
        }
        return vo;
    }

    public List<Car> findByFuzzy(String key,Integer curentPage, Integer lineSize) throws SQLException {
        List<Car> cars = new ArrayList<Car>();
        String sql = "SELECT c.id,c.park_id,c.car_num,c.owner_name,c.owner_phone,c.createTime,c.updateTime FROM car c " +
                "WHERE car_num LIKE ? OR owner_name LIKE ? OR owner_phone LIKE ? LIMIT ?,?";
        super.pstmt = super.conn.prepareStatement(sql);
        super.pstmt.setString(1,"%"+key+"%");
        super.pstmt.setString(2,"%"+key+"%");
        super.pstmt.setString(3,"%"+key+"%");
        super.pstmt.setInt(4,(curentPage-1)*lineSize);
        super.pstmt.setInt(5,lineSize);
        ResultSet rs = super.pstmt.executeQuery();

        while(rs.next()){
            Car car= new Car();
            car.setId(rs.getInt(1));
            car.setPark_id(rs.getInt(2));
            car.setCar_num(rs.getString(3));
            car.setOwner_name(rs.getString(4));
            car.setOwner_phone(rs.getString(5));
            car.setCreateTime(rs.getDate(6));
            car.setUpdateTime(rs.getDate(7));
            cars.add(car);

        }
        return cars;
    }
}
