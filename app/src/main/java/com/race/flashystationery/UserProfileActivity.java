package com.race.flashystationery;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.Menu;

import com.race.flashystationery.databinding.ActivityUserProfileBinding;

public class UserProfileActivity extends AppCompatActivity {

    ActivityUserProfileBinding binding;
//    ActionBar actionBar = getSupportActionBar();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_user_profile);

        binding = ActivityUserProfileBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        customActionBar();


    }

    private void customActionBar() {

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.user_profile_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }
}