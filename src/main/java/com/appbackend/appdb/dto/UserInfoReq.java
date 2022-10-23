package com.appbackend.appdb.dto;

import com.appbackend.appdb.entity.Userinfo;

public class UserInfoReq {
    private int id;
    private int userId;
    private int age;
    private int sex;
    private int qg;
    private String job;
    private String path;
    private String birthday;

    @Override
    public String toString() {
        return "userinfo{" +
                "id=" + id +
                ", user_id=" + userId +
                ", age=" + age +
                ", sex=" + sex +
                ", qg=" + qg +
                ", job='" + job + '\'' +
                ", path='" + path + '\'' +
                ", birthday='" + birthday + '\'' +
                '}';
    }

    public void setUserInfoReq(Userinfo userinfo){
        this.setAge(userinfo.getAge());
        this.setUserId(userinfo.getUserId());
        this.setBirthday(userinfo.getBirthday());
        this.setId(userinfo.getId());
        this.setJob(userinfo.getJob());
        this.setPath(userinfo.getPath());
        this.setQg(userinfo.getQg());
        this.setSex(userinfo.getSex());
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public int getQg() {
        return qg;
    }

    public void setQg(int qg) {
        this.qg = qg;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }
}
