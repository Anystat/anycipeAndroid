package com.anystat.anycipeandroid.UI;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.anystat.anycipeandroid.R;

public class RecipeDetailActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe_detail);
/* It for Landscape. Code for it is very soon */
//        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
//
//            finish();
//            return;
//        }

        if(savedInstanceState == null){
            RecipeDetailFragment recipeDetailFragment = new RecipeDetailFragment();
            recipeDetailFragment.setArguments(getIntent().getExtras());
            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.details_fragment_container, recipeDetailFragment)
                    .commit();
        }
    }
}
