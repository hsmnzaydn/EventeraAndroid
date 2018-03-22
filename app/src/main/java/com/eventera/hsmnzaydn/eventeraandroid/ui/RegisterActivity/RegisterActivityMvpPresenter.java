package com.eventera.hsmnzaydn.eventeraandroid.ui.RegisterActivity;

import com.eventera.hsmnzaydn.eventeraandroid.data.network.model.RegisterObject;
import com.eventera.hsmnzaydn.eventeraandroid.ui.base.MvpPresenter;

/**
 * Created by hsmnzaydn on 22.03.2018.
 */

public interface RegisterActivityMvpPresenter <V extends RegisterActivityMvpView> extends MvpPresenter<V> {
    void register(RegisterObject registerObject);
}
