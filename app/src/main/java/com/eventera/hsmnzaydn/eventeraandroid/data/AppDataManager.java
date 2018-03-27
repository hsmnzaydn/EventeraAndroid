package com.eventera.hsmnzaydn.eventeraandroid.data;

import com.eventera.hsmnzaydn.eventeraandroid.data.network.ApiHelper;
import com.eventera.hsmnzaydn.eventeraandroid.data.network.model.CommonResponse;
import com.eventera.hsmnzaydn.eventeraandroid.data.network.model.Interests;
import com.eventera.hsmnzaydn.eventeraandroid.data.network.model.RegisterObject;
import com.eventera.hsmnzaydn.eventeraandroid.data.network.model.RegisterResponse;
import com.eventera.hsmnzaydn.eventeraandroid.data.network.service.ServiceCallback;
import com.eventera.hsmnzaydn.eventeraandroid.data.pref.PrefHelper;

import java.util.List;

import javax.inject.Inject;

/**
 * Created by hsmnzaydn on 22.03.2018.
 */

public class AppDataManager implements DataManager {
    ApiHelper apiHelper;
    PrefHelper prefHelper;

    @Inject
    public AppDataManager(ApiHelper apiHelper,PrefHelper prefHelper) {
        this.apiHelper = apiHelper;
        this.prefHelper=prefHelper;
    }

    @Override
    public void startApplication(ServiceCallback<CommonResponse> callback) {
        apiHelper.startApplication(callback);
    }

    @Override
    public void saveUdid(String udid) {
        prefHelper.saveUdid(udid);
    }

    @Override
    public String getUdid() {
        return prefHelper.getUdid();
    }

    @Override
    public void saveAuthorization(String authorization) {
            prefHelper.saveAuthorization(authorization);
    }

    @Override
    public String getAuthorization() {
        return prefHelper.getAuthorization();
    }

    @Override
    public void register(RegisterObject registerObject, ServiceCallback<RegisterResponse> callback, ServiceCallback<CommonResponse> commonResponseServiceCallback) {
        apiHelper.register(registerObject,callback,commonResponseServiceCallback);
    }

    @Override
    public void getListOfInterests(ServiceCallback<List<Interests>> callback, ServiceCallback<CommonResponse> commonResponseServiceCallback) {
        apiHelper.getListOfInterests(callback,commonResponseServiceCallback);
    }
}
