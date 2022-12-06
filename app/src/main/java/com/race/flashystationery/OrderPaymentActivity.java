package com.race.flashystationery;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.race.adapters.ItemAdapter;
import com.race.adapters.ItemOrderAdapter;
import com.race.flashystationery.databinding.ActivityOrderPaymentBinding;
import com.race.models.Item;

import java.util.ArrayList;

public class OrderPaymentActivity extends AppCompatActivity {

    ActivityOrderPaymentBinding binding;
    ItemOrderAdapter orderAdapter;
    ArrayList<Item> items;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // setContentView(R.layout.activity_order_payment);
        binding = ActivityOrderPaymentBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        getSupportActionBar().setTitle("Kiểm tra");
        addEvents();
    }

    private void addEvents() {
        binding.llAddressDetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(OrderPaymentActivity.this, AddressListActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onResume() {
        loadItemData();
        super.onResume();
    }

    private void loadItemData() {
        items = new ArrayList<>();
        items.add(new Item(R.drawable.notebook, "1", "Sổ Tay Ghi Chép giấy kraft Nâu Có Dòng Kẻ", "Phân loại: 100 trang, Mẫu: 05", "SALE: kết thúc 31 thg 12 23:59:59", 48000));
        items.add(new Item(R.drawable.notebook4, "2", "Sổ Tay Ghi Chép giấy kraft Nâu Có Dòng Kẻ", "Phân loại: 100 trang, Mẫu: 05", null, 96000));

        orderAdapter =  new ItemOrderAdapter(OrderPaymentActivity.this, R.layout.order_payment_item_list, items);
        binding.lvOrderPaymentItem.setAdapter(orderAdapter);
    }
}