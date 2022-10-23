package com.appbackend.appdb.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author yxt
 * @since 2022-04-23
 */
public class Post implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 发布人
     */
    private Integer userId;

    private String title;

    private String titlepic;

    private String content;

    private Integer sharenum;

    private String path;

    /**
     * 0 图文 1分享
     */
    private Integer type;

    private long createTime;

    private Integer postClassId;

    private Integer shareId;

    /**
     * 1开放，0仅自己可见
     */
    private Boolean isopen;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
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

    public Integer getSharenum() {
        return sharenum;
    }

    public void setSharenum(Integer sharenum) {
        this.sharenum = sharenum;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(long createTime) {
        this.createTime = createTime;
    }

    public Integer getPostClassId() {
        return postClassId;
    }

    public void setPostClassId(Integer postClassId) {
        this.postClassId = postClassId;
    }

    public Integer getShareId() {
        return shareId;
    }

    public void setShareId(Integer shareId) {
        this.shareId = shareId;
    }

    public Boolean getIsopen() {
        return isopen;
    }

    public void setIsopen(Boolean isopen) {
        this.isopen = isopen;
    }

    @Override
    public String toString() {
        return "Post{" +
        "id=" + id +
        ", userId=" + userId +
        ", title=" + title +
        ", titlepic=" + titlepic +
        ", content=" + content +
        ", sharenum=" + sharenum +
        ", path=" + path +
        ", type=" + type +
        ", createTime=" + createTime +
        ", postClassId=" + postClassId +
        ", shareId=" + shareId +
        ", isopen=" + isopen +
        "}";
    }
}
