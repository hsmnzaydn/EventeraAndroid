package com.eventera.hsmnzaydn.eventeraandroid.ui.RegisterActivity;


import android.app.Activity;

import com.eventera.hsmnzaydn.eventeraandroid.data.DataManager;
import com.eventera.hsmnzaydn.eventeraandroid.data.network.model.RegisterObject;
import com.eventera.hsmnzaydn.eventeraandroid.ui.base.BasePresenter;

/**
 * Created by hsmnzaydn on 22.03.2018.
 */

public class RegisterActivityPresenter<V extends RegisterActivityMvpView> extends BasePresenter<V> implements RegisterActivityMvpPresenter<V> {

    Activity activity;
    DataManager dataManager;


    public RegisterActivityPresenter(Activity activity, DataManager dataManager) {
        super((V) activity);
        this.activity = activity;
        this.dataManager = dataManager;
    }

    @Override
    public void register(RegisterObject registerObject) {

    }
}
