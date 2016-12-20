package com.anystat.anycipeandroid.Network;


import com.anystat.anycipeandroid.Network.response.Recipe;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface IRestAPI {

    @GET("receipts")
    Call<List<Recipe>> getRecipesList();

    @GET("receipts/find/{request}")
    Call<List<Recipe>> findRecipe(@Path("request") String request);


}

