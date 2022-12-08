package com.race.adapters;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.race.flashystationery.R;
import com.race.models.HotProduct;

import java.util.List;

public class HotProductAdapter extends BaseAdapter {
    Activity activity;
    int hotproduct_layout;
    List<HotProduct> hotProductList;

    //Constructor

    public HotProductAdapter(Activity activity, int item_layout, List<HotProduct> hotProductList) {
        this.activity = activity;
        this.hotproduct_layout = item_layout;
        this.hotProductList = hotProductList;
    }

    @Override
    public int getCount() {
        return hotProductList.size();
    }

    @Override
    public Object getItem(int i) {
        return hotProductList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        HotProductAdapter.ViewHolder holder;

        if (view == null){
            holder = new HotProductAdapter.ViewHolder();
            LayoutInflater inflater = (LayoutInflater) activity.getSystemService
                    (Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(this.hotproduct_layout, null);
            holder.imvProPhoto = view.findViewById(R.id.imv_HotProduct);
            holder.txtHotName = view.findViewById(R.id.txt_HotProductName);
            holder.txtHotPrice = view.findViewById(R.id.txt_HotProductPrice);
            holder.txtAmount = view.findViewById(R.id.txt_HotProductAmount);
            view.setTag(holder);
        }else {
            holder = (HotProductAdapter.ViewHolder) view.getTag();
        }

        HotProduct hotProduct = hotProductList.get(i);
        holder.imvProPhoto.setImageResource(hotProduct.getProphoto());
        holder.txtHotName.setText(hotProduct.getHotName());
        holder.txtHotPrice.setText(String.valueOf(hotProduct.getHotPrice()));
        holder.txtAmount.setText(hotProduct.getHotAmount());

        return view;
    }
    public static class ViewHolder{
        ImageView imvProPhoto;
        TextView txtHotName, txtHotPrice, txtAmount;
    }
}
