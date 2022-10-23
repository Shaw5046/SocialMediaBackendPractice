package com.appbackend.appdb.dto;

//从后台向前台 返回验证信息 的封装实体bean
public class RespBean {

    private String msg;
    private Object data;

    @Override
    public String toString() {
        return "RespBean{" +
                "msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }

    public RespBean(String msg, Object data) {
        this.msg = msg;
        this.data = data;
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
