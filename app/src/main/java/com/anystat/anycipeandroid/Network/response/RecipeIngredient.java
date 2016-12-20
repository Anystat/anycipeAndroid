package com.anystat.anycipeandroid.Network.response;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RecipeIngredient {
    @SerializedName("name")
    @Expose
    public String name;

}
