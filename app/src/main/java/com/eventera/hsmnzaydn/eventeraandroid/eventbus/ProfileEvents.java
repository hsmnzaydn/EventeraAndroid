package com.eventera.hsmnzaydn.eventeraandroid.eventbus;

import com.eventera.hsmnzaydn.eventeraandroid.data.network.model.RegisterObject;
import com.eventera.hsmnzaydn.eventeraandroid.data.network.model.User;

/**
 * Created by hsmnzaydn on 5/6/18.
 */

public class ProfileEvents {

    private User user;

    public ProfileEvents(User user) {
        this.user = user;
    }




    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
