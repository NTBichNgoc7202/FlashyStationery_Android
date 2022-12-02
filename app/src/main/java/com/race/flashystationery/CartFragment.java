package com.race.flashystationery;

import android.graphics.Color;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.race.adapters.ItemAdapter;
import com.race.flashystationery.databinding.ActivityCartBinding;
import com.race.flashystationery.databinding.FragmentCartBinding;
import com.race.models.Item;

import java.util.ArrayList;


public class CartFragment extends Fragment {

    FragmentCartBinding binding;
    ArrayList<Item> items;
    ItemAdapter adapter;
    TextView txtCartFull, txtCartRebuy;

    public CartFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ((AppCompatActivity) getActivity()).getSupportActionBar()
                .setDisplayShowTitleEnabled(false);
        setHasOptionsMenu(true);

        // Inflate the layout for this fragment

        binding = FragmentCartBinding.inflate(inflater, container, false);
        View view = binding.getRoot();
        txtCartFull = view.findViewById(R.id.txt_CartFull);
        txtCartRebuy = view.findViewById(R.id.txt_CartRebuy);
        addEvents();
        loadData();
        loadView();
        return view;


    }

    private void loadView() {
        txtCartFull.setBackgroundResource(R.drawable.header_activate);
        txtCartRebuy.setBackgroundResource(R.drawable.header_disable);
        txtCartFull.setTextColor(Color.parseColor("#5d5c78"));
        txtCartRebuy.setTextColor(Color.parseColor("#66000000"));
    }

    public void addEvents(){
        txtCartRebuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                replaceFragment(new CartFragment2());
            }
        });
        txtCartRebuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txtCartFull.setBackgroundResource(R.drawable.header_activate);
                txtCartRebuy.setBackgroundResource(R.drawable.header_disable);
            }
        });
    }
    private void loadData() {
        items = new ArrayList<>();
        items.add(new Item(R.drawable.notebook, "1", "Sổ Tay Ghi Chép giấy kraft Nâu Có Dòng Kẻ", "Phân loại: 100 trang, Mẫu: 05", "Kết thúc 31 thg 12 23:59:59", "48.000 đ"));
        items.add(new Item(R.drawable.notebook, "2", "Sổ Tay Ghi Chép giấy kraft Nâu Có Dòng Kẻ", "Phân loại: 100 trang, Mẫu: 05", "Kết thúc 31 thg 12 23:59:59", "48.000 đ"));

        adapter = new ItemAdapter(CartFragment.this, R.layout.cart_item_list, items);
        binding.lvItem.setAdapter(adapter);
    }

    @Override
    public void onResume() {
        showEmptyView();
        loadData();
        super.onResume();
    }

    private void showEmptyView() {
        if(binding.lvItem.getAdapter().isEmpty()){
            binding.imvEmpty.setVisibility(View.VISIBLE);
            binding.txtEmpty.setVisibility(View.VISIBLE);
        }
        else
        {
            binding.imvEmpty.setVisibility(View.GONE);
            binding.txtEmpty.setVisibility(View.GONE);
        }
    }
    private void replaceFragment(Fragment fragment){
        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frameContainer,fragment);
        fragmentTransaction.commit();
    }


    public void plusItem(Item item){
        int number = Integer.parseInt(item.getItemNumber().toString()) + 1;
        item.setItemNumber(String.valueOf(number));;
    }
    public void minusItem(Item item){
        int number = Integer.parseInt(item.getItemNumber().toString()) - 1;
        if(Integer.parseInt(item.getItemNumber().toString()) > 0){
            item.setItemNumber(String.valueOf(number));
        }
    }
}