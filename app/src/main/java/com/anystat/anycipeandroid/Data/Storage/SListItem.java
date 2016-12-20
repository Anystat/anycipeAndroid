package com.anystat.anycipeandroid.Data.Storage;



public class SListItem {

    public int id;
    public String name;
    public String quantity;
    public String unit;
    public boolean checked;

    public SListItem(int id, String name, String quantity, String unit) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.unit = unit;
        this.checked = false;
    }
}
