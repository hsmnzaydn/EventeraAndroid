package com.eventera.hsmnzaydn.eventeraandroid.ui.SplashActivity;

import android.os.Bundle;

import com.eventera.hsmnzaydn.eventeraandroid.R;
import com.eventera.hsmnzaydn.eventeraandroid.data.DataManager;
import com.eventera.hsmnzaydn.eventeraandroid.di.DaggerApplication;
import com.eventera.hsmnzaydn.eventeraandroid.ui.RegisterActivity.RegisterActivity;
import com.eventera.hsmnzaydn.eventeraandroid.ui.base.BaseActivity;
import com.eventera.hsmnzaydn.eventeraandroid.utility.Utils;

import javax.inject.Inject;


public class SplashActivity extends BaseActivity implements SplashActivityMvpView {

    SplashActivityPresenter<SplashActivityMvpView> presenter;

    @Inject
    DataManager dataManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        ((DaggerApplication) getApplication()).getDaggerComponent().inject(this);

        presenter=new SplashActivityPresenter(this,dataManager);
        presenter.startApplication();
    }


    @Override
    public void openMainActivity() {

    }

    @Override
    public void openRegisteractivity() {
        Utils.changeActivity(this, RegisterActivity.class);
    }
}
