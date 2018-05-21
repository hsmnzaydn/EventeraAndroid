package com.eventera.hsmnzaydn.eventeraandroid.ui.AttendEventActivity;

import android.app.Activity;

import com.eventera.hsmnzaydn.eventeraandroid.data.DataManager;
import com.eventera.hsmnzaydn.eventeraandroid.data.network.model.CommonResponse;
import com.eventera.hsmnzaydn.eventeraandroid.data.network.service.ServiceCallback;
import com.eventera.hsmnzaydn.eventeraandroid.ui.CommentListActivity.CommentListActivityMvpPresenter;
import com.eventera.hsmnzaydn.eventeraandroid.ui.CommentListActivity.CommentListActivityMvpView;
import com.eventera.hsmnzaydn.eventeraandroid.ui.base.BasePresenter;

/**
 * Created by hsmnzaydn on 5/22/18.
 */

public class AttendEventActivityPresenter <V extends AttendEventActivityMvpView> extends BasePresenter<V> implements AttendEventActivityMvpPresenter<V> {
    DataManager dataManager;

    public AttendEventActivityPresenter(Activity activity,DataManager dataManager) {
        super(activity);
        this.dataManager=dataManager;
    }

    @Override
    public void attendToEvent(String id) {
        getMvpView().showLoading();

        dataManager.attendToEvent(id, new ServiceCallback<CommonResponse>() {
            @Override
            public void onResponse(CommonResponse response) {

                getMvpView().dissmisLoading();
                getMvpView().openEventListActivity();


            }

            @Override
            public void onError(String message) {
                getMvpView().showError(message);
                getMvpView().dissmisLoading();

            }
        });

    }
}
