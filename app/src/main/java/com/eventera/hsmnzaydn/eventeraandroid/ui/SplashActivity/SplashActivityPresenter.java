package com.eventera.hsmnzaydn.eventeraandroid.ui.SplashActivity;

import android.app.Activity;
import android.content.Context;
import android.util.Log;

import com.eventera.hsmnzaydn.eventeraandroid.data.DataManager;
import com.eventera.hsmnzaydn.eventeraandroid.data.network.model.CommonResponse;
import com.eventera.hsmnzaydn.eventeraandroid.data.network.service.ServiceCallback;
import com.eventera.hsmnzaydn.eventeraandroid.ui.base.BasePresenter;
import com.eventera.hsmnzaydn.eventeraandroid.utility.Constant;
import com.eventera.hsmnzaydn.eventeraandroid.utility.Utils;


/**
 * Created by hsmnzaydn on 22.03.2018.
 */

public class SplashActivityPresenter<V extends SplashActivityMvpView> extends BasePresenter<V> implements SplashActivityMvpPresenter<V> {

    Activity activity;
    private Context context;

    DataManager dataManager;

    public SplashActivityPresenter(Activity activity, Context context,DataManager dataManager) {
        super( activity);
        this.dataManager=dataManager;
        this.context=context;
    }


    @Override
    public void startApplication() {
        dataManager.saveUdid(Utils.getUdid(context));
        Constant.UDID = dataManager.getUdid();
        if (dataManager.getAuthorization() != null) {
            Constant.AUTHORIZATION = dataManager.getAuthorization();
        }

        getMvpView().showLoading();
        dataManager.startApplication(new ServiceCallback<CommonResponse>() {
            @Override
            public void onResponse(CommonResponse response) {
                getMvpView().dissmisLoading();


                if(response.getCode() == Constant.UNREGISTER_CODE){
                    getMvpView().openRegisteractivity();
                }else if(response.getCode()== Constant.SUCCESS_CODE){
                    getMvpView().openMainActivity();
                }



                getMvpView().killActivity();
            }

            @Override
            public void onError(String message) {
                getMvpView().showError(message);
                getMvpView().killActivity();
                getMvpView().dissmisLoading();
            }


        });
    }


}
