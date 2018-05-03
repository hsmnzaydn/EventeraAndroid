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
    private List<Interesting> interests;
    @Expose
    @SerializedName("adress")
    private String adress;
    @Expose
    @SerializedName("name")
    private String name;
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
        if (getAdress().isEmpty() && getAge().isEmpty() && getName().isEmpty() && getMail().isEmpty() && getSex().isEmpty()) {
            return true;
        } else
            return false;
    }

    public List<Interesting> getInterests() {
        return interests;
    }

    public void setInterests(List<Interesting> ınterests) {
        this.interests = ınterests;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
