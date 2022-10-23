package com.appbackend.appdb.dto;

import java.util.List;

public class PostListResp {
    private List<PostDetailReq> list;

    @Override
    public String toString() {
        return "PostListTopicResp{" +
                "list=" + list +
                '}';
    }

    public List<PostDetailReq> getList() {
        return list;
    }

    public void setList(List<PostDetailReq> list) {
        this.list = list;
    }



}
