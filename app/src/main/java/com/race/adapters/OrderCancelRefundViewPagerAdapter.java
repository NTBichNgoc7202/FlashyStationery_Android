package com.race.adapters;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.race.fragments.OrderCancelFragment;
import com.race.fragments.OrderRefundFragment;

public class OrderCancelRefundViewPagerAdapter extends FragmentStateAdapter {
    public OrderCancelRefundViewPagerAdapter(@NonNull Fragment fragment) {
        super(fragment);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position){
            case 0:
                return new OrderCancelFragment();
            case 1:
                return new OrderRefundFragment();
            default:
                return new OrderCancelFragment();
        }
    }

    @Override
    public int getItemCount() {
        return 2;
    }
}
