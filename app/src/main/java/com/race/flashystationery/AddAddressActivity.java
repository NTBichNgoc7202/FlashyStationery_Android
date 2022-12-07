package com.race.flashystationery;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

import com.race.flashystationery.databinding.ActivityAddAddressBinding;

import java.sql.DatabaseMetaData;

public class AddAddressActivity extends AppCompatActivity {

    ActivityAddAddressBinding binding;
    AddressDatabaseHelper db = AddressListActivity.db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_add_address);

        binding = ActivityAddAddressBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        getSupportActionBar().setTitle("Thêm địa chỉ mới");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        addEvents();
    }

    private void addEvents() {
        binding.btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String addressType = "Nhà riêng";
                if (binding.radHomeAddress.isChecked())
                    addressType = "Nhà riêng";
                else if (binding.radOfficeAddress.isChecked())
                    addressType = "Văn phòng";

                String defaultAddress = "";
                if (binding.chkDefaultAddress.isChecked())
                    defaultAddress = "x";

                db.execSql("INSERT INTO " + AddressDatabaseHelper.TBL_NAME + " VALUES(null, '"
                        + binding.edtAddressName.getText().toString() + "', '"
                        + binding.edtAddressPhone.getText().toString() + "', '"
                        + binding.edtAddress.getText().toString() + "', '"
                        + binding.edtAddressDetail.getText().toString() + "', '"
                        + addressType + "', '"
                        + defaultAddress + "')");
                finish();
            }
        });

        binding.btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                this.finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}