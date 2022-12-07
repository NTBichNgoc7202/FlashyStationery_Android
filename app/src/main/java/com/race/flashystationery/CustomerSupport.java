package com.race.flashystationery;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.race.flashystationery.databinding.ActivityAddressListBinding;
import com.race.flashystationery.databinding.ActivityCustomerSupportBinding;

public class CustomerSupport extends AppCompatActivity {
    public static final int REQUEST_CALL = 1;
    ActivityCustomerSupportBinding binding;
    String[] questions = {"Làm sao tôi có thể thay đổi địa chỉ giao hàng?", "Tôi có thể theo dõi đơn hàng của mình bằng cách nào?",
            "Sản phẩm không như tôi mong đợi, tôi có thể đổi trả như thế nào?",
            "Tại sao tôi không thể thanh toán được bằng thẻ ngân hàng?"};
    ArrayAdapter<String> adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_customer_support);
        binding = ActivityCustomerSupportBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        getSupportActionBar().setTitle("HỖ TRỢ KHÁCH HÀNG");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        addEvents();
        loadData();
    }



    private void addEvents() {
        binding.llChatSupport.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        binding.llCallSupport.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               makeCall();
            }
        });

        binding.llEmailSupport.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    Intent intent = new Intent(CustomerSupport.this, EmailSupportActivity.class);
                    startActivity(intent);
                }
        });

    }

    private void makeCall() {
        if (ActivityCompat.checkSelfPermission(CustomerSupport.this,
                Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(CustomerSupport.this, new String[] {Manifest.permission.CALL_PHONE}, REQUEST_CALL);}
        else
        {
            Intent intent = new Intent();
            intent.setAction(Intent.ACTION_CALL);
            intent.setData(Uri.parse("tel:0357887939"));
            startActivity(intent);
        }
    }

    private void loadData() {
    adapter = new ArrayAdapter<String>(CustomerSupport.this, android.R.layout.simple_list_item_1,questions);
    binding.lvQuestion.setAdapter(adapter);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {

        if (requestCode == REQUEST_CALL) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            makeCall();
            }
            else {
                Toast.makeText(this, "Từ chối cho phép gọi", Toast.LENGTH_SHORT).show();
            }

        }

        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }
}