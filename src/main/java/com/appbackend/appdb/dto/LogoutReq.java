package com.appbackend.appdb.dto;

import java.util.List;

public class LogoutReq {
    private String msg;
    private List<Object> data;

    @Override
    public String toString() {
        return "LogoutReq{" +
                "msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List getData() {
        return data;
    }

    public void setData(List<Object> data) {
        this.data = data;
    }
}
