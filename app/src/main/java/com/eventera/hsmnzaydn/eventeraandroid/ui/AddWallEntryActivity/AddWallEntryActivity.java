package com.eventera.hsmnzaydn.eventeraandroid.ui.AddWallEntryActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;

import com.eventera.hsmnzaydn.eventeraandroid.R;
import com.eventera.hsmnzaydn.eventeraandroid.data.DataManager;
import com.eventera.hsmnzaydn.eventeraandroid.data.network.model.Event;
import com.eventera.hsmnzaydn.eventeraandroid.di.DaggerApplication;
import com.eventera.hsmnzaydn.eventeraandroid.eventbus.EventShare;
import com.eventera.hsmnzaydn.eventeraandroid.ui.base.BaseActivity;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import javax.inject.Inject;

import butterknife.BindString;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class AddWallEntryActivity extends BaseActivity implements AddWallEntryActivityMvpView {
    AddWallEntryActivityPresenter presenter;
    @BindView(R.id.activity_add_wall_entry_edit_text)
    EditText activityAddWallEntryEditText;
    @BindView(R.id.activity_add_Wall_entry_send_image_view)
    ImageView activityAddWallEntrySendImageView;
    Event event;

    @BindString(R.string.add_wall_entry)
    String title;

    @Inject
    DataManager dataManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_wall_entry);
        ButterKnife.bind(this);

        ((DaggerApplication) getApplication()).getDaggerComponent().inject(this);
        presenter = new AddWallEntryActivityPresenter(this,dataManager);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setTitle(title);

    }

    @OnClick(R.id.activity_add_Wall_entry_send_image_view)
    public void onViewClicked() {
        presenter.postWallEntry(event.getId(),activityAddWallEntryEditText.getText().toString());
    }



    @Subscribe(sticky = true, threadMode = ThreadMode.MAIN)
    public void getEvent(EventShare eventShare){
        event=eventShare.getEvent();
        EventBus.getDefault().unregister(this);
    }

    @Override
    public void backPress() {
        onBackPressed();
    }


    @Override
    protected void onResume() {
        super.onResume();
        activityAddWallEntryEditText.requestFocus();
        InputMethodManager imgr = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        imgr.showSoftInput(activityAddWallEntryEditText, InputMethodManager.SHOW_IMPLICIT);
    }
}
