package com.race.flashystationery;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class SettingLanguage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting_language);
        getSupportActionBar().setTitle("Cài đặt ngôn ngữ");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}