package com.anystat.anycipeandroid.UI;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.anystat.anycipeandroid.R;
import com.anystat.anycipeandroid.Storage.SListItem;
import com.anystat.anycipeandroid.Storage.ShoppingList;


import java.util.List;


public class BookListsRecyclerViewAdapter extends RecyclerView.Adapter<BookListsRecyclerViewAdapter.ViewHolder> {

    private List<ShoppingList> mValues;
    private ViewHolder.BookListsClickListener mListener;
    //private final OnListFragmentInteractionListener mListener;

    public BookListsRecyclerViewAdapter(List<ShoppingList> items, ViewHolder.BookListsClickListener listener) {
        mValues = items;
        mListener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.booklists_item_layout, parent, false);
        return new ViewHolder(view, mListener);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = mValues.get(position);
        holder.mIdView.setText(mValues.get(position).id);
        holder.mContentView.setText(mValues.get(position).name);

//        holder.mView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if (null != mListener) {
//                    // Notify the active callbacks interface (the activity, if the
//                    // fragment is attached to one) that an item has been selected.
//                    mListener.onListFragmentInteraction(holder.mItem);
//                }
//            }
//        });
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        private BookListsClickListener mListener;
        public final View mView;
        public final TextView mIdView;
        public final TextView mContentView;
        public ShoppingList mItem;

        public ViewHolder(View view, BookListsClickListener clickListener) {
            super(view);
            mView = view;
            mIdView = (TextView) view.findViewById(R.id.id);
            mContentView = (TextView) view.findViewById(R.id.content);
            view.setOnClickListener(this);
        }

        @Override
        public String toString() {
            return super.toString() + " '" + mContentView.getText() + "'";
        }

        @Override
        public void onClick(View view) {

        }

        public  interface BookListsClickListener {
            void bookListsClickListener(int position);
           // void bookListsClickListener(ShoppingList list);

        }
//        public interface BookListsClickListener{
//            void bookListsClickListener(int position);
//        }
    }
}
