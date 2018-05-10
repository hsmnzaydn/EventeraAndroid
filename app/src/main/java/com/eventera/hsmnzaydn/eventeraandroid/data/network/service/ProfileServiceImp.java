package com.eventera.hsmnzaydn.eventeraandroid.data.network.service;

import com.eventera.hsmnzaydn.eventeraandroid.data.network.ApiClient;
import com.eventera.hsmnzaydn.eventeraandroid.data.network.ApiInterface;
import com.eventera.hsmnzaydn.eventeraandroid.data.network.NetworkError;
import com.eventera.hsmnzaydn.eventeraandroid.data.network.model.CommonResponse;
import com.eventera.hsmnzaydn.eventeraandroid.data.network.model.Event;
import com.eventera.hsmnzaydn.eventeraandroid.data.network.model.RegisterObject;
import com.eventera.hsmnzaydn.eventeraandroid.data.network.model.User;

import java.util.List;

import javax.inject.Inject;

import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * Created by hsmnzaydn on 5/6/18.
 */

public class ProfileServiceImp implements ProfileService {

    private ApiInterface apiService;

    @Inject
    public ProfileServiceImp() {
        apiService = ApiClient.getClient().create(ApiInterface.class);
    }


    @Override
    public void getProfile(String profileId, final ServiceCallback<User> registerObjectServiceCallback, final ServiceCallback<CommonResponse> commonResponseServiceCallback) {
        apiService.getProfile(profileId).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .onErrorResumeNext(new Func1<Throwable, Observable<? extends User>>() {
                    @Override
                    public Observable<? extends User> call(Throwable throwable) {
                        return null;
                    }
                }).subscribe(new Subscriber<User>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

                new NetworkError(e).response(commonResponseServiceCallback);

            }

            @Override
            public void onNext(User user) {
                registerObjectServiceCallback.onResponse(user);

            }
        });
    }

    @Override
    public void updateProfile(String profileId, RegisterObject user, final ServiceCallback<CommonResponse> commonResponseServiceCallback) {
        apiService.updateProfile(profileId,user).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .onErrorResumeNext(new Func1<Throwable, Observable<? extends CommonResponse>>() {
                    @Override
                    public Observable<? extends CommonResponse> call(Throwable throwable) {
                        return null;
                    }
                }).subscribe(new Subscriber<CommonResponse>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

                new NetworkError(e).response(commonResponseServiceCallback);

            }

            @Override
            public void onNext(CommonResponse commonResponse) {
                commonResponseServiceCallback.onResponse(commonResponse);

            }
        });
    }
}
