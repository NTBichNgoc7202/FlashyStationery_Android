package com.race.flashystationery;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NavUtils;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.race.adapters.AddressAdapter;
import com.race.flashystationery.databinding.ActivityAddressListBinding;
import com.race.models.Address;

import java.util.ArrayList;

public class AddressListActivity extends AppCompatActivity {

    ActivityAddressListBinding binding;
    AddressAdapter adapter;
    ArrayList<Address> addresses;
    AddressDatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_address_list);

        binding = ActivityAddressListBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        getSupportActionBar().setTitle("Sổ địa chỉ");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        createDb();
        loadData();
        addEvents();
    }

    private void addEvents() {
        binding.txtAddAddress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(AddressListActivity.this,
                        AddAddressActivity.class));
            }
        });
    }

    private void createDb() {
        db = new AddressDatabaseHelper(AddressListActivity.this);
        db.createSampleData();
    }

    private void loadData() {
        addresses = new ArrayList<>();
        Cursor c = db.getData();
        while (c.moveToNext()){
            addresses.add(new Address(c.getString(1),c.getString(2),
                    c.getString(4),c.getString(3),c.getString(5),c.getInt(6)));
        }
        c.close();

        adapter = new AddressAdapter(AddressListActivity.this,R.layout.address_listview,
                addresses);
        binding.lvAddress.setAdapter(adapter);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                this.finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}