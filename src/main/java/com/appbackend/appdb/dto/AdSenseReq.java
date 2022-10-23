package com.appbackend.appdb.dto;

import com.appbackend.appdb.entity.Adsense;

import java.time.LocalDateTime;

public class AdSenseReq {

    private int id;
    private String src;
    private String url;
    private int type;
    private LocalDateTime create_time;

    public void setAdSenseReq(Adsense adsense){
        this.setId(adsense.getId());
        this.setSrc(adsense.getSrc());
        this.setUrl(adsense.getUrl());
        this.setType(adsense.getType());
        this.setCreate_time(adsense.getCreateTime());
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSrc() {
        return src;
    }

    public void setSrc(String src) {
        this.src = src;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public LocalDateTime getCreate_time() {
        return create_time;
    }

    public void setCreate_time(LocalDateTime create_time) {
        this.create_time = create_time;
    }
}
