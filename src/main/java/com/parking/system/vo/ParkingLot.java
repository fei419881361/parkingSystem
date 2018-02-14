package com.parking.system.vo;

import java.util.Date;

public class ParkingLot {
    private Integer id;
    private Integer park_id;
    private Integer number;
    private String position;
    private Date createTime;
    private Date updateTime;

    public ParkingLot() {
    }

    public ParkingLot(Integer id, Integer park_id, Integer number, String position, Date createTime, Date updateTime) {
        this.id = id;
        this.park_id = park_id;
        this.number = number;
        this.position = position;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    public ParkingLot(Integer park_id, Integer number, String position, Date createTime, Date updateTime) {
        this.park_id = park_id;
        this.number = number;
        this.position = position;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPark_id() {
        return park_id;
    }

    public void setPark_id(Integer park_id) {
        this.park_id = park_id;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        return "ParkingLot{" +
                "id=" + id +
                ", park_id=" + park_id +
                ", number=" + number +
                ", position='" + position + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }
}
