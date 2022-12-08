package com.race.flashystationery;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
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



public class SetUpAccountActivity extends AppCompatActivity {

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
            Toast.makeText(SetUpAccountActivity.this, "Đã xảy ra sự cố! Chi tiết người dùng hiện không có sẵn", Toast.LENGTH_SHORT).show();
        }else {
            checkifEmailVerified(firebaseUser);

            progressBar.setVisibility(View.VISIBLE);
            showUserProdile(firebaseUser);

        }

    }
    //Users coming to SetUpAccountActivity after successful registeration
    private void checkifEmailVerified(FirebaseUser firebaseUser) {
        showAlertDiolog();
    }

    private void showAlertDiolog() {
        //Setup the Alert Builder
        AlertDialog.Builder builder = new AlertDialog.Builder(SetUpAccountActivity.this);
        builder.setTitle("Email không được xác nhận");
        builder.setMessage("Vui lòng xác nhận email của bạn ngay bây giờ. Bạn không thể đăng nhập nếu không xác thực eamil vào lần tới");
        //Open Email Apps if user clicks/tap continue button
        builder.setPositiveButton("Continue", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Intent intent = new Intent(Intent.ACTION_MAIN);
                intent.addCategory(Intent.CATEGORY_APP_EMAIL);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK); // To email app in new window and not within and not within our app
                startActivity(intent);
            }
        });

        //Create the AlertDialog
        AlertDialog alertDialog = builder.create();

        //Show the Allert Dialog
        alertDialog.show();

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
   //Creating ActionBar Menu


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.common_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
       int id = item.getItemId();
       if (id == R.id.menu_refesh){
           startActivity(getIntent());
           finish();
//       } else if (id == R.id.mn_update_profile){
//           Intent intent = new Intent(SetUpAccountActivity.this, UpdateProfileActivity.class);
//           startActivity(intent);
//       }else if (id == R.id.mn_update_email){
//           Intent intent = new Intent(SetUpAccountActivity.this, UpdateEmailActivity.class);
//           startActivity(intent);
//       }else if (id == R.id.mn_setting) {
           Toast.makeText(SetUpAccountActivity.this, "menu_settings", Toast.LENGTH_SHORT).show();
//       }else  if (id == R.id.mn_change_password){
//           Intent intent = new Intent(SetUpAccountActivity.this, UpdatePasswordActivity.class);
//           startActivity(intent);
//       }else  if (id == R.id.mn_delete_profile){
//           Intent intent = new Intent(SetUpAccountActivity.this, DeleteActivity.class);
//           startActivity(intent);
       }else if (id == R.id.mn_logout) {
           authProfile.signOut();
           Toast.makeText(SetUpAccountActivity.this, "Đăng xuất", Toast.LENGTH_SHORT).show();
           Intent intent = new Intent(SetUpAccountActivity.this, LoginRegisterActivity.class);

           intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
           startActivity(intent);
           finish();
       } else {
           Toast.makeText(SetUpAccountActivity.this, "Lỗi", Toast.LENGTH_SHORT).show();
       }
        return super.onOptionsItemSelected(item);
    }
}