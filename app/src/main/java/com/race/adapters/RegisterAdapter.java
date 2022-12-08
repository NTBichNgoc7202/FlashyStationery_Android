package com.race.adapters;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.race.flashystationery.R;
import com.race.flashystationery.SetUpAccountActivity;
import com.race.models.Address;
import com.race.models.Register;

import java.util.List;

public class RegisterAdapter extends BaseAdapter {
    Activity activity;
    int item_layout;
    List<Register> registers;

    public RegisterAdapter(Activity activity, int item_layout, List<Register> registers) {
        this.activity = activity;
        this.item_layout = item_layout;
        this.registers = registers;
    }


    @Override
    public int getCount() {return registers.size();}

    @Override
    public Object getItem(int i) {return registers.get(i);}

    @Override
    public long getItemId(int i) {return 0;}

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder;
        if (view == null){
            holder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(this.item_layout, null);

            holder.txtUserName = view.findViewById(R.id.txt_ShowFullName);
            holder.txtPhoneNumber = view.findViewById(R.id.txt_ShowPhoneNumber);
            holder.txtEmail = view.findViewById(R.id.txt_ShowEmail);
            holder.txtGender = view.findViewById(R.id.txt_ShowGender);
            holder.txtDOB = view.findViewById(R.id.txt_ShowDoB);
            holder.txtPassword = view.findViewById(R.id.txt_ShowPasswordHint);

            view.setTag(holder);
        }
        else {
            holder =(ViewHolder) view.getTag();
        }

        Register register = registers.get(i);

        holder.txtUserName.setText(register.getUserName());
        holder.txtPhoneNumber.setText(register.getUserPhoneNumber());
        holder.txtEmail.setText(register.getUserEmail());
        holder.txtGender.setText(register.getUserGender());
        holder.txtDOB.setText(register.getUserDOB());
        holder.txtPassword.setText(register.getUserPassword());



        return view;
    }
    public static class ViewHolder{
        TextView txtUserName, txtPhoneNumber, txtEmail, txtGender, txtDOB, txtPassword;
    }
}
