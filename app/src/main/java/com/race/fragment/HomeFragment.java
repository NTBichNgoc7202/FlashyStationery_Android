package com.race.fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.MenuItemCompat;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.SearchView;
import android.widget.TextView;

import com.race.adapters.BannerAdapter;
import com.race.adapters.HotProductAdapter;
import com.race.adapters.ItemNoteBookAdapter;
import com.race.flashystationery.Banner;
import com.race.flashystationery.NoteBookActivity;
import com.race.flashystationery.NotificationActivity;
import com.race.flashystationery.R;
import com.race.flashystationery.databinding.FragmentHomeBinding;
import com.race.models.HotProduct;
import com.race.models.ItemNoteBook;

import java.util.ArrayList;
import java.util.List;

import me.relex.circleindicator.CircleIndicator;


public class HomeFragment extends Fragment {

    FragmentHomeBinding binding;
    ViewPager viewPager;
    CircleIndicator indicator;
    BannerAdapter bannerAdapter;

    HotProductAdapter hotProductAdapter;
    ArrayList<HotProduct> hotProductArrayList;

    ItemNoteBookAdapter itemNoteBookAdapter;
    ArrayList<ItemNoteBook> itemNoteBookArrayList;

    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        ((AppCompatActivity) getActivity()).getSupportActionBar()
                        .setDisplayShowTitleEnabled(false);
        setHasOptionsMenu(true);

        //return inflater.inflate(R.layout.fragment_home, container, false);


        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View view = binding.getRoot();

        viewPager = binding.viewpagerbanner;
        indicator = binding.ccIndicatorBanner;

        bannerAdapter = new BannerAdapter(HomeFragment.this, getListBanners());
        viewPager.setAdapter(bannerAdapter);

        indicator.createIndicators(3,0);
        indicator.animatePageSelected(2);
        indicator.setViewPager(viewPager);
        bannerAdapter.registerDataSetObserver(indicator.getDataSetObserver());

        loadHotProduct();
        loadSuggestProduct();
        addEvents();

        return view;

    }

    private void loadHotProduct() {
        hotProductArrayList = new ArrayList<>();
        hotProductArrayList.add(new HotProduct(R.drawable.soloxodona4,
                "Sổ lò xo kép Caro 200 trang B5", "Đã bán 200/tháng",
                45000.0 ));
        hotProductArrayList.add(new HotProduct(R.drawable.book1,
                "Vở kẻ ngang Click cỡ A4 260 trang", "Đã bán 70/tháng",
                29000.0 ));
        hotProductArrayList.add(new HotProduct(R.drawable.ruotsocongcaro100to,
                "Ruột sổ còng Caro B5 120/76 - 100 tờ", "Đã bán 60/tháng",
                35000.0 ));
        hotProductArrayList.add(new HotProduct(R.drawable.butmura,
                "Bút bi gel Mura ngòi 0.5mm", "Đã bán 100/tháng",
                8000.0 ));

        hotProductAdapter = new HotProductAdapter(getActivity(),
                R.layout.hot_product_list, hotProductArrayList);
        binding.gvHotProduct.setAdapter(hotProductAdapter);


    }

    private void loadSuggestProduct() {
        itemNoteBookArrayList = new ArrayList<>();
        itemNoteBookArrayList.add(new ItemNoteBook(R.drawable.planneritem,
                "Sổ kế hoạch lò xo kép Study Planner B5 160 trang",
                75000.0));
        itemNoteBookArrayList.add(new ItemNoteBook(R.drawable.notebook2,
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


    }

    private List<Banner> getListBanners() {
        List<Banner> list = new ArrayList<>();
        list.add(new Banner(R.drawable.banner1));
        list.add(new Banner(R.drawable.banner2));
        list.add(new Banner(R.drawable.banner3));
        return list;
    }

    private void addEvents() {
        binding.imvNoteBook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(),
                        NoteBookActivity.class);
                intent.putExtra("noteList", "notebook");
                startActivity(intent);
            }
        });
        binding.imvBook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), NoteBookActivity.class);
                intent.putExtra("noteList", "book");
                startActivity(intent);
            }
        });
        binding.imvLearningTool.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), NoteBookActivity.class);
                intent.putExtra("noteList", "learningtool");
                startActivity(intent);
            }
        });
        binding.imvFiles.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), NoteBookActivity.class);
                intent.putExtra("noteList", "files");
                startActivity(intent);
            }
        });

    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        ((AppCompatActivity) getActivity()).getMenuInflater().inflate(R.menu.home_menu, menu);

        MenuItem searchItem = menu.findItem(R.id.app_Bar_Search);
        SearchView searchView = (SearchView) MenuItemCompat.getActionView(searchItem);
        searchView.setQueryHint("Bạn muốn tìm gì?");
        searchView.setIconifiedByDefault(false);
        searchView.setBackgroundResource(R.drawable.round_border_finding);

        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.app_Bar_Search){
            //Opening Search Activity
            //startActivity(new Intent(getActivity(), NotificationActivity.class));

        } else if (item.getItemId() == R.id.app_Bar_Notify){
            //Opening Notification Act
            startActivity(new Intent(getActivity(), NotificationActivity.class));
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}