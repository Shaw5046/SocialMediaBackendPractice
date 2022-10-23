package com.appbackend.appdb.dto;

import com.appbackend.appdb.entity.Post;
import com.appbackend.appdb.entity.Support;

import java.util.List;

public class PostDetailReq {

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
    private int ding_count;
    private int cai_count;
    private int comment_count;

    private UserReq user;
    private List<ImageReq> images;
    private PostDetailShareReq share;
    private List<Support> support;



    public void setPostDetailReq(Post post, UserReq userReq,
                                 List<ImageReq> imageList){

        this.setId(post.getId());
        this.setUser_id(userReq.getId());
        this.setTitle(post.getTitle());
        this.setTitlepic(post.getTitlepic());
        this.setContent(post.getContent());
        this.setSharemun(0);
        this.setPath("未知");
        this.setType(0);
        this.setCreate_time(post.getCreateTime());
        this.setPost_class_id(post.getPostClassId());
        this.setShare_id(0);
        this.setIsopen(1);
        this.setStatus(1);
        this.setUser(userReq);
        this.setImages(imageList);
        this.setShare(null);

        this.setDing_count(0);
        this.setCai_count(0);
        this.setSupport(null);

    }


    public void setPostDetailReq(Post post, int ding_count,int cai_count, UserReq userReq,
                                 PostDetailShareReq postDetailShareReq,
                                 List<ImageReq> imageList){

        this.setId(post.getId());
        this.setUser_id(userReq.getId());
        this.setTitle(post.getTitle());
        this.setTitlepic(post.getTitlepic());
        this.setContent(post.getContent());
        this.setSharemun(0);
        this.setPath("未知");
        this.setType(0);
        this.setCreate_time(post.getCreateTime());
        this.setPost_class_id(post.getPostClassId());
        this.setShare_id(0);
        this.setIsopen(1);
        this.setStatus(1);
        this.setUser(userReq);
        this.setImages(imageList);
        this.setShare(postDetailShareReq);

        this.setDing_count(ding_count);
        this.setCai_count(cai_count);
        this.setSupport(null);



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

    public int getDing_count() {
        return ding_count;
    }

    public void setDing_count(int ding_count) {
        this.ding_count = ding_count;
    }

    public int getCai_count() {
        return cai_count;
    }

    public void setCai_count(int cai_count) {
        this.cai_count = cai_count;
    }

    public int getComment_count() {
        return comment_count;
    }

    public void setComment_count(int comment_count) {
        this.comment_count = comment_count;
    }

    public UserReq getUser() {
        return user;
    }

    public void setUser(UserReq user) {
        this.user = user;
    }

    public List<ImageReq> getImages() {
        return images;
    }

    public void setImages(List<ImageReq> images) {
        this.images = images;
    }

    public PostDetailShareReq getShare() {
        return share;
    }

    public void setShare(PostDetailShareReq share) {
        this.share = share;
    }

    public List<Support> getSupport() {
        return support;
    }

    public void setSupport(List<Support> support) {
        this.support = support;
    }
}
