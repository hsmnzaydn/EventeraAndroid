package com.eventera.hsmnzaydn.eventeraandroid.ui.DialogPopup;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.eventera.hsmnzaydn.eventeraandroid.R;
import com.eventera.hsmnzaydn.eventeraandroid.data.DataManager;
import com.eventera.hsmnzaydn.eventeraandroid.data.network.model.Event;
import com.eventera.hsmnzaydn.eventeraandroid.di.DaggerApplication;
import com.eventera.hsmnzaydn.eventeraandroid.eventbus.EventShare;
import com.eventera.hsmnzaydn.eventeraandroid.ui.EventListActivity.EventListActivity;
import com.eventera.hsmnzaydn.eventeraandroid.ui.base.BaseDialog;
import com.eventera.hsmnzaydn.eventeraandroid.utility.Utils;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import javax.inject.Inject;

import butterknife.BindString;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.internal.Util;

/**
 * Created by hsmnzaydn on 29.01.2018.
 */

public class PopupFragment extends BaseDialog implements PopupFragmentMvpView {

    private View root;

    public static final String TAG = "PopupFragment";

    private PopupFragmentPresenter dialogFragmentPresenter;


    /*
        TYPE=1:
         - FUNCTION 1= SHOW A POPUP WHEN CLICK OK BUTTON IT'LL OPEN MAINACTIVITY

        TYPE=2;
         - FUNCTION 1= SHOW A POPUP WHEN CLICK PASS BUTTON IT'LL OPEN MAINACTIVITY
                                    WHEN CLICK INSTALL BUTTON IT'LL OPEN APK'S URL
         - FUNCTION 2= SHOW A POPUP WHEN GET PUSH NOTIFICATION
                                    WHEN CLICK SHOW IT'LL OPEN NOTIFICATION FRAGMENT
                                    WHEN CLICK CANCEL IT'LL CLOSE POPUP
        TYPE=3;
         - FUNCTION 1= SHOW A POPUP WHEN CLICK USER WRITE TO EDITTEXT AND PRESS SEND IT'LL POST TO RESERVATION REASON

        TYPE=4;
         - FUNCTION 1= SHOW A POPUP WHEN CLICK SHOW IT'LL OPEN NOTIFICATION FRAGMENT
                                    WHEN CLICK CANCEL IT'LL CLOSE POPUP


     */

    private int dialogType;
    private int dialogFunction;

    //DİALOG TYPE ONE IT SHOW ONLY INFORMATION
    @BindView(R.id.dialog_type_one)
    LinearLayout dialogTypeOne;

    @BindView(R.id.dialog_type_one_title)
    TextView dialogTypeOneTextView;


    //DİALOG TYPE TWO IT GIVE A CHANGE TO USER

    @BindView(R.id.dialog_type_two)
    LinearLayout dialogTypeTwo;

    @BindView(R.id.dialog_type_two_title_textview)
    TextView dialogTypeTwoTextView;

    @BindView(R.id.dialog_type_two_ok_button)
    Button dialogTypeTwoOkButton;

    @BindView(R.id.dialog_type_two_cancel_button)
    Button dialogTypeTwoCancelButton;


    //DİALOG TYPE THREE IT TAKE AN INPUT

    @BindView(R.id.dialog_type_three)
    LinearLayout dialogTypeThree;

    @BindView(R.id.dialog_type_three_text_view)
    TextView dialogTypeThreeTextView;

    @BindView(R.id.dialog_type_three_edit_text)
    EditText dialogTypeThreeEditText;

    @BindView(R.id.dialog_type_three_send_button)
    Button dialogTypeThreeButton;

    @BindView(R.id.dialog_type_three_cancel_button)
    Button dialogTypeThreeCancelButton;
    //UpdateAvailable Status
    //   private UpdateAvailable updateAvailable;

    // ONE TEXT 2 CHOOSE
    @BindView(R.id.dialog_type_four_title_text_view)
    TextView dialogTypeFourTitleTextView;
    @BindView(R.id.dialog_type_four_detail_text_view)
    TextView dialogTypeFourDetailTextView;
    @BindView(R.id.dialog_type_four_location_text_view)
    TextView dialogTypeFourLocationTextView;
    @BindView(R.id.dialog_type_four_category_text_view)
    TextView dialogTypeFourCategoryTextView;
    @BindView(R.id.dialog_type_four_cancel_button)
    Button dialogTypeFourCancelButton;
    @BindView(R.id.dialog_type_four_send_button)
    Button dialogTypeFourSendButton;
    @BindView(R.id.dialog_type_four)
    LinearLayout dialogTypeFour;

    private int reservationId;
    Event event;

    @BindString(R.string.attend)
    String attend;

    @Inject
    DataManager dataManager;
    public static PopupFragment newInstance() {
        PopupFragment fragment = new PopupFragment();
        Bundle bundle = new Bundle();
        fragment.setArguments(bundle);
        return fragment;
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        root = inflater.inflate(R.layout.dialog_try_error_popup, container, false);

        setUnBinder(ButterKnife.bind(this, root));
        EventBus.getDefault().register(this);
        ((DaggerApplication) getActivity().getApplication()).getDaggerComponent().inject(this);

        dialogFragmentPresenter = new PopupFragmentPresenter(getActivity(),dataManager);
        dialogFragmentPresenter.onAttach(this);

        if (dialogType == 1 && dialogFunction == 1) {
            dialogTypeOne.setVisibility(View.VISIBLE);
            dialogTypeOneTextView.setText(getActivity().getString(R.string.popup_type_one_title));
        }
       /* if(dialogType == 2 && dialogFunction == 1){
            dialogTypeTwo.setVisibility(View.VISIBLE);
            dialogTypeTwoOkButton.setText(getActivity().getString(R.string.popup_type_two_install));
            dialogTypeTwoCancelButton.setText(getActivity().getString(R.string.popup_type_two_pass));
            dialogTypeTwoTextView.setText(getActivity().getString(R.string.popup_type_two_title_optional));

            if(updateAvailable.getType().toString().equals("MANDATORY") ){
                dialogTypeTwoTextView.setText(getActivity().getString(R.string.popup_type_two_title_mandatory));
                dialogTypeTwoCancelButton.setVisibility(View.GONE);
            }


        }*/
        if (dialogType == 2 && dialogFunction == 2) {
            dialogTypeTwo.setVisibility(View.VISIBLE);
            dialogTypeTwoOkButton.setText(getActivity().getString(R.string.popup_type_two_show_notification));
            dialogTypeTwoCancelButton.setText(getActivity().getString(R.string.cancel));
            dialogTypeTwoTextView.setText(getActivity().getString(R.string.popup_type_two_notification));


        }


        if (dialogType == 3 && dialogFunction == 1) {
            dialogTypeThree.setVisibility(View.VISIBLE);
            dialogTypeThreeTextView.setText(getString(R.string.row_reservation_reason_hint));
            dialogTypeThreeButton.setText(getString(R.string.send));
        }

        if (dialogType == 4 && dialogFunction == 1) {
            dialogTypeFour.setVisibility(View.VISIBLE);
            dialogTypeFourSendButton.setText(attend);
            dialogTypeFourTitleTextView.setText(event.getEventname());
            dialogTypeFourLocationTextView.setText(event.getEventlocation());
            dialogTypeFourDetailTextView.setText(event.getEventdescription());
        }


        return root;

    }


    @OnClick(R.id.dialog_type_one_ok_button)
    public void clickToOkButton() {
        switch (dialogFunction) {
            case 1:
                getActivity().finish();
                //  Utils.changeActivity(getActivity(), MainActivity.class);
                break;
        }

    }

    @OnClick(R.id.dialog_type_two_ok_button)
    public void clickToOkButtonOfTypeTwo() {
        switch (dialogFunction) {
            case 1:
                // Utils.openLink(getActivity(),updateAvailable.getLink());
                break;
            case 2:
                break;
        }

    }

    @OnClick(R.id.dialog_type_two_cancel_button)
    public void clickToCancelButtonOfTypeTwo() {
        switch (dialogFunction) {
            case 1:
                //  Utils.changeActivity(getActivity(),MainActivity.class);
                break;
            case 2:
                dismiss();
        }
    }


    @OnClick(R.id.dialog_type_three_send_button)
    public void clickToSendButtonOfTypeThree() {
        switch (dialogFunction) {
            case 1:
             /*   ReservationRequest reservationRequest=new ReservationRequest();
                reservationRequest.setStatus("DECLINED");
                reservationRequest.setReason(dialogTypeThreeEditText.getText().toString());
                dialogFragmentPresenter.setReservationStatus(reservationRequest,reservationId);
                break;
                */
        }


    }

    @OnClick(R.id.dialog_type_three_cancel_button)
    public void cancelButtonOfTypeThree() {
        dismiss();
    }

    @Override
    protected void setUp(View view) {

    }

    public void show(FragmentManager fragmentManager, int type, int function) {
        super.show(fragmentManager, TAG);
        dialogType = type;
        dialogFunction = function;
    }


    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void onStop() {
        super.onStop();
        EventBus.getDefault().unregister(this);
    }

    @Override
    public void onResume() {
        super.onResume();
        dialogTypeThreeEditText.post(new Runnable() {
            @Override
            public void run() {
                dialogTypeThreeEditText.requestFocus();
                InputMethodManager imgr = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
                imgr.showSoftInput(dialogTypeThreeEditText, InputMethodManager.SHOW_IMPLICIT);
            }
        });
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();

    }

    @OnClick({R.id.dialog_type_four_cancel_button, R.id.dialog_type_four_send_button})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.dialog_type_four_cancel_button:
                dismiss();
                break;
            case R.id.dialog_type_four_send_button:
                dialogFragmentPresenter.attendToEvent(event.getId());
                break;
        }
    }


    @Subscribe(sticky = true, threadMode = ThreadMode.MAIN)
    public void getEventObject(EventShare eventShare) {
        event = eventShare.getEvent();
        EventBus.getDefault().unregister(this);

    }



    @Override
    public void openEventListActivity() {
        Utils.changeActivity(getActivity(), EventListActivity.class);
    }


}
