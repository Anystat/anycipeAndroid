package com.anystat.anycipeandroid.UI;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.anystat.anycipeandroid.R;

public class RecipesFragment extends Fragment{
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private Context mContext;

    String[] mTestData = {"11231231", "3213543543", "4123123123", "53452435234", "gfdsgdfgfdg", "23412342", "12341234", "123412fds", "f234rf34f"};

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = getActivity().getApplicationContext();
        Log.e("FRAGMENT", "Context is null =  " + (mContext == null));
        mRecyclerView = ((RecyclerView) getActivity().findViewById(R.id.recipes_recycler_view));
        //mRecyclerView.setHasFixedSize(true);
       // mLayoutManager = new GridLayoutManager(mContext, 2);

            mLayoutManager = new LinearLayoutManager(mContext);





        mRecyclerView.setLayoutManager(mLayoutManager);

//        mAdapter = new RecipesGridAdapter(mTestData);
//        mRecyclerView.setAdapter(mAdapter);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.recipes_fragment_layout, container, false);
    }
}
