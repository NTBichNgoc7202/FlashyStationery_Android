package com.race.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.race.flashystationery.OrderDetailActivity;
import com.race.flashystationery.OrderReturnActivity;
import com.race.flashystationery.R;
import com.race.flashystationery.databinding.FragmentOrderNotReviewBinding;

public class OrderNotReviewFragment extends Fragment {

    FragmentOrderNotReviewBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentOrderNotReviewBinding.inflate(inflater,container,false);
        View view = binding.getRoot();

        addEvents();

        return view;
    }

    private void addEvents() {
        binding.llDeliverSuccess.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), OrderDetailActivity.class);
                intent.putExtra("status","success");
                startActivity(intent);
            }
        });

        binding.btnReturnOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), OrderReturnActivity.class));
            }
        });
    }
}