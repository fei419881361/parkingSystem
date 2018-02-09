package com.parking.system.vo;

import java.io.Serializable;
import java.util.Date;

public class Admin implements Serializable {
    private Integer id;
    private String account;
    private String pwd;
    private String name;
    private Integer sex;
    private Date work_time;
    private String phone;
    private Integer level;
    private Integer age;

    public Admin() {
    }

    public Admin(String account, String pwd, String name, Integer sex, Date work_time, String phone, Integer level, Integer age) {
        this.account = account;
        this.pwd = pwd;
        this.name = name;
        this.sex = sex;
        this.work_time = work_time;
        this.phone = phone;
        this.level = level;
        this.age = age;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "id=" + id +
                ", account='" + account + '\'' +
                ", pwd='" + pwd + '\'' +
                ", name='" + name + '\'' +
                ", sex=" + sex +
                ", work_time=" + work_time +
                ", phone='" + phone + '\'' +
                ", level=" + level +
                ", age=" + age +
                '}';
    }
}
