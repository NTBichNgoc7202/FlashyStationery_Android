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

import com.race.flashystationery.OrderPaymentActivity;
import com.race.flashystationery.R;
import com.race.models.Item;

import java.util.List;

public class ItemOrderAdapter extends BaseAdapter {
    OrderPaymentActivity activity;
    int item_layout;
    List<Item> orderItemList;

    public ItemOrderAdapter(OrderPaymentActivity activity, int item_layout, List<Item> orderItemList) {
        this.activity = activity;
        this.item_layout = item_layout;
        this.orderItemList = orderItemList;
    }

    @Override
    public int getCount() {
        return orderItemList.size();
    }

    @Override
    public Object getItem(int i) {
        return orderItemList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder;
        if(view == null){
            holder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(this.item_layout, null);

            holder.imvThumb = view.findViewById(R.id.imv_OrderThumb);
            holder.txtName = view.findViewById(R.id.txt_OrderName);
            holder.txtCategory = view.findViewById(R.id.txt_OrderCategory);
            holder.txtDiscount = view.findViewById(R.id.txt_OrderDiscount);
            holder.txtPrice = view.findViewById(R.id.txt_OrderPrice);
            holder.txtNumber = view.findViewById(R.id.txt_OrderNumber);

            view.setClickable(true);
            view.setTag(holder);
        }
        else{
            holder = (ViewHolder) view.getTag();
        }
        Item item = orderItemList.get(i);
        holder.imvThumb.setImageResource(item.getItemThumb());
        holder.txtName.setText(item.getItemName());
        holder.txtCategory.setText(item.getItemName());
        holder.txtDiscount.setText(item.getItemDiscount());
        holder.txtPrice.setText(item.getItemPrice() + " đ");
        holder.txtNumber.setText("Số lượng: " + item.getItemNumber());

      return view;
    }
    public static class ViewHolder{
        ImageView imvThumb;
        TextView txtName, txtCategory, txtDiscount, txtPrice, txtNumber;
    }
}
