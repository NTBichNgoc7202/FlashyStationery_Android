package com.race.flashystationery;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.race.flashystationery.databinding.ActivityPostDetailBinding;
import com.race.flashystationery.databinding.ActivitySettingBinding;

public class PostDetail extends AppCompatActivity {

    ActivityPostDetailBinding binding;
    BottomSheetDialog bottomSheetSharePost, bottomSheetRequest;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_post_detail);
        binding = ActivityPostDetailBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        getSupportActionBar().setTitle("Bài viết");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        addEvents();

    }

    private void addEvents() {
        binding.btnShopping.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PostDetail.this, ProductActivity.class);
                startActivity(intent);
            }
        });
        binding.imvsharepost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (bottomSheetSharePost == null) {
                    bottomSheetSharePost = new BottomSheetDialog((PostDetail.this));
                    bottomSheetSharePost.setContentView(R.layout.dialog_sharepost);
                }
                bottomSheetSharePost.show();
            }
        });
        binding.btnsendcmt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (bottomSheetRequest == null) {
                    bottomSheetRequest = new BottomSheetDialog(PostDetail.this);
                    bottomSheetRequest.setContentView(R.layout.activity_login_request);
                }
                bottomSheetRequest.show();
            }
        });
    }
}