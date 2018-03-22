package com.eventera.hsmnzaydn.eventeraandroid.ui.base;

import android.app.Activity;

/**
 * Created by hsmnzaydn on 12.01.2018.
 */

public interface MvpView {
    void showLoading();
    void dissmisLoading();
    void showMessageToast(String text);
    void showError(String text);
    void showMessageDialog(String text);
    void killActivity();

}
