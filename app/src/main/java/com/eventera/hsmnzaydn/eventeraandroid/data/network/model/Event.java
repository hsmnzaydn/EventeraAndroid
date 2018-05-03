package com.eventera.hsmnzaydn.eventeraandroid.data.network.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by hsmnzaydn on 26.03.2018.
 */

public class Event {


    @Expose
    @SerializedName("__v")
    private int V;
    @Expose
    @SerializedName("eventLocation")
    private String eventlocation;
    @Expose
    @SerializedName("eventCategoryName")
    private String eventcategoryname;
    @Expose
    @SerializedName("eventEndTime")
    private String eventendtime;
    @Expose
    @SerializedName("eventDescription")
    private String eventdescription;
    @Expose
    @SerializedName("eventName")
    private String eventname;
    @Expose
    @SerializedName("_id")
    private String Id;
    @Expose
    @SerializedName("wallEntryList")
    private List<WallEntry> wallentrylist;

    public int getV() {
        return V;
    }

    public void setV(int V) {
        this.V = V;
    }

    public String getEventlocation() {
        return eventlocation;
    }

    public void setEventlocation(String eventlocation) {
        this.eventlocation = eventlocation;
    }

    public String getEventcategoryname() {
        return eventcategoryname;
    }

    public void setEventcategoryname(String eventcategoryname) {
        this.eventcategoryname = eventcategoryname;
    }

    public String getEventendtime() {
        return eventendtime;
    }

    public void setEventendtime(String eventendtime) {
        this.eventendtime = eventendtime;
    }

    public String getEventdescription() {
        return eventdescription;
    }

    public void setEventdescription(String eventdescription) {
        this.eventdescription = eventdescription;
    }

    public String getEventname() {
        return eventname;
    }

    public void setEventname(String eventname) {
        this.eventname = eventname;
    }

    public String getId() {
        return Id;
    }

    public void setId(String Id) {
        this.Id = Id;
    }

    public List<WallEntry> getWallentrylist() {
        return wallentrylist;
    }

    public void setWallentrylist(List<WallEntry> wallentrylist) {
        this.wallentrylist = wallentrylist;
    }

    public static class Interesting {
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


}
