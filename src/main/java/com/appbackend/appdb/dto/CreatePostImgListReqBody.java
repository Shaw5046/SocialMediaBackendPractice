package com.appbackend.appdb.dto;

public class CreatePostImgListReqBody {
    private int id;//imgId
    private String url;


    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
