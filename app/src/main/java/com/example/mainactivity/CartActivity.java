package com.example.mainactivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;

public class CartActivity extends AppCompatActivity {

    ListView cartListView;
    Button checkoutButton;
    ArrayList<String> cartItems;
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        cartListView = findViewById(R.id.cartListView);
        checkoutButton = findViewById(R.id.checkoutButton);

        cartItems = CartManager.getCartItems(CartActivity.this);


        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, cartItems);
        cartListView.setAdapter(adapter);

        checkoutButton.setOnClickListener(v -> {
            Intent intent = new Intent(CartActivity.this, CheckoutActivity.class);
            startActivity(intent);
        });

    }
}
