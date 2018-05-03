package com.eventera.hsmnzaydn.eventeraandroid.ui.MainActivity;

import com.eventera.hsmnzaydn.eventeraandroid.data.network.model.Event;
import com.eventera.hsmnzaydn.eventeraandroid.ui.base.MvpView;

import java.util.List;

/**
 * Created by hsmnzaydn on 26.03.2018.
 */

public interface MainActivityMvpView  extends MvpView{
    void LoadDataSpecificsEvent(List<Event> listOfEvent);
    void openWallEntryListActivity();
    void openPopup();
}
