package com.eventera.hsmnzaydn.eventeraandroid.ui.RegisterActivityStepTwo;

import android.app.Activity;

import com.eventera.hsmnzaydn.eventeraandroid.data.DataManager;

import com.eventera.hsmnzaydn.eventeraandroid.data.network.model.CommonResponse;
import com.eventera.hsmnzaydn.eventeraandroid.data.network.model.Interests;
import com.eventera.hsmnzaydn.eventeraandroid.data.network.model.RegisterObject;
import com.eventera.hsmnzaydn.eventeraandroid.data.network.model.RegisterResponse;
import com.eventera.hsmnzaydn.eventeraandroid.data.network.service.ServiceCallback;
import com.eventera.hsmnzaydn.eventeraandroid.ui.base.BasePresenter;

import java.util.List;

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


    @Override
    public void register(final RegisterObject registerObject) {
            getMvpView().showLoading();
            dataManager.register(registerObject, new ServiceCallback<RegisterResponse>() {
                @Override
                public void onResponse(RegisterResponse response) {
                    dataManager.saveAuthorization(response.getSecret());
                    getMvpView().dissmisLoading();
                    getMvpView().openMainActivity();

                }

                @Override
                public void onError(String message) {
                    getMvpView().showError(message);
                    getMvpView().dissmisLoading();

                }
            }, new ServiceCallback<CommonResponse>() {
                @Override
                public void onResponse(CommonResponse response) {

                    getMvpView().showError(response.getMessage());
                    getMvpView().dissmisLoading();
                }

                @Override
                public void onError(String message) {
                    getMvpView().showError(message);
                    getMvpView().dissmisLoading();
                }
            });
    }

    @Override
    public void getListOfInterests() {
        getMvpView().showLoading();

        dataManager.getListOfInterests(new ServiceCallback<List<Interests>>() {
            @Override
            public void onResponse(List<Interests> response) {

                getMvpView().dissmisLoading();
                getMvpView().loadDataToRecylerview(response);
            }

            @Override
            public void onError(String message) {

                getMvpView().dissmisLoading();
                getMvpView().showError(message);
            }
        }, new ServiceCallback<CommonResponse>() {
            @Override
            public void onResponse(CommonResponse response) {
                getMvpView().dissmisLoading();
                getMvpView().showError(response.getMessage());
            }

            @Override
            public void onError(String message) {
                getMvpView().dissmisLoading();
                getMvpView().showError(message);
            }
        });
    }
}
