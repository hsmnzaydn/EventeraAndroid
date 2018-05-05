package com.eventera.hsmnzaydn.eventeraandroid.ui.CommentListActivity;

import android.app.Activity;


import com.eventera.hsmnzaydn.eventeraandroid.data.DataManager;
import com.eventera.hsmnzaydn.eventeraandroid.data.network.model.Comment;
import com.eventera.hsmnzaydn.eventeraandroid.data.network.model.CommonResponse;
import com.eventera.hsmnzaydn.eventeraandroid.data.network.service.ServiceCallback;
import com.eventera.hsmnzaydn.eventeraandroid.ui.base.BasePresenter;

import java.util.List;

/**
 * Created by hsmnzaydn on 5/5/18.
 */

public class CommentListActivityPresenter <V extends CommentListActivityMvpView> extends BasePresenter<V> implements CommentListActivityMvpPresenter<V> {

    DataManager dataManager;

    public CommentListActivityPresenter(Activity activity,DataManager dataManager) {
        super(activity);
        this.dataManager=dataManager;
    }

    @Override
    public void getCommentList(String eventId, String wallEntryId) {
        getMvpView().showLoading();

        dataManager.getCommentList(eventId, wallEntryId, new ServiceCallback<List<Comment>>() {
            @Override
            public void onResponse(List<Comment> response) {
                getMvpView().loadDataToList(response);
                getMvpView().dissmisLoading();
            }

            @Override
            public void onError(String message) {
                getMvpView().showError(message);
                getMvpView().dissmisLoading();
            }
        }, new ServiceCallback<CommonResponse>() {
            @Override
            public void onResponse(CommonResponse response) {
                getMvpView().showError(response.getMessage());
                getMvpView().dissmisLoading();
            }

            @Override
            public void onError(String message) {
                getMvpView().showError(message);
                getMvpView().dissmisLoading();
            }
        });


    }

    @Override
    public void postComment(final String eventId, final String wallEntryId, String text) {
        getMvpView().showLoading();
        Comment comment=new Comment();
        comment.setText(text);
        dataManager.postComment(eventId, wallEntryId, comment, new ServiceCallback<CommonResponse>() {
            @Override
            public void onResponse(CommonResponse response) {
                getMvpView().dissmisLoading();
                getCommentList(eventId,wallEntryId);

            }

            @Override
            public void onError(String message) {

                getMvpView().showError(message);
                getMvpView().dissmisLoading();
            }
        });
    }
}
