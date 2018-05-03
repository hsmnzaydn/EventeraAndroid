
package com.eventera.hsmnzaydn.eventeraandroid.ui.Adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import com.eventera.hsmnzaydn.eventeraandroid.R;
import com.eventera.hsmnzaydn.eventeraandroid.data.network.model.Interesting;

import java.util.ArrayList;
import java.util.List;


public class CategoryListRecyclerViewAdapter extends RecyclerView.Adapter<CategoryListRecyclerViewAdapter.ViewHolder> {

    private List<Interesting> myItems;
    private List<Interesting> selectedItems=new ArrayList<Interesting>();

    public CategoryListRecyclerViewAdapter(List<Interesting> items) {
        myItems = items;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row_category, parent, false)); // TODO
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
        void onItemClick(String item);
    }


    public List<Interesting> getSelectedItems(){
        return selectedItems;
    }
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        // TODO - Your view members
        public Interesting item;
        TextView textView;
        CheckBox checkBox;

        public ViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            textView=itemView.findViewById(R.id.row_category_title);
            checkBox=itemView.findViewById(R.id.row_category_check_box);
            // TODO instantiate/assign view members
        }

        public void setData(final Interesting item) {
            this.item = item;
            // TODO set data to view
            textView.setText(item.getName());
            checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                    if(b){
                        selectedItems.add(item);
                    }
                }
            });
        }

        @Override
        public void onClick(View v) {

        }
    }


}
                                