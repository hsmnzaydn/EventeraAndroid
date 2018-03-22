package com.eventera.hsmnzaydn.eventeraandroid.di;

import android.app.Application;
import android.content.Context;


import com.eventera.hsmnzaydn.eventeraandroid.data.AppDataManager;
import com.eventera.hsmnzaydn.eventeraandroid.data.DataManager;
import com.eventera.hsmnzaydn.eventeraandroid.data.network.ApiHelper;
import com.eventera.hsmnzaydn.eventeraandroid.data.network.AppApiHelper;
import com.eventera.hsmnzaydn.eventeraandroid.data.network.service.StartApplication;
import com.eventera.hsmnzaydn.eventeraandroid.data.network.service.StartApplicationImp;
import com.eventera.hsmnzaydn.eventeraandroid.data.pref.AppPrefHelper;
import com.eventera.hsmnzaydn.eventeraandroid.data.pref.PrefHelper;

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
    ApiHelper provideApiHelper(StartApplication startApplication){
        return new AppApiHelper(startApplication);
    }

    @Provides
    @Singleton
    StartApplication provideStartApplication(){
        return new StartApplicationImp();
    }

    @Provides
    @Singleton
    PrefHelper provicePrefHelper(Context context){
        return new AppPrefHelper(context);
    }


}