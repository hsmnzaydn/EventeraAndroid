package com.eventera.hsmnzaydn.eventeraandroid.ui.EventListActivity;

import android.os.Bundle;

import com.eventera.hsmnzaydn.eventeraandroid.R;
import com.eventera.hsmnzaydn.eventeraandroid.data.DataManager;
import com.eventera.hsmnzaydn.eventeraandroid.data.network.model.Event;
import com.eventera.hsmnzaydn.eventeraandroid.data.network.model.WallEntry;
import com.eventera.hsmnzaydn.eventeraandroid.di.DaggerApplication;
import com.eventera.hsmnzaydn.eventeraandroid.eventbus.EventShare;
import com.eventera.hsmnzaydn.eventeraandroid.ui.base.BaseActivity;


import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.List;

import javax.inject.Inject;

public class EventListActivity extends BaseActivity  implements EventListActivityMvpView{

    EventListActivityPresenter presenter;
    private Event event;
    @Inject
    DataManager dataManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_list);
        presenter=new EventListActivityPresenter(this,dataManager);
        ((DaggerApplication) getApplication()).getDaggerComponent().inject(this);


    }


    @Override
    public void loadWallEntryList(List<WallEntry> listOfWallEntry) {



    }

    @Subscribe(sticky = true,threadMode = ThreadMode.MAIN)
    public void getEvent(EventShare eventShare){
        event=eventShare.getEvent();
        presenter.getWallEntry(event.getId());
    }
}
