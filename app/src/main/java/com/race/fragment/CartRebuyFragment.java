package com.race.fragment;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.race.adapters.RebuyItemAdapter;
import com.race.flashystationery.R;
import com.race.flashystationery.databinding.FragmentCartRebuyBinding;
import com.race.models.RebuyItem;

import java.util.ArrayList;

public class CartRebuyFragment extends Fragment {

    FragmentCartRebuyBinding binding;
    ArrayList<RebuyItem> rebuyItems;
    RebuyItemAdapter rebuyAdapter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ((AppCompatActivity) getActivity()).getSupportActionBar()
                .setDisplayShowTitleEnabled(false);
        setHasOptionsMenu(true);

        binding = FragmentCartRebuyBinding.inflate(inflater, container, false);
        View view = binding.getRoot();
        loadRebuyData();
        return view;
    }
    private void loadRebuyData() {
        rebuyItems = new ArrayList<>();
        rebuyItems.add(new RebuyItem(R.drawable.notebook, "1", "Sổ Tay Ghi Chép giấy kraft Nâu Có Dòng Kẻ", "Phân loại: 100 trang, Mẫu: 05", 48000));
        rebuyItems.add(new RebuyItem(R.drawable.notebook, "2", "Sổ Tay Ghi Chép giấy kraft Nâu Có Dòng Kẻ", "Phân loại: 100 trang, Mẫu: 05", 48000));

        rebuyAdapter = new RebuyItemAdapter(CartRebuyFragment.this, R.layout.rebuy_item_list, rebuyItems);
        binding.lvRebuyItem.setAdapter(rebuyAdapter);
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
        super.onResume();
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