package com.anystat.anycipeandroid.UI;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.anystat.anycipeandroid.DataManager;
import com.anystat.anycipeandroid.Network.response.Recipe;
import com.anystat.anycipeandroid.R;

import java.util.ArrayList;
import java.util.List;



public class RecipesFragment extends Fragment implements DataManager.ResponseListener{
    private final String TAG = this.getClass().getSimpleName();
    private RecipesGridAdapter mAdapter;
    private Context mContext;
    private DataManager mDataManager;
    List<Recipe> mData ;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = getActivity().getApplicationContext();
        setHasOptionsMenu(true);
        mDataManager = DataManager.getDataManager(mContext);
        mDataManager.setResponselistener(this);

    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.main, menu);
        MenuItem item = menu.findItem(R.id.action_search);

        SearchView searchView = (SearchView) item.getActionView();

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                if(query != null){
                    mDataManager.findRecipeFromAPI(query);
                }
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });



    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.recipes_fragment_layout, container, false);

        mData = new ArrayList<>();

        RecyclerView mRecyclerView = ((RecyclerView) rootView.findViewById(R.id.recipes_recycler_view));
        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(getActivity(), 2);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mAdapter = new RecipesGridAdapter(mData, new RecipesGridAdapter.RecipeViewHolder.RecipeClickListener() {
            @Override
            public void onRecipeItemClickListener(int position) {
                Toast.makeText(mContext, "Position " + position, Toast.LENGTH_SHORT).show();
                RecipeDetailFragment recipeDetailFragment = new RecipeDetailFragment();
                getFragmentManager().beginTransaction().addToBackStack(null).replace(R.id.fragment_container, recipeDetailFragment).commit();
            }
        });
        mRecyclerView.setAdapter(mAdapter);


        return rootView;
    }



    @Override
    public void response(List<Recipe> response) {
        mAdapter.setData(response);

    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }
}
