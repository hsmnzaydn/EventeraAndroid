
package com.eventera.hsmnzaydn.eventeraandroid.ui.Adapters;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.eventera.hsmnzaydn.eventeraandroid.R;
import com.eventera.hsmnzaydn.eventeraandroid.data.network.model.Event;
import com.eventera.hsmnzaydn.eventeraandroid.eventbus.EventShare;
import com.eventera.hsmnzaydn.eventeraandroid.ui.WallEntryListActivity.WallEntryListActivity;
import com.eventera.hsmnzaydn.eventeraandroid.utility.Utils;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.List;

public class AttendesListViewAdapter<T> extends BaseAdapter {

    private Activity context;
    private LayoutInflater layoutInflater;

    private List<Event> items = new ArrayList<Event>();

    public AttendesListViewAdapter(Activity context,List<Event> items) {
        this.context = context;
        this.layoutInflater = LayoutInflater.from(context);
        this.items=items;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = layoutInflater.inflate(R.layout.row_attendes, null); // TODO
            convertView.setTag(new ViewHolder(convertView));
        }
        initializeViews(getItem(position), (ViewHolder) convertView.getTag());
        return convertView;
    }

    private void initializeViews(final Event item, ViewHolder holder) {
        holder.titleTextView.setText(item.getEventname());

        //TODO
    }

    @Override
    public Event getItem(int position) {
        return items.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getCount() {
        return items.size();
    }

    protected class ViewHolder {
        TextView titleTextView;
        // TODO FIELDS

        public ViewHolder(View view) {
            titleTextView=view.findViewById(R.id.row_attendes_title_text_view);
            // TODO ASSIGNEMENTS
        }
    }
}
                                