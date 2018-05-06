package com.eventera.hsmnzaydn.eventeraandroid.ui.Adapters;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.eventera.hsmnzaydn.eventeraandroid.R;
import com.eventera.hsmnzaydn.eventeraandroid.data.DataManager;
import com.eventera.hsmnzaydn.eventeraandroid.data.network.model.WallEntry;
import com.eventera.hsmnzaydn.eventeraandroid.eventbus.ProfileEvents;
import com.eventera.hsmnzaydn.eventeraandroid.eventbus.WallEntryEvent;
import com.eventera.hsmnzaydn.eventeraandroid.ui.CommentListActivity.CommentListActivity;
import com.eventera.hsmnzaydn.eventeraandroid.ui.ProfileActivity.ProfileActivity;
import com.eventera.hsmnzaydn.eventeraandroid.utility.Utils;

import org.greenrobot.eventbus.EventBus;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


public class WallEntryListRecyclerViewAdapter extends RecyclerView.Adapter<WallEntryListRecyclerViewAdapter.ViewHolder> {



    private List<WallEntry> myItems;
    private ItemListener myListener;
    private Activity activity;
    private DataManager dataManager;

    public WallEntryListRecyclerViewAdapter(Activity activity, List<WallEntry> items, DataManager dataManager,ItemListener listener) {
        myItems = items;
        myListener = listener;
        this.activity = activity;
        this.dataManager=dataManager;


    }

    public void setListener(ItemListener listener) {
        myListener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row_wall_entries, parent, false)); // TODO
    }

    @Override
    public int getItemCount() {
        return myItems.size();
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.setData(myItems.get(position));
    }

    public interface ItemListener {
        void onItemClick(WallEntry item);
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        // TODO - Your view members
        public WallEntry item;
        private TextView name;
        private TextView wallEntryText;
        private TextView likeCount;
        private Button comment;

        @BindView(R.id.row_wall_entries_image)
        ImageView rowWallEntriesImage;
        @BindView(R.id.row_wall_entries_name_text_view)
        TextView rowWallEntriesNameTextView;
        @BindView(R.id.row_wall_entries_content_text_view)
        TextView rowWallEntriesContentTextView;
        @BindView(R.id.row_wall_entries_like_count_text_view)
        TextView rowWallEntriesLikeCountTextView;
        @BindView(R.id.row_wall_entries_like_button)
        ImageView rowWallEntriesLikeButton;
        @BindView(R.id.row_wall_entries_comment_button)
        ImageView rowWallEntriesCommentButton;

        public ViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            ButterKnife.bind(this, itemView);

            // TODO instantiate/assign view members
        }

        public void setData(final WallEntry item) {
            this.item = item;
            rowWallEntriesNameTextView.setText(item.getUser().getName());
            rowWallEntriesLikeCountTextView.setText(String.valueOf(item.getLikecount()));
            rowWallEntriesContentTextView.setText(item.getText());

            rowWallEntriesCommentButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    EventBus.getDefault().postSticky(new WallEntryEvent(item));
                    Utils.changeActivity(activity, CommentListActivity.class);
                }
            });
            if(item.getLiked()){
                rowWallEntriesLikeButton.setImageResource(R.mipmap.action_fill_like);
            }
            rowWallEntriesLikeButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    rowWallEntriesLikeButton.setImageResource(R.mipmap.action_fill_like);

                    dataManager.like(item.getEventId(),item.getId());

                }
            });

            rowWallEntriesImage.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    EventBus.getDefault().postSticky(new ProfileEvents(item.getUser()));
                    Utils.changeActivity(activity, ProfileActivity.class);
                }
            });

            // TODO set data to view
        }

        @Override
        public void onClick(View v) {
            if (myListener != null) {
                myListener.onItemClick(item);
            }
        }
    }


}
                                