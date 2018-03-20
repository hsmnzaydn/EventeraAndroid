package com.eventera.hsmnzaydn.eventeraandroid.ui.base;

import android.app.Activity;

import com.mobistech.seturmice.Utility.Constant;
import com.mobistech.seturmice.data.AppDataManager;
import com.mobistech.seturmice.data.DataManager;
import com.mobistech.seturmice.data.network.ApiHelper;
import com.mobistech.seturmice.data.network.AppApiHelper;
import com.mobistech.seturmice.data.network.service.EventServiceImp;
import com.mobistech.seturmice.data.network.service.MapServiceImp;
import com.mobistech.seturmice.data.network.service.NotificationServiceImp;
import com.mobistech.seturmice.data.network.service.ReservationsImp;
import com.mobistech.seturmice.data.network.service.ShuttleServiceImp;
import com.mobistech.seturmice.data.network.service.StartApplication;
import com.mobistech.seturmice.data.network.service.StartApplicationImp;
import com.mobistech.seturmice.data.network.service.UsersImp;
import com.mobistech.seturmice.data.pref.AppPrefHelper;
import com.mobistech.seturmice.data.pref.PrefHelper;

import javax.inject.Inject;

/**
 * Created by hsmnzaydn on 12.01.2018.
 */

public class BasePresenter<V extends MvpView> implements MvpPresenter<V> {

    @Inject
    DataManager dataManager;

    @Inject
    PrefHelper prefHelper;

    @Inject
    ApiHelper apiHelper;

    @Inject
    StartApplication startApplication;


    private V mvpView;


    public DataManager getDataManager(Activity activity) {
        prefHelper=new AppPrefHelper(activity,Constant.PREF_FILE_NAME);
        startApplication=new StartApplicationImp();
        apiHelper =new AppApiHelper(startApplication,new MapServiceImp(),new ReservationsImp(),new UsersImp(),new EventServiceImp(),new ShuttleServiceImp(),new NotificationServiceImp());
        dataManager=new AppDataManager(activity,prefHelper, apiHelper);
        return dataManager;
    }

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
