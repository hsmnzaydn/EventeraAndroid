package com.eventera.hsmnzaydn.eventeraandroid.ui.EventListActivity;

import android.app.Activity;

import com.eventera.hsmnzaydn.eventeraandroid.data.DataManager;

import com.eventera.hsmnzaydn.eventeraandroid.ui.base.BasePresenter;

/**
 * Created by hsmnzaydn on 02.05.2018.
 */

public class EventListActivityPresenter <V extends EventListActivityMvpView> extends BasePresenter<V> implements EventListActivityMvpPresenter<V> {
    private DataManager dataManager;
    public EventListActivityPresenter(Activity activity, DataManager dataManager) {
        super(activity);
        this.dataManager=dataManager;
    }

    @Override
    public void getWallEntry(String eventId) {

    }
}
