package com.eventera.hsmnzaydn.eventeraandroid.ui.RegisterActivityStepTwo;

import com.eventera.hsmnzaydn.eventeraandroid.data.network.model.Interests;
import com.eventera.hsmnzaydn.eventeraandroid.ui.base.MvpView;

import java.util.List;

/**
 * Created by hsmnzaydn on 24.03.2018.
 */

public interface RegisterActivityTwoStepTwoMvpView extends MvpView {
    void openMainActivity();
    void loadDataToRecylerview(List<Interests> categoryList);
}
