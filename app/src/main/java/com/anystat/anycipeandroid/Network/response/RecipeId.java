package com.anystat.anycipeandroid.Network.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RecipeId  {

    @SerializedName("timestamp")
    @Expose
    public double timestamp;
    @SerializedName("machineIdentifier")
    @Expose
    public int machineIdentifier;
    @SerializedName("processIdentifier")
    @Expose
    public int processIdentifier;
    @SerializedName("counter")
    @Expose
    public int counter;
    @SerializedName("time")
    @Expose
    public double time;
    @SerializedName("date")
    @Expose
    public double date;
    @SerializedName("timeSecond")
    @Expose
    public double timeSecond;
}
