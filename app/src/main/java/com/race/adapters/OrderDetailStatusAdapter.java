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
import com.race.models.OrderDetailStatus;

import java.util.List;

public class OrderDetailStatusAdapter extends BaseAdapter {

    Activity activity;
    int item_layout;
    List<OrderDetailStatus> orderDetailStatusList;

    public OrderDetailStatusAdapter(Activity activity, int item_layout, List<OrderDetailStatus> orderDetailStatusList) {
        this.activity = activity;
        this.item_layout = item_layout;
        this.orderDetailStatusList = orderDetailStatusList;
    }

    @Override
    public int getCount() {
        return orderDetailStatusList.size();
    }

    @Override
    public Object getItem(int i) {
        return orderDetailStatusList;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        OrderDetailStatusAdapter.ViewHolder holder;
        if (view == null){
            holder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(this.item_layout,null);

            holder.imvOrderDetailStatusIcon = view.findViewById(R.id.imv_OrderDetailStatus);
            holder.txtOrderDetailStatus = view.findViewById(R.id.txt_OrderDetailStatus);

            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }

        OrderDetailStatus orderDetailStatus = orderDetailStatusList.get(i);

        holder.imvOrderDetailStatusIcon.setImageResource(orderDetailStatus.getOrderStatusIcon());
        holder.txtOrderDetailStatus.setText(orderDetailStatus.getOrderStatus());

        return view;
    }

    public static class ViewHolder{
        ImageView imvOrderDetailStatusIcon;
        TextView txtOrderDetailStatus;
    }
}
