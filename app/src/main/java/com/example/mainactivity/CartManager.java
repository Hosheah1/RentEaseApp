package com.example.mainactivity;

import android.content.Context;
import android.content.SharedPreferences;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class CartManager {

    private static final String PREF_NAME = "PaintShopPrefs";
    private static final String KEY_CART = "CartItems";

    public static void addToCart(Context context, String item) {
        SharedPreferences prefs = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        Set<String> currentItems = prefs.getStringSet(KEY_CART, new HashSet<>());
        Set<String> updatedItems = new HashSet<>(currentItems);
        updatedItems.add(item);
        prefs.edit().putStringSet(KEY_CART, updatedItems).apply();
    }

    public static ArrayList<String> getCartItems(Context context) {
        SharedPreferences prefs = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        Set<String> savedItems = prefs.getStringSet(KEY_CART, new HashSet<>());
        return new ArrayList<>(savedItems);
    }

    public static void clearCart(Context context) {
        SharedPreferences prefs = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        prefs.edit().remove(KEY_CART).apply();
    }
}
