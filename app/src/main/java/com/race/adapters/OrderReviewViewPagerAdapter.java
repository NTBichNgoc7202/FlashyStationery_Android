package com.race.adapters;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.race.fragments.OrderNotReviewFragment;
import com.race.fragments.OrderReviewedFragment;

public class OrderReviewViewPagerAdapter extends FragmentStateAdapter {
    public OrderReviewViewPagerAdapter(@NonNull Fragment fragment) {
        super(fragment);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position){
            case 0:
                return new OrderNotReviewFragment();
            case 1:
                return new OrderReviewedFragment();
            default:
                return new OrderNotReviewFragment();
        }
    }

    @Override
    public int getItemCount() {
        return 2;
    }
}
