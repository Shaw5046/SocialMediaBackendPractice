package com.appbackend.appdb.dto;

import java.util.List;

public class AdSenseListReq {
    private List<AdSenseReq> list;

    public void setAdSenseListReq(List<AdSenseReq> list) {
        this.list = list;
    }

    public List<AdSenseReq> getList() {
        return list;
    }

    public void setList(List<AdSenseReq> list) {
        this.list = list;
    }
}
