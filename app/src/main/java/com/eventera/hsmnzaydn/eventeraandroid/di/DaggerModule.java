package com.eventera.hsmnzaydn.eventeraandroid.di;

import android.app.Activity;
import android.app.Application;
import android.content.Context;


import com.eventera.hsmnzaydn.eventeraandroid.data.AppDataManager;
import com.eventera.hsmnzaydn.eventeraandroid.data.DataManager;
import com.eventera.hsmnzaydn.eventeraandroid.data.network.ApiHelper;
import com.eventera.hsmnzaydn.eventeraandroid.data.network.AppApiHelper;
import com.eventera.hsmnzaydn.eventeraandroid.data.network.service.EventService;
import com.eventera.hsmnzaydn.eventeraandroid.data.network.service.EventServiceImp;
import com.eventera.hsmnzaydn.eventeraandroid.data.network.service.RegisterService;
import com.eventera.hsmnzaydn.eventeraandroid.data.network.service.RegisterServiceImp;
import com.eventera.hsmnzaydn.eventeraandroid.data.network.service.StartApplicationService;
import com.eventera.hsmnzaydn.eventeraandroid.data.network.service.StartApplicationServiceImp;
import com.eventera.hsmnzaydn.eventeraandroid.data.network.service.WallEntryService;
import com.eventera.hsmnzaydn.eventeraandroid.data.network.service.WallEntryServiceImp;
import com.eventera.hsmnzaydn.eventeraandroid.data.pref.AppPrefHelper;
import com.eventera.hsmnzaydn.eventeraandroid.data.pref.PrefHelper;
import com.eventera.hsmnzaydn.eventeraandroid.ui.MainActivity.MainActivityMvpPresenter;
import com.eventera.hsmnzaydn.eventeraandroid.ui.MainActivity.MainActivityMvpView;
import com.eventera.hsmnzaydn.eventeraandroid.ui.MainActivity.MainActivityPresenter;
import com.eventera.hsmnzaydn.eventeraandroid.ui.SplashActivity.SplashActivityMvpView;
import com.eventera.hsmnzaydn.eventeraandroid.ui.SplashActivity.SplashActivityPresenter;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by hsmnzaydn on 18.03.2018.
 */

@Module
public class DaggerModule {


    private Context context;

    public DaggerModule(Application app) {
        this.context = app;
    }



    @Provides
    Context providesContext() {
        return context;
    }



    @Provides
    @Singleton
    DataManager provideDataManager(ApiHelper apiHelper,PrefHelper prefHelper){
        return new AppDataManager(apiHelper,prefHelper);
    }


    @Provides
    @Singleton
    ApiHelper provideApiHelper(StartApplicationService startApplicationService, RegisterService registerService, EventService eventService,WallEntryService wallEntryService){
        return new AppApiHelper(startApplicationService,registerService,eventService,wallEntryService);
    }

    @Provides
    @Singleton
    StartApplicationService provideStartApplication(){
        return new StartApplicationServiceImp();
    }



    @Provides
    @Singleton
    PrefHelper provicePrefHelper(Context context){
        return new AppPrefHelper(context);
    }

    @Provides
    @Singleton
    RegisterService provideRegisterService(){
        return new RegisterServiceImp();
    }


    @Provides
    @Singleton
    EventService provideEventService(){
        return new EventServiceImp();
    }

    @Provides
    @Singleton
    WallEntryService provideWallEntryService(){
        return new WallEntryServiceImp();
    }

    @Provides
    @Singleton
    MainActivityMvpPresenter<MainActivityMvpView> provideMainActivityPresenter(MainActivityPresenter<MainActivityMvpView> presenter){
        return presenter;
    }


}