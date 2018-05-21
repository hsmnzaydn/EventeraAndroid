package com.eventera.hsmnzaydn.eventeraandroid.ui.AttendEventActivity;

import com.eventera.hsmnzaydn.eventeraandroid.ui.CommentListActivity.CommentListActivityMvpView;
import com.eventera.hsmnzaydn.eventeraandroid.ui.base.MvpPresenter;

/**
 * Created by hsmnzaydn on 5/22/18.
 */

public interface AttendEventActivityMvpPresenter   <V extends AttendEventActivityMvpView> extends MvpPresenter<V> {
    void attendToEvent(String id);

}
