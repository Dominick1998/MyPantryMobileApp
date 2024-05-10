package com.example.mypantry;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.mypantry.model.PantryItem;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;

public class MainActivity extends AppCompatActivity {
    private FloatingActionButton mFAB;
    public PantryAdapterListBasic mAdapter;
    public RecyclerView recyclerView;

    ActivityResultLauncher<Intent> resultLauncher = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            result -> {
                if (result.getResultCode() == Activity.RESULT_OK) {
                    Intent data = result.getData();
                    if (data != null) {
                        String pantryName = data.getStringExtra("pantryName");
                        String pantryQuantity = data.getStringExtra("pantryQuantity");
                        String pantrySKU = data.getStringExtra("pantrySKU");
                        String pantryExpDate = data.getStringExtra("pantryExpDate");
                        String pantryLocation = data.getStringExtra("pantryLocation");
                        String pantryNote = data.getStringExtra("pantryNote");
                        if (pantryName != null && pantryQuantity != null && pantrySKU != null && pantryExpDate != null && pantryLocation != null) {
                            DataHolder.getInstance().getPantryList().add(new PantryItem(pantryName, pantryQuantity, pantrySKU, pantryExpDate, pantryLocation, pantryNote));
                            mAdapter.notifyDataSetChanged();
                        }
                    }
                }
            });

    private void showSortDialog() {
        final BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(MainActivity.this);
        View bottomSheetView = getLayoutInflater().inflate(R.layout.sort_by, null);
        bottomSheetDialog.setContentView(bottomSheetView);
        bottomSheetDialog.show();

        Button nameSortBtn = bottomSheetView.findViewById(R.id.nameSort);
        Button skuSortBtn = bottomSheetView.findViewById(R.id.skuSort);
        Button expDateSortBtn = bottomSheetView.findViewById(R.id.expDateSort);
        Button quantitySortBtn = bottomSheetView.findViewById(R.id.quantitySort);
        Button locationSortBtn = bottomSheetView.findViewById(R.id.locationSort);

        nameSortBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Collections.sort(DataHolder.getInstance().getPantryList(), new Comparator<PantryItem>() {
                    @Override
                    public int compare(PantryItem i1, PantryItem i2) {
                        return i1.getPantryName().compareTo(i2.getPantryName());
                    }
                });
                mAdapter.notifyDataSetChanged();
                bottomSheetDialog.dismiss();
            }
        });

        skuSortBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Collections.sort(DataHolder.getInstance().getPantryList(), new Comparator<PantryItem>() {
                    @Override
                    public int compare(PantryItem i1, PantryItem i2) {
                        return i1.getPantrySKU().compareTo(i2.getPantrySKU());
                    }
                });
                mAdapter.notifyDataSetChanged();
                bottomSheetDialog.dismiss();
            }
        });

        expDateSortBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final SimpleDateFormat format = new SimpleDateFormat("mm/dd/yyyy");
                Collections.sort(DataHolder.getInstance().getPantryList(), new Comparator<PantryItem>() {
                    @Override
                    public int compare(PantryItem i1, PantryItem i2) {
                        try {
                            Date date1 = format.parse(i1.getPantryExpDate());
                            Date date2 = format.parse(i2.getPantryExpDate());
                            if (date1 != null && date2 != null) {
                                return date1.compareTo(date2);
                            }
                        } catch (ParseException e) {
                            e.printStackTrace();
                        }
                        return 0;
                    }
                });
                mAdapter.notifyDataSetChanged();
                bottomSheetDialog.dismiss();
            }
        });

        quantitySortBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Collections.sort(DataHolder.getInstance().getPantryList(), new Comparator<PantryItem>() {
                    @Override
                    public int compare(PantryItem i1, PantryItem i2) {
                        return i1.getPantryQuantity().compareTo(i2.getPantryQuantity());
                    }
                });
                mAdapter.notifyDataSetChanged();
                bottomSheetDialog.dismiss();
            }
        });

        locationSortBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Collections.sort(DataHolder.getInstance().getPantryList(), new Comparator<PantryItem>() {
                    @Override
                    public int compare(PantryItem i1, PantryItem i2) {
                        return i2.getPantryLocation().compareTo(i1.getPantryLocation());
                    }
                });
                mAdapter.notifyDataSetChanged();
                bottomSheetDialog.dismiss();
            }
        });

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mainactivity);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNav);
        bottomNavigationView.setSelectedItemId(R.id.nav_home);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);

        Intent intent = getIntent();
        String pantryName = intent.getStringExtra("GroceryName");
        String pantryQuantity = intent.getStringExtra("pantryQuantity");
        String pantrySKU = intent.getStringExtra("pantrySKU");
        String pantryExpDate = intent.getStringExtra("pantryExpDate");
        String pantryLocation = intent.getStringExtra("pantryLocation");
        String pantryNote = intent.getStringExtra("pantryNote");
        if (pantryName != null && pantryQuantity != null && pantrySKU != null && pantryExpDate != null && pantryLocation != null ) {
            DataHolder.getInstance().getPantryList().add(new PantryItem(pantryName, pantryQuantity, pantrySKU, pantryExpDate, pantryLocation, pantryNote));
        }

        mAdapter = new PantryAdapterListBasic(this, DataHolder.getInstance().getPantryList());

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(mAdapter);

        Button sortBtn = findViewById(R.id.sortBy);
        sortBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {showSortDialog();};
        });

        Intent addPantryIntent = new Intent(MainActivity.this, addPantry.class);
        Intent groceryIntent = new Intent(MainActivity.this, GroceryActivity.class);

        mFAB = findViewById(R.id.addItem);
        mFAB.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                resultLauncher.launch(addPantryIntent);
            }
        });

        bottomNavigationView.setOnNavigationItemSelectedListener(item -> {
            if (item.getItemId() == R.id.nav_home) {

            } else if (item.getItemId() == R.id.nav_grocery) {
                startActivity(groceryIntent);
            }
            return true;
        });
    }
}