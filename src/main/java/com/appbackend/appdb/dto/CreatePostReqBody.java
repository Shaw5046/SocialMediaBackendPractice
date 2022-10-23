package com.appbackend.appdb.dto;

import java.util.List;

public class CreatePostReqBody {
    private List<CreatePostImgListReqBody> imglist;
    private String text;
    private int isopen;
    private int topic_id;
    private int post_class_id;

    @Override
    public String toString() {
        return "CreatePostReqBody{" +
                "imglist=" + imglist +
                ", text='" + text + '\'' +
                ", isopen=" + isopen +
                ", topic_id=" + topic_id +
                ", post_class_id=" + post_class_id +
                '}';
    }

    public List<CreatePostImgListReqBody> getImglist() {
        return imglist;
    }

    public void setImglist(List<CreatePostImgListReqBody> imglist) {
        this.imglist = imglist;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getIsopen() {
        return isopen;
    }

    public void setIsopen(int isopen) {
        this.isopen = isopen;
    }

    public int getTopic_id() {
        return topic_id;
    }

    public void setTopic_id(int topic_id) {
        this.topic_id = topic_id;
    }

    public int getPost_class_id() {
        return post_class_id;
    }

    public void setPost_class_id(int post_class_id) {
        this.post_class_id = post_class_id;
    }
}
