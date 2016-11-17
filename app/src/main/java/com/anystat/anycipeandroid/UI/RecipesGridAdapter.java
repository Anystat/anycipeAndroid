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

        public ViewHolder(TextView textView, ImageView imageView) {
            super(textView);
            mTextView = textView;
            mImageView = imageView;

        }
    }


    public RecipesGridAdapter(String[] dataset) {
        mDataset = dataset;
    }

    @Override
    public RecipesGridAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.recipe_view_list_layout, parent, false);

        ViewHolder viewHolder = new ViewHolder((TextView) v.findViewById(R.id.recipe_header), (ImageView) v.findViewById(R.id.recipe_item_image));

        return viewHolder;
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
