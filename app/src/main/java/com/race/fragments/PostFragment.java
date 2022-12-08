package com.race.fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.race.flashystationery.LoginRegisterActivity;
import com.race.flashystationery.MainActivity;
import com.race.flashystationery.OrderPaymentActivity;
import com.race.flashystationery.OrderTrackingActivity;
import com.race.flashystationery.PostDetail;
import com.race.flashystationery.ProductActivity;
import com.race.flashystationery.R;
import com.race.flashystationery.databinding.ActivityLoginRegisterBinding;
import com.race.flashystationery.databinding.FragmentPostBinding;


public class PostFragment extends Fragment {

    FragmentPostBinding binding;
    BottomSheetDialog bottomSheetSharePost;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        ((AppCompatActivity) getActivity()).getSupportActionBar().setDisplayShowTitleEnabled(true);
        ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle("Bảng tin FLASHY");


        binding = FragmentPostBinding.inflate(inflater, container, false);

        View view = binding.getRoot();
        addEvent();


        return view;
    }

    private void addEvent() {
        binding.txtdetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), PostDetail.class);
                startActivity(intent);
            }
        });
        binding.btnshoppingBlog2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), ProductActivity.class);
                startActivity(intent);
            }
        });
        binding.btnshoppingBlog1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), MainActivity.class);
                startActivity(intent);
            }
        });
        binding.imvshareBlog1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                bottomSheetSharePost.setContentView(R.layout.dialog_sharepost);
                bottomSheetSharePost.show();
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}