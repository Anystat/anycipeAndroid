package com.anystat.anycipeandroid.UI;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;

import com.anystat.anycipeandroid.DataManager;
import com.anystat.anycipeandroid.MainActivity;
import com.anystat.anycipeandroid.Network.response.Recipe;
import com.anystat.anycipeandroid.R;

import java.util.List;



public class RecipesFragment extends Fragment {
    private final String TAG = this.getClass().getSimpleName();
    private RecipesGridAdapter mAdapter;
    private Context mContext;
    private DataManager mDataManager;
    List<Recipe> mDataSet;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = getActivity().getApplicationContext();
        setHasOptionsMenu(true);
        mDataManager = DataManager.getDataManager(mContext);
        Log.d(TAG, "DataManager" + mDataManager.toString());

        //mDataManager.setResponselistener(this);

    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {

        super.onCreateOptionsMenu(menu, inflater);



    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.recipes_fragment_layout, container, false);
        mDataSet = mDataManager.mDataSet;

        Log.d(TAG, "DataManager size: " + mDataManager.mDataSet.size());
        Log.d(TAG, "Dataset size: " + mDataSet.size());
        //mDataSet = new ArrayList<>();

        RecyclerView mRecyclerView = ((RecyclerView) rootView.findViewById(R.id.recipes_recycler_view));
        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(getActivity(), 2);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mAdapter = new RecipesGridAdapter(mDataSet, (MainActivity)getActivity());
//        mAdapter = new RecipesGridAdapter(mDataSet, new RecipesGridAdapter.RecipeViewHolder.RecipeClickListener() {
//            @Override
//            public void onRecipeItemClickListener(int position) {
//                Toast.makeText(mContext, "Position " + position, Toast.LENGTH_SHORT).show();
//                RecipeDetailFragment recipeDetailFragment = new RecipeDetailFragment();
//                getFragmentManager().beginTransaction().addToBackStack(null).replace(R.id.fragment_container, recipeDetailFragment).commit();
//            }
//        });
        mRecyclerView.setAdapter(mAdapter);


        return rootView;
    }





    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }
}
