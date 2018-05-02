package com.eventera.hsmnzaydn.eventeraandroid.ui.EventListActivity;

import com.eventera.hsmnzaydn.eventeraandroid.data.network.model.WallEntry;
import com.eventera.hsmnzaydn.eventeraandroid.ui.base.MvpView;

import java.util.List;

/**
 * Created by hsmnzaydn on 02.05.2018.
 */

public interface EventListActivityMvpView extends MvpView{

    void loadWallEntryList(List<WallEntry> listOfWallEntry);

}
