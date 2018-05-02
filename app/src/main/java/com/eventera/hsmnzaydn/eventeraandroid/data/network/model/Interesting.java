package com.eventera.hsmnzaydn.eventeraandroid.data.network.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Interesting {
    @Expose
    @SerializedName("name")
    private String name;
    @Expose
    @SerializedName("id")
    private String ıd;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return ıd;
    }

    public void setId(String ıd) {
        this.ıd = ıd;
    }
}
