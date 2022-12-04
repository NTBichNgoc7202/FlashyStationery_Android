package com.race.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.race.fragment.CartFullFragment;
import com.race.flashystationery.R;
import com.race.models.ItemModel;

import java.util.List;

public class ItemModelAdapter extends BaseAdapter {
    CartFullFragment fragment;
    int item_layout;
    List<ItemModel> itemList;

    public ItemModelAdapter(CartFullFragment fragment, int item_layout, List<ItemModel> itemList) {
        this.fragment = fragment;
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
        if(view == null)
        {
            holder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) fragment.getActivity().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(this.item_layout,null);

            holder.imvModelPhoto = view.findViewById(R.id.imv_ModelPhoto);
            holder.txtModelName = view.findViewById(R.id.txt_ModelName);

            view.setClickable(true);
            view.setTag(holder);
        }
        else
        {
            holder = (ItemModelAdapter.ViewHolder)view.getTag();
        }
        ItemModel item = itemList.get(i);
        holder.imvModelPhoto.setImageResource(item.getModelPhoto());
        holder.txtModelName.setText(item.getModelNo());
        return view;
    }
    public static class ViewHolder{
        ImageView imvModelPhoto;
        TextView txtModelName;
    }
}
