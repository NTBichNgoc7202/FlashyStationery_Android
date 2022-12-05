package com.race.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.race.fragment.CartFullFragment;
import com.race.flashystationery.R;
import com.race.models.Item;

import java.util.List;

public class ItemAdapter extends BaseAdapter {
    CartFullFragment fragment;
    int item_layout;
    List<Item> itemList;

    public ItemAdapter(CartFullFragment fragment, int item_layout, List<Item> itemList) {
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
        if(view == null) {
            holder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) fragment.getActivity().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(this.item_layout, null);

            holder.imvThumb = view.findViewById(R.id.imv_ItemThumb);
            holder.txtName = view.findViewById(R.id.txt_ItemName);
            holder.txtCategory = view.findViewById(R.id.txt_ItemCategory);
            holder.txtDiscount = view.findViewById(R.id.txt_ItemDiscount);
            holder.txtPrice = view.findViewById(R.id.txt_ItemPrice);
            holder.txtNumber = view.findViewById(R.id.txt_ItemNumber);
            holder.btnPlus = view.findViewById(R.id.btn_Plus);
            holder.btnMinus = view.findViewById(R.id.btn_Minus);
            holder.chkSelect = view.findViewById(R.id.chk_Select);
            holder.llItemClick = view.findViewById(R.id.ll_ItemClick);

            view.setClickable(true);
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
        holder.txtPrice.setText(item.getItemPrice() + " đ");
        holder.txtNumber.setText(item.getItemNumber());
        holder.btnPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fragment.plusItem(item);
            }
        });
        holder.btnMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fragment.minusItem(item);
            }
        });
        holder.txtCategory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fragment.createBottomSheetCategory(item);
            }
        });
        holder.llItemClick.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                fragment.deleteItem();
                return true;
            }
        });
            return view;
    }

    public static class ViewHolder {
        ImageView imvThumb;
        TextView txtName, txtCategory, txtDiscount, txtPrice, txtNumber;
        Button btnPlus, btnMinus;
        CheckBox chkSelect;
        LinearLayout llItemClick;
    }
}
