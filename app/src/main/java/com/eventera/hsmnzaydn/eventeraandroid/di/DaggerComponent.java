package com.eventera.hsmnzaydn.eventeraandroid.di;



import android.app.Activity;

import com.eventera.hsmnzaydn.eventeraandroid.ui.MainActivity.MainActivity;
import com.eventera.hsmnzaydn.eventeraandroid.ui.MainActivity.MainActivityMvpPresenter;
import com.eventera.hsmnzaydn.eventeraandroid.ui.MainActivity.MainActivityMvpView;
import com.eventera.hsmnzaydn.eventeraandroid.ui.MainActivity.MainActivityPresenter;
import com.eventera.hsmnzaydn.eventeraandroid.ui.RegisterActivityStepTwo.RegisterActivityStepTwo;
import com.eventera.hsmnzaydn.eventeraandroid.ui.SplashActivity.SplashActivity;
import com.eventera.hsmnzaydn.eventeraandroid.ui.SplashActivity.SplashActivityPresenter;

import javax.inject.Singleton;

import dagger.Component;


@Singleton
@Component(modules =  {DaggerModule.class})
public interface DaggerComponent {



    void inject(SplashActivity splashActivity);

    void inject(RegisterActivityStepTwo registerActivityStepTwo);
    void inject(MainActivity mainActivity);
}
