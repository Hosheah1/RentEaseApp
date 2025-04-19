package com.example.mainactivity;

import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class CheckoutActivity extends AppCompatActivity {

    private TextView orderSummaryTextView;
    private TextView orderDetailsTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout);

        orderSummaryTextView = findViewById(R.id.orderSummaryTextView);
        orderDetailsTextView = findViewById(R.id.orderDetailsTextView);

        CartManager.clearCart(CheckoutActivity.this);

        orderSummaryTextView.setText("Order Confirmation");
        orderDetailsTextView.setText("Your order has been successfully placed.\nWe will contact you within 24 hours.\nThank you!");
    }
}
