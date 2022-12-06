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

public class LoginActivity extends AppCompatActivity {

    private  boolean passwordShowing = false;

    private EditText edtInputLoginName, edtInputPassword;
    private Button btnSignIn;
    private RegisterDatabaseHelper myDb;
    private TextView registerNow;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        edtInputLoginName = findViewById(R.id.edt_InputLoginName);
        edtInputPassword = findViewById(R.id.edt_InputPassword);
        btnSignIn = findViewById(R.id.btn_SignIn);
        registerNow = findViewById(R.id.txt_RegisterNow);

        myDb = new RegisterDatabaseHelper(this);
        
        loginUser();
        

//        final EditText edtInputLoginName = findViewById(R.id.edt_InputLoginName);
//        final EditText edtInputPassword = findViewById(R.id.edt_InputPassword);
//        final ImageView imvPasswordIcon = findViewById(R.id.imv_Passwordicon);
//        final TextView registerNow = findViewById(R.id.txt_RegisterNow);
//
//        final AppCompatButton btnSignIn = findViewById(R.id.btn_SignIn);

//        imvPasswordIcon.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                // Checking if password is showing or not
//                if (passwordShowing){
//                    passwordShowing = false;
//
//                    edtInputPassword.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
//                    imvPasswordIcon.setImageResource(R.drawable.password_show);
//                }
//                else
//                {
//                    passwordShowing = true;
//
//                    edtInputPassword.setInputType(InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
//                    imvPasswordIcon.setImageResource(R.drawable.password_hidden);
//                }
//                // move the  cursor at last of the text
//               edtInputPassword.setSelection(edtInputPassword.length());
//            }
//        });

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

    private void loginUser() {
        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean var = myDb.checkUser(edtInputLoginName.getText().toString(), edtInputPassword.getText().toString());
                if(var){
                    Toast.makeText(LoginActivity.this, "Đăng nhập thành công", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(LoginActivity.this, MainActivity.class));

                finish();}
                else {
                    Toast.makeText(LoginActivity.this, "Đăng nhập thất bại", Toast.LENGTH_SHORT).show();

                }

            }
        });

    }
}