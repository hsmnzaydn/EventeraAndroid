package com.eventera.hsmnzaydn.eventeraandroid.data.network;


import com.eventera.hsmnzaydn.eventeraandroid.data.network.model.Comment;
import com.eventera.hsmnzaydn.eventeraandroid.data.network.model.CommonResponse;
import com.eventera.hsmnzaydn.eventeraandroid.data.network.model.Event;
import com.eventera.hsmnzaydn.eventeraandroid.data.network.model.Interesting;
import com.eventera.hsmnzaydn.eventeraandroid.data.network.model.RegisterObject;
import com.eventera.hsmnzaydn.eventeraandroid.data.network.model.RegisterResponse;
import com.eventera.hsmnzaydn.eventeraandroid.data.network.model.WallEntry;
import com.eventera.hsmnzaydn.eventeraandroid.data.network.service.EventService;
import com.eventera.hsmnzaydn.eventeraandroid.data.network.service.RegisterService;
import com.eventera.hsmnzaydn.eventeraandroid.data.network.service.ServiceCallback;
import com.eventera.hsmnzaydn.eventeraandroid.data.network.service.StartApplicationService;
import com.eventera.hsmnzaydn.eventeraandroid.data.network.service.WallEntryService;

import java.util.List;

import javax.inject.Inject;

/**
 * Created by hsmnzaydn on 17.01.2018.
 */

public class AppApiHelper implements ApiHelper {


    private StartApplicationService startApplicationService;
    private RegisterService registerService;
    private EventService eventService;
    private WallEntryService wallEntryService;
    @Inject
    public AppApiHelper(StartApplicationService startApplicationService,RegisterService registerService, EventService eventService,WallEntryService wallEntryService) {
        this.startApplicationService = startApplicationService;
        this.eventService=eventService;
        this.registerService=registerService;
        this.wallEntryService=wallEntryService;
    }

    @Override
    public void startApplication(ServiceCallback<CommonResponse> callback) {
        startApplicationService.startApplication(callback);
    }

    @Override
    public void register(RegisterObject registerObject, ServiceCallback<RegisterResponse> callback, ServiceCallback<CommonResponse> commonResponseServiceCallback) {
        registerService.register(registerObject,callback,commonResponseServiceCallback);
    }

    @Override
    public void getListOfInterests(ServiceCallback<List<Interesting>> callback, ServiceCallback<CommonResponse> commonResponseServiceCallback) {
        registerService.getListOfInterests(callback,commonResponseServiceCallback);
    }


    @Override
    public void getEventList(ServiceCallback<List<Event>> listOfEvent, ServiceCallback<CommonResponse> commonResponseServiceCallback) {
            eventService.getEventList(listOfEvent,commonResponseServiceCallback);
    }

    @Override
    public void attendToEvent(String id, ServiceCallback<CommonResponse> commonResponseServiceCallback) {
        eventService.attendToEvent(id,commonResponseServiceCallback);
    }

    @Override
    public void getWallEntries(String id, ServiceCallback<List<WallEntry>> wallEntryListCallback, ServiceCallback<CommonResponse> commonResponseServiceCallback) {
        eventService.getWallEntries(id,wallEntryListCallback,commonResponseServiceCallback);
    }

    @Override
    public void postWallEntries(String id, WallEntry wallEntry, ServiceCallback<CommonResponse> commonResponseServiceCallback) {
        eventService.postWallEntries(id,wallEntry,commonResponseServiceCallback);
    }

    @Override
    public void isAttend(String id, ServiceCallback<CommonResponse> commonResponseServiceCallback) {
        eventService.isAttend(id,commonResponseServiceCallback);
    }

    @Override
    public void postComment(String eventId, String wallEntryId, Comment text, ServiceCallback<CommonResponse> commonResponseServiceCallback) {
        wallEntryService.postComment(eventId,wallEntryId,text,commonResponseServiceCallback);
    }

    @Override
    public void getCommentList(String eventId, String wallEntryId, ServiceCallback<List<Comment>> listServiceCallback, ServiceCallback<CommonResponse> commonResponseServiceCallback) {
        wallEntryService.getCommentList(eventId,wallEntryId,listServiceCallback,commonResponseServiceCallback);
    }

    @Override
    public void like(String eventId, String wallEntryId) {
        wallEntryService.like(eventId,wallEntryId);
    }
}
