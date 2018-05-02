package com.eventera.hsmnzaydn.eventeraandroid.ui.EventListActivity;

import com.eventera.hsmnzaydn.eventeraandroid.ui.MainActivity.MainActivityMvpView;
import com.eventera.hsmnzaydn.eventeraandroid.ui.base.MvpPresenter;

/**
 * Created by hsmnzaydn on 02.05.2018.
 */

public interface EventListActivityMvpPresenter <V extends EventListActivityMvpView> extends MvpPresenter<V> {

    void getWallEntry(String eventId);
}
