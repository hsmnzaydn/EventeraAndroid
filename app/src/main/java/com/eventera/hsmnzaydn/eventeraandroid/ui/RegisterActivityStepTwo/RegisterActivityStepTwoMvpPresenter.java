package com.eventera.hsmnzaydn.eventeraandroid.ui.RegisterActivityStepTwo;

import com.eventera.hsmnzaydn.eventeraandroid.data.network.model.RegisterObject;
import com.eventera.hsmnzaydn.eventeraandroid.ui.base.MvpPresenter;

/**
 * Created by hsmnzaydn on 24.03.2018.
 */

public interface RegisterActivityStepTwoMvpPresenter  <V extends RegisterActivityTwoStepTwoMvpView> extends MvpPresenter<V> {

    void register(RegisterObject registerObject);
    void getListOfInterests();
}
