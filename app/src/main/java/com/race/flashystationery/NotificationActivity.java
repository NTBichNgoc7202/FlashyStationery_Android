package com.race.flashystationery;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.race.flashystationery.databinding.ActivityNotificationBinding;

public class NotificationActivity extends AppCompatActivity {
    ActivityNotificationBinding binding;

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

//        binding.llOrder.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(NotificationActivity.this, MessageActivity.class);
//                intent.putExtra("position",2);
//                startActivity(intent);
//            }
//        });
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
    }
}