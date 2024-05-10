package com.example.mypantry.model;

public class GroceryItem {
    private String groceryName;
    private String groceryQuantity;
    private String grocerySKU;

    public GroceryItem(String groceryName, String groceryQuantity, String grocerySKU) {
        this.groceryName = groceryName;
        this.groceryQuantity = groceryQuantity;
        this.grocerySKU = grocerySKU;
    }

    public String getGroceryName() {
        return groceryName;
    }

    public String getGroceryQuantity() {
        return groceryQuantity;
    }

    public String getGrocerySKU() {
        return grocerySKU;
    }
}
