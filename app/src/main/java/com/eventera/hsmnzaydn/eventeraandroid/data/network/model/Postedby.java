package com.eventera.hsmnzaydn.eventeraandroid.data.network.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Postedby {
    @Expose
    @SerializedName("__v")
    private int V;
    @Expose
    @SerializedName("mail")
    private String mail;
    @Expose
    @SerializedName("sex")
    private String sex;
    @Expose
    @SerializedName("age")
    private String age;
    @Expose
    @SerializedName("location")
    private String location;
    @Expose
    @SerializedName("job")
    private String job;
    @Expose
    @SerializedName("udid")
    private String udid;
    @Expose
    @SerializedName("_id")
    private String Id;
    @Expose
    @SerializedName("attendes")
    private List<Event> attendes;
    @Expose
    @SerializedName("interesting")
    private List<Interesting> ınteresting;

    public int getV() {
        return V;
    }

    public void setV(int V) {
        this.V = V;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getUdid() {
        return udid;
    }

    public void setUdid(String udid) {
        this.udid = udid;
    }

    public String getId() {
        return Id;
    }

    public void setId(String Id) {
        this.Id = Id;
    }

    public List<Event> getAttendes() {
        return attendes;
    }

    public void setAttendes(List<Event> attendes) {
        this.attendes = attendes;
    }

    public List<Interesting> getInteresting() {
        return ınteresting;
    }

    public void setInteresting(List<Interesting> ınteresting) {
        this.ınteresting = ınteresting;
    }
}
