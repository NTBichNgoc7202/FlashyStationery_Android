package com.race.flashystationery;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.race.flashystationery.databinding.ActivityNotificationBinding;

public class NotificationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_notification);
        binding = ActivityNotificationBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        getSupportActionBar().setTitle("Thông báo");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        addEvents();
    }

    private void addEvents() {
        binding.llMessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(NotificationActivity.this, MessageActivity.class ));
            }
        });

        binding.llOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(NotificationActivity.this, OrderActivity.class ));
            }
        });

        binding.llPromotion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(NotificationActivity.this, PromotionActivity.class ));
            }
        });

        binding.llAnnouncement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(NotificationActivity.this, AnnouncementActivity.class ));
            }
        });
        binding.llUpdate1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //startActivity(new Intent(NotificationActivity.this, OrderTrackingActivity.class ));
                Intent intent = new Intent(NotificationActivity.this, OrderTrackingActivity.class);
                intent.putExtra("position",3);
                startActivity(intent);
            }
        });
        binding.llUpdate2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //startActivity(new Intent(NotificationActivity.this, OrderTrackingActivity.class ));
                Intent intent = new Intent(NotificationActivity.this, OrderTrackingActivity.class);
                intent.putExtra("position",2);
                startActivity(intent);
            }
        });
        binding.llUpdate3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //startActivity(new Intent(NotificationActivity.this, OrderTrackingActivity.class ));
                Intent intent = new Intent(NotificationActivity.this, OrderTrackingActivity.class);
                intent.putExtra("position",1);
                startActivity(intent);
            }
        });
        binding.llUpdate4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(NotificationActivity.this, OrderTrackingActivity.class ));
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