package com.anystat.anycipeandroid;

import android.content.Context;
import android.util.Log;

import com.anystat.anycipeandroid.Network.IRestAPI;
import com.anystat.anycipeandroid.Network.ServiceGenerator;
import com.anystat.anycipeandroid.Network.response.Recipe;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DataManager {

    public static final String TAG_API = "API";
    private IRestAPI mIRestAPI;
    private Context mContext;
    private static DataManager INSTANCE = null;
    private ResponseListener responseListener;

    private DataManager(Context context) {
        //this.responseListener = listener;
        this.mContext = context;
        this.mIRestAPI = ServiceGenerator.createService(IRestAPI.class);
    }


    public static DataManager getDataManager(Context context) {
        if (INSTANCE == null) {
            return new DataManager(context);
        }

        return INSTANCE;
    }

//    } private DataManager(Context context, ResponseListener listener) {
//        this.responseListener = listener;
//        this.mContext = context;
//        this.mIRestAPI = ServiceGenerator.createService(IRestAPI.class);
//    }
//
//
//    public static DataManager getDataManager(Context context, ResponseListener listener){
//        if( INSTANCE == null) {
//            return new DataManager(context, listener);
//        }
//
//        return INSTANCE;
//    }

    private Call<List<Recipe>> getRecipes(){
        return mIRestAPI.getRecipesList();
    }

    private Call<List<Recipe>> findRecipe(String request){
        return mIRestAPI.findRecipe(request);
    }

    public void setResponselistener(ResponseListener listener){
        this.responseListener = listener;
    }

    public void findRecipeFromAPI(String request){
        Log.d(TAG_API, "FIND RECIPE BY ID");
        findRecipe(request).enqueue(recipeCallback());
    }


    public void getRecipesNamesFromAPI(){
        getRecipes().enqueue(recipeCallback());

    }



    private List<Recipe> collectRecipes(Response<List<Recipe>> response){
        List<Recipe> list = new ArrayList<>();
        for(Recipe recipe : response.body()){
            list.add(recipe);
            Log.d(TAG_API, "Added record: "+recipe.receipt);
        }
        return list;
    }

    private Callback<List<Recipe>> recipeCallback(){
        return new Callback<List<Recipe>>() {
            @Override
            public void onResponse(Call<List<Recipe>> call, Response<List<Recipe>> response) {
                if(response.isSuccessful()){

                    responseListener.response(collectRecipes(response));
                }
            }

            @Override
            public void onFailure(Call<List<Recipe>> call, Throwable t) {
                Log.d(TAG_API, "RETROFIT FAILURE " + t.getMessage());
            }
        };
    }


    public interface ResponseListener{
        void response(List<Recipe> response);
    }

}
