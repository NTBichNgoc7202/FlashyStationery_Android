package com.race.fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.race.flashystationery.OrderDetailActivity;
import com.race.flashystationery.R;
import com.race.flashystationery.databinding.FragmentAccountBinding;
import com.race.flashystationery.databinding.FragmentOrderConfirmBinding;

public class OrderConfirmFragment extends Fragment {

    FragmentOrderConfirmBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentOrderConfirmBinding.inflate(inflater, container, false);
        View view = binding.getRoot();

        addEvents();

        return view;
    }

    private void addEvents() {
        binding.llOrderConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), OrderDetailActivity.class);
                intent.putExtra("status","confirm");
                startActivity(intent);
            }
        });
    }
}