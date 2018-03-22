package com.eventera.hsmnzaydn.eventeraandroid.data.pref;

/**
 * Created by hsmnzaydn on 22.03.2018.
 */

public interface PrefHelper {
    void saveUdid(String udid);
    String getUdid();

    void saveAuthorization(String authorization);
    String getAuthorization();

}
