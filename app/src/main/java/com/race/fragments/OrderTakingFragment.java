package com.race.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.race.adapters.ItemNoteBookAdapter;
import com.race.flashystationery.OrderDetailActivity;
import com.race.flashystationery.R;
import com.race.flashystationery.databinding.FragmentOrderTakingBinding;
import com.race.models.ItemNoteBook;

import java.util.ArrayList;

public class OrderTakingFragment extends Fragment {

    FragmentOrderTakingBinding binding;
    ItemNoteBookAdapter itemNoteBookAdapter;
    ArrayList<ItemNoteBook> itemNoteBookArrayList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentOrderTakingBinding.inflate(inflater, container, false);
        View view = binding.getRoot();

        addEvents();
        loadSuggestProduct();
        return view;
    }

    private void loadSuggestProduct() {
        itemNoteBookArrayList = new ArrayList<>();
        itemNoteBookArrayList.add(new ItemNoteBook(R.drawable.planneritem,
                "Sổ kế hoạch lò xo kép Study Planner B5 160 trang",
                75000.0));
        itemNoteBookArrayList.add(new ItemNoteBook(R.drawable.socongbianhua,
                "Sổ Binder File Caro còng sắt B5 26 chấu 80 tờ",
                78000.0));
        itemNoteBookArrayList.add(new ItemNoteBook(R.drawable.notebook1,
                "Sổ lò xo kép Caro 200 trang B5 giấy dày chống lem",
                45000.0));
        itemNoteBookArrayList.add(new ItemNoteBook(R.drawable.soloxodona4,
                "Sổ lò xo đơn Caro (6x6)mm 200 trang A4",
                48000.0));
        itemNoteBookArrayList.add(new ItemNoteBook(R.drawable.soloxodona4300tr,
                "Sổ lò xo đơn Caro (6x6)mm 300 trang A4",
                69000.0));
        itemNoteBookArrayList.add(new ItemNoteBook(R.drawable.soloxokepdot200tr,
                "Sổ lò xo kép Dot Grid B5 200 trang",
                51000.0));
        itemNoteBookArrayList.add(new ItemNoteBook(R.drawable.soloxodot,
                "Sổ lò xo kép Dot Grid B5 200 trang",
                49000.0));
        itemNoteBookArrayList.add(new ItemNoteBook(R.drawable.sovecaocap40to,
                "Sổ vẽ lò xo đa năng Creative Art A5 40 tờ",
                50000.0));
        itemNoteBookArrayList.add(new ItemNoteBook(R.drawable.ruotsocongdot100to,
                "Ruột sổ còng Dot Grid B5 120/76 - 100 tờ",
                34000.0));
        itemNoteBookArrayList.add(new ItemNoteBook(R.drawable.ruotsocongcaro100to,
                "Ruột sổ còng Caro B5 120/76 - 100 tờ",
                34000.0));
        //bannerAdapter = new BannerAdapter(HomeFragment.this, getListBanners());

        itemNoteBookAdapter = new ItemNoteBookAdapter(getActivity(),
                R.layout.notebook_item_list, itemNoteBookArrayList);
        binding.gvSuggestProduct.setAdapter(itemNoteBookAdapter);
        binding.gvSuggestProduct.setExpanded(true);
    }

    private void addEvents() {
        binding.llOrderTaking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), OrderDetailActivity.class);
                intent.putExtra("status","taking");
                startActivity(intent);
            }
        });
    }
}