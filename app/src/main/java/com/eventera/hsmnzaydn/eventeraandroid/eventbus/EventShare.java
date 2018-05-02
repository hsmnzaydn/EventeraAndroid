package com.eventera.hsmnzaydn.eventeraandroid.eventbus;

import com.eventera.hsmnzaydn.eventeraandroid.data.network.model.Event;

/**
 * Created by hsmnzaydn on 01.05.2018.
 */

public class EventShare {

    private Event event;

    public EventShare(Event event) {
        this.event = event;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }
}
