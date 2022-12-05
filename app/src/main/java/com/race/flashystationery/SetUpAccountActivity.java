package com.race.flashystationery;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import org.w3c.dom.Text;

public class SetUpAccountActivity extends AppCompatActivity {

    private TextView txtShowFullName, txtShowPassWordHint,txtShowEmail, txtShowPhoneNumber, txtShowGender, txtShowDOB, txtShowSocialMedia, txtShowAccountBank;
    private ProgressBar progressBar;
    private String fullName, eMail, doB, gender, phoneNumber;
    private ImageView imageView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_up_account);

        txtShowFullName = findViewById(R.id.txt_ShowFullName);
        txtShowPassWordHint = findViewById(R.id.txt_ShowPasswordHint);
        txtShowEmail = findViewById(R.id.txt_ShowEmail);
        txtShowPhoneNumber = findViewById(R.id.txt_ShowPhoneNumber);
        txtShowGender = findViewById(R.id.txt_ShowGender);
        txtShowDOB = findViewById(R.id.txt_ShowDoB);
        txtShowSocialMedia = findViewById(R.id.txt_ShowSocialMedia);
        txtShowAccountBank = findViewById(R.id.txt_ShowAccountBank);
        progressBar = findViewById(R.id.processBar);
    }
}