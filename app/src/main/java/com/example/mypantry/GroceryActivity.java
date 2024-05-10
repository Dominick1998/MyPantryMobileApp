package com.example.mypantry;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mypantry.model.GroceryItem;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class GroceryActivity extends AppCompatActivity {

    private FloatingActionButton mFAB;
    public GroceryAdapterListBasic mAdapter;
    public RecyclerView recyclerView;


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 1 && resultCode == RESULT_OK) {
            String groceryName = data.getStringExtra("GroceryName");
            String groceryQuantity = data.getStringExtra("GroceryQuantity");
            String grocerySKU = data.getStringExtra("GrocerySKU");
            if (groceryName != null && groceryQuantity != null && grocerySKU != null) {
                DataHolder.getInstance().getGroceryList().add(new GroceryItem(groceryName, groceryQuantity, grocerySKU));
                mAdapter.notifyDataSetChanged();
            }
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.grocery_main);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNav);
        bottomNavigationView.setSelectedItemId(R.id.nav_grocery);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);

        Intent intent = getIntent();
        String groceryName = intent.getStringExtra("GroceryName");
        String groceryQuantity = intent.getStringExtra("GroceryQuantity");
        String grocerySKU = intent.getStringExtra("GrocerySKU");
        if (groceryName != null && groceryQuantity != null && grocerySKU != null) {
            DataHolder.getInstance().getGroceryList().add(new GroceryItem(groceryName, groceryQuantity, grocerySKU));
        }

        mAdapter = new GroceryAdapterListBasic(this, DataHolder.getInstance().getGroceryList());

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(mAdapter);


        Intent addGroceryIntent = new Intent(GroceryActivity.this, addGrocery.class);
        Intent mainIntent = new Intent(GroceryActivity.this, MainActivity.class);

        mFAB = findViewById(R.id.addGroceryItem);
        mFAB.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                startActivityForResult(addGroceryIntent, 1);
            }
        });

        bottomNavigationView.setOnNavigationItemSelectedListener(item -> {
            if (item.getItemId() == R.id.nav_home) {
                startActivity(mainIntent);
            } else if (item.getItemId() == R.id.nav_grocery) {

            }
            return true;
        });

    }
}