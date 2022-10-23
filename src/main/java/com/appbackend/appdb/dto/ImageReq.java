package com.appbackend.appdb.dto;

import com.appbackend.appdb.entity.Image;

public class ImageReq {

    private String url;
    private int user_id;
    private long create_time;
    private long update_time;
    private int id;
    private ImagePivotReq pivot;


    public void setPostImageReq(Image image, ImagePivotReq pivot){
        this.setUser_id(image.getUserId());
        this.setCreate_time(image.getCreateTime());
        this.setId(image.getId());
        this.setUpdate_time((int)System.currentTimeMillis()/1000);
        this.setUrl(image.getUrl());
        this.setPivot(pivot);

    }

    public void setPostImageReq(Image image){
        this.setUser_id(image.getUserId());
        this.setCreate_time(image.getCreateTime());
        this.setId(image.getId());
        this.setUpdate_time((int)System.currentTimeMillis()/1000);
        this.setUrl(image.getUrl());
        this.setPivot(null);

    }

    public ImagePivotReq getPivot() {
        return pivot;
    }

    public void setPivot(ImagePivotReq pivot) {
        this.pivot = pivot;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public long getCreate_time() {
        return create_time;
    }

    public void setCreate_time(long create_time) {
        this.create_time = create_time;
    }

    public long getUpdate_time() {
        return update_time;
    }

    public void setUpdate_time(long update_time) {
        this.update_time = update_time;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
