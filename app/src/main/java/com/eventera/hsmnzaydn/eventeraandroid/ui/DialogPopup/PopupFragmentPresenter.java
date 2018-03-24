package com.eventera.hsmnzaydn.eventeraandroid.ui.DialogPopup;

import android.app.Activity;


import com.eventera.hsmnzaydn.eventeraandroid.ui.base.BasePresenter;
import com.eventera.hsmnzaydn.eventeraandroid.ui.base.DialogMvpView;

import org.greenrobot.eventbus.EventBus;

/**
 * Created by hsmnzaydn on 29.01.2018.
 */

public class PopupFragmentPresenter<V extends DialogMvpView> extends BasePresenter<V>
        implements PopupFragmentMvpPresenter<V> {

    private Activity activity;
    private PopupFragment popupFragment;


    public PopupFragmentPresenter(Activity activity) {
        super(activity);
    }
}

