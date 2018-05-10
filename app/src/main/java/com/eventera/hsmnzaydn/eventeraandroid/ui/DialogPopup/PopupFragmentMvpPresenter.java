package com.eventera.hsmnzaydn.eventeraandroid.ui.DialogPopup;


import com.eventera.hsmnzaydn.eventeraandroid.data.network.model.RegisterObject;
import com.eventera.hsmnzaydn.eventeraandroid.data.network.model.User;
import com.eventera.hsmnzaydn.eventeraandroid.ui.base.DialogMvpView;
import com.eventera.hsmnzaydn.eventeraandroid.ui.base.MvpPresenter;

/**
 * Created by hsmnzaydn on 29.01.2018.
 */

public interface PopupFragmentMvpPresenter<V extends DialogMvpView> extends MvpPresenter<V> {
    void attendToEvent(String id);
    void getInterestingList();
    void updateIntestingList(String profileId, RegisterObject user);

}
