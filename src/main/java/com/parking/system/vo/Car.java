package com.parking.system.vo;

import java.util.Date;

/**
 * 有车位的车辆
 * */
public class Car {
    private Integer id;
    private Integer park_id;
    private String car_num;
    private String owner_name;
    private String owner_phone;
    private Date createTime;
    private Date updateTime;

    public Car() {
    }

    public Car(Integer park_id, String car_num, String owner_name, String owner_phone, Date createTime, Date updateTime) {
        this.park_id = park_id;
        this.car_num = car_num;
        this.owner_name = owner_name;
        this.owner_phone = owner_phone;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    public Car(Integer id, Integer park_id, String car_num, String owner_name, String owner_phone, Date createTime, Date updateTime) {
        this.id = id;
        this.park_id = park_id;
        this.car_num = car_num;
        this.owner_name = owner_name;
        this.owner_phone = owner_phone;
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

    public String getCar_num() {
        return car_num;
    }

    public void setCar_num(String car_num) {
        this.car_num = car_num;
    }

    public String getOwner_name() {
        return owner_name;
    }

    public void setOwner_name(String owner_name) {
        this.owner_name = owner_name;
    }

    public String getOwner_phone() {
        return owner_phone;
    }

    public void setOwner_phone(String owner_phone) {
        this.owner_phone = owner_phone;
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
        return "Car{" +
                "id=" + id +
                ", park_id=" + park_id +
                ", car_num='" + car_num + '\'' +
                ", owner_name='" + owner_name + '\'' +
                ", owner_phone='" + owner_phone + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }
}
