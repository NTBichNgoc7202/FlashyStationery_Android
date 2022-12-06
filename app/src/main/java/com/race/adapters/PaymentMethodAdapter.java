package com.race.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.race.flashystationery.OrderPaymentActivity;
import com.race.flashystationery.R;
import com.race.models.PaymentMethod;

import java.util.ArrayList;
import java.util.zip.Inflater;

public class PaymentMethodAdapter extends BaseAdapter {
    OrderPaymentActivity activity;
    int method_layout;
    ArrayList<PaymentMethod> methods;

    public PaymentMethodAdapter(OrderPaymentActivity activity, int method_layout, ArrayList<PaymentMethod> methods) {
        this.activity = activity;
        this.method_layout = method_layout;
        this.methods = methods;
    }

    @Override
    public int getCount() {
        return methods.size();
    }

    @Override
    public Object getItem(int i) {
        return methods.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder;
        if (view == null)
        {
            holder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(this.method_layout, null);

            holder.imvMePhoto = view.findViewById(R.id.imv_MePhoto);
            holder.txtMeTitle = view.findViewById(R.id.txt_MeTitle);
            holder.txtMeDes = view.findViewById(R.id.txt_MeDes);

            view.setClickable(true);
            view.setTag(holder);
        }
        else
        {
            holder = (ViewHolder) view.getTag();
        }

        PaymentMethod method = methods.get(i);

        holder.imvMePhoto.setImageResource(method.getMePhoto());
        holder.txtMeTitle.setText(method.getMeTitle());
        holder.txtMeDes.setText(method.getMeDes());

        return view;
    }

    public static class ViewHolder {
        ImageView imvMePhoto;
        TextView txtMeTitle, txtMeDes;
    }
}
