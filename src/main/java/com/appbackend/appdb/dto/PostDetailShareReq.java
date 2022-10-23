package com.appbackend.appdb.dto;

import com.appbackend.appdb.entity.Post;
import com.appbackend.appdb.entity.User;

public class PostDetailShareReq {
    private int id;
    private int user_id;
    private String title;
    private String titlepic;
    private String content;
    private int sharemun;
    private String path;
    private int type;
    private long create_time;
    private int post_class_id;
    private int share_id;
    private int isopen;
    private int status;

    @Override
    public String toString() {
        return "PostDetailShareReq{" +
                "id=" + id +
                ", user_id=" + user_id +
                ", title='" + title + '\'' +
                ", titlepic='" + titlepic + '\'' +
                ", content='" + content + '\'' +
                ", sharemun=" + sharemun +
                ", path='" + path + '\'' +
                ", type=" + type +
                ", create_time=" + create_time +
                ", post_class_id=" + post_class_id +
                ", share_id=" + share_id +
                ", isopen=" + isopen +
                ", status=" + status +
                '}';
    }

    public void setPostDetailShareReq(Post post, User user){

        this.setId(post.getId());
        this.setUser_id(user.getId());
        this.setTitle(post.getTitle());
        this.setTitle("");
        this.setContent(post.getContent());
        this.setSharemun(0);
        this.setPath("未知");
        this.setType(0);
        this.setCreate_time(post.getCreateTime());
        this.setPost_class_id(post.getPostClassId());
        this.setShare_id(0);
        this.setIsopen(1);
        this.setStatus(1);

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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitlepic() {
        return titlepic;
    }

    public void setTitlepic(String titlepic) {
        this.titlepic = titlepic;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getSharemun() {
        return sharemun;
    }

    public void setSharemun(int sharemun) {
        this.sharemun = sharemun;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }


    public long getCreate_time() {
        return create_time;
    }

    public void setCreate_time(long create_time) {
        this.create_time = create_time;
    }

    public int getPost_class_id() {
        return post_class_id;
    }

    public void setPost_class_id(int post_class_id) {
        this.post_class_id = post_class_id;
    }

    public int getShare_id() {
        return share_id;
    }

    public void setShare_id(int share_id) {
        this.share_id = share_id;
    }

    public int getIsopen() {
        return isopen;
    }

    public void setIsopen(int isopen) {
        this.isopen = isopen;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
