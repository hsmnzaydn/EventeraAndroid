package com.eventera.hsmnzaydn.eventeraandroid.data.network.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by hsmnzaydn on 02.05.2018.
 */

public class WallEntry {


    @Expose
    @SerializedName("_id")
    private String Id;
    @Expose
    @SerializedName("comment")
    private List<Comment> comment;
    @Expose
    @SerializedName("likeCount")
    private int likecount;
    @Expose
    @SerializedName("text")
    private String text;
    @Expose
    @SerializedName("liked")
    private Boolean liked;
    @Expose
    @SerializedName("postedBy")
    private User user;

    public Boolean getLiked() {
        return liked;
    }

    public void setLiked(Boolean liked) {
        this.liked = liked;
    }



    @Expose
    @SerializedName("eventId")
    private String eventId;

    public String getEventId() {
        return eventId;
    }

    public void setEventId(String eventId) {
        this.eventId = eventId;
    }

    public String getId() {
        return Id;
    }

    public void setId(String Id) {
        this.Id = Id;
    }

    public List<Comment> getComment() {
        return comment;
    }

    public void setComment(List<Comment> comment) {
        this.comment = comment;
    }

    public int getLikecount() {
        return likecount;
    }

    public void setLikecount(int likecount) {
        this.likecount = likecount;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
