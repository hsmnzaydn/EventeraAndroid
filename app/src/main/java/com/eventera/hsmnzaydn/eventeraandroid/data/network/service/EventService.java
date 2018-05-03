package com.eventera.hsmnzaydn.eventeraandroid.data.network.service;

import android.app.Service;

import com.eventera.hsmnzaydn.eventeraandroid.data.network.model.CommonResponse;
import com.eventera.hsmnzaydn.eventeraandroid.data.network.model.Event;
import com.eventera.hsmnzaydn.eventeraandroid.data.network.model.WallEntry;

import java.util.List;

/**
 * Created by hsmnzaydn on 01.05.2018.
 */

public interface EventService {
    void getEventList(ServiceCallback<List<Event>> listOfEvent, ServiceCallback<CommonResponse> commonResponseServiceCallback);
    void attendToEvent(String id, ServiceCallback<CommonResponse> commonResponseServiceCallback);
    void getWallEntries(String id, ServiceCallback<List<WallEntry>> wallEntryListCallback, ServiceCallback<CommonResponse> commonResponseServiceCallback);
    void postWallEntries(String id,WallEntry wallEntry,ServiceCallback<CommonResponse> commonResponseServiceCallback);
    void isAttend(String id,ServiceCallback<CommonResponse> commonResponseServiceCallback);

}
