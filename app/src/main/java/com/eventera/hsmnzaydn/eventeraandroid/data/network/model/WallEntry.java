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
    private List<String> comment;
    @Expose
    @SerializedName("likeCount")
    private int likecount;
    @Expose
    @SerializedName("text")
    private String text;
    @Expose
    @SerializedName("postedBy")
    private Postedby postedby;

    public String getId() {
        return Id;
    }

    public void setId(String Id) {
        this.Id = Id;
    }

    public List<String> getComment() {
        return comment;
    }

    public void setComment(List<String> comment) {
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

    public Postedby getPostedby() {
        return postedby;
    }

    public void setPostedby(Postedby postedby) {
        this.postedby = postedby;
    }
}
