package com.eventera.hsmnzaydn.eventeraandroid.data.network.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;


/**
 * Created by hsmnzaydn on 22.03.2018.
 */

public class RegisterObject {


    @Expose
    @SerializedName("interests")
    private List<Interests> interests;
    @Expose
    @SerializedName("adress")
    private String adress;
    @Expose
    @SerializedName("job")
    private String job;
    @Expose
    @SerializedName("age")
    private String age;
    @Expose
    @SerializedName("mail")
    private String mail;
    @Expose
    @SerializedName("sex")
    private String sex;

    public boolean emptyControll() {
        if (getAdress().isEmpty() && getAge().isEmpty() && getJob().isEmpty() && getMail().isEmpty() && getSex().isEmpty()) {
            return true;
        } else
            return false;
    }

    public List<Interests> getInterests() {
        return interests;
    }

    public void setInterests(List<Interests> ınterests) {
        this.interests = ınterests;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
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
}
