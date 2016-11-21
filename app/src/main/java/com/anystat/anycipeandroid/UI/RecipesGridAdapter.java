package com.anystat.anycipeandroid.UI;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.anystat.anycipeandroid.R;

public class RecipesGridAdapter extends RecyclerView.Adapter<RecipesGridAdapter.ViewHolder> {
    private String[] mDataset;

    public static class ViewHolder extends RecyclerView.ViewHolder{

        public TextView mTextView;
        public ImageView mImageView;

        public ViewHolder(View v) {
            super(v);
            mTextView = ((TextView) v.findViewById(R.id.recipe_item_header));
            mImageView = ((ImageView) v.findViewById(R.id.recipe_item_img));

        }
    }


    public RecipesGridAdapter(String[] dataset) {
        this.mDataset = dataset;
    }

    @Override
    public RecipesGridAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.recipe_recycler_view_item_relative, parent, false);



        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(RecipesGridAdapter.ViewHolder holder, int position) {
        holder.mTextView.setText(mDataset[position]);
        holder.mImageView.setImageResource(R.drawable.test);
    }

    @Override
    public int getItemCount() {
        return mDataset.length;
    }
}
