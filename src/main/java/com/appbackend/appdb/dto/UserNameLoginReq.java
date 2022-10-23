package com.appbackend.appdb.dto;

import java.sql.Time;

public class UserNameLoginReq {

    private String msg;
    private Object data;

    @Override
    public String toString() {
        return "UserNameLoginReq{" +
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

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
