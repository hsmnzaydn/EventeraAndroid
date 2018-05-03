package com.eventera.hsmnzaydn.eventeraandroid.ui.AddWallEntryActivity;
import com.eventera.hsmnzaydn.eventeraandroid.ui.base.MvpPresenter;

/**
 * Created by hsmnzaydn on 5/3/18.
 */

public interface AddWallEntryActivityMvpPresenter <V extends AddWallEntryActivityMvpView> extends MvpPresenter<V> {
void postWallEntry(String id,String text);
}
