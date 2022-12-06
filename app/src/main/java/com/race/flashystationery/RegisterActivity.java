package com.race.flashystationery;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class RegisterActivity extends AppCompatActivity {

    private EditText edtInputFullName,edtInputEmail,edtInputPhoneNumber, edtInputPassword,edtInputConfirmPassWord,
    edtInputDOB;
    private ProgressBar progressBar;
    private RadioGroup radioGroupRegisterGender;
    private RadioButton radioButtonRegisterGenderSelected;
//    ActivityRegisterBinding binding;
//    RegisterDatabaseHelper dB = SetUpAccountActivity.dB;
//    TextView txtRegisterNow;
//    private boolean passwordShowing = false;
//    private boolean confirmPasswordShowing = false;
//
//    private Button btnSignUp;
//    private RegisterDatabaseHelper myDB;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

//        binding = ActivityRegisterBinding.inflate(getLayoutInflater());
//        setContentView(binding.getRoot());
        getSupportActionBar().setTitle("Tạo tài khoản");
        Toast.makeText(RegisterActivity.this, "Bạn có thể tạo tài khoản ngay bây giờ", Toast.LENGTH_SHORT).show();

        edtInputFullName = findViewById(R.id.edt_InputAccountName);
        edtInputPhoneNumber = findViewById(R.id.edt_InputPhoneNumber);
        edtInputEmail = findViewById(R.id.edt_InputEmail);
        edtInputDOB = findViewById(R.id.edt_InputDOB);
        edtInputPassword = findViewById(R.id.edt_InputPassword);
        edtInputConfirmPassWord = findViewById(R.id.edt_InputConfirmPassword);

        //RadioButton for Gender
        radioGroupRegisterGender = findViewById(R.id.radio_group);
        radioGroupRegisterGender.clearCheck();

        AppCompatButton btnSignUp = findViewById(R.id.btn_SignUp);
        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int selectedGenderId = radioGroupRegisterGender.getCheckedRadioButtonId();
                radioButtonRegisterGenderSelected = findViewById(selectedGenderId);

                //Obtain the entered data
                String textFullName = edtInputFullName.getText().toString();
                String textPhoneNumber = edtInputPhoneNumber.getText().toString();
                String textEmail = edtInputEmail.getText().toString();
                String textDOB = edtInputDOB.getText().toString();
                String textPassword = edtInputPassword.getText().toString();
                String textConfirmPassword = edtInputConfirmPassWord.getText().toString();
                String textGender;
                //Can't obtain the view before verifying if any button was selected or not

                if (TextUtils.isEmpty(textFullName)) {
                    Toast.makeText(RegisterActivity.this, "Vui lòng nhập tên của bạn", Toast.LENGTH_LONG).show();
                    edtInputFullName.setError("Bắt buộc nhập tên của bạn");
                    edtInputFullName.requestFocus();

                }else if (TextUtils.isEmpty(textPhoneNumber)) {
                    Toast.makeText(RegisterActivity.this, "Vui lòng nhập lại số điện thoại của bạn", Toast.LENGTH_LONG).show();
                    edtInputPhoneNumber.setError("Bắt buộc nhập số điện thoại");
                    edtInputPhoneNumber.requestFocus();
                } else if (textPhoneNumber.length() != 10) {
                    Toast.makeText(RegisterActivity.this, "Vui lòng nhập lại số điện thoại của bạn", Toast.LENGTH_LONG).show();
                    edtInputPhoneNumber.setError("Số điện thoại chỉ gồm 10 chữ số");
                    edtInputPhoneNumber.requestFocus();
                }  else if (TextUtils.isEmpty(textEmail)) {
                    Toast.makeText(RegisterActivity.this, "Vui lòng nhập email của bạn", Toast.LENGTH_LONG).show();
                    edtInputEmail.setError("Bắt buộc nhập email");
                    edtInputEmail.requestFocus();
                } else if (!Patterns.EMAIL_ADDRESS.matcher(textEmail).matches()) {
                    Toast.makeText(RegisterActivity.this, "Vui lòng nhập lại email của bạn", Toast.LENGTH_LONG).show();
                    edtInputEmail.setError("Bắt buộc nhập email");
                    edtInputEmail.requestFocus();
                } else if (TextUtils.isEmpty(textDOB)) {
                    Toast.makeText(RegisterActivity.this, "Vui lòng nhập ngày sinh của bạn", Toast.LENGTH_LONG).show();
                    edtInputDOB.setError("Bắt buộc nhập ngày sinh");
                    edtInputDOB.requestFocus();
                } else if (radioGroupRegisterGender.getCheckedRadioButtonId() == -1) {
                    Toast.makeText(RegisterActivity.this, "Vui lòng chọn giới tính của bạn", Toast.LENGTH_LONG).show();
                    radioButtonRegisterGenderSelected.setError("Bắt buộc chọn giới tính");
                    radioButtonRegisterGenderSelected.requestFocus();

                } else if (TextUtils.isEmpty(textPassword)) {
                    Toast.makeText(RegisterActivity.this, "Vui lòng nhập mật khẩu của bạn", Toast.LENGTH_LONG).show();
                    edtInputPassword.setError("Bắt buộc nhập mật khẩu");
                    edtInputPassword.requestFocus();
                } else if (textPassword.length() < 8) {
                    Toast.makeText(RegisterActivity.this, "Mật khẩu phải chứa từ 8 ký tự trở lên", Toast.LENGTH_LONG).show();
                    edtInputPassword.setError("Mật khẩu của bạn quá yếu");
                    edtInputPassword.requestFocus();
                } else if (TextUtils.isEmpty(textConfirmPassword)) {
                    Toast.makeText(RegisterActivity.this, "Vui lòng xác nhận lại mật khẩu của bạn", Toast.LENGTH_LONG).show();
                    edtInputConfirmPassWord.setError("Bắt buộc nhập xác nhận lại mật khẩu");
                    edtInputConfirmPassWord.requestFocus();
                } else if (!textPassword.equals(textConfirmPassword)) {
                    Toast.makeText(RegisterActivity.this, "Vui lòng nhập xác nhận mật khẩu của bạn trùng với mật khẩu đã đặt", Toast.LENGTH_LONG).show();
                    edtInputConfirmPassWord.setError("Bắt buộc xác nhận mật khẩu");
                    edtInputConfirmPassWord.requestFocus();
                    //Clear the entered passwords
                    edtInputPassword.clearComposingText();
                    edtInputConfirmPassWord.clearComposingText();
                } else {
                    textGender = radioButtonRegisterGenderSelected.getText().toString();
                    progressBar.setVisibility(View.VISIBLE);
                    RegisterUser(textFullName, textPhoneNumber, textEmail, textDOB, textGender, textPassword);
                }

            }
        });
    }
    //Register User using the credentials given
    private void RegisterUser(String textFullName, String textPhoneNumber, String textEmail, String textDOB, String textGender, String textPassword) {
    FirebaseAuth auth = FirebaseAuth.getInstance();
    auth.createUserWithEmailAndPassword(textEmail, textPassword).addOnCompleteListener(RegisterActivity.this,
            new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    Toast.makeText(RegisterActivity.this, "Đăng ký tài khoản thành công", Toast.LENGTH_LONG).show();
                    FirebaseUser firebaseUser = auth.getCurrentUser();

                    //Send Verification Email
                    firebaseUser.sendEmailVerification();

                    //Open User profile after successful registation
                    Intent intent = new Intent(RegisterActivity.this, SetUpAccountActivity.class);
                    //To Prevent User from returning back to Register Activity on pressing back button after registration
                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(intent);
                    finish();
                    //to close Register  Activity


                }
            });

    }


//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

//        addEvent();
//
//
//
//        btnSignUp = findViewById(R.id.btn_SignUp);
//        myDB = new RegisterDatabaseHelper(this);
//        insertUser();







//        final EditText edtInputAccounName = findViewById(R.id.edt_InputAccountName);
//
//        final EditText edtInputPhoneNumber = findViewById(R.id.edt_InputPhoneNumber);
//        final EditText edtInputEmail = findViewById(R.id.edt_InputEmail);
//        final EditText edtInputDOB = findViewById(R.id.edt_InputDOB);
//        final RadioGroup radioGroupRegisterGender = findViewById(R.id.radio_group);
//
//
//        final  EditText edtInputPassword = findViewById(R.id.edt_InputPassword);
//        final EditText edtInputConfirmPassword = findViewById(R.id.edt_InputConfirmPassword);
//        final ImageView imvPasswordIcon = findViewById(R.id.imv_Password_Icon);
//        final  ImageView imvConfirmPasswordIcon = findViewById(R.id.imv_ConformPasswordIcon);
//        final AppCompatButton btnSignUp = findViewById(R.id.btn_SignUp);
//        final TextView signInNow = findViewById(R.id.txt_SignInNow);
//
//        imvPasswordIcon.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
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
//                edtInputPassword.setSelection(edtInputPassword.length());
//
//            }
//        });
//
//        imvConfirmPasswordIcon.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//                // Checking if password is showing or not
//                if (confirmPasswordShowing){
//                    confirmPasswordShowing = false;
//
//                   edtInputConfirmPassword.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
//                    imvConfirmPasswordIcon.setImageResource(R.drawable.password_show);
//                }
//                else
//                {
//                    confirmPasswordShowing = true;
//
//                    edtInputConfirmPassword.setInputType(InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
//                    imvConfirmPasswordIcon.setImageResource(R.drawable.password_hidden);
//                }
//                // move the  cursor at last of the text
//                edtInputConfirmPassword.setSelection(edtInputConfirmPassword.length());
//
//
//            }
//        });
//
//        btnSignUp.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                int selectedGenderId = radioGroupRegisterGender.getCheckedRadioButtonId();
//                radioButtonRegisterGenderSelected = findViewById(selectedGenderId);
//

//
//
//
//                final String getMobileTxt = edtInputPhoneNumber.getText().toString();
//                final String getEmailTxt = edtInputEmail.getText().toString();
//            //opening OTP verification Activity along with mobile and email
//                Intent intent = new Intent(RegisterActivity.this, OTPVerification.class);
//
//                intent.putExtra("mobile", getMobileTxt);
//                intent.putExtra("email", getEmailTxt);
//
//                startActivity(intent);
//
//
//            }
//        });
//
//        signInNow.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//                startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
//
//            }
//        });
//
//
////        txtRegisterNow = findViewById(R.id.txt_LoginNow);
////
//        txtRegisterNow.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
//            }
//        });
//    }

//    private void addEvent() {
//        binding.btnSignUp.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                dB.execSql("INSERT INTO " + RegisterDatabaseHelper.TABLE_NAME + " VALUES(null, '"
//                        + binding.edtInputAccountName.getText().toString() + "', '"
//                        + binding.edtInputPhoneNumber.getText().toString() + "', '"
//                        + binding.edtInputEmail.getText().toString() + "', '"
//                        + binding.edtInputDOB.getText().toString() + "', '"
//                        + binding.edtInputPassword.getText().toString());
//                finish();
//            }
//        });
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
//        switch (item.getItemId()) {
//            case android.R.id.home:
//                this.finish();
//                return true;
//            default:
//                return super.onOptionsItemSelected(item);
//        }
//    }

//    //Register User using the credentials given
//    private void registerUser(String textFullName, String textPhoneNumber, String textEmail, String textDOB, String textGender, String textPassword) {
//    }
//
//    private  void insertUser(){
//        btnSignUp.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                boolean var = myDB.registerUserFlashyApp(edtInputAccounName.getText().toString(), edtInputEmail.getText().toString(), edtInputPhoneNumber.getText().toString(), edtInputPassword.getText().toString());
//                if(var){
//                    Toast.makeText(RegisterActivity.this, "Chúc mừng bạn đã đăng ký thành công ||", Toast.LENGTH_SHORT).show();
//
//                }
//                else
//                    Toast.makeText(RegisterActivity.this, "Đăng ký thất bại ||", Toast.LENGTH_SHORT).show();
//
//
//            }
//        });
//
//    }


}

