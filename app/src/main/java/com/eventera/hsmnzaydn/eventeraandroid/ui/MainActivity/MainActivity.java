package com.eventera.hsmnzaydn.eventeraandroid.ui.MainActivity;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.eventera.hsmnzaydn.eventeraandroid.R;
import com.eventera.hsmnzaydn.eventeraandroid.data.DataManager;
import com.eventera.hsmnzaydn.eventeraandroid.data.network.model.Event;
import com.eventera.hsmnzaydn.eventeraandroid.di.DaggerApplication;
import com.eventera.hsmnzaydn.eventeraandroid.ui.Adapters.EventListRecyclerviewAdapter;
import com.eventera.hsmnzaydn.eventeraandroid.ui.base.BaseActivity;
import com.eventera.hsmnzaydn.eventeraandroid.utility.Utils;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindString;
import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity implements MainActivityMvpView {

    @Inject
    DataManager dataManager;

    EventListRecyclerviewAdapter.ItemListener itemListener;

    MainActivityPresenter presenter;

    EventListRecyclerviewAdapter adapter;

    @BindString(R.string.empty_event_list)
    String empty;

    @BindString(R.string.title_event)
    String title;

    @BindView(R.id.activity_main_recylerview)
    RecyclerView activityMainRecylerview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        ((DaggerApplication) getApplication()).getDaggerComponent().inject(this);

        presenter = new MainActivityPresenter(this, dataManager);
        setTitle(title);
        presenter.getSpecificEventList();


        itemListener = new EventListRecyclerviewAdapter.ItemListener() {
            @Override
            public void onItemClick(Event item) {

            }
        };


    }


    @Override
    public void LoadDataSpecificsEvent(List<Event> listOfEvent) {
        Utils.showEmptyTextView(this,listOfEvent,empty);
        adapter = new EventListRecyclerviewAdapter(listOfEvent, itemListener);
        activityMainRecylerview.setLayoutManager(new LinearLayoutManager(this));
        activityMainRecylerview.setAdapter(adapter);
    }
}
