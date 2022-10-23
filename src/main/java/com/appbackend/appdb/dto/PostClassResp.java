package com.appbackend.appdb.dto;

import com.appbackend.appdb.entity.PostClass;

import java.util.List;

public class PostClassResp {

    private List<PostClass> list;

    @Override
    public String toString() {
        return "PostClassResp{" +
                "list=" + list +
                '}';
    }

    public List<PostClass> getList() {
        return list;
    }

    public void setList(List<PostClass> list) {
        this.list = list;
    }
}
