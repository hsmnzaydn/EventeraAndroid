package com.eventera.hsmnzaydn.eventeraandroid.ui.WallEntryListActivity;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.eventera.hsmnzaydn.eventeraandroid.R;
import com.eventera.hsmnzaydn.eventeraandroid.data.DataManager;
import com.eventera.hsmnzaydn.eventeraandroid.data.network.model.Event;
import com.eventera.hsmnzaydn.eventeraandroid.data.network.model.WallEntry;
import com.eventera.hsmnzaydn.eventeraandroid.di.DaggerApplication;
import com.eventera.hsmnzaydn.eventeraandroid.eventbus.EventShare;
import com.eventera.hsmnzaydn.eventeraandroid.ui.Adapters.WallEntryListRecyclerViewAdapter;
import com.eventera.hsmnzaydn.eventeraandroid.ui.AddWallEntryActivity.AddWallEntryActivity;
import com.eventera.hsmnzaydn.eventeraandroid.ui.base.BaseActivity;
import com.eventera.hsmnzaydn.eventeraandroid.utility.Utils;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindString;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.internal.Util;

public class WallEntryListActivity extends BaseActivity implements WallEntryListActivityMvpView {

    WallEntryListActivityPresenter presenter;

    @BindView(R.id.activity_event_list_recyclerview)
    RecyclerView activityEventListRecyclerview;
    @BindView(R.id.activity_event_list_float_action_button)
    FloatingActionButton activityEventListFloatActionButton;
    private WallEntryListRecyclerViewAdapter adapter;
    @BindString(R.string.empty_wall_entry_list)
    String empty;
    private Event event;
    @Inject
    DataManager dataManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_list);
        ButterKnife.bind(this);
        ((DaggerApplication) getApplication()).getDaggerComponent().inject(this);
        presenter = new WallEntryListActivityPresenter(this, dataManager);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }


    @Override
    public void loadWallEntryList(List<WallEntry> listOfWallEntry) {
        Utils.showEmptyTextView(this,listOfWallEntry,empty);
        adapter = new WallEntryListRecyclerViewAdapter(listOfWallEntry, new WallEntryListRecyclerViewAdapter.ItemListener() {
            @Override
            public void onItemClick(WallEntry item) {

            }
        });

        activityEventListRecyclerview.setLayoutManager(new LinearLayoutManager(this));
        activityEventListRecyclerview.setAdapter(adapter);


    }

    @Subscribe(sticky = true, threadMode = ThreadMode.MAIN)
    public void getEvent(EventShare eventShare) {
        event = eventShare.getEvent();
        presenter.getWallEntry(event.getId());
        setTitle(event.getEventname());
        EventBus.getDefault().unregister(this);

    }

    @Override
    protected void onRestart() {
        super.onRestart();
    }

    @OnClick(R.id.activity_event_list_float_action_button)
    public void onViewClicked() {
        Utils.changeActivity(this, AddWallEntryActivity.class);
    }
}
