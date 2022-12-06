package com.race.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.race.flashystationery.OrderDetailActivity;
import com.race.flashystationery.databinding.FragmentOrderDeliverBinding;

public class OrderDeliverFragment extends Fragment {

    FragmentOrderDeliverBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentOrderDeliverBinding.inflate(inflater, container, false);
        View view = binding.getRoot();

        addEvents();

        return view;
    }

    private void addEvents() {
        binding.llOrderDeliver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), OrderDetailActivity.class);
                intent.putExtra("status","deliver");
                startActivity(intent);
            }
        });
    }
}