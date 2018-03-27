package com.eventera.hsmnzaydn.eventeraandroid.data.network;


import com.eventera.hsmnzaydn.eventeraandroid.data.network.model.CommonResponse;
import com.eventera.hsmnzaydn.eventeraandroid.data.network.model.Interests;
import com.eventera.hsmnzaydn.eventeraandroid.data.network.model.RegisterObject;
import com.eventera.hsmnzaydn.eventeraandroid.data.network.model.RegisterResponse;

import java.util.List;

import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import rx.Observable;

public interface ApiInterface {

    @GET("secure/startApplication")
    Observable<CommonResponse> startApplication();

    @POST("registration/validateId")
    Observable<RegisterResponse> register(@Body RegisterObject registerObject);

    @GET("registration/categories")
    Observable<List<Interests>> getListOfInterests();

}
