package com.example.mainactivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private EditText searchEditText;
    private RadioGroup RadioGroup;
    private CheckBox deliveryCheckbox;
    private Switch notifySwitch;
    private Button searchButton, cartButton;
    private ListView itemsListView;

    private ArrayList<String> items;
    private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        searchEditText = findViewById(R.id.searchEditText);
        RadioGroup = findViewById(R.id.durationRadioGroup);
        deliveryCheckbox = findViewById(R.id.deliveryCheckbox);
        notifySwitch = findViewById(R.id.notifySwitch);
        searchButton = findViewById(R.id.searchButton);
        cartButton = findViewById(R.id.cartButton);
        itemsListView = findViewById(R.id.itemsListView);

        items = new ArrayList<>();
        items.add("White paint");
        items.add("Gray paint");
        items.add("Red paint");
        items.add("Light blue paint");
        items.add("Dark pink paint");

        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, items);
        itemsListView.setAdapter(adapter);

        searchButton.setOnClickListener(view -> {
            String searchText = searchEditText.getText().toString().trim();
            ArrayList<String> filteredList = new ArrayList<>();

            for (String item : items) {
                if (item.toLowerCase().contains(searchText.toLowerCase())) {
                    filteredList.add(item);
                }
            }

            if (filteredList.isEmpty()) {
                Toast.makeText(MainActivity.this, "No matching results", Toast.LENGTH_SHORT).show();
            }

            adapter = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_list_item_1, filteredList);
            itemsListView.setAdapter(adapter);
        });

        itemsListView.setOnItemClickListener((parent, view, position, id) -> {
            String selectedItem = adapter.getItem(position);
            CartManager.addToCart(MainActivity.this, selectedItem);
            Toast.makeText(MainActivity.this, "Added to cart", Toast.LENGTH_SHORT).show();
        });

        cartButton.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, CartActivity.class);
            startActivity(intent);
        });
    }
}
