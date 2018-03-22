package com.eventera.hsmnzaydn.eventeraandroid.data.network;


import com.eventera.hsmnzaydn.eventeraandroid.data.network.model.CommonResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import rx.Observable;

public interface ApiInterface {

    @GET("secure/startApplication")
    Observable<CommonResponse> startApplication();

}
