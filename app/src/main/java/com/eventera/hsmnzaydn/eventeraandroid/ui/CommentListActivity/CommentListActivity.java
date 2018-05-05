package com.eventera.hsmnzaydn.eventeraandroid.ui.CommentListActivity;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.EditText;
import android.widget.ImageView;

import com.eventera.hsmnzaydn.eventeraandroid.R;
import com.eventera.hsmnzaydn.eventeraandroid.data.DataManager;
import com.eventera.hsmnzaydn.eventeraandroid.data.network.model.Comment;
import com.eventera.hsmnzaydn.eventeraandroid.data.network.model.WallEntry;
import com.eventera.hsmnzaydn.eventeraandroid.di.DaggerApplication;
import com.eventera.hsmnzaydn.eventeraandroid.eventbus.WallEntryEvent;
import com.eventera.hsmnzaydn.eventeraandroid.ui.Adapters.CommentListRecyclerViewAdapter;
import com.eventera.hsmnzaydn.eventeraandroid.ui.base.BaseActivity;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class CommentListActivity extends BaseActivity implements CommentListActivityMvpView {

    @BindView(R.id.activity_comment_list_recyclerview)
    RecyclerView activityCommentListRecyclerview;
    @BindView(R.id.editText)
    EditText activityCommentListEditText;
    @BindView(R.id.activity_comment_list_send_image_view)
    ImageView activityCommentListSendImageView;

    WallEntry wallEntry;

    CommentListActivityPresenter presenter;
    CommentListRecyclerViewAdapter adapter;

    @Inject
    DataManager dataManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comment_list);
        ButterKnife.bind(this);
        ((DaggerApplication) getApplication()).getDaggerComponent().inject(this);

        presenter=new CommentListActivityPresenter(this,dataManager);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }


    @Subscribe(sticky = true, threadMode = ThreadMode.MAIN)
    public void getEvent(WallEntryEvent wallEntryEvent){
        wallEntry=wallEntryEvent.getWallEntry();
        presenter.getCommentList(wallEntry.getEventId(),wallEntry.getId());



    }

    @OnClick(R.id.activity_comment_list_send_image_view)
    public void onViewClicked() {
        presenter.postComment(wallEntry.getEventId(),wallEntry.getId(),activityCommentListEditText.getText().toString());
        activityCommentListEditText.setText("");
    }

    @Override
    public void loadDataToList(List<Comment> listOfComment) {
       adapter=new CommentListRecyclerViewAdapter(listOfComment, new CommentListRecyclerViewAdapter.ItemListener() {
           @Override
           public void onItemClick(Comment item) {

           }
       }) ;
        activityCommentListRecyclerview.setLayoutManager(new LinearLayoutManager(this));
        activityCommentListRecyclerview.setAdapter(adapter);

    }
}
