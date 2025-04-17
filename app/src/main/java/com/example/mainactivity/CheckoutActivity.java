package com.example.mainactivity;

import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class CheckoutActivity extends AppCompatActivity {

    TextView orderSummaryTextView, orderDetailsTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout);

        CartManager.clearCart(CheckoutActivity.this);

        orderSummaryTextView = findViewById(R.id.orderSummaryTextView);
        orderDetailsTextView = findViewById(R.id.orderDetailsTextView);

        orderDetailsTextView.setText("تم تأكيد الطلب بنجاح!\nسيتم التواصل معك قريبًا.");
    }
}
