package com.eventera.hsmnzaydn.eventeraandroid.ui.MainActivity;

import android.app.Activity;

import com.eventera.hsmnzaydn.eventeraandroid.data.DataManager;

import com.eventera.hsmnzaydn.eventeraandroid.data.network.model.Event;
import com.eventera.hsmnzaydn.eventeraandroid.ui.base.BasePresenter;

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
        List<Event> eventList=new ArrayList<>();
        Event event=new Event();
        event.setName("Test");
        event.setCategoryName("text");
        event.setStartTime("1522066417");
        eventList.add(event);
        getMvpView().LoadDataSpecificsEvent(eventList);
    }
}
