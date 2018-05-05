package com.eventera.hsmnzaydn.eventeraandroid.ui.CommentListActivity;

import com.eventera.hsmnzaydn.eventeraandroid.data.network.model.Comment;
import com.eventera.hsmnzaydn.eventeraandroid.ui.base.MvpView;

import java.util.List;

/**
 * Created by hsmnzaydn on 5/5/18.
 */

public interface CommentListActivityMvpView extends MvpView{

void loadDataToList(List<Comment> listOfComment);

}
