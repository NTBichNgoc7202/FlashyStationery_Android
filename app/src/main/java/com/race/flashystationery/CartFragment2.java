package com.race.flashystationery;

import android.graphics.Color;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.race.adapters.ItemAdapter;
import com.race.adapters.RebuyItemAdapter;
import com.race.flashystationery.databinding.FragmentCart2Binding;
import com.race.flashystationery.databinding.FragmentCartBinding;
import com.race.models.Item;
import com.race.models.RebuyItem;

import java.util.ArrayList;

public class CartFragment2 extends Fragment {

    FragmentCart2Binding binding;
    ArrayList<RebuyItem> items;
    RebuyItemAdapter adapter;
    TextView txtCartFull, txtCartRebuy;

    public CartFragment2() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ((AppCompatActivity) getActivity()).getSupportActionBar()
                .setDisplayShowTitleEnabled(false);
        setHasOptionsMenu(true);

        // Inflate the layout for this fragment

        binding = FragmentCart2Binding.inflate(inflater, container, false);
        View view = binding.getRoot();
        txtCartFull = view.findViewById(R.id.txt_CartFull);
        txtCartRebuy = view.findViewById(R.id.txt_CartRebuy);
        addEvents();
        loadData();

        return view;
    }

    private void addEvents() {
        txtCartFull.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                replaceFragment(new CartFragment());
            }
        });
    }

    @Override
    public void onResume() {
        showEmptyView();
        super.onResume();
    }
    private void loadView() {
        txtCartFull.setBackgroundResource(R.drawable.header_disable);
        txtCartRebuy.setBackgroundResource(R.drawable.header_activate);
        txtCartRebuy.setTextColor(Color.parseColor("#5d5c78"));
        txtCartFull.setTextColor(Color.parseColor("#66000000"));
    }
    private void showEmptyView() {
        if (binding.lvReItem.getAdapter().isEmpty()) {
            binding.imvReEmpty.setVisibility(View.VISIBLE);
            binding.txtReEmpty.setVisibility(View.VISIBLE);
        } else {
            binding.imvReEmpty.setVisibility(View.GONE);
            binding.txtReEmpty.setVisibility(View.GONE);
        }
    }
    private void loadData() {
        items = new ArrayList<>();
        items.add(new RebuyItem(R.drawable.notebook, "1", "Sổ Tay Ghi Chép giấy kraft Nâu Có Dòng Kẻ", "Phân loại: 100 trang, Mẫu: 05",  "48.000 đ"));
        items.add(new RebuyItem(R.drawable.notebook, "2", "Sổ Tay Ghi Chép giấy kraft Nâu Có Dòng Kẻ", "Phân loại: 100 trang, Mẫu: 05",  "48.000 đ"));

        adapter = new RebuyItemAdapter(CartFragment2.this, R.layout.rebuy_item_list, items);
        binding.lvReItem.setAdapter(adapter);
    }

    public void plusItem(RebuyItem item){
        int number = Integer.parseInt(item.getReNumber().toString()) + 1;
        item.setReNumber(String.valueOf(number));;
    }
    public void minusItem(RebuyItem item){
        int number = Integer.parseInt(item.getReNumber().toString()) - 1;
        if(Integer.parseInt(item.getReNumber().toString()) > 0){
            item.setReNumber(String.valueOf(number));
        }
    }
    private void replaceFragment(Fragment fragment){
        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frameContainer,fragment);
        fragmentTransaction.commit();
    }
}