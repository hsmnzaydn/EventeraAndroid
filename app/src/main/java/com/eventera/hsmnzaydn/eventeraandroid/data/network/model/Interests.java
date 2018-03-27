package com.eventera.hsmnzaydn.eventeraandroid.data.network.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Interests {

    @Expose
    @SerializedName("intesrestName")
    private String ıntesrestname;
    @Expose
    @SerializedName("interestId")
    private String ınterestıd;

    public String getIntesrestname() {
        return ıntesrestname;
    }

    public void setIntesrestname(String ıntesrestname) {
        this.ıntesrestname = ıntesrestname;
    }

    public String getInterestıd() {
        return ınterestıd;
    }

    public void setInterestıd(String ınterestıd) {
        this.ınterestıd = ınterestıd;
    }
}
