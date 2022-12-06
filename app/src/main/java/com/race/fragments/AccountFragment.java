package com.race.fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.race.flashystationery.AddressListActivity;
import com.race.flashystationery.FavoriteProductActivity;
import com.race.flashystationery.NotificationActivity;
import com.race.flashystationery.OrderTrackingActivity;
import com.race.flashystationery.R;
import com.race.flashystationery.databinding.FragmentAccountBinding;

public class AccountFragment extends Fragment {

   FragmentAccountBinding binding;

    public AccountFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        ((AppCompatActivity) getActivity()).getSupportActionBar()
                .setDisplayShowTitleEnabled(true);
        ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle(R.string.user_acc_title);

        setHasOptionsMenu(true);

        // Inflate the layout for this fragment
        binding = FragmentAccountBinding.inflate(inflater, container, false);
        View view = binding.getRoot();

        addEvents();

        return view;
    }

    private void addEvents() {
        binding.llChoXacNhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), OrderTrackingActivity.class));
            }
        });

        binding.llChoLayHang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), OrderTrackingActivity.class);
                intent.putExtra("position",1);
                startActivity(intent);
            }
        });

        binding.llDangGiao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), OrderTrackingActivity.class);
                intent.putExtra("position",2);
                startActivity(intent);
            }
        });

        binding.llDanhGia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), OrderTrackingActivity.class);
                intent.putExtra("position",3);
                startActivity(intent);
            }
        });

        binding.llHuyVaTraHang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), OrderTrackingActivity.class);
                intent.putExtra("position",4);
                startActivity(intent);
            }
        });

        binding.llFavoriteProduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), FavoriteProductActivity.class));
            }
        });

        binding.llAccountSetting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        binding.llAddressList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), AddressListActivity.class));
            }
        });

        binding.llPolicy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        binding.llSupport.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        ((AppCompatActivity) getActivity()).getMenuInflater()
                .inflate(R.menu.user_profile_menu,menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.mn_Setting){
            //Opening Setting Act

        } else if (item.getItemId() == R.id.mn_Notify){
            //Opening Notification Act
            startActivity(new Intent(getActivity(), NotificationActivity.class));
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}