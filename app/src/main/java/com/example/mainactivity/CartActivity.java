package com.example.mainactivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;

public class CartActivity extends AppCompatActivity {

    private ListView cartListView;
    private Button checkoutButton;
    private ArrayList<String> cartItems;
    private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        cartListView = findViewById(R.id.cartListView);
        checkoutButton = findViewById(R.id.checkoutButton);

        cartItems = CartManager.getCartItems(CartActivity.this);

        if (cartItems.isEmpty()) {
            Toast.makeText(CartActivity.this, "Cart is currently empty", Toast.LENGTH_SHORT).show();
        }

        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, cartItems);
        cartListView.setAdapter(adapter);

        checkoutButton.setOnClickListener(view -> {
            if (!cartItems.isEmpty()) {
                Intent intent = new Intent(CartActivity.this, CheckoutActivity.class);
                startActivity(intent);
            } else {
                Toast.makeText(CartActivity.this, "No items to checkout", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
