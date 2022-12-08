package com.race.flashystationery;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.race.flashystationery.databinding.ActivityNotificationBinding;
import com.race.flashystationery.databinding.ActivityOrderBinding;
import com.race.fragments.OrderConfirmFragment;
import com.race.fragments.OrderDeliverFragment;
import com.race.fragments.OrderNotReviewFragment;
import com.race.fragments.OrderReviewFragment;
import com.race.fragments.OrderTakingFragment;

public class OrderActivity extends AppCompatActivity {
    ActivityOrderBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_order);
        binding = ActivityOrderBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        getSupportActionBar().setTitle("Đơn hàng");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        addEvents();
    }

    private void addEvents() {
        binding.btnDanhGia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(OrderActivity.this, OrderTrackingActivity.class);
                intent.putExtra("position",3);
                startActivity(intent);
            }
        });
        binding.btnDaNhanDuocHang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(OrderActivity.this, OrderDetailActivity.class);
                intent.putExtra("status","success");
                startActivity(intent);
            }
        });
        binding.btnXemChiTiet1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(OrderActivity.this, OrderDetailActivity.class);
                intent.putExtra("status","taking");
                startActivity(intent);

            }
        });
        binding.btnXemChiTiet2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(OrderActivity.this, OrderDetailActivity.class);
                intent.putExtra("status","confirm");
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                this.finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}