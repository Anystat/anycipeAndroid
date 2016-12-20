package com.anystat.anycipeandroid.Data.Storage;

import java.util.List;

public class ShoppingList {

    public int id;
    public String name;
    public List<SListItem> mListItems;

    public ShoppingList(int id, String name, List<SListItem> listItems) {
        this.id = id;
        this.name = name;
        mListItems = listItems;
    }

    public void addItem(SListItem sListItem){
        mListItems.add(sListItem);
    }
}
