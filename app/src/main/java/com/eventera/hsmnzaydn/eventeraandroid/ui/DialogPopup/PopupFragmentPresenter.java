package com.eventera.hsmnzaydn.eventeraandroid.ui.DialogPopup;

import android.app.Activity;


import com.eventera.hsmnzaydn.eventeraandroid.data.DataManager;
import com.eventera.hsmnzaydn.eventeraandroid.data.network.model.CommonResponse;
import com.eventera.hsmnzaydn.eventeraandroid.data.network.service.ServiceCallback;
import com.eventera.hsmnzaydn.eventeraandroid.ui.base.BasePresenter;
import com.eventera.hsmnzaydn.eventeraandroid.ui.base.DialogMvpView;

import org.greenrobot.eventbus.EventBus;

/**
 * Created by hsmnzaydn on 29.01.2018.
 */

public class PopupFragmentPresenter<V extends PopupFragmentMvpView> extends BasePresenter<V>
        implements PopupFragmentMvpPresenter<V> {

    private Activity activity;
    private PopupFragment popupFragment;
    private DataManager dataManager;

    public PopupFragmentPresenter(Activity activity, DataManager dataManager) {
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

