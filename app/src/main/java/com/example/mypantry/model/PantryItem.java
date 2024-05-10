package com.example.mypantry.model;

public class PantryItem {
    private String pantryName;
    private String pantryQuantity;
    private String pantrySKU;
    private String pantryExpDate;
    private String pantryLocation;
    private String pantryNotes;

    public PantryItem(String pantryName, String pantryQuantity, String pantrySKU, String pantryExpDate, String pantryLocation, String pantryNotes) {
        this.pantryName = pantryName;
        this.pantryQuantity = pantryQuantity;
        this.pantrySKU = pantrySKU;
        this.pantryExpDate = pantryExpDate;
        this.pantryLocation = pantryLocation;
        this.pantryNotes = pantryNotes;
    }

    public String getPantryName() {
        return pantryName;
    }

    public String getPantryQuantity() {
        return pantryQuantity;
    }

    public String getPantrySKU() {
        return pantrySKU;
    }

    public String getPantryExpDate() {
        return pantryExpDate;
    }

    public String getPantryLocation() {
        return pantryLocation;
    }

    public String getPantryNotes() { return pantryNotes; }

}
