package com.eventera.hsmnzaydn.eventeraandroid.ui.DialogPopup;

import android.app.Activity;

import com.mobistech.seturmice.EventBus.ReservationActivityRestartEvent;
import com.mobistech.seturmice.R;
import com.mobistech.seturmice.data.network.model.CommonResponse;
import com.mobistech.seturmice.data.network.model.requestmodel.ReservationRequest;
import com.mobistech.seturmice.data.network.service.ServiceCallback;
import com.mobistech.seturmice.ui.base.BasePresenter;
import com.mobistech.seturmice.ui.base.DialogMvpView;

import org.greenrobot.eventbus.EventBus;

/**
 * Created by hsmnzaydn on 29.01.2018.
 */

public class PopupFragmentPresenter<V extends DialogMvpView> extends BasePresenter<V>
        implements PopupFragmentMvpPresenter<V> {

    private Activity activity;
    private PopupFragment popupFragment;

    public PopupFragmentPresenter(Activity activity, PopupFragment popupFragment) {
        this.activity = activity;
        this.popupFragment = popupFragment;
    }

    @Override
    public void setReservationStatus(ReservationRequest reservationStatus, int id) {

        if(reservationStatus.getReason().isEmpty()){
            getMvpView().showError(activity.getString(R.string.Error_fill));
        }else {
            getMvpView().showLoading();

            getDataManager(activity).setReservationStatus(reservationStatus, id, new ServiceCallback<CommonResponse>() {
                @Override
                public void onResponse(CommonResponse response) {
                    getMvpView().dissmisLoading();
                    popupFragment.dismiss();
                    EventBus.getDefault().postSticky(new ReservationActivityRestartEvent());
                }

                @Override
                public void onError(String errorMessage) {
                    getMvpView().showError(errorMessage);
                    getMvpView().dissmisLoading();
                }
            }, new ServiceCallback<CommonResponse>() {
                @Override
                public void onResponse(CommonResponse response) {
                    getMvpView().showError(response.getMessage());
                    getMvpView().dissmisLoading();
                }

                @Override
                public void onError(String errorMessage) {
                    getMvpView().dissmisLoading();
                }
            });
        }

    }
}
