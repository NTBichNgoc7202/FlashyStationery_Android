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
import com.race.models.ItemNoteBook;

import java.util.List;

public class ItemNoteBookAdapter extends BaseAdapter {
    Activity activity;
    int itemnotebook_layout;
    List<ItemNoteBook> itemNoteBookList;

    public ItemNoteBookAdapter(Activity activity, int itemnotebook_layout, List<ItemNoteBook> itemNoteBookList) {
        this.activity = activity;
        this.itemnotebook_layout = itemnotebook_layout;
        this.itemNoteBookList = itemNoteBookList;
    }

    @Override
    public int getCount() {
        return itemNoteBookList.size();
    }

    @Override
    public Object getItem(int i) {
        return itemNoteBookList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder;

        if (view == null){
            holder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) activity.getSystemService
                    (Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(this.itemnotebook_layout, null);
            holder.imvPhoto = view.findViewById(R.id.imv_ItemNoteBook);
            holder.txtNoteName = view.findViewById(R.id.txt_ItemNameNoteBook);
            holder.txtNotePrice = view.findViewById(R.id.txt_ItemPriceNoteBook);
            view.setTag(holder);
        }else {
            holder = (ViewHolder) view.getTag();
        }

        ItemNoteBook itemNoteBook = itemNoteBookList.get(i);
        holder.imvPhoto.setImageResource(itemNoteBook.getPhoto());
        holder.txtNoteName.setText(itemNoteBook.getNoteName());
        holder.txtNotePrice.setText(String.valueOf(itemNoteBook.getNotePrice()));

        return view;
    }
    public static class ViewHolder{
        ImageView imvPhoto;
        TextView txtNoteName, txtNotePrice;
    }
}
