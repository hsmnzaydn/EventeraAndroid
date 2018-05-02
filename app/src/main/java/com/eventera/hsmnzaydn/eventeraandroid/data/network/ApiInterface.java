package com.eventera.hsmnzaydn.eventeraandroid.data.network;


import com.eventera.hsmnzaydn.eventeraandroid.data.network.model.CommonResponse;
import com.eventera.hsmnzaydn.eventeraandroid.data.network.model.Event;
import com.eventera.hsmnzaydn.eventeraandroid.data.network.model.Interests;
import com.eventera.hsmnzaydn.eventeraandroid.data.network.model.RegisterObject;
import com.eventera.hsmnzaydn.eventeraandroid.data.network.model.RegisterResponse;
import com.eventera.hsmnzaydn.eventeraandroid.data.network.model.WallEntry;

import java.util.List;

import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import rx.Observable;

public interface ApiInterface {

    @GET("secure/startApplication")
    Observable<CommonResponse> startApplication();

    @POST("registration/validateId")
    Observable<RegisterResponse> register(@Body RegisterObject registerObject);

    @GET("registration/categories")
    Observable<List<Interests>> getListOfInterests();


    @GET("secure/events")
    Observable<List<Event>> listOfEvent();

    @GET("secure/events/{id}")
    Observable<CommonResponse> attendToEvent(@Path("id" ) String id );

    @GET("secure/events/{id}/wallEntries")
    Observable<List<WallEntry>> getWallEntries(@Path("id") String id);
}
