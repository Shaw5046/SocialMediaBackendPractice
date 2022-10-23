package com.appbackend.appdb.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author yxt
 * @since 2022-04-23
 */
public class Userinfo implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 用户id
     */
    private Integer userId;

    /**
     * 年龄
     */
    private Integer age;

    /**
     * 0 男 1女 2不限
     */
    private Integer sex;

    /**
     * 0不限
     */
    private Integer qg;

    private String job;

    private String path;

    private String birthday;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
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

    public Integer getQg() {
        return qg;
    }

    public void setQg(Integer qg) {
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

    @Override
    public String toString() {
        return "Userinfo{" +
        "id=" + id +
        ", userId=" + userId +
        ", age=" + age +
        ", sex=" + sex +
        ", qg=" + qg +
        ", job=" + job +
        ", path=" + path +
        ", birthday=" + birthday +
        "}";
    }
}
