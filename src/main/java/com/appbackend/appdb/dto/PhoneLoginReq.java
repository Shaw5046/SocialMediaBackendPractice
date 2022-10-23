package com.appbackend.appdb.dto;

public class PhoneLoginReq {
    private String msg;
    private UserReq data;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public UserReq getData() {
        return data;
    }

    public void setData(UserReq userReq) {
        this.data = userReq;
    }

    @Override
    public String toString() {
        return "PhoneLoginReq{" +
                "msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }
}
