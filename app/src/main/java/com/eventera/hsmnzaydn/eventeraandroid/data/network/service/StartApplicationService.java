package com.eventera.hsmnzaydn.eventeraandroid.data.network.service;

import com.eventera.hsmnzaydn.eventeraandroid.data.network.model.CommonResponse;

/**
 * Created by hsmnzaydn on 20.03.2018.
 */

public interface StartApplicationService {
    void startApplication(ServiceCallback<CommonResponse> callback);
}
