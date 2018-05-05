package com.eventera.hsmnzaydn.eventeraandroid.data.network.service;

import com.eventera.hsmnzaydn.eventeraandroid.data.network.ApiClient;
import com.eventera.hsmnzaydn.eventeraandroid.data.network.ApiInterface;
import com.eventera.hsmnzaydn.eventeraandroid.data.network.NetworkError;
import com.eventera.hsmnzaydn.eventeraandroid.data.network.model.Comment;
import com.eventera.hsmnzaydn.eventeraandroid.data.network.model.CommonResponse;

import java.util.List;

import javax.inject.Inject;

import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * Created by hsmnzaydn on 5/5/18.
 */

public class WallEntryServiceImp implements WallEntryService {

    private ApiInterface apiService;

    @Inject
    public WallEntryServiceImp() {
        apiService = ApiClient.getClient().create(ApiInterface.class);
    }


    @Override
    public void postComment(String eventId, String wallEntryId, Comment text, final ServiceCallback<CommonResponse> commonResponseServiceCallback) {
        apiService.postComment(eventId,wallEntryId,text).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .onErrorResumeNext(new Func1<Throwable, Observable<? extends CommonResponse>>() {
                    @Override
                    public Observable<? extends CommonResponse> call(Throwable throwable) {

                        return Observable.error(throwable);
                    }
                })
                .subscribe(new Subscriber<CommonResponse>() {
                    @Override
                    public void onCompleted() {

                    }
                    @Override
                    public void onError(Throwable e) {
                        NetworkError networkError = new NetworkError(e);
                        networkError.response(commonResponseServiceCallback);

                    }

                    @Override
                    public void onNext(CommonResponse commonResponse) {
                        commonResponseServiceCallback.onResponse(commonResponse);

                    }
                });
    }

    @Override
    public void getCommentList(String eventId, String wallEntryId, final ServiceCallback<List<Comment>> listServiceCallback, final ServiceCallback<CommonResponse> commonResponseServiceCallback) {
        apiService.getCommentList(eventId,wallEntryId).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .onErrorResumeNext(new Func1<Throwable, Observable<? extends List<Comment>>>() {
                    @Override
                    public Observable<? extends List<Comment>> call(Throwable throwable) {

                        return Observable.error(throwable);
                    }
                })
                .subscribe(new Subscriber<List<Comment>>() {
                    @Override
                    public void onCompleted() {

                    }
                    @Override
                    public void onError(Throwable e) {
                        NetworkError networkError = new NetworkError(e);
                        networkError.response(commonResponseServiceCallback);

                    }

                    @Override
                    public void onNext(List<Comment> commentList) {
                        listServiceCallback.onResponse(commentList);

                    }
                });
    }

    @Override
    public void like(String eventId, String wallEntryId) {
        apiService.likeToWallEntry(eventId,wallEntryId).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .onErrorResumeNext(new Func1<Throwable, Observable<? extends CommonResponse>>() {
                    @Override
                    public Observable<? extends CommonResponse> call(Throwable throwable) {

                        return Observable.error(throwable);
                    }
                })
                .subscribe(new Subscriber<CommonResponse>() {
                    @Override
                    public void onCompleted() {

                    }
                    @Override
                    public void onError(Throwable e) {
                        NetworkError networkError = new NetworkError(e);

                    }

                    @Override
                    public void onNext(CommonResponse commonResponse) {

                    }
                });
    }
}
