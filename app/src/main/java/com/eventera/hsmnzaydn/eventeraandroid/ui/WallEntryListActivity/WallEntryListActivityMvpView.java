package com.eventera.hsmnzaydn.eventeraandroid.ui.WallEntryListActivity;

import com.eventera.hsmnzaydn.eventeraandroid.data.network.model.WallEntry;
import com.eventera.hsmnzaydn.eventeraandroid.ui.base.MvpView;

import java.util.List;

/**
 * Created by hsmnzaydn on 02.05.2018.
 */

public interface WallEntryListActivityMvpView extends MvpView{

    void loadWallEntryList(List<WallEntry> listOfWallEntry);

}
