package com.race.flashystationery;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {
//    TextView txtRegisterNow;
    private boolean passwordShowing = false;
    private boolean confirmPasswordShowing = false;
    private ProgressBar progressBar;
    private RadioGroup radioGroupRegisterGender;
    private RadioButton radioButtonRegisterGenderSelected;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        getSupportActionBar().setTitle("Register");

        Toast.makeText(RegisterActivity.this, "Bạn có thể đăng ký ngay bây giờ", Toast.LENGTH_LONG).show();





        final EditText edtInputAccounName = findViewById(R.id.edt_InputAccountName);

        final EditText edtInputPhoneNumber = findViewById(R.id.edt_InputPhoneNumber);
        final EditText edtInputEmail = findViewById(R.id.edt_InputEmail);
        final EditText edtInputDOB = findViewById(R.id.edt_InputDOB);
        final RadioGroup radioGroupRegisterGender = findViewById(R.id.radio_group);


        final  EditText edtInputPassword = findViewById(R.id.edt_InputPassword);
        final EditText edtInputConfirmPassword = findViewById(R.id.edt_InputConfirmPassword);
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

        imvConfirmPasswordIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // Checking if password is showing or not
                if (confirmPasswordShowing){
                    confirmPasswordShowing = false;

                   edtInputConfirmPassword.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
                    imvConfirmPasswordIcon.setImageResource(R.drawable.password_show);
                }
                else
                {
                    confirmPasswordShowing = true;

                    edtInputConfirmPassword.setInputType(InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
                    imvConfirmPasswordIcon.setImageResource(R.drawable.password_hidden);
                }
                // move the  cursor at last of the text
                edtInputConfirmPassword.setSelection(edtInputConfirmPassword.length());


            }
        });

        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int selectedGenderId = radioGroupRegisterGender.getCheckedRadioButtonId();
                radioButtonRegisterGenderSelected = findViewById(selectedGenderId);

                //Obtain the entered data
                String textFullName = edtInputAccounName.getText().toString();
                String textPhoneNumber = edtInputPhoneNumber.getText().toString();
                String textEmail = edtInputEmail.getText().toString();
                String textDOB = edtInputDOB.getText().toString();
                String textPassword = edtInputPassword.getText().toString();
                String textConfirmPassword = edtInputConfirmPassword.getText().toString();
                String textGender; //Can't obtain the view before verifying if any button was selected or not

                if(TextUtils.isEmpty(textFullName)){
                    Toast.makeText(RegisterActivity.this, "Vui lòng nhập tên của bạn", Toast.LENGTH_LONG).show();
                    edtInputAccounName.setError("Tên của bạn không hợp lệ");
                    edtInputAccounName.requestFocus();

                } else if (TextUtils.isEmpty(textEmail)){
                    Toast.makeText(RegisterActivity.this, "Vui lòng nhập email của bạn", Toast.LENGTH_LONG).show();

                    edtInputEmail.setError("Email không hợp lệ");
                    edtInputEmail.requestFocus();
                } else if(!Patterns.EMAIL_ADDRESS.matcher(textEmail).matches()){
                    Toast.makeText(RegisterActivity.this, "Vui lòng nhập lại email của bạn", Toast.LENGTH_LONG).show();
                    edtInputEmail.setError("Bắc buộc nhập email");
                    edtInputEmail.requestFocus();
                } else if (TextUtils.isEmpty(textDOB)){
                    Toast.makeText(RegisterActivity.this, "Vui lòng nhập ngày sinh của bạn", Toast.LENGTH_LONG).show();
                    edtInputDOB.setError("Bắt buộc nhập ngày sinh");
                    edtInputDOB.requestFocus();

                } else if (radioGroupRegisterGender.getCheckedRadioButtonId()== -1){
                    Toast.makeText(RegisterActivity.this, "Vui lòng chọn giới tính của bạn", Toast.LENGTH_LONG).show();
                    radioButtonRegisterGenderSelected.setError("Bắt buộc chọn giới tính");
                    radioButtonRegisterGenderSelected.requestFocus();
                } else if (TextUtils.isEmpty(textPhoneNumber)){
                    Toast.makeText(RegisterActivity.this, "Vui lòng nhập lại số điện thoại của bạn", Toast.LENGTH_LONG).show();
                    edtInputPhoneNumber.setError("Bắt buộc nhập số điện thoại");
                    edtInputPhoneNumber.requestFocus();
                }else if(textPhoneNumber.length()!=10){
                    Toast.makeText(RegisterActivity.this, "Vui lòng nhập lại số điện thoại của bạn", Toast.LENGTH_LONG).show();
                    edtInputPhoneNumber.setError("Số điện thoại chỉ gồm 10 chữ số");
                    edtInputPhoneNumber.requestFocus();
                }else if (TextUtils.isEmpty(textPassword)){
                    Toast.makeText(RegisterActivity.this, "Vui lòng nhập mật khẩu của bạn", Toast.LENGTH_LONG).show();
                    edtInputPassword.setError("Bắt buộc nhập mật khẩu");
                    edtInputPassword.requestFocus();
                }else if (textPassword.length()<8){
                    Toast.makeText(RegisterActivity.this, "Mật khẩu phải chứa từ 8 ký tự trở lên", Toast.LENGTH_LONG).show();
                    edtInputPassword.setError("Mật khẩu của bạn quá yếu");
                    edtInputPassword.requestFocus();
                }
                else if (TextUtils.isEmpty(textConfirmPassword)){
                    Toast.makeText(RegisterActivity.this, "Vui lòng xác nhận lại mật khẩu của bạn", Toast.LENGTH_LONG).show();
                    edtInputConfirmPassword.setError("Bắt buộc nhập xác nhận lại mật khẩu");
                    edtInputConfirmPassword.requestFocus();
                }
                else if (!textPassword.equals(textConfirmPassword)){
                    Toast.makeText(RegisterActivity.this, "Vui lòng nhập xác nhận mật khẩu của bạn trùng với mật khẩu đã đặt", Toast.LENGTH_LONG).show();
                    edtInputConfirmPassword.setError("Bắt buộc xác nhận mật khẩu");
                    edtInputConfirmPassword.requestFocus();
                    //Clear the entered passwords
                    edtInputPassword.clearComposingText();
                    edtInputConfirmPassword.clearComposingText();
                } else {
                    textGender = radioButtonRegisterGenderSelected.getText().toString();
                    progressBar.setVisibility(View.VISIBLE);
                    registerUser(textFullName, textPhoneNumber, textEmail, textDOB, textGender, textPassword);

                }



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
//Register User using the credentials given
    private void registerUser(String textFullName, String textPhoneNumber, String textEmail, String textDOB, String textGender, String textPassword) {
    }


}