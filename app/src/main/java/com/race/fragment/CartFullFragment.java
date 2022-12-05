package com.race.fragment;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.MenuItemCompat;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.race.adapters.ItemAdapter;
import com.race.adapters.ItemModelAdapter;
import com.race.flashystationery.AddressListActivity;
import com.race.flashystationery.OrderPaymentActivity;
import com.race.flashystationery.ProductActivity;
import com.race.flashystationery.R;
import com.race.flashystationery.databinding.FragmentCartFullBinding;
import com.race.models.Item;
import com.race.models.ItemModel;

import java.util.ArrayList;


public class CartFullFragment extends Fragment {

    FragmentCartFullBinding binding;
    ArrayList<Item> fullItems;
    ArrayList<ItemModel> itemModels;
    ItemAdapter fullAdapter;
    ItemModelAdapter modelAdapter;
    BottomSheetDialog bottomSheetDialog;

    public CartFullFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        ((AppCompatActivity) getActivity()).getSupportActionBar().setDisplayShowTitleEnabled(true);
        ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle("Giỏ hàng của tôi");

        setHasOptionsMenu(true);

        binding = FragmentCartFullBinding.inflate(inflater, container, false);
        View view = binding.getRoot();

//        loadFullView();
        loadFullData();
        return view;

    }

    public void deleteItem() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Xác nhận xóa");
        builder.setIcon(android.R.drawable.ic_delete);
        builder.setMessage("Bạn có chắc muốn xóa sản phẩm?");
        builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                //Delete Item
            }
        });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });
        builder.show();
    }


    public void addEvents() {
        binding.includeCartFooter.btnConfirmPay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), OrderPaymentActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onResume() {
        showEmptyView();
        loadFullData();
        addEvents();
        super.onResume();
    }

    private void showEmptyView() {
        if (binding.lvItem.getAdapter().isEmpty()) {
            binding.imvEmpty.setVisibility(View.VISIBLE);
            binding.txtEmpty.setVisibility(View.VISIBLE);
            binding.includeCartFooter.getRoot().setVisibility(View.GONE);
        } else {
            binding.imvEmpty.setVisibility(View.GONE);
            binding.txtEmpty.setVisibility(View.GONE);
            binding.includeCartFooter.getRoot().setVisibility(View.VISIBLE);
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
        fullItems.add(new Item(R.drawable.notebook, "1", "Sổ Tay Ghi Chép giấy kraft Nâu Có Dòng Kẻ", "Phân loại: 100 trang, Mẫu: 05", "SALE: kết thúc 31 thg 12 23:59:59", 48000));
        fullItems.add(new Item(R.drawable.notebook4, "2", "Sổ Tay Ghi Chép giấy kraft Nâu Có Dòng Kẻ", "Phân loại: 100 trang, Mẫu: 05", null, 96000));
        fullItems.add(new Item(R.drawable.notebook, "1", "Sổ Tay Ghi Chép giấy kraft Nâu Có Dòng Kẻ", "Phân loại: 100 trang, Mẫu: 05", "SALE: kết thúc 31 thg 12 23:59:59", 48000));
        fullItems.add(new Item(R.drawable.notebook4, "2", "Sổ Tay Ghi Chép giấy kraft Nâu Có Dòng Kẻ", "Phân loại: 100 trang, Mẫu: 05", null, 96000));
        fullItems.add(new Item(R.drawable.notebook, "1", "Sổ Tay Ghi Chép giấy kraft Nâu Có Dòng Kẻ", "Phân loại: 100 trang, Mẫu: 05", "SALE: kết thúc 31 thg 12 23:59:59", 48000));
        fullItems.add(new Item(R.drawable.notebook4, "2", "Sổ Tay Ghi Chép giấy kraft Nâu Có Dòng Kẻ", "Phân loại: 100 trang, Mẫu: 05", null, 96000));

        fullAdapter = new ItemAdapter(CartFullFragment.this, R.layout.cart_item_list, fullItems);
        binding.lvItem.setAdapter(fullAdapter);
    }

//    private void loadFullView() {
//        txtCartFull.setBackgroundResource(R.drawable.header_activate);
//        txtCartRebuy.setBackgroundResource(R.drawable.header_disable);
//        txtCartFull.setTextColor(Color.parseColor("#5d5c78"));
//        txtCartRebuy.setTextColor(Color.parseColor("#66000000"));
//    }

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
//    private void loadRebuyData() {
//        rebuyItems = new ArrayList<>();
//        rebuyItems.add(new RebuyItem(R.drawable.notebook, "1", "Sổ Tay Ghi Chép giấy kraft Nâu Có Dòng Kẻ", "Phân loại: 100 trang, Mẫu: 05", 48000));
//        rebuyItems.add(new RebuyItem(R.drawable.notebook, "2", "Sổ Tay Ghi Chép giấy kraft Nâu Có Dòng Kẻ", "Phân loại: 100 trang, Mẫu: 05", 48000));
//
//        rebuyAdapter = new RebuyItemAdapter(CartFragment.this, R.layout.rebuy_item_list, rebuyItems);
//        binding.lvItem.setAdapter(rebuyAdapter);
//    }
//    private void loadRebuyView() {
//        txtCartFull.setBackgroundResource(R.drawable.header_disable);
//        txtCartRebuy.setBackgroundResource(R.drawable.header_activate);
//        txtCartRebuy.setTextColor(Color.parseColor("#5d5c78"));
//        txtCartFull.setTextColor(Color.parseColor("#66000000"));
//        binding.includeFooter.getRoot().setVisibility(View.GONE);
//    }

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

            modelAdapter = new ItemModelAdapter(CartFullFragment.this, R.layout.item_model_list, itemModels);
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