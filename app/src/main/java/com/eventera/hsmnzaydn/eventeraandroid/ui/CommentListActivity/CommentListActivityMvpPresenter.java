package com.eventera.hsmnzaydn.eventeraandroid.ui.CommentListActivity;

import com.eventera.hsmnzaydn.eventeraandroid.ui.MainActivity.MainActivityMvpView;
import com.eventera.hsmnzaydn.eventeraandroid.ui.base.MvpPresenter;

/**
 * Created by hsmnzaydn on 5/5/18.
 */

public interface CommentListActivityMvpPresenter  <V extends CommentListActivityMvpView> extends MvpPresenter<V> {

    void getCommentList(String eventId,String wallEntryId);
    void postComment(String eventId,String wallEntryId,String text);

}
