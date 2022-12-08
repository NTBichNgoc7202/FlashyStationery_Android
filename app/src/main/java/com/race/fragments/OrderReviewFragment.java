package com.race.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import com.race.adapters.OrderReviewViewPagerAdapter;
import com.race.flashystationery.databinding.FragmentOrderReviewBinding;

public class OrderReviewFragment extends Fragment {

    FragmentOrderReviewBinding binding;
    ViewPager2 reviewViewPager;
    TabLayout reviewTabLayout;
    OrderReviewViewPagerAdapter viewPagerAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentOrderReviewBinding.inflate(inflater, container, false);
        View view = binding.getRoot();

        customOrderReviewFragment();

        return view;
    }

    private void customOrderReviewFragment() {
        viewPagerAdapter = new OrderReviewViewPagerAdapter(this);

        reviewTabLayout = binding.tlOrderReview;
        reviewViewPager = binding.vpOrderReview;

        reviewViewPager.setAdapter(viewPagerAdapter);

        new TabLayoutMediator(reviewTabLayout, reviewViewPager,
                new TabLayoutMediator.TabConfigurationStrategy(){
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                switch (position) {
                    case 0:
                        tab.setText("Chưa đánh giá");
                        break;
                    case 1:
                        tab.setText("Đã đánh giá");
                        break;
                }
            }
        }).attach();
    }

    @Override
    public void onResume() {
        reviewViewPager.setCurrentItem(0);
        super.onResume();
    }
}