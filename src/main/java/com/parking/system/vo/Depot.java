package com.parking.system.vo;

import java.util.Date;

/**
 * 停车场实体类
 * */
public class Depot {
    private Integer id;
    private String developer;
    private String position;
    private String park_num;
    private Date createTime;
    private Date updateTime;

    public Depot() {
    }

    public Depot(Integer id, String developer, String position, String park_num, Date createTime, Date updateTime) {
        this.id = id;
        this.developer = developer;
        this.position = position;
        this.park_num = park_num;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    public Depot(String developer, String position, String park_num, Date createTime, Date updateTime) {
        this.developer = developer;
        this.position = position;
        this.park_num = park_num;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDeveloper() {
        return developer;
    }

    public void setDeveloper(String developer) {
        this.developer = developer;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getPark_num() {
        return park_num;
    }

    public void setPark_num(String park_num) {
        this.park_num = park_num;
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
        return "Depot{" +
                "id=" + id +
                ", developer='" + developer + '\'' +
                ", position='" + position + '\'' +
                ", park_num='" + park_num + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }
}
