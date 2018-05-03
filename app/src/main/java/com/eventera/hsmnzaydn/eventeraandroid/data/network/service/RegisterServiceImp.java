package com.eventera.hsmnzaydn.eventeraandroid.data.network.service;

import com.eventera.hsmnzaydn.eventeraandroid.data.network.ApiClient;
import com.eventera.hsmnzaydn.eventeraandroid.data.network.ApiInterface;
import com.eventera.hsmnzaydn.eventeraandroid.data.network.NetworkError;
import com.eventera.hsmnzaydn.eventeraandroid.data.network.model.CommonResponse;
import com.eventera.hsmnzaydn.eventeraandroid.data.network.model.Interesting;
import com.eventera.hsmnzaydn.eventeraandroid.data.network.model.RegisterObject;
import com.eventera.hsmnzaydn.eventeraandroid.data.network.model.RegisterResponse;

import java.util.List;

import javax.inject.Inject;

import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * Created by hsmnzaydn on 22.03.2018.
 */

public class RegisterServiceImp implements RegisterService{


    private ApiInterface apiService;

    @Inject
    public RegisterServiceImp() {
        apiService = ApiClient.getClient().create(ApiInterface.class);
    }

    @Override
    public void register(final RegisterObject registerObject, final ServiceCallback<RegisterResponse> callback, final ServiceCallback<CommonResponse> commonResponseServiceCallback) {

        apiService.register(registerObject).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .onErrorResumeNext(new Func1<Throwable, Observable<? extends RegisterResponse>>() {
                    @Override
                    public Observable<? extends RegisterResponse> call(Throwable throwable) {

                        return Observable.error(throwable);
                    }
                })
                .subscribe(new Subscriber<RegisterResponse>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                     new NetworkError(e).response(commonResponseServiceCallback);

                    }

                    @Override
                    public void onNext(RegisterResponse registerResponse) {
                        callback.onResponse(registerResponse);

                    }
                });
    }

    @Override
    public void getListOfInterests(final ServiceCallback<List<Interesting>> callback, final ServiceCallback<CommonResponse> commonResponseServiceCallback) {
        apiService.getListOfInterests().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .onErrorResumeNext(new Func1<Throwable, Observable<? extends List<Interesting>>>() {
                    @Override
                    public Observable<? extends List<Interesting>> call(Throwable throwable) {

                        return Observable.error(throwable);
                    }
                })
                .subscribe(new Subscriber<List<Interesting>>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                        new NetworkError(e).response(commonResponseServiceCallback);

                    }

                    @Override
                    public void onNext(List<Interesting> listOfCategory) {
                        callback.onResponse(listOfCategory);

                    }
                });
    }


}
