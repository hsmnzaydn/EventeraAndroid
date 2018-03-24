package com.eventera.hsmnzaydn.eventeraandroid.eventbus;

import com.eventera.hsmnzaydn.eventeraandroid.data.network.model.RegisterObject;

/**
 * Created by hsmnzaydn on 24.03.2018.
 */

public class RegisterObjectEvent {
    private RegisterObject registerObject;

    public RegisterObjectEvent(RegisterObject registerObject) {
        this.registerObject = registerObject;
    }

    public RegisterObject getRegisterObject() {
        return registerObject;
    }

    public void setRegisterObject(RegisterObject registerObject) {
        this.registerObject = registerObject;
    }
}
