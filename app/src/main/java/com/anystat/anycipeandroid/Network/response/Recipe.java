package com.anystat.anycipeandroid.Network.response;


import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Recipe implements Parcelable{

    @SerializedName("_id")
    @Expose
    public RecipeId id;
    @SerializedName("receipt")
    @Expose
    public String receipt;
    @SerializedName("link")
    @Expose
    public String link;
    @SerializedName("ingredients")
    @Expose
    public List<RecipeIngredient> ingredients = null;
    @SerializedName("description")
    @Expose
    public String description;
    @SerializedName("instruction")
    @Expose
    public String instruction;

    protected Recipe(Parcel in) {
        receipt = in.readString();
        link = in.readString();
        description = in.readString();
        instruction = in.readString();
    }

    public static final Creator<Recipe> CREATOR = new Creator<Recipe>() {
        @Override
        public Recipe createFromParcel(Parcel in) {
            return new Recipe(in);
        }

        @Override
        public Recipe[] newArray(int size) {
            return new Recipe[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(receipt);
        parcel.writeString(link);
        parcel.writeString(description);
        parcel.writeString(instruction);
    }
}
