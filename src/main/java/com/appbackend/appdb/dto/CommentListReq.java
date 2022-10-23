package com.appbackend.appdb.dto;

import java.util.List;

public class CommentListReq {
    private List<CommentReq> list;

    public List<CommentReq> getList() {
        return list;
    }

    public void setList(List<CommentReq> list) {
        this.list = list;
    }
}
