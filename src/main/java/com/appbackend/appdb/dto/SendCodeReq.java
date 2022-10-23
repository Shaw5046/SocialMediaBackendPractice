package com.appbackend.appdb.dto;

public class SendCodeReq {
    private String msg;
    private boolean errorCode;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public boolean isErrorCode() {
        return errorCode;
    }

    public void setErrorCode(boolean errorCode) {
        this.errorCode = errorCode;
    }

    @Override
    public String toString() {
        return "SendCodeResp{" +
                "msg='" + msg + '\'' +
                ", errorCode=" + errorCode +
                '}';
    }
}
