package com.appbackend.appdb.dto;


import com.appbackend.appdb.entity.TopicClass;

import java.util.List;

public class TopicClassResp {

    private List<TopicClass> list;

    @Override
    public String toString() {
        return "TopicClassResp{" +
                "list=" + list +
                '}';
    }

    public List<TopicClass> getList() {

        return list;
    }

    public void setList(List<TopicClass> list) {
        this.list = list;
    }
}
