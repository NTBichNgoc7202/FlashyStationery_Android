package com.race.adapters;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.race.fragment.CartFullFragment;
import com.race.fragment.CartRebuyFragment;

public class CartTabViewAdapter extends FragmentStateAdapter {
    public CartTabViewAdapter(@NonNull Fragment fragment) {
        super(fragment);
    }

//    public CartTabViewAdapter(@NonNull FragmentActivity fragmentActivity) {
//        super(fragmentActivity);
//    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position){
            case 0:
                return new CartFullFragment();
            case 1:
                return  new CartRebuyFragment();
        }
        return  new CartFullFragment();
    }

    @Override
    public int getItemCount() {
        return 2;
    }
}
