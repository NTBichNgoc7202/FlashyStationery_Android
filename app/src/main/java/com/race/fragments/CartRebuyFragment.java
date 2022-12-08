package com.race.fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.MenuItemCompat;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.race.adapters.ItemNoteBookAdapter;
import com.race.adapters.RebuyItemAdapter;
import com.race.flashystationery.AddressListActivity;
import com.race.flashystationery.R;
import com.race.flashystationery.databinding.FragmentCartRebuyBinding;
import com.race.models.ItemNoteBook;
import com.race.models.RebuyItem;

import java.util.ArrayList;

public class CartRebuyFragment extends Fragment {

    FragmentCartRebuyBinding binding;
    ArrayList<RebuyItem> rebuyItems;
    RebuyItemAdapter rebuyAdapter;

    ItemNoteBookAdapter itemNoteBookAdapter;
    ArrayList<ItemNoteBook> itemNoteBookArrayList;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ((AppCompatActivity) getActivity()).getSupportActionBar().setDisplayShowTitleEnabled(true);
        ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle("Giỏ hàng của tôi");

        setHasOptionsMenu(true);

        binding = FragmentCartRebuyBinding.inflate(inflater, container, false);
        View view = binding.getRoot();
        loadRebuyData();

        return view;
    }
    private void loadRebuyData() {
        rebuyItems = new ArrayList<>();
//        rebuyItems.add(new RebuyItem(R.drawable.notebook, "1", "Sổ Tay Ghi Chép giấy kraft Nâu Có Dòng Kẻ", "Phân loại: 100 trang, Mẫu: 05", 48000));
//        rebuyItems.add(new RebuyItem(R.drawable.notebook, "2", "Sổ Tay Ghi Chép giấy kraft Nâu Có Dòng Kẻ", "Phân loại: 100 trang, Mẫu: 05", 48000));

        rebuyAdapter = new RebuyItemAdapter(CartRebuyFragment.this, R.layout.rebuy_item_list, rebuyItems);
        binding.lvRebuyItem.setAdapter(rebuyAdapter);
        binding.lvRebuyItem.setExpanded(true);
    }
    public void plusItem(RebuyItem item) {
        int number = Integer.parseInt(item.getReNumber().toString()) + 1;
        item.setReNumber(String.valueOf(number));
        ;
    }

    public void minusItem(RebuyItem item) {
        int number = Integer.parseInt(item.getReNumber().toString()) - 1;
        if (Integer.parseInt(item.getReNumber().toString()) > 0) {
            item.setReNumber(String.valueOf(number));
        }
    }
    public void onResume() {
        showEmptyView();
        loadSuggestProduct();
        super.onResume();
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
        binding.gvCartRebuySuggestProduct.setAdapter(itemNoteBookAdapter);
        binding.gvCartRebuySuggestProduct.setExpanded(true);
    }

    private void showEmptyView() {
        if (binding.lvRebuyItem.getAdapter().isEmpty()) {
            binding.imvReEmpty.setVisibility(View.VISIBLE);
            binding.txtReEmpty.setVisibility(View.VISIBLE);
        } else {
            binding.imvReEmpty.setVisibility(View.GONE);
            binding.txtReEmpty.setVisibility(View.GONE);
        }
    }
}