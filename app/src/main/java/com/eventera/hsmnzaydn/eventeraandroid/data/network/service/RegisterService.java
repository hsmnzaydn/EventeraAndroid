package com.eventera.hsmnzaydn.eventeraandroid.data.network.service;

import com.eventera.hsmnzaydn.eventeraandroid.data.network.model.CommonResponse;
import com.eventera.hsmnzaydn.eventeraandroid.data.network.model.RegisterObject;
import com.eventera.hsmnzaydn.eventeraandroid.data.network.model.RegisterResponse;

/**
 * Created by hsmnzaydn on 22.03.2018.
 */

public interface RegisterService {

        void register(RegisterObject registerObject, ServiceCallback<RegisterResponse> callback, ServiceCallback<CommonResponse> commonResponseServiceCallback);
}
