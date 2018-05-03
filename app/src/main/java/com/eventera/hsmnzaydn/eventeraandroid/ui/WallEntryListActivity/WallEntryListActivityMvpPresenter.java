package com.eventera.hsmnzaydn.eventeraandroid.ui.WallEntryListActivity;

import com.eventera.hsmnzaydn.eventeraandroid.ui.base.MvpPresenter;

/**
 * Created by hsmnzaydn on 02.05.2018.
 */

public interface WallEntryListActivityMvpPresenter<V extends WallEntryListActivityMvpView> extends MvpPresenter<V> {

    void getWallEntry(String eventId);
}
