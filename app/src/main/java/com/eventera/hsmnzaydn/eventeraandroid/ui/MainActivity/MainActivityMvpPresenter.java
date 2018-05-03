package com.eventera.hsmnzaydn.eventeraandroid.ui.MainActivity;

import com.eventera.hsmnzaydn.eventeraandroid.data.network.model.Event;
import com.eventera.hsmnzaydn.eventeraandroid.ui.RegisterActivityStepTwo.RegisterActivityTwoStepTwoMvpView;
import com.eventera.hsmnzaydn.eventeraandroid.ui.base.MvpPresenter;

/**
 * Created by hsmnzaydn on 26.03.2018.
 */

public interface MainActivityMvpPresenter  <V extends MainActivityMvpView> extends MvpPresenter<V> {
    void getSpecificEventList();
    void attend(Event event);
}
