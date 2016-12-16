package com.anystat.anycipeandroid.UI;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.anystat.anycipeandroid.DataManager;
import com.anystat.anycipeandroid.Network.response.Recipe;
import com.anystat.anycipeandroid.R;


public class RecipeDetailFragment extends Fragment {
    private final String TAG = getClass().getSimpleName();
    DataManager mDataManager;
    Recipe mRecipe;
    int position = 0;

    TextView mViewTitle;
    TextView mViewDescription;
    ImageView mViewImage;

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

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       // Log.d(TAG, "savedInstanceState = " + savedInstanceState.size());
//        if(savedInstanceState!=null){
//            position = savedInstanceState.getInt("position");
//            Log.d(TAG, "savedInstanceState position = " + position);
//        }
        return inflater.inflate(R.layout.recipe_detail_fragment_layout, container, false);

    }

    @Override
    public void onStart() {
        super.onStart();
        mViewTitle = ((TextView) getActivity().findViewById(R.id.recipe_detail_title));
        mViewTitle.setText(mRecipe.receipt);
        mViewDescription = ((TextView) getActivity().findViewById(R.id.recipe_detail_description));
        mViewDescription.setText(mRecipe.description);

    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("position", position);
    }
}
