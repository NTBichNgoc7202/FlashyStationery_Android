package com.race.flashystationery;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.bumptech.glide.Glide;

import java.util.List;

public class PhotoAdapter extends PagerAdapter {

    private Context context;
    List<Photos> photosList;

    public PhotoAdapter(Context context, List<Photos> photosList) {
        this.context = context;
        this.photosList = photosList;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        View view = LayoutInflater.from(container.getContext()).inflate(R.layout.product_photo, container, false);
        ImageView imgPhoto = view.findViewById(R.id.img_Photo);
        Photos photos = photosList.get(position);
        if (photos!= null)
        {
            Glide.with(context).load(photos.getResource_id()).into(imgPhoto);
        }

        container.addView(view);

        return view;
    }

    @Override
    public int getCount() {
        if (photosList != null) {
            return photosList.size();
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
