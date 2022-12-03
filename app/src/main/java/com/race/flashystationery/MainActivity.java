package com.race.flashystationery;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import com.race.flashystationery.databinding.ActivityMainBinding;
import com.race.fragment.AccountFragment;
import com.race.fragment.CartFragment;
import com.race.fragment.HomeFragment;
import com.race.fragment.PostFragment;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    SharedPreferences preferences = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        replaceFragment(new HomeFragment());

        preferences = getSharedPreferences("com.race.myAppName",MODE_PRIVATE);

        fragmentNavigation();

//        binding.imvNoteBook.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(MainActivity.this,
//                        NoteBookActivity.class);
//                intent.putExtra("noteList", "itembotebook");
//                startActivity(intent);
//            }
//        });


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
                    replaceFragment(new HomeFragment());
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