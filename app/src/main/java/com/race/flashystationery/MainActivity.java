package com.race.flashystationery;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import com.race.flashystationery.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    SharedPreferences preferences = null;
    Fragment fragmentHome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        preferences = getSharedPreferences("com.race.myAppName",MODE_PRIVATE);



        //preferences.edit().putBoolean("firstrun", true).commit();

    }

    @Override
    protected void onResume() {
        super.onResume();

        if (preferences.getBoolean("firstrun", true)){
            Intent intent = new Intent(MainActivity.this, OnboardingActivity.class);
            startActivity(intent);
            preferences.edit().putBoolean("firstrun", false).commit();
        }
    }
}