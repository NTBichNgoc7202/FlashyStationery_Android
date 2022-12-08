package com.race.flashystationery;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.race.flashystationery.databinding.ActivityPromotionBinding;

public class PromotionActivity extends AppCompatActivity {
    ActivityPromotionBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_promotion);
        binding = ActivityPromotionBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        addEventd();

        getSupportActionBar().setTitle("Khuyến mãi");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    private void addEventd() {
        binding.btnXemChiTietMua1Tang1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(PromotionActivity.this, SaleProductActivity.class ));
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                this.finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}