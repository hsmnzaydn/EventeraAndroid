package com.eventera.hsmnzaydn.eventeraandroid.data.network;


import com.eventera.hsmnzaydn.eventeraandroid.data.network.model.Event;
import com.eventera.hsmnzaydn.eventeraandroid.data.network.service.EventService;
import com.eventera.hsmnzaydn.eventeraandroid.data.network.service.ProfileService;
import com.eventera.hsmnzaydn.eventeraandroid.data.network.service.RegisterService;
import com.eventera.hsmnzaydn.eventeraandroid.data.network.service.StartApplicationService;
import com.eventera.hsmnzaydn.eventeraandroid.data.network.service.WallEntryService;

/**
 * Created by hsmnzaydn on 17.01.2018.
 */

public interface ApiHelper extends StartApplicationService,RegisterService,EventService,WallEntryService,ProfileService {


}
