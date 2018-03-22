package com.eventera.hsmnzaydn.eventeraandroid.ui.SplashActivity;

import android.app.Activity;
import android.util.Log;

import com.eventera.hsmnzaydn.eventeraandroid.data.DataManager;
import com.eventera.hsmnzaydn.eventeraandroid.data.network.NetworkError;
import com.eventera.hsmnzaydn.eventeraandroid.data.network.model.CommonResponse;
import com.eventera.hsmnzaydn.eventeraandroid.data.network.service.ServiceCallback;
import com.eventera.hsmnzaydn.eventeraandroid.ui.base.BasePresenter;
import com.eventera.hsmnzaydn.eventeraandroid.utility.Constant;
import com.eventera.hsmnzaydn.eventeraandroid.utility.Utils;

import retrofit2.adapter.rxjava.HttpException;


/**
 * Created by hsmnzaydn on 22.03.2018.
 */

public class SplashActivityPresenter<V extends SplashActivityMvpView> extends BasePresenter<V> implements SplashActivityMvpPresenter<V> {

    Activity activity;



    DataManager dataManager;

    public SplashActivityPresenter(Activity activity,DataManager dataManager) {
        this.activity=activity;
        this.dataManager=dataManager;

    }

    @Override
    public void startApplication() {
        dataManager.saveUdid(Utils.getUdid(activity));
        Constant.UDID=dataManager.getUdid();
        if(dataManager.getAuthorization() != null){
            Constant.AUTHORIZATION=dataManager.getAuthorization();
        }

        getMvpView().showLoading();
            dataManager.startApplication(new ServiceCallback<CommonResponse>() {
                @Override
                public void onResponse(CommonResponse response) {
                    Log.d("veri","veri");
                    getMvpView().dissmisLoading();
                }

                @Override
                public void onError(NetworkError errorMessage) {
                    int code= ((HttpException) errorMessage.getError()).code();

                    getMvpView().showError(errorMessage.getAppErrorMessage());
                    getMvpView().dissmisLoading();
                }
            });
    }



}
