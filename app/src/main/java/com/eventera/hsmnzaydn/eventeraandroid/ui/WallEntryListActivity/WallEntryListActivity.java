package com.eventera.hsmnzaydn.eventeraandroid.ui.WallEntryListActivity;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;

import com.eventera.hsmnzaydn.eventeraandroid.R;
import com.eventera.hsmnzaydn.eventeraandroid.data.DataManager;
import com.eventera.hsmnzaydn.eventeraandroid.data.network.model.Event;
import com.eventera.hsmnzaydn.eventeraandroid.data.network.model.User;
import com.eventera.hsmnzaydn.eventeraandroid.data.network.model.WallEntry;
import com.eventera.hsmnzaydn.eventeraandroid.di.DaggerApplication;
import com.eventera.hsmnzaydn.eventeraandroid.eventbus.EventShare;
import com.eventera.hsmnzaydn.eventeraandroid.eventbus.ProfileEvents;
import com.eventera.hsmnzaydn.eventeraandroid.ui.Adapters.WallEntryListRecyclerViewAdapter;
import com.eventera.hsmnzaydn.eventeraandroid.ui.AddWallEntryActivity.AddWallEntryActivity;
import com.eventera.hsmnzaydn.eventeraandroid.ui.ProfileActivity.ProfileActivity;
import com.eventera.hsmnzaydn.eventeraandroid.ui.base.BaseActivity;
import com.eventera.hsmnzaydn.eventeraandroid.utility.Utils;
import com.getkeepsafe.taptargetview.TapTarget;
import com.getkeepsafe.taptargetview.TapTargetView;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindString;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class WallEntryListActivity extends BaseActivity implements WallEntryListActivityMvpView {

    WallEntryListActivityPresenter presenter;

    @BindView(R.id.activity_event_list_recyclerview)
    RecyclerView activityEventListRecyclerview;
    @BindView(R.id.activity_event_list_float_action_button)
    FloatingActionButton activityEventListFloatActionButton;
    @BindView(R.id.activity_wall_entry_list_swipe_refresh)
    SwipeRefreshLayout activityWallEntryListSwipeRefresh;
    private WallEntryListRecyclerViewAdapter adapter;
    @BindString(R.string.empty_wall_entry_list)
    String empty;
    @BindString(R.string.add_wall_entry)
    String addWallEntry;

    private Event event;
    @Inject
    DataManager dataManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wall_entry_list);
        ButterKnife.bind(this);
        ((DaggerApplication) getApplication()).getDaggerComponent().inject(this);
        presenter = new WallEntryListActivityPresenter(this, dataManager);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        activityWallEntryListSwipeRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                presenter.getWallEntry(event.getId());
            }
        });
    }


    @Override
    public void loadWallEntryList(List<WallEntry> listOfWallEntry) {
        adapter = new WallEntryListRecyclerViewAdapter(this, listOfWallEntry, dataManager, new WallEntryListRecyclerViewAdapter.ItemListener() {
            @Override
            public void onItemClick(WallEntry item) {

            }
        });

        if(listOfWallEntry.size() == 0){
            TapTargetView.showFor(this,
                    TapTarget.forView(findViewById(R.id.activity_event_list_float_action_button), empty, addWallEntry)
                            .outerCircleColor(R.color.colorPrimary)
                            .outerCircleAlpha(0.96f)
                            .targetCircleColor(R.color.grey)
                            .titleTextSize(20)
                            .titleTextColor(R.color.grey)
                            .descriptionTextSize(10)
                            .descriptionTextColor(R.color.grey)
                            .textColor(R.color.grey)
                            .textTypeface(Typeface.SANS_SERIF)
                            .dimColor(R.color.transparent)
                            .drawShadow(true)
                            .cancelable(true)
                            .tintTarget(true)
                            .transparentTarget(false)
                            .icon(getResources().getDrawable(R.mipmap.ic_plus))
                            .targetRadius(60),
                    new TapTargetView.Listener() {
                        @Override
                        public void onTargetClick(TapTargetView view) {
                            super.onTargetClick(view);
                            view.dismiss(false);
                            Utils.changeActivity(WallEntryListActivity.this,AddWallEntryActivity.class);
                        }
                    });
        }

        if (activityWallEntryListSwipeRefresh.isRefreshing()) {
            activityWallEntryListSwipeRefresh.setRefreshing(false);
        }


        activityEventListRecyclerview.setLayoutManager(new LinearLayoutManager(this));
        activityEventListRecyclerview.setAdapter(adapter);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_profile, menu);


        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.menu_search_profile:
                User user = new User();
                user.setUdid(dataManager.getUdid());
                EventBus.getDefault().postSticky(new ProfileEvents(user));
                Utils.changeActivity(this, ProfileActivity.class);
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
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
