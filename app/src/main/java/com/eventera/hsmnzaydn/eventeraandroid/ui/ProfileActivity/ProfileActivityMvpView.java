package com.eventera.hsmnzaydn.eventeraandroid.ui.ProfileActivity;

import com.eventera.hsmnzaydn.eventeraandroid.data.network.model.RegisterObject;
import com.eventera.hsmnzaydn.eventeraandroid.data.network.model.User;
import com.eventera.hsmnzaydn.eventeraandroid.ui.base.MvpView;

/**
 * Created by hsmnzaydn on 5/6/18.
 */

public interface ProfileActivityMvpView extends MvpView{

    void loadProfileInformation(User registerObject);
}
