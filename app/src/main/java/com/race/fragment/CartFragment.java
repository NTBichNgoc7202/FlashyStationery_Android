package com.race.fragment;

import android.app.Dialog;
import android.content.Intent;
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
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.race.adapters.ItemAdapter;
import com.race.adapters.ItemModelAdapter;
import com.race.adapters.RebuyItemAdapter;
import com.race.flashystationery.ProductActivity;
import com.race.flashystationery.R;
import com.race.flashystationery.databinding.ActivityCartBinding;
import com.race.flashystationery.databinding.FragmentCartBinding;
import com.race.models.Item;
import com.race.models.ItemModel;
import com.race.models.RebuyItem;

import java.util.ArrayList;


public class CartFragment extends Fragment {

    FragmentCartBinding binding;
    ArrayList<Item> fullItems;
    ArrayList<RebuyItem> rebuyItems;
    ArrayList<ItemModel> itemModels;
    ItemAdapter fullAdapter;
    RebuyItemAdapter rebuyAdapter;
    ItemModelAdapter modelAdapter;
    TextView txtCartFull, txtCartRebuy;
    BottomSheetDialog bottomSheetDialog;

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
        loadFullView();
        loadFullData();
        return view;

    }


    public void addEvents() {
        txtCartRebuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadRebuyData();
                loadRebuyView();
            }
        });
        txtCartFull.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadFullView();
                loadFullData();
            }
        });
    }


    @Override
    public void onResume() {
        showEmptyView();
        super.onResume();
    }

    private void showEmptyView() {
        if (binding.lvItem.getAdapter().isEmpty()) {
            binding.imvEmpty.setVisibility(View.VISIBLE);
            binding.txtEmpty.setVisibility(View.VISIBLE);
        } else {
            binding.imvEmpty.setVisibility(View.GONE);
            binding.txtEmpty.setVisibility(View.GONE);
        }
    }
//    private void replaceFragment(Fragment fragment){
//        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
//        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
//        fragmentTransaction.replace(R.id.frameContainer,fragment);
//        fragmentTransaction.commit();
//    }

    //Full Item
    private void loadFullData() {
        fullItems = new ArrayList<>();
        fullItems.add(new Item(R.drawable.notebook, "1", "Sổ Tay Ghi Chép giấy kraft Nâu Có Dòng Kẻ", "Phân loại: 100 trang, Mẫu: 05", "Kết thúc 31 thg 12 23:59:59", 48000));
        fullItems.add(new Item(R.drawable.notebook, "2", "Sổ Tay Ghi Chép giấy kraft Nâu Có Dòng Kẻ", "Phân loại: 100 trang, Mẫu: 05", "Kết thúc 31 thg 12 23:59:59", 48000));

        fullAdapter = new ItemAdapter(CartFragment.this, R.layout.cart_item_list, fullItems);
        binding.lvItem.setAdapter(fullAdapter);
    }

    private void loadFullView() {
        txtCartFull.setBackgroundResource(R.drawable.header_activate);
        txtCartRebuy.setBackgroundResource(R.drawable.header_disable);
        txtCartFull.setTextColor(Color.parseColor("#5d5c78"));
        txtCartRebuy.setTextColor(Color.parseColor("#66000000"));
    }

    public void plusItem(Item item) {
        int number = Integer.parseInt(item.getItemNumber().toString()) + 1;
        item.setItemNumber(String.valueOf(number));
        ;
    }

    public void minusItem(Item item) {
        int number = Integer.parseInt(item.getItemNumber().toString()) - 1;
        if (Integer.parseInt(item.getItemNumber().toString()) > 0) {
            item.setItemNumber(String.valueOf(number));
        }
    }

    //Rebuy Item
    private void loadRebuyData() {
        rebuyItems = new ArrayList<>();
        rebuyItems.add(new RebuyItem(R.drawable.notebook, "1", "Sổ Tay Ghi Chép giấy kraft Nâu Có Dòng Kẻ", "Phân loại: 100 trang, Mẫu: 05", 48000));
        rebuyItems.add(new RebuyItem(R.drawable.notebook, "2", "Sổ Tay Ghi Chép giấy kraft Nâu Có Dòng Kẻ", "Phân loại: 100 trang, Mẫu: 05", 48000));

        rebuyAdapter = new RebuyItemAdapter(CartFragment.this, R.layout.rebuy_item_list, rebuyItems);
        binding.lvItem.setAdapter(rebuyAdapter);
    }
    private void loadRebuyView() {
        txtCartFull.setBackgroundResource(R.drawable.header_disable);
        txtCartRebuy.setBackgroundResource(R.drawable.header_activate);
        txtCartRebuy.setTextColor(Color.parseColor("#5d5c78"));
        txtCartFull.setTextColor(Color.parseColor("#66000000"));
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

    public void createBottomSheetCategory(Item item) {
        if (bottomSheetDialog == null) {
            bottomSheetDialog = new BottomSheetDialog(this.getActivity());
            bottomSheetDialog.setContentView(R.layout.show_category_dialog);
            ImageView imvSelectedItem;
            TextView txtSelectedPrice, txtSelectedCategory;
            RadioButton rad80, rad100;
            Button btnConfirm, btnShowDetail;
            GridView gvItemModel;

            imvSelectedItem = bottomSheetDialog.findViewById(R.id.imv_SelectedItem);
            txtSelectedPrice = bottomSheetDialog.findViewById(R.id.txt_SelectedPrice);
            txtSelectedCategory = bottomSheetDialog.findViewById(R.id.txt_SelectedCategory);
            btnConfirm = bottomSheetDialog.findViewById(R.id.btn_Confirm);
            btnShowDetail = bottomSheetDialog.findViewById(R.id.btn_ShowDetail);
            rad80 = bottomSheetDialog.findViewById(R.id.rad_80);
            rad100 = bottomSheetDialog.findViewById(R.id.rad_100);
            gvItemModel = bottomSheetDialog.findViewById(R.id.gv_ItemModel);

            imvSelectedItem.setImageResource(item.getItemThumb());
            txtSelectedCategory.setText(item.getItemCategory());
            txtSelectedPrice.setText(item.getItemPrice() + " đ");

            //load model data
            itemModels = new ArrayList<>();
            itemModels.add(new ItemModel(R.drawable.nb1, "1"));
            itemModels.add(new ItemModel(R.drawable.nb2, "2"));
            itemModels.add(new ItemModel(R.drawable.nb3, "3"));
            itemModels.add(new ItemModel(R.drawable.nb4, "4"));
            itemModels.add(new ItemModel(R.drawable.nb5, "5"));
            itemModels.add(new ItemModel(R.drawable.nb6, "6"));

            modelAdapter = new ItemModelAdapter(CartFragment.this, R.layout.item_model_list, itemModels);
            gvItemModel.setAdapter(modelAdapter);

            btnConfirm.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    bottomSheetDialog.dismiss();
                }
            });
            btnShowDetail.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(getActivity(), ProductActivity.class);
                    startActivity(intent);
                }
            });
        }
        bottomSheetDialog.show();
    }
}