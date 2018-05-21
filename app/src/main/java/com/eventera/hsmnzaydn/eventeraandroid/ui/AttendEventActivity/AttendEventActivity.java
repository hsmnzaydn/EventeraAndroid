package com.eventera.hsmnzaydn.eventeraandroid.ui.AttendEventActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.eventera.hsmnzaydn.eventeraandroid.R;
import com.eventera.hsmnzaydn.eventeraandroid.data.DataManager;
import com.eventera.hsmnzaydn.eventeraandroid.data.network.model.Event;
import com.eventera.hsmnzaydn.eventeraandroid.di.DaggerApplication;
import com.eventera.hsmnzaydn.eventeraandroid.eventbus.EventShare;
import com.eventera.hsmnzaydn.eventeraandroid.ui.WallEntryListActivity.WallEntryListActivity;
import com.eventera.hsmnzaydn.eventeraandroid.ui.base.BaseActivity;
import com.eventera.hsmnzaydn.eventeraandroid.utility.Utils;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class AttendEventActivity extends BaseActivity implements AttendEventActivityMvpView {

    AttendEventActivityMvpPresenter presenter;

    @Inject
    DataManager dataManager;
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
    private Event event;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attend_event);
        ButterKnife.bind(this);
        ((DaggerApplication) getApplication()).getDaggerComponent().inject(this);

        presenter = new AttendEventActivityPresenter(AttendEventActivity.this, dataManager);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setTitle("Attend Event");


    }

    @OnClick({R.id.dialog_type_four_cancel_button, R.id.dialog_type_four_send_button})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.dialog_type_four_cancel_button:
                onBackPressed();
                break;
            case R.id.dialog_type_four_send_button:
                presenter.attendToEvent(event.getId());
                this.finish();
                break;
        }
    }


    @Subscribe(sticky = true, threadMode = ThreadMode.MAIN)
    public void getEventObject(EventShare eventShare) {
        event = eventShare.getEvent();
        dialogTypeFourTitleTextView.setText(event.getEventname());
        dialogTypeFourDetailTextView.setText(event.getEventdescription());
        dialogTypeFourLocationTextView.setText(event.getEventlocation());
        dialogTypeFourCategoryTextView.setText(event.getEventcategoryname());

        EventBus.getDefault().unregister(this);

    }

    @Override
    public void openEventListActivity() {
        Utils.changeActivity(this, WallEntryListActivity.class);

    }
}
