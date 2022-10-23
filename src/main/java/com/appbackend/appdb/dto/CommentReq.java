package com.appbackend.appdb.dto;

import com.appbackend.appdb.entity.Comment;

import java.util.List;

public class CommentReq {

    private int id;
    private int user_id;
    private int fid;
    private int fnum;
    private String data;
    private long create_time;
    private int post_id;
    private UserReq user;


    public void setCommentReq(Comment comment, UserReq user){
        this.setId(comment.getId());
        this.setData(comment.getData());
        this.setCreate_time(comment.getCreateTime());
        this.setUser_id(comment.getUserId());
        this.setFid(comment.getFid());
        this.setFnum(comment.getFnum());
        this.setPost_id(comment.getPostId());
        this.setUser(user);
    }

    public UserReq getUser() {
        return user;
    }

    public void setUser(UserReq user) {
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getFid() {
        return fid;
    }

    public void setFid(int fid) {
        this.fid = fid;
    }

    public int getFnum() {
        return fnum;
    }

    public void setFnum(int fnum) {
        this.fnum = fnum;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public long getCreate_time() {
        return create_time;
    }

    public void setCreate_time(long create_time) {
        this.create_time = create_time;
    }

    public int getPost_id() {
        return post_id;
    }

    public void setPost_id(int post_id) {
        this.post_id = post_id;
    }
}
