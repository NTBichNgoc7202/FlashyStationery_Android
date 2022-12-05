package com.race.flashystationery;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.race.adapters.PhotoAdapter;
import com.race.flashystationery.databinding.ActivityProductBinding;

import java.util.ArrayList;
import java.util.List;

import me.relex.circleindicator.CircleIndicator;

public class ProductActivity extends AppCompatActivity {
    ViewPager viewPager;
    CircleIndicator ccIndicatior;
    PhotoAdapter photoAdapter;
    ActivityProductBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_product);
        binding = ActivityProductBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        viewPager = binding.viewpager;
        ccIndicatior = binding.ccIndicator;

        photoAdapter = new PhotoAdapter(ProductActivity.this, getListPhotos());
        viewPager.setAdapter(photoAdapter);

        ccIndicatior.createIndicators(4,0);
        ccIndicatior.animatePageSelected(2);
        ccIndicatior.setViewPager(viewPager);
        photoAdapter.registerDataSetObserver(ccIndicatior.getDataSetObserver());
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