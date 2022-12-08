package com.race.flashystationery;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.race.flashystationery.databinding.ActivityPolicyListBinding;
import com.race.fragments.AccountFragment;

public class PolicyListActivity extends AppCompatActivity {
    ActivityPolicyListBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_policy);
        binding = ActivityPolicyListBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        getSupportActionBar().setTitle("CHÍNH SÁCH CỦA FLASHY");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        addEvents();
    }

    private void addEvents() {
        binding.txtPrivatePolicy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getSupportActionBar().setTitle("CHÍNH SÁCH BẢO MẬT");
                setContentView(R.layout.policy_private);
            }
        });

        binding.txtShippingPolicy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getSupportActionBar().setTitle("CHÍNH SÁCH GIAO HÀNG");
                setContentView(R.layout.policy_shipping);
            }
        });

        binding.txtExchangePolicy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getSupportActionBar().setTitle("CHÍNH SÁCH ĐỔI TRẢ");
                setContentView(R.layout.policy_exchange);
            }
        });
    }
}