package com.example.mypantry;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class addGrocery extends AppCompatActivity {
    private FloatingActionButton mFAB;
    private int value = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_grocery_item);

        Intent groceryIntent = new Intent(addGrocery.this, GroceryActivity.class);

        //close button
        Button closeAdd = findViewById(R.id.close_addGrocery);
        closeAdd.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                startActivity(groceryIntent);
            }
        });


        TextView quantity = findViewById(R.id.itemQuantity);
        quantity.setText(Integer.toString(value));

        //increase quantity
        Button incQuantity = findViewById(R.id.incQuantity);
        incQuantity.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                value += 1;
                quantity.setText(Integer.toString(value));
            }
        });

        //decrease quantity
        Button decQuantity = findViewById(R.id.decQuantity);
        decQuantity.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                value -= 1;
                quantity.setText(Integer.toString(value));
            }
        });

        Button addItem = findViewById(R.id.addGroceryItem);
        addItem.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                EditText itemName = (EditText) findViewById(R.id.itemName);
                String newName = itemName.getText().toString();
                groceryIntent.putExtra("GroceryName", newName);

                TextView itemQuantity = (TextView) findViewById(R.id.itemQuantity);
                String newQuantity = itemQuantity.getText().toString();
                groceryIntent.putExtra("GroceryQuantity", newQuantity);

                EditText itemSKU = (EditText) findViewById(R.id.itemSKU);
                String newSKU = itemSKU.getText().toString();
                groceryIntent.putExtra("GrocerySKU", newSKU);

                setResult(RESULT_OK, groceryIntent);
                finish();
            }
        });
    }
}