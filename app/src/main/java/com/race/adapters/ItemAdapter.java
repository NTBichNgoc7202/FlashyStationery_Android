package com.race.adapters;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import com.race.flashystationery.R;
import com.race.models.Item;

import java.util.List;

public class ItemAdapter extends BaseAdapter {
    Activity activity;
    int item_layout;
    List<Item> itemList;

    public ItemAdapter(Activity activity, int item_layout, List<Item> itemList) {
        this.activity = activity;
        this.item_layout = item_layout;
        this.itemList = itemList;
    }


    @Override
    public int getCount() {
        return itemList.size();
    }

    @Override
    public Object getItem(int i) {
        return itemList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder;
        if(view == null) {
            holder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(this.item_layout, null);

            holder.imvThumb = view.findViewById(R.id.imv_ItemThumb);
            holder.txtName = view.findViewById(R.id.txt_ItemName);
            holder.txtCategory = view.findViewById(R.id.txt_ItemCategory);
            holder.txtDiscount = view.findViewById(R.id.txt_ItemDiscount);
            holder.txtPrice = view.findViewById(R.id.txt_ItemPrice);
            holder.txtNumber = view.findViewById(R.id.txt_ItemNumber);

            view.setTag(holder);
        }
        else
        {
            holder = (ViewHolder)view.getTag();
        }
        Item item = itemList.get(i);
        holder.imvThumb.setImageResource(item.getItemThumb());
        holder.txtName.setText(item.getItemName());
        holder.txtCategory.setText(item.getItemCategory());
        holder.txtDiscount.setText(item.getItemDiscount());
        holder.txtPrice.setText(item.getItemPrice());
        holder.txtNumber.setText(item.getItemNumber());



            return view;
    }
    public static class ViewHolder {
        ImageView imvThumb;
        TextView txtName, txtCategory, txtDiscount, txtPrice, txtNumber;
    }
}
