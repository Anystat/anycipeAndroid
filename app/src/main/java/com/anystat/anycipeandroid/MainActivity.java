package com.anystat.anycipeandroid;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.anystat.anycipeandroid.UI.RecipeDetailActivity;
import com.anystat.anycipeandroid.UI.RecipesFragment;
import com.anystat.anycipeandroid.UI.RecipesGridAdapter;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, DataManager.ResponseListener, RecipesGridAdapter.RecipeViewHolder.RecipeClickListener{

     //RecipesFragment mRecipesFragment;
     DataManager mDataManager;
    private final String TAG = getClass().getSimpleName();
    //private ProgressBar mProgressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        //mProgressBar = (ProgressBar) findViewById(R.id.recipe_load_progress);
        setSupportActionBar(toolbar);
        mDataManager = DataManager.getDataManager(this);
        mDataManager.setResponselistener(this);
        Log.d(TAG, "DataManager" + mDataManager.toString());
//        mRecipesFragment = new RecipesFragment();
//
//
//
//
//        getSupportFragmentManager().beginTransaction().add(R.id.fragment_container,mRecipesFragment).commit();


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);



    }



    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        MenuItem item = menu.findItem(R.id.action_search);

        SearchView searchView = (SearchView) item.getActionView();

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                if(query != null){
                    mDataManager.findRecipeFromAPI(query);
                    //mProgressBar.setVisibility(View.VISIBLE);
                }
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                if(newText.length() >= 2){

                    mDataManager.findRecipeFromAPI(newText);
                    //mProgressBar.setVisibility(View.VISIBLE);
                }
                return true;
            }
        });
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }


        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_recipes) {

        } else if (id == R.id.nav_shopping_list) {

        } else if (id == R.id.nav_favorite_recipes) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


    @Override
    public void response(boolean success, String error) {
       // mProgressBar.setVisibility(View.INVISIBLE);
        if(success){
            Log.d(TAG, "Response reached");
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new RecipesFragment()).setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN).commit();
        }else {
            Log.e(TAG, "Error: " + error);
        }
    }

    @Override
    public void onRecipeItemClickListener(int position) {
//        Log.d(TAG, "Callback from recyclerView. Position: " + position);
//        Bundle bundle = new Bundle();
//        bundle.putInt("position", position);
//        RecipeDetailFragment recipeDetailFragment = new RecipeDetailFragment();
//        Log.d(TAG, "Callback from recyclerView. bundle: " + bundle.size());
//        recipeDetailFragment.setArguments(bundle);
//        getSupportFragmentManager()
//                .beginTransaction()
//                .replace(R.id.fragment_container,recipeDetailFragment)
//                .addToBackStack(null)
//                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
//                .commit();
        Intent intent = new Intent();
        intent.setClass(this, RecipeDetailActivity.class);
        intent.putExtra("position", position);
        startActivity(intent);
    }
}
