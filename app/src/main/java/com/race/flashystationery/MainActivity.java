package com.race.flashystationery;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.race.flashystationery.databinding.ActivityMainBinding;
import com.race.fragments.AccountFragment;
import com.race.fragments.CartFragment;
import com.race.fragments.PostFragment;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    SharedPreferences preferences = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        replaceFragment(new com.race.fragment.HomeFragment());

        preferences = getSharedPreferences("com.race.myAppName",MODE_PRIVATE);

        fragmentNavigation();

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

    private void fragmentNavigation() {
        binding.bottomnavigationView.setOnItemSelectedListener(item -> {
            switch (item.getItemId()){
                case R.id.home:
                    replaceFragment(new com.race.fragment.HomeFragment());
                    break;
                case R.id.post:
                    replaceFragment(new PostFragment());
                    break;
                case R.id.cart:
                    replaceFragment(new CartFragment());
                    break;
                case R.id.account:
                    replaceFragment(new AccountFragment());
                    break;
            }

            return true;
        });
    }

    private void replaceFragment(Fragment fragment){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frameContainer,fragment);
        fragmentTransaction.commit();
    }
}