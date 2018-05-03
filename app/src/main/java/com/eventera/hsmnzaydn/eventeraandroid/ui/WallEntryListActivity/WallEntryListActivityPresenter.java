package com.eventera.hsmnzaydn.eventeraandroid.ui.WallEntryListActivity;

import android.app.Activity;

import com.eventera.hsmnzaydn.eventeraandroid.data.DataManager;

import com.eventera.hsmnzaydn.eventeraandroid.data.network.model.CommonResponse;
import com.eventera.hsmnzaydn.eventeraandroid.data.network.model.WallEntry;
import com.eventera.hsmnzaydn.eventeraandroid.data.network.service.ServiceCallback;
import com.eventera.hsmnzaydn.eventeraandroid.ui.base.BasePresenter;

import java.util.List;

/**
 * Created by hsmnzaydn on 02.05.2018.
 */

public class WallEntryListActivityPresenter<V extends WallEntryListActivityMvpView> extends BasePresenter<V> implements WallEntryListActivityMvpPresenter<V> {
    private DataManager dataManager;
    public WallEntryListActivityPresenter(Activity activity, DataManager dataManager) {
        super(activity);
        this.dataManager=dataManager;
    }

    @Override
    public void getWallEntry(String eventId) {
        getMvpView().showLoading();


        dataManager.getWallEntries(eventId, new ServiceCallback<List<WallEntry>>() {
            @Override
            public void onResponse(List<WallEntry> response) {
                getMvpView().dissmisLoading();
                getMvpView().loadWallEntryList(response);
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
