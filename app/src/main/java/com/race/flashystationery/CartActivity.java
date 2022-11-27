package com.race.flashystationery;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.race.adapters.ItemAdapter;
import com.race.flashystationery.databinding.ActivityCartBinding;
import com.race.models.Item;

import java.util.ArrayList;

public class CartActivity extends AppCompatActivity {
    ActivityCartBinding binding;
    ArrayList<Item> items;
    ItemAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       //setContentView(R.layout.activity_cart);
        binding = ActivityCartBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        loadData();
    }

    private void loadData() {
        items = new ArrayList<>();
        items.add(new Item(R.drawable.notebook, "1", "Sổ Tay Ghi Chép giấy kraft Nâu Có Dòng Kẻ", "Phân loại: 100 trang, Mẫu: 05", "Kết thúc 31 thg 12 23:59:59", "48.000 đ"));
        items.add(new Item(R.drawable.notebook, "2", "Sổ Tay Ghi Chép giấy kraft Nâu Có Dòng Kẻ", "Phân loại: 100 trang, Mẫu: 05", "Kết thúc 31 thg 12 23:59:59", "48.000 đ"));

        adapter = new ItemAdapter(CartActivity.this, R.layout.cart_item_list, items);
        binding.lvItem.setAdapter(adapter);
    }
}