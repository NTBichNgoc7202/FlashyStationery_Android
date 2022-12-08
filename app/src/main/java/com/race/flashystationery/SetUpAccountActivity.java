package com.race.flashystationery;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.race.adapters.AddressAdapter;
import com.race.models.Address;
import com.race.models.Register;

import java.util.ArrayList;

public class SetUpAccountActivity extends AppCompatActivity {
//    @NonNull ActivitySetUpAccountBinding binding;
//    RegisterDatabaseHelper adapter;
//    ArrayList<Register> registers;
//    public static RegisterDatabaseHelper dB;

    private TextView txtShowFullName, txtShowPassWordHint,txtShowEmail, txtShowPhoneNumber, txtShowGender, txtShowDOB, txtShowSocialMedia, txtShowAccountBank;
    private ProgressBar progressBar;
    private String fullName, email, doB, gender, phoneNumber;
    private ImageView imageView;
    private FirebaseAuth authProfile;



//    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_up_account);

        getSupportActionBar().setTitle("Home");

//        binding = ActivitySetUpAccountBinding.inflate(getLayoutInflater());
//
//        getSupportActionBar().setTitle("Tài khoản");
//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
//
//        createDb();
//        loadData();


        txtShowFullName = findViewById(R.id.txt_ShowFullName);
        txtShowPassWordHint = findViewById(R.id.txt_ShowPasswordHint);
        txtShowEmail = findViewById(R.id.txt_ShowEmail);
        txtShowPhoneNumber = findViewById(R.id.txt_ShowPhoneNumber);
        txtShowGender = findViewById(R.id.txt_ShowGender);
        txtShowDOB = findViewById(R.id.txt_ShowDoB);
        txtShowSocialMedia = findViewById(R.id.txt_ShowSocialMedia);
        txtShowAccountBank = findViewById(R.id.txt_ShowAccountBank);
        progressBar = findViewById(R.id.progressBar);


        authProfile = FirebaseAuth.getInstance();
        FirebaseUser firebaseUser = authProfile.getCurrentUser();
        if (firebaseUser == null){
            Toast.makeText(SetUpAccountActivity.this, "something went  wrong! Users details are not available at the moment", Toast.LENGTH_SHORT).show();
        }else {
            progressBar.setVisibility(View.VISIBLE);
            showUserProdile(firebaseUser);

        }

    }

    private void showUserProdile(FirebaseUser firebaseUser) {
        String userID = firebaseUser.getUid();

        //Extracting User Reference from Database for "Registered User"
        DatabaseReference referenceProfile = FirebaseDatabase.getInstance().getReference("Registered Users");
        referenceProfile.child(userID).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                ReadWriteUserDetails readWriteUserDetails = snapshot.getValue(ReadWriteUserDetails.class);
                if(readWriteUserDetails != null){
                    fullName = firebaseUser.getDisplayName();
                    email = firebaseUser.getEmail();
                    doB = readWriteUserDetails.dOB;
                    gender = readWriteUserDetails.gender;
                    phoneNumber = readWriteUserDetails.phoneNumber;

                    txtShowFullName.setText(fullName);
                    txtShowEmail.setText(email);
                    txtShowPhoneNumber.setText(phoneNumber);
                    txtShowDOB.setText(doB);
                    txtShowGender.setText(gender);


                }
                progressBar.setVisibility(View.GONE);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(SetUpAccountActivity.this, "Something went wrong!", Toast.LENGTH_LONG).show();
                progressBar.setVisibility(View.GONE);

            }
        });
    }


//    private void loadData() {
//
//        registers = new ArrayList<>();
//        registers.clear();
//
//        Cursor c = dB.getData();
//
//        if (c.getCount() == 0)
//            Toast.makeText(SetUpAccountActivity.this, "No data to load",
//                    Toast.LENGTH_SHORT).show();
//        else {
//            while (c.moveToNext()){
//                registers.add(new Register(c.getInt(0), c.getString(1),c.getString(2),
//                        c.getString(3),c.getString(4),c.getString(5),c.getString(6)));
//            }
//            c.close();
//        }
//    }

//    private void createDb() {
//        dB = new RegisterDatabaseHelper(SetUpAccountActivity.this);
//        dB.createSampleData();
//    }
}