package com.race.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import com.race.adapters.OrderCancelRefundViewPagerAdapter;
import com.race.flashystationery.databinding.FragmentOrderCancelRefundBinding;

public class OrderCancelRefundFragment extends Fragment {

    FragmentOrderCancelRefundBinding binding;
    ViewPager2 cancelRefundViewPager;
    TabLayout cancelRefundTabLayout;
    OrderCancelRefundViewPagerAdapter viewPagerAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentOrderCancelRefundBinding.inflate(inflater, container, false);
        View view = binding.getRoot();

        customOrderCancelRefundFragment();

        return view;
    }

    private void customOrderCancelRefundFragment() {
        viewPagerAdapter = new OrderCancelRefundViewPagerAdapter(this);

        cancelRefundTabLayout = binding.tlOrderCancelRefund;
        cancelRefundViewPager = binding.vpOrderCancelRefund;

        cancelRefundViewPager.setAdapter(viewPagerAdapter);

        new TabLayoutMediator(cancelRefundTabLayout, cancelRefundViewPager,
                new TabLayoutMediator.TabConfigurationStrategy(){
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                switch (position) {
                    case 0:
                        tab.setText("Đã huỷ");
                        break;
                    case 1:
                        tab.setText("Trả hàng/Hoàn tiền");
                        break;
                }
            }
        }).attach();
    }
}