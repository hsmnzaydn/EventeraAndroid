package com.eventera.hsmnzaydn.eventeraandroid.ui.AddWallEntryActivity;

import android.app.Activity;

import com.eventera.hsmnzaydn.eventeraandroid.data.DataManager;
import com.eventera.hsmnzaydn.eventeraandroid.data.network.model.CommonResponse;
import com.eventera.hsmnzaydn.eventeraandroid.data.network.model.WallEntry;
import com.eventera.hsmnzaydn.eventeraandroid.data.network.service.ServiceCallback;
import com.eventera.hsmnzaydn.eventeraandroid.ui.base.BasePresenter;
import com.eventera.hsmnzaydn.eventeraandroid.utility.Constant;

/**
 * Created by hsmnzaydn on 5/3/18.
 */

public class AddWallEntryActivityPresenter <V extends AddWallEntryActivityMvpView> extends BasePresenter<V> implements AddWallEntryActivityMvpPresenter<V> {
    private DataManager dataManager;
    public AddWallEntryActivityPresenter(Activity activity,DataManager dataManager) {
        super(activity);
        this.dataManager=dataManager;
    }

    @Override
    public void postWallEntry(String id,String text) {
        getMvpView().showLoading();
        WallEntry wallEntry=new WallEntry();
        wallEntry.setText(text);

        dataManager.postWallEntries(id, wallEntry, new ServiceCallback<CommonResponse>() {
            @Override
            public void onResponse(CommonResponse response) {
                if(response.getCode()== Constant.SUCCESS_CODE){
                    getMvpView().backPress();
                }else {
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
