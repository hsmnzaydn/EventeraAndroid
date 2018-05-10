
package com.eventera.hsmnzaydn.eventeraandroid.ui.Adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.eventera.hsmnzaydn.eventeraandroid.R;
import com.eventera.hsmnzaydn.eventeraandroid.data.network.model.Event;
import com.eventera.hsmnzaydn.eventeraandroid.utility.Utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;


public class EventListRecyclerviewAdapter extends RecyclerView.Adapter<EventListRecyclerviewAdapter.ViewHolder> {

    private List<Event> myItems;
    private ItemListener myListener;

    public EventListRecyclerviewAdapter(List<Event> items, ItemListener listener) {
        myItems = items;
        myListener = listener;
    }

    public void setListener(ItemListener listener) {
        myListener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row_event, parent, false)); // TODO
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
        void onItemClick(Event item);
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        // TODO - Your view members
        public Event item;
         TextView title;
         TextView category;


        public ViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            title=itemView.findViewById(R.id.row_event_title_text_view);
            category=itemView.findViewById(R.id.row_event_category_name);
            // TODO instantiate/assign view members
        }

        public void setData(Event item) {
            this.item = item;
            title.setText(item.getEventname());
            category.setText(item.getEventcategoryname());
            // TODO set data to view
        }

        @Override
        public void onClick(View v) {
            if (myListener != null) {
                myListener.onItemClick(item);
            }
        }
    }

    public void setFilter(ArrayList<Event> newList){

        myItems=new ArrayList<>();
        myItems.addAll(newList);
        notifyDataSetChanged();
    }


    private static long parseDate(String text)
            throws ParseException
    {
        SimpleDateFormat dateFormat = new SimpleDateFormat("hh:mm a MM/dd/yyyy",
                Locale.getDefault());
        dateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        return dateFormat.parse(text).getTime();
    }
}
                                