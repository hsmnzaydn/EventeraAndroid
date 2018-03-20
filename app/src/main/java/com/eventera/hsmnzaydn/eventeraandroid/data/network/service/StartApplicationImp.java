package com.eventera.hsmnzaydn.eventeraandroid.data.network.service;

import com.eventera.hsmnzaydn.eventeraandroid.data.network.ApiClient;
import com.eventera.hsmnzaydn.eventeraandroid.data.network.ApiInterface;
import com.eventera.hsmnzaydn.eventeraandroid.data.network.model.CommonResponse;

import javax.inject.Inject;

/**
 * Created by hsmnzaydn on 20.03.2018.
 */

public class StartApplicationImp implements StartApplication{
    private ApiInterface apiService;

    @Inject
    public StartApplicationImp() {
        apiService = ApiClient.getClient().create(ApiInterface.class);
    }

    @Override
    public void startApplication(ServiceCallback<CommonResponse> callback) {

    }
}
