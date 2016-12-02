package com.anystat.anycipeandroid.Data.Storage;


import java.util.ArrayList;
import java.util.List;

public class ShoppingListTestGenerator {

    public List<ShoppingList> mShoppingLists;

    private final int COUNT = 5;

    public List<SListItem> generateItems(int count){
        List<SListItem> listItems = new ArrayList<SListItem>();

        for (int i = 0; i<count; i++){
            listItems.add(new SListItem(i, "Item " + i, "112" ,"шт"));
        }

        return listItems;
    }

    public List<ShoppingList> generateLists(int count){
        List<ShoppingList> lists = new ArrayList<ShoppingList>();
        for(int i = 0; i < count; i++){
            lists.add(new ShoppingList(i, "Список "  + i,generateItems(COUNT+ 1 - i)));
        }
        return lists;
    }

    public ShoppingListTestGenerator() {
        mShoppingLists = generateLists(COUNT);
    }

    public List<ShoppingList> getList(){
        return mShoppingLists;
    }
}
