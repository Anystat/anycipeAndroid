package com.anystat.anycipeandroid.UI;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.anystat.anycipeandroid.DataManager;
import com.anystat.anycipeandroid.Network.response.Recipe;
import com.anystat.anycipeandroid.Network.response.RecipeIngredient;
import com.anystat.anycipeandroid.R;

import java.util.ArrayList;


public class RecipeDetailFragment extends Fragment {
    private final String TAG = getClass().getSimpleName();
    DataManager mDataManager;
    Recipe mRecipe;
    int position = 0;
    Context mContext;

    TextView mViewTitle;
    TextView mViewDescription, mViewInstruction;
    ImageView mViewImage;
    ListView mListView;

   public static RecipeDetailFragment newInstance(int position){
       RecipeDetailFragment recipeDetailFragment = new RecipeDetailFragment();

       Bundle args = new Bundle();
       args.putInt("position", position);
       recipeDetailFragment.setArguments(args);

       return recipeDetailFragment;
   }

    public int getShownPosition(){
        return getArguments().getInt("position", 0);
    }



    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mDataManager = DataManager.getDataManager(getContext());
        position = getShownPosition();
        mRecipe = mDataManager.mDataSet.get(position);
        mContext = getContext();

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        return inflater.inflate(R.layout.recipe_detail_fragment_layout, container, false);

    }

    @Override
    public void onStart() {
        super.onStart();
        mViewTitle = ((TextView) getActivity().findViewById(R.id.recipe_detail_title));
        mViewTitle.setText(mRecipe.receipt);
        mViewDescription = new TextView(mContext);
        mViewDescription.setText(mRecipe.description);
        mViewInstruction = new TextView(mContext);
        mViewInstruction.setText(mRecipe.instruction);

        mListView = (ListView) getActivity().findViewById(R.id.recipe_detail_ingredients_list_view);
        ArrayList<String> list = new ArrayList<>();;

        mListView.addHeaderView(mViewDescription);
        mListView.addFooterView(mViewInstruction);

        if(mRecipe.ingredients != null) {
            ArrayList<RecipeIngredient> arrayList = (ArrayList<RecipeIngredient>) mRecipe.ingredients;
            for (RecipeIngredient ingredient : arrayList) {
                String name = ingredient.name;
                Log.d(TAG, "Ingredient name = " + name);
                list.add(name);
            }
        }

       String[] data =  list.toArray(new String[0]);
        Log.d(TAG, "Data = " + data.length);
       ArrayAdapter<String> adapter = new ArrayAdapter<>(getContext(), R.layout.recipe_detail_ingredient_item_layout,R.id.ingredient_name_text_view, data);
       mListView.setAdapter(adapter);







    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("position", position);
    }
}
