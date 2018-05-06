package com.eventera.hsmnzaydn.eventeraandroid.ui.ProfileActivity;

import com.eventera.hsmnzaydn.eventeraandroid.ui.MainActivity.MainActivityMvpView;
import com.eventera.hsmnzaydn.eventeraandroid.ui.base.MvpPresenter;

/**
 * Created by hsmnzaydn on 5/6/18.
 */

public interface ProfileActivityMvpPresenter <V extends ProfileActivityMvpView> extends MvpPresenter<V> {


    void  getProfileInformation(String profileId);
}
