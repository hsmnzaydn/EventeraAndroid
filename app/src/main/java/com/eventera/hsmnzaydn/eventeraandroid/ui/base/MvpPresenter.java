package com.eventera.hsmnzaydn.eventeraandroid.ui.base;

/**
 * Created by hsmnzaydn on 12.01.2018.
 */

public interface MvpPresenter<V extends MvpView>  {
    void onAttach(V mvpView);
    void onDetach();

}
