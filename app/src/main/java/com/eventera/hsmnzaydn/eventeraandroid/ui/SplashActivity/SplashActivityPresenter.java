package com.eventera.hsmnzaydn.eventeraandroid.ui.SplashActivity;

import android.app.Activity;
import android.util.Log;

import com.eventera.hsmnzaydn.eventeraandroid.data.DataManager;
import com.eventera.hsmnzaydn.eventeraandroid.data.network.model.CommonResponse;
import com.eventera.hsmnzaydn.eventeraandroid.data.network.service.ServiceCallback;
import com.eventera.hsmnzaydn.eventeraandroid.di.DaggerApplication;
import com.eventera.hsmnzaydn.eventeraandroid.ui.base.BasePresenter;

import javax.inject.Inject;

/**
 * Created by hsmnzaydn on 22.03.2018.
 */

public class SplashActivityPresenter<V extends SplashActivityMvpView> extends BasePresenter<V> implements SplashActivityMvpPresenter<V> {

    @Inject
    Activity activity;


    DataManager dataManager;

    @Inject
    public SplashActivityPresenter(Activity activity,DataManager dataManager) {
       // inject();
        this.activity=activity;
        this.dataManager=dataManager;
    }

    @Override
    public void startApplication() {
        getMvpView().showLoading();
            dataManager.startApplication(new ServiceCallback<CommonResponse>() {
                @Override
                public void onResponse(CommonResponse response) {
                    Log.d("veri","veri");
                    getMvpView().dissmisLoading();
                }

                @Override
                public void onError(String errorMessage) {
                    getMvpView().dissmisLoading();
                }
            });
    }


    private void inject(){
       //((DaggerApplication) activity.getApplicationContext()).getDaggerComponent().inject( this);
    }
}
