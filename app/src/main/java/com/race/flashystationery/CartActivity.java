package com.race.flashystationery;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.MenuItemCompat;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import com.race.adapters.CartTabViewAdapter;
import com.race.adapters.ItemAdapter;
import com.race.adapters.OrderTrackingViewPagerAdapter;
import com.race.flashystationery.databinding.ActivityCartBinding;
import com.race.models.Item;

import java.util.ArrayList;

public class CartActivity extends AppCompatActivity {
    ActivityCartBinding binding;
    CartTabViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_cart);
        binding = ActivityCartBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
//        getSupportActionBar().setDisplayShowTitleEnabled(true);
        getSupportActionBar().setTitle("Giỏ hàng của tôi");

       // loadTabView();
    }

    private void loadTabView() {
        adapter = new CartTabViewAdapter(this);
        binding.vpCart.setAdapter(adapter);
        binding.vpCart.setUserInputEnabled(false);
        binding.tlCart.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                binding.vpCart.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        binding.vpCart.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                binding.tlCart.getTabAt(position).select();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(@NonNull Menu menu) {
        getMenuInflater().inflate(R.menu.cart_menu, menu);
//        MenuItem menuAddress = menu.findItem(R.id.mn_Address);
//        MenuItemCompat.setActionView(menuAddress, R.layout.cart_menu_layout);
        return super.onCreateOptionsMenu(menu);
    }
}