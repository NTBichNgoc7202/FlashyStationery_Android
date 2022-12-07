package com.race.flashystationery;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.race.adapters.AddressAdapter;
import com.race.flashystationery.databinding.ActivitySetUpAccountBinding;
import com.race.models.Address;
import com.race.models.Register;

import java.util.ArrayList;

public class SetUpAccountActivity extends AppCompatActivity {
    @NonNull ActivitySetUpAccountBinding binding;
    RegisterDatabaseHelper adapter;
    ArrayList<Register> registers;
    public static RegisterDatabaseHelper dB;

//    private TextView txtShowFullName, txtShowPassWordHint,txtShowEmail, txtShowPhoneNumber, txtShowGender, txtShowDOB, txtShowSocialMedia, txtShowAccountBank;
//    private ProgressBar progressBar;
//    private String fullName, eMail, doB, gender, phoneNumber;
//    private ImageView imageView;


//    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_up_account);

        binding = ActivitySetUpAccountBinding.inflate(getLayoutInflater());

        getSupportActionBar().setTitle("Tài khoản");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        createDb();
        loadData();


//        txtShowFullName = findViewById(R.id.txt_ShowFullName);
//        txtShowPassWordHint = findViewById(R.id.txt_ShowPasswordHint);
//        txtShowEmail = findViewById(R.id.txt_ShowEmail);
//        txtShowPhoneNumber = findViewById(R.id.txt_ShowPhoneNumber);
//        txtShowGender = findViewById(R.id.txt_ShowGender);
//        txtShowDOB = findViewById(R.id.txt_ShowDoB);
//        txtShowSocialMedia = findViewById(R.id.txt_ShowSocialMedia);
//        txtShowAccountBank = findViewById(R.id.txt_ShowAccountBank);
//        progressBar = findViewById(R.id.processBar);
    }


    private void loadData() {

        registers = new ArrayList<>();
        registers.clear();

        Cursor c = dB.getData();

        if (c.getCount() == 0)
            Toast.makeText(SetUpAccountActivity.this, "No data to load",
                    Toast.LENGTH_SHORT).show();
        else {
            while (c.moveToNext()){
                registers.add(new Register(c.getInt(0), c.getString(1),c.getString(2),
                        c.getString(3),c.getString(4),c.getString(5),c.getString(6)));
            }
            c.close();
        }
    }

    private void createDb() {
        dB = new RegisterDatabaseHelper(SetUpAccountActivity.this);
        dB.createSampleData();
    }
}