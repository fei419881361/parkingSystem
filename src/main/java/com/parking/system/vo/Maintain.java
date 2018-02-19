package com.parking.system.vo;

import java.time.LocalDateTime;
import java.util.Date;

/**
 * 保养记录
 * */
public class Maintain {
    private Integer id;
    private Double cost;
    private Integer type;
    private String maintain_time;
    private Date createTime;
    private Date updateTime;

    public Maintain() {
    }

    public Maintain(Integer id, Double cost, Integer type, String maintain_time, Date createTime, Date updateTime) {
        this.id = id;
        this.cost = cost;
        this.type = type;
        this.maintain_time = maintain_time;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    public Maintain(Double cost, Integer type, String maintain_time, Date createTime) {
        this.cost = cost;
        this.type = type;
        this.maintain_time = maintain_time;
        this.createTime = createTime;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getMaintain_time() {
        return maintain_time;
    }

    public void setMaintain_time(String maintain_time) {
        this.maintain_time = maintain_time;
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
        return "Maintain{" +
                "id=" + id +
                ", cost=" + cost +
                ", type=" + type +
                ", maintain_time=" + maintain_time +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }
}
