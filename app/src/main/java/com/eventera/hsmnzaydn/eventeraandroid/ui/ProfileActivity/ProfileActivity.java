package com.eventera.hsmnzaydn.eventeraandroid.ui.ProfileActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;

import com.eventera.hsmnzaydn.eventeraandroid.R;
import com.eventera.hsmnzaydn.eventeraandroid.data.DataManager;
import com.eventera.hsmnzaydn.eventeraandroid.data.network.model.Event;
import com.eventera.hsmnzaydn.eventeraandroid.data.network.model.Interesting;
import com.eventera.hsmnzaydn.eventeraandroid.data.network.model.User;
import com.eventera.hsmnzaydn.eventeraandroid.di.DaggerApplication;
import com.eventera.hsmnzaydn.eventeraandroid.eventbus.ProfileEvents;
import com.eventera.hsmnzaydn.eventeraandroid.ui.CustomComponent.MyListView;
import com.eventera.hsmnzaydn.eventeraandroid.ui.base.BaseActivity;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ProfileActivity extends BaseActivity implements ProfileActivityMvpView {
    ProfileActivityPresenter profileActivityPresenter;
    User user;
    @Inject
    DataManager dataManager;
    @BindView(R.id.activity_profile_interes_listview)
    MyListView activityProfileInteresListview;
    @BindView(R.id.activity_profile_almost_listview)
    MyListView activityProfileAlmostListview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        ButterKnife.bind(this);

        ((DaggerApplication) getApplication()).getDaggerComponent().inject(this);

        profileActivityPresenter = new ProfileActivityPresenter(this, dataManager);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }

    @Override
    public void loadProfileInformation(User registerObject) {
        setTitle(registerObject.getName());
        ArrayAdapter<String> interestingAdaptor=new ArrayAdapter<String>
                (this, android.R.layout.simple_list_item_1, android.R.id.text1, getInteresting(registerObject.getInteresting()));
        activityProfileInteresListview.setAdapter(interestingAdaptor);
        ArrayAdapter<String> attendAdapter=new ArrayAdapter<String>
                (this, android.R.layout.simple_list_item_1, android.R.id.text1, getEvents(registerObject.getAttendes()));
        activityProfileAlmostListview.setAdapter(attendAdapter);

    }


    @Subscribe(sticky = true, threadMode = ThreadMode.MAIN)
    public void getProfile(ProfileEvents profileEvents) {
        user = profileEvents.getUser();
        profileActivityPresenter.getProfileInformation(user.getUdid());
        EventBus.getDefault().removeStickyEvent(profileEvents);
    }


    public List<String> getInteresting(List<Interesting> interestingList){
        List<String> stringList=new ArrayList<>();

        for (Interesting interesting: interestingList) {
            stringList.add(interesting.getName());
        }

        return stringList;
    }

    public List<String> getEvents(List<Event> eventList){
        List<String> stringList=new ArrayList<>();

        for (Event event: eventList) {
            stringList.add(event.getEventname());
        }

        return stringList;
    }
}
