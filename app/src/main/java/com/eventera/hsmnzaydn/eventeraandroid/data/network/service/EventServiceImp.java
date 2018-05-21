package com.eventera.hsmnzaydn.eventeraandroid.data.network.service;

import com.eventera.hsmnzaydn.eventeraandroid.data.network.ApiClient;
import com.eventera.hsmnzaydn.eventeraandroid.data.network.ApiInterface;
import com.eventera.hsmnzaydn.eventeraandroid.data.network.NetworkError;
import com.eventera.hsmnzaydn.eventeraandroid.data.network.model.CommonResponse;
import com.eventera.hsmnzaydn.eventeraandroid.data.network.model.Event;
import com.eventera.hsmnzaydn.eventeraandroid.data.network.model.RegisterResponse;
import com.eventera.hsmnzaydn.eventeraandroid.data.network.model.WallEntry;
import com.eventera.hsmnzaydn.eventeraandroid.utility.Constant;

import java.util.List;

import javax.inject.Inject;

import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * Created by hsmnzaydn on 01.05.2018.
 */

public class EventServiceImp implements EventService{

    private ApiInterface apiService;

    @Inject
    public EventServiceImp() {
        apiService = ApiClient.getClient().create(ApiInterface.class);
    }

    @Override
    public void getEventList(final ServiceCallback<List<Event>> callBackList, final ServiceCallback<CommonResponse> commonResponseServiceCallback) {
        apiService.listOfEvent().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .onErrorResumeNext(new Func1<Throwable, Observable<? extends List<Event>>>() {
                    @Override
                    public Observable<? extends List<Event>> call(Throwable throwable) {
                        return null;
                    }
                }).subscribe(new Subscriber<List<Event>>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

                new NetworkError(e).response(commonResponseServiceCallback);

            }

            @Override
            public void onNext(List<Event> listOfEvent) {
                callBackList.onResponse(listOfEvent);

            }
        });
    }

    @Override
    public void attendToEvent(String id, final ServiceCallback<CommonResponse> commonResponseServiceCallback) {



        apiService.attendToEvent(id).subscribeOn(Schedulers.io())
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

             //  new NetworkError(e).response(commonResponseServiceCallback);

            }

            @Override
            public void onNext(CommonResponse commonResponse) {
                commonResponseServiceCallback.onResponse(commonResponse);

            }
        });
    }

    @Override
    public void getWallEntries(String id, final ServiceCallback<List<WallEntry>> wallEntryListCallback, final ServiceCallback<CommonResponse> commonResponseServiceCallback) {
        apiService.getWallEntries(id).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .onErrorResumeNext(new Func1<Throwable, Observable<? extends List<WallEntry>>>() {
                    @Override
                    public Observable<? extends List<WallEntry>> call(Throwable throwable) {
                        return null;
                    }
                }).subscribe(new Subscriber<List<WallEntry>>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

                new NetworkError(e).response(commonResponseServiceCallback);

            }

            @Override
            public void onNext(List<WallEntry> listOfEvent) {
                wallEntryListCallback.onResponse(listOfEvent);

            }
        });
    }

    @Override
    public void postWallEntries(String id, WallEntry wallEntry, final ServiceCallback<CommonResponse> commonResponseServiceCallback) {
        apiService.postWallEntry(id,wallEntry).subscribeOn(Schedulers.io())
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

    @Override
    public void isAttend(String id, final ServiceCallback<CommonResponse> commonResponseServiceCallback) {
        apiService.isAttend(id).subscribeOn(Schedulers.io())
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

                CommonResponse commonResponse=new CommonResponse();
                commonResponse.setCode(Constant.UNREGISTER_CODE);
                commonResponse.setMessage("This user is not register");
                commonResponseServiceCallback.onResponse(commonResponse);
            }

            @Override
            public void onNext(CommonResponse commonResponse) {
                commonResponseServiceCallback.onResponse(commonResponse);

            }
        });
    }

}
