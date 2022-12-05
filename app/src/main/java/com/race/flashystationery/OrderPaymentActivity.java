package com.race.flashystationery;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.race.adapters.ItemAdapter;
import com.race.flashystationery.databinding.ActivityOrderPaymentBinding;
import com.race.models.Item;

import java.util.ArrayList;

public class OrderPaymentActivity extends AppCompatActivity {

    ActivityOrderPaymentBinding binding;
    ItemAdapter itemAdapter;
    ArrayList<Item> items;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // setContentView(R.layout.activity_order_payment);
        binding = ActivityOrderPaymentBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        getSupportActionBar().setTitle("Kiểm tra");
    }

    @Override
    protected void onResume() {
        loadItemData();
        super.onResume();
    }

    private void loadItemData() {
        
    }
}