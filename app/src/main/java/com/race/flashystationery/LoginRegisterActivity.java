package com.race.flashystationery;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class LoginRegisterActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_register);
        //Set the title
        getSupportActionBar().setTitle("FLASHY STATIONERY");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        //Open Login Activity
        Button btnSignIn = findViewById(R.id.btn_Login);
        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginRegisterActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });
        //Open Register Activity
        Button btnSiggUp = findViewById(R.id.btn_Register);
        btnSiggUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginRegisterActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });
        //Close LoginRegister Page and go to Home Page
        TextView txtPass = findViewById(R.id.txt_Pass);
        txtPass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginRegisterActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

//
//
//        binding = ActivityLoginRegisterBinding.inflate(getLayoutInflater());
//        setContentView(binding.getRoot());
//
//        ActionBar actionBar = getSupportActionBar();
//        actionBar.hide();
//
//        binding.btnLogin.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                startActivity(new Intent(LoginRegisterActivity.this, LoginActivity.class));
//
//            }
//        });
//
//        binding.btnRegister.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                startActivity(new Intent(LoginRegisterActivity.this, RegisterActivity.class));
//
//            }
//        });
//
//        binding.txtPass.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                startActivity(new Intent(LoginRegisterActivity.this,MainActivity.class));
//            }
//        });
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