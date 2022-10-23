package com.appbackend.appdb.dto;


import com.appbackend.appdb.entity.Topic;

import java.time.LocalDateTime;

public class TopicReq {
    private int id;
    private String title;
    private String titlepic;
    private String desc;
    private int type;
    private LocalDateTime create_time;
    private int topic_class_id;
    private int post_count;
    private int todaypost_count;

    @Override
    public String toString() {
        return "TopicReq{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", titlepic='" + titlepic + '\'' +
                ", desc='" + desc + '\'' +
                ", type=" + type +
                ", create_time=" + create_time +
                ", topic_class_id=" + topic_class_id +
                ", post_count=" + post_count +
                ", todaypost_count=" + todaypost_count +
                '}';
    }

    public void setTopicReq(Topic topic){
        this.id = topic.getId();
        this.title = topic.getTitle();
        this.titlepic= topic.getTitlepic();
        this.desc= topic.getDesc();
        this.type= topic.getType();
        this.create_time= topic.getCreateTime();
        this.topic_class_id= topic.getTopicClassId();
        this.post_count= 0;
        this.todaypost_count = 0;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
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

    public int getTopic_class_id() {
        return topic_class_id;
    }

    public void setTopic_class_id(int topic_class_id) {
        this.topic_class_id = topic_class_id;
    }

    public int getPost_count() {
        return post_count;
    }

    public void setPost_count(int post_count) {
        this.post_count = post_count;
    }

    public int getTodaypost_count() {
        return todaypost_count;
    }

    public void setTodaypost_count(int todaypost_count) {
        this.todaypost_count = todaypost_count;
    }
}
