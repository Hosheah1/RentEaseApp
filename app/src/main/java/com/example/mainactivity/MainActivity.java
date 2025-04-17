package com.example.mainactivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Spinner categorySpinner;
    EditText searchEditText;
    RadioGroup durationRadioGroup;
    CheckBox deliveryCheckbox, cleaningCheckbox;
    Switch notifySwitch;
    Button searchButton;
    ListView itemsListView;

    ArrayList<String> items;
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        categorySpinner = findViewById(R.id.categorySpinner);
        searchEditText = findViewById(R.id.searchEditText);
        durationRadioGroup = findViewById(R.id.durationRadioGroup);
        deliveryCheckbox = findViewById(R.id.deliveryCheckbox);
        cleaningCheckbox = findViewById(R.id.cleaningCheckbox);
        notifySwitch = findViewById(R.id.notifySwitch);
        searchButton = findViewById(R.id.searchButton);
        itemsListView = findViewById(R.id.itemsListView);

        String[] categories = {"كهربائيات", "أدوات بناء", "أدوات تنظيف"};
        ArrayAdapter<String> spinnerAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, categories);
        categorySpinner.setAdapter(spinnerAdapter);

        items = new ArrayList<>();
        items.add("مكنسة كهربائية - متوفرة");
        items.add("مثقاب كهربائي - متوفر");
        items.add("مروحة عمودية - غير متوفرة");
        items.add("atm");

        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, items);
        itemsListView.setAdapter(adapter);

        searchButton.setOnClickListener(v -> {
            String searchText = searchEditText.getText().toString().trim();
            ArrayList<String> filtered = new ArrayList<>();
            for (String item : items) {
                if (item.contains(searchText)) {
                    filtered.add(item);
                }
            }
            adapter = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_list_item_1, filtered);
            itemsListView.setAdapter(adapter);
        });

        itemsListView.setOnItemClickListener((parent, view, position, id) -> {
            String selectedItem = adapter.getItem(position);
            CartManager.addToCart(MainActivity.this, selectedItem);
            Toast.makeText(MainActivity.this, "تمت إضافة العنصر إلى السلة", Toast.LENGTH_SHORT).show();
        });

        Button cartButton = findViewById(R.id.cartButton);
        cartButton.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, CartActivity.class);
            startActivity(intent);
        });


    }
}
