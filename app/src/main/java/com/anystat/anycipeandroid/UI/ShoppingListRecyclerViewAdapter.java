package com.anystat.anycipeandroid.UI;


import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;
import com.anystat.anycipeandroid.R;
import com.anystat.anycipeandroid.Storage.SListItem;

import java.util.List;

public class ShoppingListRecyclerViewAdapter extends RecyclerView.Adapter<ShoppingListRecyclerViewAdapter.ShoppingListViewHolder>{

    private List<SListItem> mItems;

    public ShoppingListRecyclerViewAdapter(List<SListItem> mItems) {
        this.mItems = mItems;
    }

    @Override
    public ShoppingListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.shopping_list_recycler_view_item, parent, false);


        return new ShoppingListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ShoppingListViewHolder holder, int position) {

        SListItem sListItem = mItems.get(position);
        holder.mCheckbox.setChecked(sListItem.checked);
        holder.mSlName.setText(sListItem.name);
        holder.mSlQuantity.setText(sListItem.quantity);
        holder.mSlUnits.setText(sListItem.unit);

    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }

    public class ShoppingListViewHolder extends RecyclerView.ViewHolder{

        public CheckBox mCheckbox;
        public TextView mSlName;
        public TextView mSlQuantity;
        public TextView mSlUnits;



        public ShoppingListViewHolder(View v) {
            super(v);
            mCheckbox = ((CheckBox) v.findViewById(R.id.sl_checkbox));
            mSlName = ((TextView) v.findViewById(R.id.sl_name));
            mSlQuantity = ((TextView) v.findViewById(R.id.sl_quantity));
            mSlUnits = ((TextView) v.findViewById(R.id.sl_units));

        }
    }





}
