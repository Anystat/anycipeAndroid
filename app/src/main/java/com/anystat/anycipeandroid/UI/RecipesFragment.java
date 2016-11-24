package com.anystat.anycipeandroid.UI;

import android.support.v4.app.Fragment;;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.anystat.anycipeandroid.R;

public class RecipesFragment extends Fragment{
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private Context mContext;

    String[] mTestData = {"Мясо", "Колбасы", "Консервы", "Салат", "Сникерсы", "Баунти", "Марсы", "Жареный арахис"};
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = getActivity().getApplicationContext();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.recipes_fragment_layout, container, false);

        RecyclerView mRecyclerView = ((RecyclerView) rootView.findViewById(R.id.recipes_recycler_view));
        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(getActivity(), 2);


        mRecyclerView.setLayoutManager(mLayoutManager);
        RecipesGridAdapter adapter = new RecipesGridAdapter(mTestData, new RecipesGridAdapter.RecipeViewHolder.RecipeClickListener() {
            @Override
            public void onRecipeItemClickListener(int position) {
                Toast.makeText(mContext, "Postion " + position, Toast.LENGTH_SHORT).show();
                getFragmentManager().beginTransaction().addToBackStack(null).replace(R.id.fragment_container, new RecipeDetailFragment()).commit();
            }
        });
        mRecyclerView.setAdapter(adapter);


        return rootView;
    }
}
