
package com.eventera.hsmnzaydn.eventeraandroid.ui.Adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.eventera.hsmnzaydn.eventeraandroid.R;
import com.eventera.hsmnzaydn.eventeraandroid.data.network.model.WallEntry;

import java.util.List;


public class WallEntryListRecyclerViewAdapter extends RecyclerView.Adapter<WallEntryListRecyclerViewAdapter.ViewHolder> {

    private List<WallEntry> myItems;
    private ItemListener myListener;

    public WallEntryListRecyclerViewAdapter(List<WallEntry> items, ItemListener listener) {
        myItems = items;
        myListener = listener;
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


        public ViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            name=itemView.findViewById(R.id.row_wall_entries_name_text_view);
            wallEntryText=itemView.findViewById(R.id.row_wall_entries_content_text_view);
            likeCount=itemView.findViewById(R.id.row_wall_entries_like_count_text_view);
            // TODO instantiate/assign view members
        }

        public void setData(WallEntry item) {
            this.item = item;
            name.setText(item.getPostedby().getName());
            wallEntryText.setText(item.getText());
            likeCount.setText(String.valueOf(item.getLikecount()));
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
                                