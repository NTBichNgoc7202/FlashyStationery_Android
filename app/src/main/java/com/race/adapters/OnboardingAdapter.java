package com.race.adapters;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.race.flashystationery.R;

public class OnboardingAdapter extends PagerAdapter{

    private Context context;

    public OnboardingAdapter(Context context){
        this.context = context;
    }

    private int[] slider_images = {R.drawable.onboarding_1, R.drawable.onboarding_2,
            R.drawable.onboarding_3};

    private int[] slider_desc = {R.string.onboarding_1,R.string.onboarding_2,R.string.onboarding_3};

    @Override
    public int getCount() {
        return slider_images.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == (RelativeLayout) object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        LayoutInflater layoutInflater = (LayoutInflater)context.
                getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(
                R.layout.onboarding_item_container,container,false);

        ImageView imvBanner = view.findViewById(R.id.imv_Banner);
        TextView txtDesc = view.findViewById(R.id.txt_Desc);

        imvBanner.setImageResource(slider_images[position]);
        txtDesc.setText(slider_desc[position]);

        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((RelativeLayout) object);
    }
}
