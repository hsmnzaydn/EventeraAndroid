package com.eventera.hsmnzaydn.eventeraandroid.data.network.service;

import com.eventera.hsmnzaydn.eventeraandroid.data.network.ApiClient;
import com.eventera.hsmnzaydn.eventeraandroid.data.network.ApiInterface;
import com.eventera.hsmnzaydn.eventeraandroid.data.network.NetworkError;
import com.eventera.hsmnzaydn.eventeraandroid.data.network.model.CommonResponse;
import com.eventera.hsmnzaydn.eventeraandroid.utility.Utils;

import javax.inject.Inject;

import retrofit2.adapter.rxjava.HttpException;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * Created by hsmnzaydn on 20.03.2018.
 */

public class StartApplicationServiceImp implements StartApplicationService {
    private ApiInterface apiService;

    @Inject
    public StartApplicationServiceImp() {
        apiService = ApiClient.getClient().create(ApiInterface.class);
    }

    @Override
    public void startApplication(final ServiceCallback<CommonResponse> callback) {
        apiService.startApplication().subscribeOn(Schedulers.io())
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
                        networkError.response(callback);

                    }

                    @Override
                    public void onNext(CommonResponse commonResponse) {
                        callback.onResponse(commonResponse);

                    }
                });

    }
}
