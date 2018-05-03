package com.eventera.hsmnzaydn.eventeraandroid.di;



import com.eventera.hsmnzaydn.eventeraandroid.ui.AddWallEntryActivity.AddWallEntryActivity;
import com.eventera.hsmnzaydn.eventeraandroid.ui.DialogPopup.PopupFragment;
import com.eventera.hsmnzaydn.eventeraandroid.ui.WallEntryListActivity.WallEntryListActivity;
import com.eventera.hsmnzaydn.eventeraandroid.ui.MainActivity.MainActivity;
import com.eventera.hsmnzaydn.eventeraandroid.ui.RegisterActivityStepTwo.RegisterActivityStepTwo;
import com.eventera.hsmnzaydn.eventeraandroid.ui.SplashActivity.SplashActivity;

import javax.inject.Singleton;

import dagger.Component;


@Singleton
@Component(modules =  {DaggerModule.class})
public interface DaggerComponent {



    void inject(SplashActivity splashActivity);

    void inject(RegisterActivityStepTwo registerActivityStepTwo);
    void inject(MainActivity mainActivity);
    void inject(PopupFragment popupFragment);
    void inject(WallEntryListActivity wallEntryListActivity);
    void inject(AddWallEntryActivity addWallEntryActivity);
}
