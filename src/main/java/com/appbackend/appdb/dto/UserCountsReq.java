package com.appbackend.appdb.dto;

public class UserCountsReq {

    private int post_count;
    private int comments_count;
    private int today_posts_count;
    private int withfollow_count;
    private int withfen_count;
    private int total_ding_count;
    private int friend_count;

    public int getPost_count() {
        return post_count;
    }

    public void setPost_count(int post_count) {
        this.post_count = post_count;
    }

    public int getComments_count() {
        return comments_count;
    }

    public void setComments_count(int comments_count) {
        this.comments_count = comments_count;
    }

    public int getToday_posts_count() {
        return today_posts_count;
    }

    public void setToday_posts_count(int today_posts_count) {
        this.today_posts_count = today_posts_count;
    }

    public int getWithfollow_count() {
        return withfollow_count;
    }

    public void setWithfollow_count(int withfollow_count) {
        this.withfollow_count = withfollow_count;
    }

    public int getWithfen_count() {
        return withfen_count;
    }

    public void setWithfen_count(int withfen_count) {
        this.withfen_count = withfen_count;
    }

    public int getTotal_ding_count() {
        return total_ding_count;
    }

    public void setTotal_ding_count(int total_ding_count) {
        this.total_ding_count = total_ding_count;
    }

    public int getFriend_count() {
        return friend_count;
    }

    public void setFriend_count(int friend_count) {
        this.friend_count = friend_count;
    }
}
