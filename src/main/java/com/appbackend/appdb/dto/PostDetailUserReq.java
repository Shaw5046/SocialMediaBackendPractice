package com.appbackend.appdb.dto;

import com.appbackend.appdb.entity.User;

import java.lang.reflect.Array;

public class PostDetailUserReq {

    private int id;
    private String username;
    private String userpic;
    private PostDetailUserInfoReq userinfo;

    @Override
    public String toString() {
        return "PostDetailUserReq{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", userpic='" + userpic + '\'' +
                ", userinfo=" + userinfo +
                '}';
    }

    public void setPostDetailUserReq(User user, PostDetailUserInfoReq postDetailUserInfoReq){

        this.setId(user.getId());
        this.setUsername(user.getUsername());
        this.setUserpic(user.getUserpic());
        this.setUserinfo(postDetailUserInfoReq);

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserpic() {
        return userpic;
    }

    public void setUserpic(String userpic) {
        this.userpic = userpic;
    }

    public PostDetailUserInfoReq getUserinfo() {
        return userinfo;
    }

    public void setUserinfo(PostDetailUserInfoReq userinfo) {
        this.userinfo = userinfo;
    }
}
