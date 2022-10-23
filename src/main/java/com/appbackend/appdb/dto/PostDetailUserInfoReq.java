package com.appbackend.appdb.dto;

import com.appbackend.appdb.entity.User;
import com.appbackend.appdb.entity.Userinfo;

public class PostDetailUserInfoReq {

    private int id;
    private int user_id;
    private int age;
    private int sex;
    private int qg;
    private String job;
    private String path;
    private String birthday;

    @Override
    public String toString() {
        return "PostDetailUserInfoReq{" +
                "id=" + id +
                ", user_id=" + user_id +
                ", age=" + age +
                ", sex=" + sex +
                ", qg=" + qg +
                ", job='" + job + '\'' +
                ", path='" + path + '\'' +
                ", birthday='" + birthday + '\'' +
                '}';
    }



    public void setPostDetailUserInfoReq(User user, Userinfo userinfo){

        this.setId(userinfo.getId());
        this.setUser_id(user.getId());
        this.setAge(userinfo.getAge());
        this.setSex(userinfo.getSex());
        this.setQg(userinfo.getQg());
        this.setJob(userinfo.getJob());
        this.setPath(userinfo.getPath());
        this.setBirthday(userinfo.getBirthday());

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
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
