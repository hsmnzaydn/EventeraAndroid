package com.eventera.hsmnzaydn.eventeraandroid.data.network;


import com.eventera.hsmnzaydn.eventeraandroid.data.network.model.CommonResponse;
import com.eventera.hsmnzaydn.eventeraandroid.data.network.service.ServiceCallback;
import com.eventera.hsmnzaydn.eventeraandroid.data.network.service.StartApplication;

import javax.inject.Inject;

/**
 * Created by hsmnzaydn on 17.01.2018.
 */

public class AppApiHelper implements ApiHelper {


    private StartApplication startApplication;

    @Inject
    public AppApiHelper(StartApplication startApplication) {
        this.startApplication = startApplication;
    }

    @Override
    public void startApplication(ServiceCallback<CommonResponse> callback) {
        startApplication.startApplication(callback);
    }
}
