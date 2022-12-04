package com.race.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.MenuItemCompat;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.tabs.TabLayout;
import com.race.adapters.CartTabViewAdapter;
import com.race.flashystationery.R;
import com.race.flashystationery.databinding.ActivityCartBinding;
import com.race.flashystationery.databinding.FragmentCartBinding;
import com.race.flashystationery.databinding.FragmentCartFullBinding;

public class CartFragment extends Fragment {

    FragmentCartBinding binding;
    CartTabViewAdapter adapter;
    Menu menu;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ((AppCompatActivity) getActivity()).getSupportActionBar()
                .setDisplayShowTitleEnabled(true);
        ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle("Giỏ hàng của tôi");
        setHasOptionsMenu(true);
        loadTabView();

        binding = FragmentCartBinding.inflate(inflater, container, false);
        View view = binding.getRoot();
        return view;
    }


    private void loadTabView() {
        adapter = new CartTabViewAdapter(getActivity());
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
    public void onCreateOptionsMenu(@NonNull Menu menu,@NonNull MenuInflater inflater) {
        ((AppCompatActivity) getActivity()).getMenuInflater().inflate(R.menu.cart_menu, menu);
        MenuItem menuAddress = menu.findItem(R.id.mn_Address);
        MenuItemCompat.setActionView(menuAddress, R.layout.cart_menu_layout);
        super.onCreateOptionsMenu(menu, inflater);
    }
}