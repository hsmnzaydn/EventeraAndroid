package com.eventera.hsmnzaydn.eventeraandroid.ui.RegisterActivityStepTwo;

import android.app.Activity;

import com.eventera.hsmnzaydn.eventeraandroid.data.DataManager;

import com.eventera.hsmnzaydn.eventeraandroid.ui.base.BasePresenter;

/**
 * Created by hsmnzaydn on 24.03.2018.
 */

public class RegisterActivityStepTwoPresenter<V extends RegisterActivityTwoStepTwoMvpView> extends BasePresenter<V> implements RegisterActivityStepTwoMvpPresenter<V> {
   private Activity activity;
   private DataManager dataManager;


    public RegisterActivityStepTwoPresenter(Activity activity,DataManager dataManager) {
        super(activity);
        this.dataManager=dataManager;
    }
}
