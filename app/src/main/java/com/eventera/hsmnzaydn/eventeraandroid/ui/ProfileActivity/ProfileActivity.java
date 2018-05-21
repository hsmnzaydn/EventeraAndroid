package com.eventera.hsmnzaydn.eventeraandroid.ui.ProfileActivity;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;

import com.eventera.hsmnzaydn.eventeraandroid.R;
import com.eventera.hsmnzaydn.eventeraandroid.data.DataManager;
import com.eventera.hsmnzaydn.eventeraandroid.data.network.model.Event;
import com.eventera.hsmnzaydn.eventeraandroid.data.network.model.Interesting;
import com.eventera.hsmnzaydn.eventeraandroid.data.network.model.User;
import com.eventera.hsmnzaydn.eventeraandroid.di.DaggerApplication;
import com.eventera.hsmnzaydn.eventeraandroid.eventbus.EventShare;
import com.eventera.hsmnzaydn.eventeraandroid.eventbus.ProfileEvents;
import com.eventera.hsmnzaydn.eventeraandroid.ui.Adapters.AttendesListViewAdapter;
import com.eventera.hsmnzaydn.eventeraandroid.ui.AttendEventActivity.AttendEventActivity;
import com.eventera.hsmnzaydn.eventeraandroid.ui.CustomComponent.MyListView;
import com.eventera.hsmnzaydn.eventeraandroid.ui.DialogPopup.PopupFragment;
import com.eventera.hsmnzaydn.eventeraandroid.ui.WallEntryListActivity.WallEntryListActivity;
import com.eventera.hsmnzaydn.eventeraandroid.ui.base.BaseActivity;
import com.eventera.hsmnzaydn.eventeraandroid.utility.Utils;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ProfileActivity extends BaseActivity implements ProfileActivityMvpView {
    ProfileActivityPresenter profileActivityPresenter;
    User user;
    @Inject
    DataManager dataManager;
    @BindView(R.id.activity_profile_interes_listview)
    MyListView activityProfileInteresListview;

    @BindView(R.id.activity_profile_add_interesting_image_view)
    ImageView activityProfileAddInterestingImageView;
    @BindView(R.id.activity_profile_almost_listview)
    MyListView activityProfileAlmostListview;
    @BindView(R.id.swipe)
    SwipeRefreshLayout swipe;

    private AttendesListViewAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        ButterKnife.bind(this);

        ((DaggerApplication) getApplication()).getDaggerComponent().inject(this);

        profileActivityPresenter = new ProfileActivityPresenter(this, dataManager);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        swipe.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                profileActivityPresenter.getProfileInformation(user.getUdid());
            }
        });

    }

    @Override
    public void loadProfileInformation(final User registerObject) {
        setTitle(registerObject.getName());
        if (registerObject.getUdid().toString().equals(dataManager.getUdid().toString())) {
            activityProfileAddInterestingImageView.setVisibility(View.VISIBLE);
        }
        ArrayAdapter<String> interestingAdaptor = new ArrayAdapter<String>
                (this, android.R.layout.simple_list_item_1, android.R.id.text1, getInteresting(registerObject.getInteresting()));
        activityProfileInteresListview.setAdapter(interestingAdaptor);

        adapter = new AttendesListViewAdapter(ProfileActivity.this, registerObject.getAttendes());
        activityProfileAlmostListview.setAdapter(adapter);

        activityProfileAlmostListview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                profileActivityPresenter.attend(registerObject.getAttendes().get(i));
                EventBus.getDefault().postSticky(new EventShare(registerObject.getAttendes().get(i)));
            }
        });

        if (swipe.isRefreshing()) {
            swipe.setRefreshing(false);
        }

    }


    @Subscribe(sticky = true, threadMode = ThreadMode.MAIN)
    public void getProfile(ProfileEvents profileEvents) {
        user = profileEvents.getUser();
        profileActivityPresenter.getProfileInformation(user.getUdid());
    }


    public List<String> getInteresting(List<Interesting> interestingList) {
        List<String> stringList = new ArrayList<>();

        for (Interesting interesting : interestingList) {
            stringList.add(interesting.getName());
        }

        return stringList;
    }

    public List<String> getEvents(List<Event> eventList) {
        List<String> stringList = new ArrayList<>();

        for (Event event : eventList) {
            stringList.add(event.getEventname());
        }

        return stringList;
    }


    @Override
    public void openWallEntryListActivity() {
        Utils.changeActivity(this, WallEntryListActivity.class);

    }

    @Override
    public void openPopup() {
       // PopupFragment.newInstance().show(getSupportFragmentManager(), 4, 1);
        Utils.changeActivity(this, AttendEventActivity.class);
    }

    @OnClick(R.id.activity_profile_add_interesting_image_view)
    public void onClickAddInteresting() {
        PopupFragment.newInstance().show(getSupportFragmentManager(), 5, 1);

    }


    @Override
    protected void onRestart() {
        super.onRestart();

    }
}
