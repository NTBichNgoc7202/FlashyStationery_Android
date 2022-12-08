package com.race.adapters;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.bumptech.glide.Glide;
import com.race.flashystationery.Banner;
import com.race.flashystationery.Photos;
import com.race.flashystationery.R;
import com.race.fragment.HomeFragment;

import java.util.List;

public class BannerAdapter extends PagerAdapter {
    HomeFragment homeFragment;
    List<Banner> bannerList;

    public BannerAdapter(HomeFragment homeFragment, List<Banner> bannerList) {
        this.homeFragment = homeFragment;
        this.bannerList = bannerList;
    }
    private int[] list_banner = {R.drawable.banner1, R.drawable.banner2,
            R.drawable.banner3};

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        View view = LayoutInflater.from(container.getContext()).inflate(R.layout.banner_photo, container, false);

        ImageView imvBannerPhoto = view.findViewById(R.id.imv_BannerPhoto);
        Banner banner = bannerList.get(position);
        if (bannerList != null)
        {
            Glide.with(homeFragment).load(banner.getResource_id()).into(imvBannerPhoto);
        }

        container.addView(view);

        return view;
    }

    @Override
    public int getCount() {
        if (bannerList != null) {
            return bannerList.size();
        }
        return 0;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }
}
