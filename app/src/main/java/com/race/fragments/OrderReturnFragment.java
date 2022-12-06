package com.race.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.race.flashystationery.MainActivity;
import com.race.flashystationery.R;
import com.race.flashystationery.databinding.FragmentOrderReturnBinding;

public class OrderReturnFragment extends Fragment {

    FragmentOrderReturnBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentOrderReturnBinding.inflate(inflater,container,false);
        View view = binding.getRoot();

        binding.btnContShopping.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), MainActivity.class));
            }
        });

        return view;
    }
}