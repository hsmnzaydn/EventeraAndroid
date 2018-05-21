package com.eventera.hsmnzaydn.eventeraandroid.ui.Adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.eventera.hsmnzaydn.eventeraandroid.R;
import com.eventera.hsmnzaydn.eventeraandroid.data.network.model.Comment;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


public class CommentListRecyclerViewAdapter extends RecyclerView.Adapter<CommentListRecyclerViewAdapter.ViewHolder> {


    private List<Comment> myItems;
    private ItemListener myListener;

    public CommentListRecyclerViewAdapter(List<Comment> items, ItemListener listener) {
        myItems = items;
        myListener = listener;
    }

    public void setListener(ItemListener listener) {
        myListener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row_comment, parent, false)); // TODO
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
        void onItemClick(Comment item);
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        @BindView(R.id.row_wall_entries_image)
        ImageView rowWallEntriesImage;
        @BindView(R.id.row_comment_name_text_view)
        TextView rowCommentNameTextView;
        @BindView(R.id.row_comment_content_text_view)
        TextView rowCommentContentTextView;

        // TODO - Your view members
        public Comment item;

        public ViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            ButterKnife.bind(this, itemView);

        }

        public void setData(Comment item) {
            this.item = item;
            rowCommentNameTextView.setText(item.getUser().getName().toString());
            rowCommentContentTextView.setText(item.getText());
        }

        @Override
        public void onClick(View v) {
            if (myListener != null) {
                myListener.onItemClick(item);
            }
        }
    }


}
                                