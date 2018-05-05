package com.eventera.hsmnzaydn.eventeraandroid.ui.MainActivity;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.view.Menu;
import android.view.MenuItem;

import com.eventera.hsmnzaydn.eventeraandroid.R;
import com.eventera.hsmnzaydn.eventeraandroid.data.DataManager;
import com.eventera.hsmnzaydn.eventeraandroid.data.network.model.Event;
import com.eventera.hsmnzaydn.eventeraandroid.di.DaggerApplication;
import com.eventera.hsmnzaydn.eventeraandroid.eventbus.EventShare;
import com.eventera.hsmnzaydn.eventeraandroid.ui.Adapters.EventListRecyclerviewAdapter;
import com.eventera.hsmnzaydn.eventeraandroid.ui.DialogPopup.PopupFragment;
import com.eventera.hsmnzaydn.eventeraandroid.ui.WallEntryListActivity.WallEntryListActivity;
import com.eventera.hsmnzaydn.eventeraandroid.ui.base.BaseActivity;
import com.eventera.hsmnzaydn.eventeraandroid.utility.Utils;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindString;
import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.internal.Util;

public class MainActivity extends BaseActivity implements MainActivityMvpView,SearchView.OnQueryTextListener {

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

    private List<Event> eventList=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        ((DaggerApplication) getApplication()).getDaggerComponent().inject(this);

        presenter = new MainActivityPresenter(this, dataManager);
        setTitle(title);
        presenter.getSpecificEventList();





    }


    @Override
    public void LoadDataSpecificsEvent(List<Event> listOfEvent) {
        Utils.showEmptyTextView(this,listOfEvent,empty);
        eventList=listOfEvent;
        adapter = new EventListRecyclerviewAdapter(listOfEvent, itemListener);
        itemListener = new EventListRecyclerviewAdapter.ItemListener() {
            @Override
            public void onItemClick(Event item) {
                EventBus.getDefault().postSticky(new EventShare(item));
                presenter.attend(item);
            }
        };
        activityMainRecylerview.setLayoutManager(new LinearLayoutManager(this));
        activityMainRecylerview.setAdapter(adapter);
    }

    @Override
    public void openWallEntryListActivity() {
        Utils.changeActivity(this, WallEntryListActivity.class);

    }

    @Override
    public void openPopup() {
        PopupFragment.newInstance().show(getSupportFragmentManager(),4,1);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_search, menu);
        MenuItem searchItem = menu.findItem(R.id.menu_search_search);
        searchItem.expandActionView();
        SearchView searchView = (SearchView) searchItem.getActionView();
        searchView.setOnQueryTextListener(this);
        return true;
    }

    @Override
    public boolean onQueryTextSubmit(String query) {

        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        newText=newText.toLowerCase();

        ArrayList<Event> newList=new ArrayList<>();
        for(Event event:eventList){
            String name=event.getEventcategoryname().toLowerCase();
            String eventName=event.getEventname().toLowerCase();
            if(name.contains(newText) || eventName.contains(newText))
                newList.add(event);
        }

        adapter.setFilter(newList);
        return false;
    }
}
