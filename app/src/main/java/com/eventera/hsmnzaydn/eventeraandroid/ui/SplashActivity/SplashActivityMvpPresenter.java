package com.eventera.hsmnzaydn.eventeraandroid.ui.SplashActivity;

import com.eventera.hsmnzaydn.eventeraandroid.ui.base.MvpPresenter;

/**
 * Created by hsmnzaydn on 22.03.2018.
 */

public interface SplashActivityMvpPresenter<V extends SplashActivityMvpView> extends MvpPresenter<V> {
    void startApplication();
}
