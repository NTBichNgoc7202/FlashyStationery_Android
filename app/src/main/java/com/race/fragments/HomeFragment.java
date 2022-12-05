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
import android.widget.SearchView;

import com.race.flashystationery.NotificationActivity;
import com.race.flashystationery.R;
import com.race.flashystationery.databinding.FragmentHomeBinding;


public class HomeFragment extends Fragment {

    FragmentHomeBinding binding;

    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        ((AppCompatActivity) getActivity()).getSupportActionBar().setDisplayShowTitleEnabled(false);

        setHasOptionsMenu(true);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View view = binding.getRoot();

        return view;

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

        } else if (item.getItemId() == R.id.app_Bar_Notify){
            startActivity(new Intent(getActivity(), NotificationActivity.class));
        }
        return super.onOptionsItemSelected(item);
    }
}