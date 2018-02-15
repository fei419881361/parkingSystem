package com.parking.system.vo;

import java.io.Serializable;
import java.util.Date;

public class Admin implements Serializable {
   private Integer id;
   private String name;
   private Integer age;
   private Integer sex;
   private Date work_time;
   private String userName;
   private String password;
   private String phoneNumber;
   private Integer level;
   private Date creatTime;
   private Date updateTime;

    public Admin() {
    }

    public Admin(String name, Integer age, Integer sex, Date work_time, String userName, String password, String phoneNumber, Integer level, Date creatTime, Date updateTime) {
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.work_time = work_time;
        this.userName = userName;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.level = level;
        this.creatTime = creatTime;
        this.updateTime = updateTime;
    }

    public Admin(Integer id, String name, Integer age, Integer sex, Date work_time, String userName, String password, String phoneNumber, Integer level, Date creatTime, Date updateTime) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.work_time = work_time;
        this.userName = userName;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.level = level;
        this.creatTime = creatTime;
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", sex=" + sex +
                ", work_time=" + work_time +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", level=" + level +
                ", creatTime=" + creatTime +
                ", updateTime=" + updateTime +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public Date getWork_time() {
        return work_time;
    }

    public void setWork_time(Date work_time) {
        this.work_time = work_time;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Date getCreatTime() {
        return creatTime;
    }

    public void setCreatTime(Date creatTime) {
        this.creatTime = creatTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}
