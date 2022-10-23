package com.appbackend.appdb.dto;

import com.appbackend.appdb.entity.PostImage;

public class ImagePivotReq {
    private int id;
    private int post_id;
    private int image_id;
    private long create_time;


    public void setPostImagePivotReq(PostImage postImage) {
        this.id = postImage.getId();
        this.post_id = postImage.getPostId();
        this.image_id = postImage.getImageId();
        this.create_time = postImage.getCreateTime();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPost_id() {
        return post_id;
    }

    public void setPost_id(int post_id) {
        this.post_id = post_id;
    }

    public int getImage_id() {
        return image_id;
    }

    public void setImage_id(int image_id) {
        this.image_id = image_id;
    }

    public long getCreate_time() {
        return create_time;
    }

    public void setCreate_time(long create_time) {
        this.create_time = create_time;
    }
}
