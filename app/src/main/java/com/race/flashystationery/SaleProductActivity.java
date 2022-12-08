package com.race.flashystationery;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.race.adapters.PhotoAdapter;
import com.race.flashystationery.databinding.ActivityProductBinding;
import com.race.flashystationery.databinding.ActivitySaleProductBinding;
import com.race.models.Photos;

import java.util.ArrayList;
import java.util.List;

import me.relex.circleindicator.CircleIndicator;

public class SaleProductActivity extends AppCompatActivity {
    ViewPager viewPager;
    CircleIndicator ccIndicatior;
    PhotoAdapter photoAdapter;
    ActivitySaleProductBinding binding;
    ImageView photoProduct;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_sale_product);
        binding = ActivitySaleProductBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        //photoProduct = findViewById(R.id.img_Photo);

        viewPager = binding.viewpager;
        ccIndicatior = binding.ccIndicator;

        photoAdapter = new PhotoAdapter(SaleProductActivity.this, getListPhotos());
        viewPager.setAdapter(photoAdapter);

        ccIndicatior.createIndicators(4,0);
        ccIndicatior.animatePageSelected(2);
        ccIndicatior.setViewPager(viewPager);
        photoAdapter.registerDataSetObserver(ccIndicatior.getDataSetObserver());

        addEvents();
    }

    private void addEvents() {
        binding.txtAddCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        binding.txtChat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        binding.txtBuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }

    private List<Photos> getListPhotos() {
        List<Photos> list = new ArrayList<>();
        list.add(new Photos(R.drawable.plan_notebook));
        list.add(new Photos(R.drawable.plan_notebook1));
        list.add(new Photos(R.drawable.plan_notebook2));
        list.add(new Photos(R.drawable.plan_notebook3));
        return  list;
    }
}