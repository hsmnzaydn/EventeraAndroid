package com.eventera.hsmnzaydn.eventeraandroid.data.network.service;

import com.eventera.hsmnzaydn.eventeraandroid.data.network.ApiClient;
import com.eventera.hsmnzaydn.eventeraandroid.data.network.ApiInterface;
import com.eventera.hsmnzaydn.eventeraandroid.data.network.model.CommonResponse;

import javax.inject.Inject;

import retrofit2.Call;
import rx.Observable;
import rx.Scheduler;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * Created by hsmnzaydn on 20.03.2018.
 */

public class StartApplicationImp implements StartApplication{
    private ApiInterface apiService;

    @Inject
    public StartApplicationImp() {
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
                       // callback.onError(new Throwable(e));

                    }

                    @Override
                    public void onNext(CommonResponse commonResponse) {
                        callback.onResponse(commonResponse);

                    }
                });

    }
}
