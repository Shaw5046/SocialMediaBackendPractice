package com.appbackend.appdb.dto;

import java.util.List;

public class TopicListReq {

    private List<TopicReq> list;

    @Override
    public String toString() {
        return "TopicListReq{" +
                "topicReqList=" + list +
                '}';
    }

    public List<TopicReq> getList() {
        return list;
    }

    public void setList(List<TopicReq> list) {
        this.list = list;
    }
}
