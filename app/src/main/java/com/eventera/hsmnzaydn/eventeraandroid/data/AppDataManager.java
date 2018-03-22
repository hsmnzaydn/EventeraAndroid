package com.eventera.hsmnzaydn.eventeraandroid.data;

import com.eventera.hsmnzaydn.eventeraandroid.data.network.ApiHelper;
import com.eventera.hsmnzaydn.eventeraandroid.data.network.model.CommonResponse;
import com.eventera.hsmnzaydn.eventeraandroid.data.network.service.ServiceCallback;

import javax.inject.Inject;

/**
 * Created by hsmnzaydn on 22.03.2018.
 */

public class AppDataManager implements DataManager {
    ApiHelper apiHelper;

    @Inject
    public AppDataManager(ApiHelper apiHelper) {
        this.apiHelper = apiHelper;
    }

    @Override
    public void startApplication(ServiceCallback<CommonResponse> callback) {
        apiHelper.startApplication(callback);
    }
}
