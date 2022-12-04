package com.race.adapters;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.race.flashystationery.R;
import com.race.models.Address;

import java.util.List;

public class AddressAdapter extends BaseAdapter {

    Activity activity;
    int item_layout;
    List<Address> addressList;

    public AddressAdapter(Activity activity, int item_layout, List<Address> addressList) {
        this.activity = activity;
        this.item_layout = item_layout;
        this.addressList = addressList;
    }

    @Override
    public int getCount() {
        return addressList.size();
    }

    @Override
    public Object getItem(int i) {
        return addressList.get(i);
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
            LayoutInflater inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(this.item_layout,null);

            holder.txtName = view.findViewById(R.id.txt_NameAddress);
            holder.txtPhone = view.findViewById(R.id.txt_PhoneNumberAddress);
            holder.txtDetail = view.findViewById(R.id.txt_AddressDetail);
            holder.txtAddress = view.findViewById(R.id.txt_Address);
            holder.txtType = view.findViewById(R.id.txt_AddressType);
            holder.txtDefault = view.findViewById(R.id.txt_DefaultAddress);
            holder.txtEdit = view.findViewById(R.id.txt_EditAddress);

            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }

        Address address = addressList.get(i);

        String subUserName;
        if (address.getUserName().length() >= 15)
            subUserName = address.getUserName().substring(0,15) + "...";
        else
            subUserName = address.getUserName();

        holder.txtName.setText(subUserName);
        holder.txtPhone.setText(address.getUserPhoneNumber());
        holder.txtDetail.setText(address.getAddressDetail());
        holder.txtAddress.setText(address.getAddress());
        holder.txtType.setText(address.getAddressType());

        if (address.getDefaultAddress().equals("x"))
            holder.txtDefault.setVisibility(TextView.VISIBLE);
        else
            holder.txtDefault.setVisibility(TextView.INVISIBLE);

        holder.txtEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        return view;
    }

    public static class ViewHolder{
        TextView txtName, txtPhone, txtDetail, txtAddress, txtType, txtDefault, txtEdit;
    }
}
