package com.example.mypantry;

import com.example.mypantry.model.GroceryItem;
import com.example.mypantry.model.PantryItem;

import java.util.ArrayList;
import java.util.List;

public class DataHolder {
    private static final DataHolder ourInstance = new DataHolder();

    private List<PantryItem> PantryList = new ArrayList<>();
    private List<GroceryItem> GroceryList = new ArrayList<>();

    public static DataHolder getInstance() {
        return ourInstance;
    }

    private DataHolder(){

    }

    public List<PantryItem> getPantryList(){
        return PantryList;
    }


    public List<GroceryItem> getGroceryList(){
        return GroceryList;
    }

}
