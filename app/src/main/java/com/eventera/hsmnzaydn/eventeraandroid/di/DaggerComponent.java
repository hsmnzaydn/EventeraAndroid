package com.eventera.hsmnzaydn.eventeraandroid.di;



import android.app.Activity;

import com.eventera.hsmnzaydn.eventeraandroid.ui.SplashActivity.SplashActivity;
import com.eventera.hsmnzaydn.eventeraandroid.ui.SplashActivity.SplashActivityPresenter;

import javax.inject.Singleton;

import dagger.Component;


@Singleton
@Component(modules =  {DaggerModule.class})
public interface DaggerComponent {



    void inject(SplashActivity splashActivity);

    void inject(Activity activity);
}
