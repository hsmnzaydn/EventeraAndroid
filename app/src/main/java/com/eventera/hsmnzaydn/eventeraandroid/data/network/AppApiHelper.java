package com.eventera.hsmnzaydn.eventeraandroid.data.network;


import com.eventera.hsmnzaydn.eventeraandroid.data.network.model.CommonResponse;
import com.eventera.hsmnzaydn.eventeraandroid.data.network.model.RegisterObject;
import com.eventera.hsmnzaydn.eventeraandroid.data.network.model.RegisterResponse;
import com.eventera.hsmnzaydn.eventeraandroid.data.network.service.RegisterService;
import com.eventera.hsmnzaydn.eventeraandroid.data.network.service.ServiceCallback;
import com.eventera.hsmnzaydn.eventeraandroid.data.network.service.StartApplicationService;

import javax.inject.Inject;

/**
 * Created by hsmnzaydn on 17.01.2018.
 */

public class AppApiHelper implements ApiHelper {


    private StartApplicationService startApplicationService;
    private RegisterService registerService;

    @Inject
    public AppApiHelper(StartApplicationService startApplicationService) {
        this.startApplicationService = startApplicationService;
    }

    @Override
    public void startApplication(ServiceCallback<CommonResponse> callback) {
        startApplicationService.startApplication(callback);
    }

    @Override
    public void register(RegisterObject registerObject, ServiceCallback<RegisterResponse> callback, ServiceCallback<CommonResponse> commonResponseServiceCallback) {
        registerService.register(registerObject,callback,commonResponseServiceCallback);
    }
}
