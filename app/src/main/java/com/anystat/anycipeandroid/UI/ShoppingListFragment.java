package com.anystat.anycipeandroid.UI;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.anystat.anycipeandroid.R;
import com.anystat.anycipeandroid.Storage.SListItem;
import com.anystat.anycipeandroid.Storage.ShoppingList;

import java.util.List;

public class ShoppingListFragment extends Fragment{

    int itemPosition;
    List<SListItem> sListItems;
    ShoppingList mShoppingList;

    public ShoppingListFragment() {

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        itemPosition = (int) getArguments().get("position");
        sListItems = ShoppingList.ITEMS.get(itemPosition);


    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_shopping_list, container, false);



        RecyclerView mRecyclerView = ((RecyclerView) rootView.findViewById(R.id.shopping_list_recycler_view));
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        ShoppingListRecyclerViewAdapter mAdapter = new ShoppingListRecyclerViewAdapter();
        return super.onCreateView(inflater, container, savedInstanceState);
    }
}
