package com.eventera.hsmnzaydn.eventeraandroid.ui.MainActivity;

import android.app.Activity;

import com.eventera.hsmnzaydn.eventeraandroid.data.DataManager;

import com.eventera.hsmnzaydn.eventeraandroid.data.network.model.CommonResponse;
import com.eventera.hsmnzaydn.eventeraandroid.data.network.model.Event;
import com.eventera.hsmnzaydn.eventeraandroid.data.network.service.EventService;
import com.eventera.hsmnzaydn.eventeraandroid.data.network.service.EventServiceImp;
import com.eventera.hsmnzaydn.eventeraandroid.data.network.service.ServiceCallback;
import com.eventera.hsmnzaydn.eventeraandroid.ui.base.BasePresenter;
import com.eventera.hsmnzaydn.eventeraandroid.utility.Constant;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;


/**
 * Created by hsmnzaydn on 26.03.2018.
 */

public class MainActivityPresenter <V extends MainActivityMvpView> extends BasePresenter<V> implements MainActivityMvpPresenter<V> {
    private Activity activity;


    DataManager dataManager;

    @Inject
    public MainActivityPresenter(Activity activity,DataManager dataManager) {
        super(activity);
        this.dataManager=dataManager;

    }


    @Override
    public void getSpecificEventList() {
        getMvpView().showLoading();


        dataManager.getEventList(new ServiceCallback<List<Event>>() {
            @Override
            public void onResponse(List<Event> response) {
                getMvpView().LoadDataSpecificsEvent(response);
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
}
