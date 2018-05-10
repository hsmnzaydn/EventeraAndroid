package com.eventera.hsmnzaydn.eventeraandroid.ui.ProfileActivity;

import android.app.Activity;


import com.eventera.hsmnzaydn.eventeraandroid.data.DataManager;
import com.eventera.hsmnzaydn.eventeraandroid.data.network.model.CommonResponse;
import com.eventera.hsmnzaydn.eventeraandroid.data.network.model.Event;
import com.eventera.hsmnzaydn.eventeraandroid.data.network.model.User;
import com.eventera.hsmnzaydn.eventeraandroid.data.network.service.ServiceCallback;
import com.eventera.hsmnzaydn.eventeraandroid.ui.base.BasePresenter;
import com.eventera.hsmnzaydn.eventeraandroid.utility.Constant;

/**
 * Created by hsmnzaydn on 5/6/18.
 */

public class ProfileActivityPresenter <V extends ProfileActivityMvpView> extends BasePresenter<V> implements ProfileActivityMvpPresenter<V> {

    DataManager dataManager;

    public ProfileActivityPresenter(Activity activity,DataManager dataManager) {
        super(activity);
        this.dataManager=dataManager;
    }

    @Override
    public void getProfileInformation(String profileId) {
        getMvpView().showLoading();


        dataManager.getProfile(profileId, new ServiceCallback<User>() {
            @Override
            public void onResponse(User response) {
                getMvpView().loadProfileInformation(response);
                getMvpView().dissmisLoading();
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
    public void attend(Event event) {
        getMvpView().showLoading();

        dataManager.isAttend(event.getId(), new ServiceCallback<CommonResponse>() {
            @Override
            public void onResponse(CommonResponse response) {
                if(response.getCode() == Constant.SUCCESS_CODE){
                    getMvpView().openWallEntryListActivity();
                }
                else if(response.getCode() == Constant.UNREGISTER_CODE){
                    getMvpView().openPopup();
                }
                else {
                    getMvpView().showError(response.getMessage());
                }
                getMvpView().dissmisLoading();

            }

            @Override
            public void onError(String message) {
                getMvpView().showError(message);
                getMvpView().dissmisLoading();
            }
        });
    }
}
