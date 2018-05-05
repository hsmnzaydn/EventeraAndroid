package com.eventera.hsmnzaydn.eventeraandroid.ui.SplashActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.eventera.hsmnzaydn.eventeraandroid.R;
import com.eventera.hsmnzaydn.eventeraandroid.data.DataManager;
import com.eventera.hsmnzaydn.eventeraandroid.di.DaggerApplication;
import com.eventera.hsmnzaydn.eventeraandroid.ui.MainActivity.MainActivity;
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

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                ((DaggerApplication) getApplication()).getDaggerComponent().inject(SplashActivity.this);
                presenter=new SplashActivityPresenter(SplashActivity.this,getApplicationContext(),dataManager);
                presenter.startApplication();


            }},
         1500);




    }


    @Override
    protected void onPause() {
        super.onPause();

    }

    @Override
    public void onStop() {
        super.onStop();

    }

    @Override
    public void openMainActivity() {
        Utils.changeActivity(this, MainActivity.class);
    }

    @Override
    public void openRegisteractivity() {
        Utils.changeActivity(this, RegisterActivity.class);
    }
}
