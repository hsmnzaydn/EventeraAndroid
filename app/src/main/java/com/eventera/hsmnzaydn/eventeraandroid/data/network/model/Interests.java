package com.eventera.hsmnzaydn.eventeraandroid.data.network.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Interests {

    @Expose
    @SerializedName("id")
    private String id;
    @Expose
    @SerializedName("name")
    private String name;

    public String getIntesrestname() {
        return id;
    }

    public void setIntesrestname(String ıntesrestname) {
        this.id = ıntesrestname;
    }

    public String getInterestıd() {
        return name;
    }

    public void setInterestıd(String ınterestıd) {
        this.name = ınterestıd;
    }
}
