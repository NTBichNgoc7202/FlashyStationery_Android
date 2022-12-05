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

public class LoginActivity extends AppCompatActivity {

    private  boolean passwordShowing = false;

//    private EditText inputLoginName, inputPassword;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        final EditText edtInputLoginName = findViewById(R.id.edt_InputLoginName);
        final EditText edtInputPassword = findViewById(R.id.edt_InputPassword);
        final ImageView imvPasswordIcon = findViewById(R.id.imv_Passwordicon);
        final TextView registerNow = findViewById(R.id.txt_RegisterNow);

        final AppCompatButton btnSignIn = findViewById(R.id.btn_SignIn);

        imvPasswordIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Checking if password is showing or not
                if (passwordShowing){
                    passwordShowing = false;

                    edtInputPassword.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
                    imvPasswordIcon.setImageResource(R.drawable.password_show);
                }
                else
                {
                    passwordShowing = true;

                    edtInputPassword.setInputType(InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
                    imvPasswordIcon.setImageResource(R.drawable.password_hidden);
                }
                // move the  cursor at last of the text
               edtInputPassword.setSelection(edtInputPassword.length());
            }
        });

        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LoginActivity.this, MainActivity.class));

            }
        });
        registerNow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LoginActivity.this, RegisterActivity.class));
            }
        });
    }
}