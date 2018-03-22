package com.eventera.hsmnzaydn.eventeraandroid.ui.base;



/**
 * Created by hsmnzaydn on 12.01.2018.
 */

public class BasePresenter<V extends MvpView> implements MvpPresenter<V> {




    private V mvpView;


    public V getMvpView() {
        return this.mvpView;
    }


    @Override
    public void onAttach(V mvpView) {
        this.mvpView = mvpView;
    }

    @Override
    public void onDetach() {
        mvpView=null;
    }


}
