package com.example.mypantry;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;

public class addPantry extends AppCompatActivity {
    private int value = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_pantry_item);

        Intent pantryIntent = new Intent(addPantry.this, MainActivity.class);

        //close button
        Button closeAdd = findViewById(R.id.close_addPantry);
        closeAdd.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                setResult(RESULT_CANCELED);
                finish();
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

        Button addItem = findViewById(R.id.addPantryItem);
        addItem.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                EditText itemName = (EditText) findViewById(R.id.itemName);
                String newName = itemName.getText().toString();
                pantryIntent.putExtra("pantryName", newName);

                TextView itemQuantity = (TextView) findViewById(R.id.itemQuantity);
                String newQuantity = itemQuantity.getText().toString();
                pantryIntent.putExtra("pantryQuantity", newQuantity);

                TextView itemSKU = (TextView) findViewById(R.id.itemSKU);
                String newSKU = itemSKU.getText().toString();
                pantryIntent.putExtra("pantrySKU", newSKU);

                EditText itemExpDate = (EditText) findViewById(R.id.itemExpDate);
                String newExpDate = itemExpDate.getText().toString();
                pantryIntent.putExtra("pantryExpDate", newExpDate);

                RadioGroup pantryLoc = (RadioGroup) findViewById(R.id.itemLoc);
                int newLoc = pantryLoc.getCheckedRadioButtonId();
                String pantry = "Pantry";
                String fridge = "Fridge";
                String freezer = "Freezer";
                if (newLoc == 2131231064) {
                    pantryIntent.putExtra("pantryLocation", pantry);
                } else if (newLoc == 2131230922) {
                    pantryIntent.putExtra("pantryLocation", fridge);
                } else {
                    pantryIntent.putExtra("pantryLocation", freezer);
                }

                EditText itemNotes = (EditText) findViewById(R.id.itemNotes);
                String newNote = itemNotes.getText().toString();
                pantryIntent.putExtra("pantryNote", newNote);

                setResult(RESULT_OK, pantryIntent);
                finish();
            }
        });
    }
}