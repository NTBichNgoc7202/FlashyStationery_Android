package com.race.flashystationery;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.race.flashystationery.databinding.ActivityLoginRegisterBinding;
import com.race.flashystationery.databinding.ActivityLoginRequestBinding;
import com.race.flashystationery.databinding.ActivityOrderPaymentBinding;

public class LoginRequest extends AppCompatActivity {

    ActivityLoginRequestBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_login_request);
        binding = ActivityLoginRequestBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        addEnvent();

    }

    private void addEnvent() {
        binding.btndangky.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginRequest.this, RegisterActivity.class);
                startActivity(intent);
            }
        });
        binding.btndangnhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginRequest.this, LoginActivity.class);
                startActivity(intent);
            }
        });
    }

}