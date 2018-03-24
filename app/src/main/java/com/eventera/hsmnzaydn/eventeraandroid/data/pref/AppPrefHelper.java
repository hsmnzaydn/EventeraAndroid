package com.eventera.hsmnzaydn.eventeraandroid.data.pref;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;

import com.eventera.hsmnzaydn.eventeraandroid.utility.Utils;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Created by hsmnzaydn on 22.03.2018.
 */

@Singleton

public class AppPrefHelper implements PrefHelper {

    private final SharedPreferences mPrefs;
    private final String PREF_UDID="udid";
    private final String PREF_AUTHORIZATON="authorization";
    private String prefFileName="";
    private Context context;


    @Inject
    public AppPrefHelper(Context activity) {
        mPrefs = activity.getSharedPreferences(prefFileName, Context.MODE_PRIVATE);
        this.context=activity;
    }
    @Override
    public void saveUdid(String udid) {
        mPrefs.edit().putString(PREF_UDID, udid).apply();

    }

    @Override
    public String getUdid() {
       return mPrefs.getString(PREF_UDID,null);
    }

    @Override
    public void saveAuthorization(String authorization) {
        mPrefs.edit().putString(PREF_AUTHORIZATON, authorization).apply();

    }

    @Override
    public String getAuthorization() {
        return mPrefs.getString(PREF_AUTHORIZATON,null);

    }
}
