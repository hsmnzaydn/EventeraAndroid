package com.eventera.hsmnzaydn.eventeraandroid.data.network.service;

import com.eventera.hsmnzaydn.eventeraandroid.data.network.NetworkError;
import com.eventera.hsmnzaydn.eventeraandroid.data.network.model.CommonResponse;

/**
 * Created by hsmnzaydn on 04/05/2017.
 */

public interface ServiceCallback<T> {

    void onResponse(T response);

    void onError(String message);
}
