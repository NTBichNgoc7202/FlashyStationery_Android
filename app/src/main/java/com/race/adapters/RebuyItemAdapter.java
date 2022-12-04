package com.race.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import com.race.flashystationery.CartFragment;
import com.race.flashystationery.R;
import com.race.models.RebuyItem;

import java.util.List;

public class RebuyItemAdapter extends BaseAdapter {
    CartFragment fragment;
    int item_layout;
    List<RebuyItem> rebuyItemList;

    public RebuyItemAdapter(CartFragment fragment, int item_layout, List<RebuyItem> rebuyItemList) {
        this.fragment = fragment;
        this.item_layout = item_layout;
        this.rebuyItemList = rebuyItemList;
    }

    @Override
    public int getCount() {
        return rebuyItemList.size();
    }

    @Override
    public Object getItem(int i) {
        return rebuyItemList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ItemAdapter.ViewHolder holder;
        if(view == null) {
            holder = new ItemAdapter.ViewHolder();
            LayoutInflater inflater = (LayoutInflater) fragment.getActivity().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(this.item_layout, null);

            holder.imvThumb = view.findViewById(R.id.imv_ReThumb);
            holder.txtName = view.findViewById(R.id.txt_ReName);
            holder.txtCategory = view.findViewById(R.id.txt_ReCategory);
            holder.txtPrice = view.findViewById(R.id.txt_RePrice);
            holder.txtNumber = view.findViewById(R.id.txt_ReNumber);
            holder.btnPlus = view.findViewById(R.id.btn_RePlus);
            holder.btnMinus = view.findViewById(R.id.btn_ReMinus);
            holder.chkSelect = view.findViewById(R.id.chk_ReSelect);

            view.setClickable(true);
            view.setTag(holder);
        }
        else
        {
            holder = (ItemAdapter.ViewHolder)view.getTag();
        }
        RebuyItem item = rebuyItemList.get(i);
        holder.imvThumb.setImageResource(item.getReThumb());
        holder.txtName.setText(item.getReName());
        holder.txtCategory.setText(item.getReCategory());
        holder.txtPrice.setText(item.getRePrice() + " đ");
        holder.txtNumber.setText(item.getReNumber());
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
        return view;
    }
    public static class ViewHolder {
        ImageView imvThumb;
        TextView txtName, txtCategory, txtPrice, txtNumber;
        Button btnPlus, btnMinus;
        CheckBox chkSelect;
    }
}
