package com.eventera.hsmnzaydn.eventeraandroid.data.network.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by hsmnzaydn on 22.03.2018.
 */

public class RegisterObject {
    @SerializedName("sex")
    @Expose
    private String sex;
    @SerializedName("mail")
    @Expose
    private String mail;
    @SerializedName("age")
    @Expose
    private String age;
    @SerializedName("job")
    @Expose
    private String job;
    @SerializedName("adress")
    @Expose
    private String adress;
    @SerializedName("interests")
    @Expose
    private List<Interest> interests = null;

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public List<Interest> getInterests() {
        return interests;
    }

    public void setInterests(List<Interest> interests) {
        this.interests = interests;
    }


    public boolean emptyControll(){
        if(getAdress().isEmpty() && getAge().isEmpty() && getJob().isEmpty() && getMail().isEmpty() && getSex().isEmpty() ){
            return true;
        }
        else
        return false;
    }
}
