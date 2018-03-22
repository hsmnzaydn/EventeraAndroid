package com.eventera.hsmnzaydn.eventeraandroid.ui.RegisterActivity;

import android.os.Bundle;

import com.eventera.hsmnzaydn.eventeraandroid.R;
import com.eventera.hsmnzaydn.eventeraandroid.data.DataManager;
import com.eventera.hsmnzaydn.eventeraandroid.ui.base.BaseActivity;

import javax.inject.Inject;

public class RegisterActivity extends BaseActivity implements RegisterActivityMvpView {

    @Inject
    DataManager dataManager;

    RegisterActivityPresenter registerActivityPresenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        registerActivityPresenter=new RegisterActivityPresenter(this,dataManager);


    }
}
