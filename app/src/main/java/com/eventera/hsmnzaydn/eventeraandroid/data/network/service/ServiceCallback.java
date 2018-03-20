package com.eventera.hsmnzaydn.eventeraandroid.data.network.service;

/**
 * Created by hsmnzaydn on 04/05/2017.
 */

public interface ServiceCallback<T> {

    void onResponse(T response);

    void onError(String errorMessage);
}
