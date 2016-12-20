package com.anystat.anycipeandroid.UI;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.anystat.anycipeandroid.Network.response.Recipe;
import com.anystat.anycipeandroid.R;

import java.util.List;

public class RecipesGridAdapter extends RecyclerView.Adapter<RecipesGridAdapter.RecipeViewHolder> {

    private final String TAG = getClass().getSimpleName();
    private List<Recipe> mDataSet;
    private RecipeViewHolder.RecipeClickListener mClickListener;


    public static class RecipeViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        private RecipeClickListener mListener;
        public TextView mTextView;
        public ImageView mImageView;

        public RecipeViewHolder(View v, RecipeClickListener clickListener) {
            super(v);
            mListener = clickListener;
            mTextView = ((TextView) v.findViewById(R.id.recipe_item_header));
            mImageView = ((ImageView) v.findViewById(R.id.recipe_item_img));
            v.setOnClickListener(this);

        }

        @Override
        public void onClick(View view) {
            if(mListener != null){
                mListener.onRecipeItemClickListener(getAdapterPosition());
            }
        }


        public interface RecipeClickListener{
            void onRecipeItemClickListener(int position);
        }
    }



    public RecipesGridAdapter(List<Recipe> dataset, RecipeViewHolder.RecipeClickListener clickListener) {
        this.mClickListener = clickListener;
        this.mDataSet = dataset;
    }

    public void clear(){
        mDataSet.clear();
        notifyDataSetChanged();
    }

    public void setData(List<Recipe> data){
        clear();
        mDataSet = data;
        notifyDataSetChanged();



    }
    @Override
    public RecipeViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recipe_recycler_view_item_layout, parent, false);
        return new RecipeViewHolder(v, mClickListener);
    }

    @Override
    public void onBindViewHolder(RecipeViewHolder holder, int position) {
        Recipe recipe = mDataSet.get(position);
        holder.mTextView.setText(recipe.receipt);
        holder.mImageView.setImageResource(R.drawable.test);
    }

    @Override
    public int getItemCount() {
       return mDataSet.size();
    }




}
