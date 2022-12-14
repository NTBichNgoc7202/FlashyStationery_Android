package com.race.fragments;

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
import android.widget.AdapterView;
import android.widget.SearchView;

import com.race.adapters.BannerAdapter;
import com.race.adapters.HotProductAdapter;
import com.race.adapters.ItemNoteBookAdapter;
import com.race.flashystationery.SearchActivity;
import com.race.flashystationery.NotificationActivity;
import com.race.models.Banner;
import com.race.flashystationery.NoteBookActivity;
//import com.race.flashystationery.NotificationActivity;
import com.race.flashystationery.ProductActivity;
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

//        return inflater.inflate(R.layout.fragment_home, container, false);
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
                "S??? l?? xo k??p Caro 200 trang B5", "???? b??n 200/th??ng",
                45000.0 ));
        hotProductArrayList.add(new HotProduct(R.drawable.book1,
                "V??? k??? ngang Click c??? A4 260 trang", "???? b??n 70/th??ng",
                29000.0 ));
        hotProductArrayList.add(new HotProduct(R.drawable.ruotsocongcaro100to,
                "Ru???t s??? c??ng Caro B5 120/76 - 100 t???", "???? b??n 60/th??ng",
                35000.0 ));
        hotProductArrayList.add(new HotProduct(R.drawable.butmura,
                "B??t bi gel Mura ng??i 0.5mm", "???? b??n 100/th??ng",
                8000.0 ));

        hotProductAdapter = new HotProductAdapter(getActivity(),
                R.layout.hot_product_list, hotProductArrayList);
        binding.gvHotProduct.setAdapter(hotProductAdapter);
    }
    private void loadSuggestProduct() {
        itemNoteBookArrayList = new ArrayList<>();
        itemNoteBookArrayList.add(new ItemNoteBook(R.drawable.planneritem,
                "S??? k??? ho???ch l?? xo k??p Study Planner B5 160 trang",
                75000.0));
        itemNoteBookArrayList.add(new ItemNoteBook(R.drawable.socongbianhua,
                "S??? Binder File Caro c??ng s???t B5 26 ch???u 80 t???",
                78000.0));
        itemNoteBookArrayList.add(new ItemNoteBook(R.drawable.notebook1,
                "S??? l?? xo k??p Caro 200 trang B5 gi???y d??y ch???ng lem",
                45000.0));
        itemNoteBookArrayList.add(new ItemNoteBook(R.drawable.soloxodona4,
                "S??? l?? xo ????n Caro (6x6)mm 200 trang A4",
                48000.0));
        itemNoteBookArrayList.add(new ItemNoteBook(R.drawable.soloxodona4300tr,
                "S??? l?? xo ????n Caro (6x6)mm 300 trang A4",
                69000.0));
        itemNoteBookArrayList.add(new ItemNoteBook(R.drawable.soloxokepdot200tr,
                "S??? l?? xo k??p Dot Grid B5 200 trang",
                51000.0));
        itemNoteBookArrayList.add(new ItemNoteBook(R.drawable.soloxodot,
                "S??? l?? xo k??p Dot Grid B5 200 trang",
                49000.0));
        itemNoteBookArrayList.add(new ItemNoteBook(R.drawable.sovecaocap40to,
                "S??? v??? l?? xo ??a n??ng Creative Art A5 40 t???",
                50000.0));
        itemNoteBookArrayList.add(new ItemNoteBook(R.drawable.ruotsocongdot100to,
                "Ru???t s??? c??ng Dot Grid B5 120/76 - 100 t???",
                34000.0));
        itemNoteBookArrayList.add(new ItemNoteBook(R.drawable.ruotsocongcaro100to,
                "Ru???t s??? c??ng Caro B5 120/76 - 100 t???",
                34000.0));
        //bannerAdapter = new BannerAdapter(HomeFragment.this, getListBanners());

        itemNoteBookAdapter = new ItemNoteBookAdapter(getActivity(),
                R.layout.notebook_item_list, itemNoteBookArrayList);
        binding.gvSuggestProduct.setAdapter(itemNoteBookAdapter);
        binding.gvSuggestProduct.setExpanded(true);
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

        binding.gvSuggestProduct.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                startActivity(new Intent(getActivity(), ProductActivity.class));
            }
        });

    }


    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        ((AppCompatActivity) getActivity()).getMenuInflater().inflate(R.menu.home_menu, menu);

        MenuItem searchItem = menu.findItem(R.id.app_Bar_Search);
        SearchView searchView = (SearchView) MenuItemCompat.getActionView(searchItem);
        searchView.setQueryHint("B???n mu???n t??m g???");
        searchView.setIconifiedByDefault(false);
        searchView.setBackgroundResource(R.drawable.round_border_finding);
//        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
//            @Override
//            public boolean onQueryTextSubmit(String s) {
//                return false;
//            }
//
//            @Override
//            public boolean onQueryTextChange(String s) {
//                return false;
//            }
//        });
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.app_Bar_Notify)
            startActivity(new Intent(getActivity(), NotificationActivity.class));
        else if (item.getItemId() == R.id.app_Bar_Search) {
            item.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
                @Override
                public boolean onMenuItemClick(MenuItem menuItem) {
                    startActivity(new Intent(getActivity(), SearchActivity.class));
                    return true;
                }
            });
        }
        return super.onOptionsItemSelected(item);
    }

}