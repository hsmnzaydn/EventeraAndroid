package com.eventera.hsmnzaydn.eventeraandroid.data.network;


import com.eventera.hsmnzaydn.eventeraandroid.data.network.model.Comment;
import com.eventera.hsmnzaydn.eventeraandroid.data.network.model.CommonResponse;
import com.eventera.hsmnzaydn.eventeraandroid.data.network.model.Event;
import com.eventera.hsmnzaydn.eventeraandroid.data.network.model.Interesting;
import com.eventera.hsmnzaydn.eventeraandroid.data.network.model.RegisterObject;
import com.eventera.hsmnzaydn.eventeraandroid.data.network.model.RegisterResponse;
import com.eventera.hsmnzaydn.eventeraandroid.data.network.model.User;
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
    Observable<List<Interesting>> getListOfInterests();


    @GET("secure/events")
    Observable<List<Event>> listOfEvent();

    @GET("secure/events/{id}")
    Observable<CommonResponse> attendToEvent(@Path("id" ) String id );

    @GET("secure/events/{id}/wallEntries")
    Observable<List<WallEntry>> getWallEntries(@Path("id") String id);

    @POST("secure/events/{id}")
    Observable<CommonResponse> postWallEntry(@Path("id") String id, @Body WallEntry wallEntry);

    @GET("secure/events/{id}/isAttend")
    Observable<CommonResponse> isAttend(@Path("id") String id);

    @POST("secure/events/{eventId}/wallEntry/{wallEntryId}/comments")
    Observable<CommonResponse> postComment(@Path("eventId") String eventId,@Path("wallEntryId") String wallEntryId, @Body Comment text);


    @GET("secure/events/{eventId}/wallEntry/{wallEntryId}/comments")
    Observable<List<Comment>> getCommentList(@Path("eventId") String eventId,@Path("wallEntryId") String wallEntryId);

    @GET("secure/events/{eventId}/wallEntry/{wallEntryId}/like")
    Observable<CommonResponse> likeToWallEntry(@Path("eventId") String eventId,@Path("wallEntryId") String wallEntryId);


    @GET("secure/profile/{profileId}")
    Observable<User> getProfile(@Path("profileId") String profileId);


    @POST("secure/profile/{profileId}/update")
    Observable<CommonResponse> updateProfile(@Path("profileId") String profileId,@Body RegisterObject user );

}
