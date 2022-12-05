package com.race.flashystationery;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {
//    TextView txtRegisterNow;
    private boolean passwordShowing = false;
    private boolean confirmPasswordShowing = false;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        final EditText edtInputAccounName = findViewById(R.id.edt_InputAccountName);

        final EditText edtInputPhoneNumber = findViewById(R.id.edt_InputPhoneNumber);
        final EditText edtInputEmail = findViewById(R.id.edt_InputEmail);

        final  EditText inputPassword = findViewById(R.id.edt_InputPassword);
        final EditText inputConfirmPassword = findViewById(R.id.edt_InputConfirmPassword);
        final ImageView imvPasswordIcon = findViewById(R.id.imv_Password_Icon);
        final  ImageView imvConfirmPasswordIcon = findViewById(R.id.imv_ConformPasswordIcon);
        final AppCompatButton btnSignUp = findViewById(R.id.btn_SignUp);
        final TextView signInNow = findViewById(R.id.txt_SignInNow);

        imvPasswordIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // Checking if password is showing or not
                if (passwordShowing){
                    passwordShowing = false;

                    inputPassword.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
                    imvPasswordIcon.setImageResource(R.drawable.password_show);
                }
                else
                {
                    passwordShowing = true;

                    inputPassword.setInputType(InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
                    imvPasswordIcon.setImageResource(R.drawable.password_hidden);
                }
                // move the  cursor at last of the text
                inputPassword.setSelection(inputPassword.length());

            }
        });

        imvConfirmPasswordIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // Checking if password is showing or not
                if (confirmPasswordShowing){
                    confirmPasswordShowing = false;

                   inputConfirmPassword.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
                    imvConfirmPasswordIcon.setImageResource(R.drawable.password_show);
                }
                else
                {
                    confirmPasswordShowing = true;

                    inputConfirmPassword.setInputType(InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
                    imvConfirmPasswordIcon.setImageResource(R.drawable.password_hidden);
                }
                // move the  cursor at last of the text
                inputConfirmPassword.setSelection(inputConfirmPassword.length());


            }
        });

        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String getMobileTxt = edtInputPhoneNumber.getText().toString();
                final String getEmailTxt = edtInputEmail.getText().toString();
            //opening OTP verification Activity along with mobile and email
                Intent intent = new Intent(RegisterActivity.this, OTPVerification.class);

                intent.putExtra("mobile", getMobileTxt);
                intent.putExtra("email", getEmailTxt);

                startActivity(intent);


            }
        });

        signInNow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(RegisterActivity.this, LoginActivity.class));

            }
        });


//        txtRegisterNow = findViewById(R.id.txt_LoginNow);
//
//        txtRegisterNow.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
//            }
//        });
    }



}