package com.parking.system.vo;

import java.util.Date;

public class Bill {
    private Integer id;
    private Integer park_id;
    private Double bill;
    private String number;
    private String owner_name;
    private String owner_phone;
    private String in_time;
    private String out_time;
    private Date createTime;
    private Date updateTime;

    public Bill() {
    }

    public Bill(Integer park_id, Double bill, String number, String owner_name, String owner_phone, String in_time, String out_time, Date createTime, Date updateTime) {
        this.park_id = park_id;
        this.bill = bill;
        this.number = number;
        this.owner_name = owner_name;
        this.owner_phone = owner_phone;
        this.in_time = in_time;
        this.out_time = out_time;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    public Bill(Integer id, Integer park_id, Double bill, String number, String owner_name, String owner_phone, String in_time, String out_time, Date createTime, Date updateTime) {
        this.id = id;
        this.park_id = park_id;
        this.bill = bill;
        this.number = number;
        this.owner_name = owner_name;
        this.owner_phone = owner_phone;
        this.in_time = in_time;
        this.out_time = out_time;
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

    public Double getBill() {
        return bill;
    }

    public void setBill(Double bill) {
        this.bill = bill;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
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

    public String getIn_time() {
        return in_time;
    }

    public void setIn_time(String in_time) {
        this.in_time = in_time;
    }

    public String getOut_time() {
        return out_time;
    }

    public void setOut_time(String out_time) {
        this.out_time = out_time;
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
        return "Bill{" +
                "id=" + id +
                ", park_id=" + park_id +
                ", bill=" + bill +
                ", number='" + number + '\'' +
                ", owner_name='" + owner_name + '\'' +
                ", owner_phone='" + owner_phone + '\'' +
                ", in_time=" + in_time +
                ", out_time=" + out_time +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }
}
