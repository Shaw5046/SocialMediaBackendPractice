package com.appbackend.appdb.dto;

import com.appbackend.appdb.entity.User;

import java.sql.Time;
import java.util.List;

public class UserReq {
    private int id;
    private String username;
    private String userpic;
    private boolean password;
    private String phone;
    private String email;
    private int statu;
    private Integer createTime;
    private String loginType;
    private String token;
    private UserInfoReq userinfo;
    private List<?> fens;
    private List<?> blackList;


    public void setUserReq(User user){
        this.setId(user.getId());
        this.setUsername(user.getUsername());
        this.setUserpic(user.getUserpic());
    }

    public void setUserReq(User user,UserInfoReq userInfoReq,List<?> fens,List<?> blackList){
        this.setId(user.getId());
        this.setUsername(user.getUsername());
        this.setUserpic(user.getUserpic());
        this.setPassword(false);
        this.setPhone(user.getPhone());
        this.setEmail(user.getEmail());
        this.setStatu(user.getStatus());
        this.setCreateTime(user.getCreateTime());
        this.setLoginType("phone");
        this.setToken(String.valueOf(user.getId()));
        this.setUserinfo(userInfoReq);
        this.setFens(fens);
        this.setBlackList(blackList);
    }


    public void setUserReq(User user,UserInfoReq userInfoReq){
        this.setId(user.getId());
        this.setUsername(user.getUsername());
        this.setUserpic(user.getUserpic());
        this.setPassword(false);
        this.setPhone(user.getPhone());
        this.setEmail(user.getEmail());
        this.setStatu(user.getStatus());
        this.setCreateTime(user.getCreateTime());
        this.setLoginType("phone");
        this.setToken(String.valueOf(user.getId()));
        this.setUserinfo(userInfoReq);
        this.setFens(null);
        this.setBlackList(null);
    }


    public List<?> getBlackList() {
        return blackList;
    }

    public void setBlackList(List<?> blackList) {
        this.blackList = blackList;
    }

    public List getFens() {
        return fens;
    }

    public void setFens(List fens) {
        this.fens = fens;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserpic() {
        return userpic;
    }

    public void setUserpic(String userpic) {
        this.userpic = userpic;
    }

    public boolean isPassword() {
        return password;
    }

    public void setPassword(boolean password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getStatu() {
        return statu;
    }

    public void setStatu(int statu) {
        this.statu = statu;
    }

    public Integer getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Integer createTime) {
        this.createTime = createTime;
    }

    public String getLoginType() {
        return loginType;
    }

    public void setLoginType(String loginType) {
        this.loginType = loginType;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public UserInfoReq getUserinfo() {
        return userinfo;
    }

    public void setUserinfo(UserInfoReq userinfo) {
        this.userinfo = userinfo;
    }
}
