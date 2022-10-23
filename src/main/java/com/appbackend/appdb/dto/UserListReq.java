package com.appbackend.appdb.dto;

import java.util.List;

public class UserListReq {

    private List<UserReq> list;


    @Override
    public String toString() {
        return "UserListReq{" +
                "list=" + list +
                '}';
    }

    public List<UserReq> getList() {
        return list;
    }

    public void setList(List<UserReq> list) {
        this.list = list;
    }
}
