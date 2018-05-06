package com.eventera.hsmnzaydn.eventeraandroid.data.network.service;

import com.eventera.hsmnzaydn.eventeraandroid.data.network.model.CommonResponse;
import com.eventera.hsmnzaydn.eventeraandroid.data.network.model.RegisterObject;
import com.eventera.hsmnzaydn.eventeraandroid.data.network.model.User;

/**
 * Created by hsmnzaydn on 5/6/18.
 */

public interface ProfileService {

    void getProfile(String profileId, ServiceCallback<User> registerObjectServiceCallback, ServiceCallback<CommonResponse> commonResponseServiceCallback);
}
