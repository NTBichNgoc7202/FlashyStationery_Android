package com.race.adapters;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.race.fragment.OrderCancelRefundFragment;
import com.race.fragment.OrderConfirmFragment;
import com.race.fragment.OrderDeliverFragment;
import com.race.fragment.OrderReviewFragment;
import com.race.fragment.OrderTakingFragment;

public class OrderTrackingViewPagerAdapter extends FragmentStateAdapter {
    public OrderTrackingViewPagerAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position){
            case 0:
                return new OrderConfirmFragment();
            case 1:
                return new OrderTakingFragment();
            case 2:
                return new OrderDeliverFragment();
            case 3:
                return new OrderReviewFragment();
            case 4:
                return new OrderCancelRefundFragment();
            default:
                return new OrderConfirmFragment();
        }
    }

    @Override
    public int getItemCount() {
        return 5;
    }
}
