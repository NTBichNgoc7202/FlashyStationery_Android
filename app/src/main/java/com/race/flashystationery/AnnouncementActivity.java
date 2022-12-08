package com.race.flashystationery;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.race.flashystationery.databinding.ActivityAnnouncementBinding;
import com.race.flashystationery.databinding.FragmentOrderReviewBinding;
import com.race.fragments.CartFragment;
import com.race.fragments.HomeFragment;
import com.race.fragments.OrderConfirmFragment;

public class AnnouncementActivity extends AppCompatActivity {
    ActivityAnnouncementBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_announcement);
        binding = ActivityAnnouncementBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        getSupportActionBar().setTitle("Thông báo tin mới");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        addEvents();
    }

    private void addEvents() {
        binding.btnXemChiTietSPSHH.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(AnnouncementActivity.this, CartActivity.class));
            }
        });
        binding.btnXemChiTietSPTrongGH.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(AnnouncementActivity.this, CartActivity.class));
            }
        });
        binding.btnXemChiTietDanhGiaSP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //startActivity(new Intent(AnnouncementActivity.this, OrderTrackingActivity.class));
                Intent intent = new Intent(AnnouncementActivity.this, OrderTrackingActivity.class);
                intent.putExtra("position",3);
                startActivity(intent);
            }
        });
        binding.btnXemChiTietGoiYSP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(AnnouncementActivity.this, MainActivity.class));
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