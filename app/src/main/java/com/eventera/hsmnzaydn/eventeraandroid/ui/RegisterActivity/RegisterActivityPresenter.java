package com.eventera.hsmnzaydn.eventeraandroid.ui.RegisterActivity;


import android.app.Activity;

import com.eventera.hsmnzaydn.eventeraandroid.R;
import com.eventera.hsmnzaydn.eventeraandroid.data.DataManager;
import com.eventera.hsmnzaydn.eventeraandroid.data.network.model.RegisterObject;
import com.eventera.hsmnzaydn.eventeraandroid.eventbus.RegisterObjectEvent;
import com.eventera.hsmnzaydn.eventeraandroid.ui.base.BasePresenter;

import org.greenrobot.eventbus.EventBus;

/**
 * Created by hsmnzaydn on 22.03.2018.
 */

public class RegisterActivityPresenter<V extends RegisterActivityMvpView> extends BasePresenter<V> implements RegisterActivityMvpPresenter<V> {

    Activity activity;
    DataManager dataManager;

    public RegisterActivityPresenter(Activity activity,DataManager dataManager) {
        super(activity);
        this.activity=activity;
        this.dataManager=dataManager;
    }


    @Override
    public void register(String eMail, String job, String adress, String age, String sex) {
            getMvpView().showLoading();
            RegisterObject registerObject=new RegisterObject();
            registerObject.setAdress(adress);
            registerObject.setAge(age);
            registerObject.setName(job);
            registerObject.setMail(eMail);
            registerObject.setSex(sex);

            if(registerObject.emptyControll()){
                getMvpView().showError(activity.getResources().getString(R.string.error_fill));
                getMvpView().dissmisLoading();
            }else {
                EventBus.getDefault().postSticky(new RegisterObjectEvent(registerObject));
                getMvpView().dissmisLoading();
                getMvpView().openRegisterStepTwo();
            }

    }
}
