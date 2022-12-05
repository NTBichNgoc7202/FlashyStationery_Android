package com.race.flashystationery;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.text.Editable;
import android.text.SpannableString;
import android.text.TextWatcher;
import android.text.style.ClickableSpan;
import android.text.style.UnderlineSpan;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class OTPVerification extends AppCompatActivity {

    TextView sendOTP;

    private EditText edtOtp1, edtOtp2, edtOtp3, edtOtp4;
    private TextView txtResend;

    //true after every 30 seconds
    private boolean resendEnable = false;

    //resend time in seconds
    private int resendTime = 30;

    private int selectedETPosition = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otpverification);

        edtOtp1 = findViewById(R.id.edt_OTP1);
        edtOtp2 = findViewById(R.id.edt_OTP2);
        edtOtp3 = findViewById(R.id.edt_OTP3);
        edtOtp4 = findViewById(R.id.edt_OTP4);

        txtResend = findViewById(R.id.txt_SendOTP);
        final AppCompatButton btnConfirmOTP = findViewById(R.id.btn_ConfirmOPT);

        final  TextView otpEmail = findViewById(R.id.txt_otpEmail);
        final  TextView otpMobile = findViewById(R.id.txt_otpMobile);

        //getting email and mobile from Register activity through itent

        final String getEmail = getIntent().getStringExtra("email");
        final  String getMobile = getIntent().getStringExtra("mobile");

        //setting email and mobile to TextView
        otpMobile.setText(getMobile);
        otpEmail.setText(getEmail);

        edtOtp1.addTextChangedListener(textWatcher);
        edtOtp2.addTextChangedListener(textWatcher);
        edtOtp3.addTextChangedListener(textWatcher);
        edtOtp4.addTextChangedListener(textWatcher);

        //by default open keyboard at edtOtp1
        showKeyboard(edtOtp1);

        //start resend count down timer
        startCounDownTimer();

        txtResend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(resendEnable){
                    //handel your resend code here

                    //start new resend count down timer
                    startCounDownTimer();
                }
            }
        });

        btnConfirmOTP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String generateOtp = edtOtp1.getText().toString() + edtOtp2.getText().toString() + edtOtp3.getText().toString() + edtOtp4.getText().toString();

                if(generateOtp.length() == 4){
                    //handle your otp verification here
                }
            }
        });

        sendOTP = findViewById(R.id.txt_SendOTP);
        sendOTP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(OTPVerification.this, "Mã xác nhận đã được gửi, hãy nhập lại mã", Toast.LENGTH_SHORT).show();
            }
        });


    }
    private  void showKeyboard(EditText edtOtp){
        edtOtp.requestFocus();
        InputMethodManager inputMethodManager =(InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        inputMethodManager.showSoftInput(edtOtp, InputMethodManager.SHOW_IMPLICIT);
    }
    private void startCounDownTimer(){
        resendEnable = false;
        txtResend.setTextColor(Color.parseColor("#000000"));

        new CountDownTimer(resendTime * 1000, 1000) {
            @Override
            public void onTick(long l) {

                txtResend.setText("Gửi lại mã xác nhận("+ (l / 1000)+ ")");

            }

            @Override
            public void onFinish() {
              resendEnable = true;
              txtResend.setText("Gửi lại mã xác nhận");
              txtResend.setTextColor(getResources().getColor(R.color.black));

            }
        }.start();
    }
   private final TextWatcher textWatcher = new TextWatcher() {
       @Override
       public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

       }

       @Override
       public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

       }

       @Override
       public void afterTextChanged(Editable editable) {
           if(editable.length()>0){
               if (selectedETPosition == 0){
                   selectedETPosition = 1;
                   showKeyboard(edtOtp2);

               }
               else if(selectedETPosition == 1){
                   selectedETPosition = 2;
                   showKeyboard(edtOtp3);

               }
               else if(selectedETPosition == 2){
                   selectedETPosition = 3;
                   showKeyboard(edtOtp4);
               }
           }
       }
   };




    public boolean onKeyUp(int keyCode, KeyEvent event) {

        if (keyCode == KeyEvent.KEYCODE_DEL){
            if(selectedETPosition == 3){
                selectedETPosition = 2;
                showKeyboard(edtOtp3);
            }
            else if(selectedETPosition == 2){
                selectedETPosition = 1;
                showKeyboard(edtOtp2);
            }
            else if(selectedETPosition == 1){
                selectedETPosition = 0;
                showKeyboard(edtOtp1);
            }
            return true;
        }
        else {
            return super.onKeyUp(keyCode, event);

        }
    }
}