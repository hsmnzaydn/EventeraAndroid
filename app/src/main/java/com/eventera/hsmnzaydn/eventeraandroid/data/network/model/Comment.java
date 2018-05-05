package com.eventera.hsmnzaydn.eventeraandroid.data.network.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by hsmnzaydn on 5/5/18.
 */
public  class Comment {
    @Expose
    @SerializedName("text")
    private String text;
    @Expose
    @SerializedName("postedBy")
    private Postedby postedby;

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