package com.race.flashystationery;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthEmailException;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;
import com.google.firebase.auth.FirebaseAuthWeakPasswordException;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserProfileChangeRequest;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Calendar;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegisterActivity extends AppCompatActivity {

    private EditText edtInputFullName,edtInputEmail,edtInputPhoneNumber, edtInputPassword,edtInputConfirmPassWord,
    edtInputDOB;
    private ProgressBar progressBar;
    private RadioGroup radioGroupRegisterGender;
    private RadioButton radioButtonRegisterGenderSelected;
    private static final String TAG= "RegisterActivity";
    private  DatePickerDialog picker;
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
        getSupportActionBar().setTitle("T???o t??i kho???n");
        Toast.makeText(RegisterActivity.this, "B???n c?? th??? t???o t??i kho???n ngay b??y gi???", Toast.LENGTH_SHORT).show();

        progressBar = findViewById(R.id.progressBar);
        edtInputFullName = findViewById(R.id.edt_InputAccountName);
        edtInputPhoneNumber = findViewById(R.id.edt_InputPhoneNumber);
        edtInputEmail = findViewById(R.id.edt_InputEmail);
        edtInputDOB = findViewById(R.id.edt_InputDOB);
        edtInputPassword = findViewById(R.id.edt_InputPassword);
        edtInputConfirmPassWord = findViewById(R.id.edt_InputConfirmPassword);

        //RadioButton for Gender
        radioGroupRegisterGender = findViewById(R.id.radio_group);
        radioGroupRegisterGender.clearCheck();

        //Setting up DatePicker  on Editext
        edtInputDOB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Calendar calendar = Calendar.getInstance();
                int day = calendar.get(Calendar.DAY_OF_MONTH);
                int month = calendar.get(Calendar.MONTH);
                int year = calendar.get(Calendar.YEAR);

                //Date Picker Dialog
                picker = new DatePickerDialog(RegisterActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int year, int month, int dayOfMonth) {
                    edtInputDOB.setText(dayOfMonth + "/" + (month + 1) + "/" + year);
                    }
                }, year, month, day);
                picker.show();

            }
        });

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
                String textGender;//Can't obtain the view before verifying if any button was selected or not

                //Validate Mobile Number using Matcher and Pattern (Regular Expressiob)
                String mobileRegex = "(0)[1-9]{9}";
                Matcher mobileMatcher;
                Pattern mobilePattern = Pattern.compile(mobileRegex);
                mobileMatcher = mobilePattern.matcher(textPhoneNumber);


                if (TextUtils.isEmpty(textFullName)) {
                    Toast.makeText(RegisterActivity.this, "Vui l??ng nh???p t??n c???a b???n", Toast.LENGTH_LONG).show();
                    edtInputFullName.setError("B???t bu???c nh???p t??n c???a b???n");
                    edtInputFullName.requestFocus();

                }else if (TextUtils.isEmpty(textPhoneNumber)) {
                    Toast.makeText(RegisterActivity.this, "Vui l??ng nh???p l???i s??? ??i???n tho???i c???a b???n", Toast.LENGTH_LONG).show();
                    edtInputPhoneNumber.setError("B???t bu???c nh???p s??? ??i???n tho???i");
                    edtInputPhoneNumber.requestFocus();
                } else if (textPhoneNumber.length() != 10) {
                    Toast.makeText(RegisterActivity.this, "Vui l??ng nh???p l???i s??? ??i???n tho???i c???a b???n", Toast.LENGTH_LONG).show();
                    edtInputPhoneNumber.setError("S??? ??i???n tho???i ch??? g???m 10 ch??? s???");
                    edtInputPhoneNumber.requestFocus();
                }else if (!mobileMatcher.find()){
                    Toast.makeText(RegisterActivity.this, "Vui l??ng nh???p l???i s??? ??i???n tho???i c???a b???n", Toast.LENGTH_LONG).show();
                    edtInputPhoneNumber.setError("S??? ??i???n tho???i kh??ng h???p l???");
                    edtInputPhoneNumber.requestFocus();
                }
                    else if (TextUtils.isEmpty(textEmail)) {
                    Toast.makeText(RegisterActivity.this, "Vui l??ng nh???p email c???a b???n", Toast.LENGTH_LONG).show();
                    edtInputEmail.setError("B???t bu???c nh???p email");
                    edtInputEmail.requestFocus();
                } else if (!Patterns.EMAIL_ADDRESS.matcher(textEmail).matches()) {
                    Toast.makeText(RegisterActivity.this, "Vui l??ng nh???p l???i email c???a b???n", Toast.LENGTH_LONG).show();
                    edtInputEmail.setError("B???t bu???c nh???p email");
                    edtInputEmail.requestFocus();
                } else if (TextUtils.isEmpty(textDOB)) {
                    Toast.makeText(RegisterActivity.this, "Vui l??ng nh???p ng??y sinh c???a b???n", Toast.LENGTH_LONG).show();
                    edtInputDOB.setError("B???t bu???c nh???p ng??y sinh");
                    edtInputDOB.requestFocus();
                } else if (radioGroupRegisterGender.getCheckedRadioButtonId() == -1) {
                    Toast.makeText(RegisterActivity.this, "Vui l??ng ch???n gi???i t??nh c???a b???n", Toast.LENGTH_LONG).show();
                    radioButtonRegisterGenderSelected.setError("B???t bu???c ch???n gi???i t??nh");
                    radioButtonRegisterGenderSelected.requestFocus();

                } else if (TextUtils.isEmpty(textPassword)) {
                    Toast.makeText(RegisterActivity.this, "Vui l??ng nh???p m???t kh???u c???a b???n", Toast.LENGTH_LONG).show();
                    edtInputPassword.setError("B???t bu???c nh???p m???t kh???u");
                    edtInputPassword.requestFocus();
                } else if (textPassword.length() < 8) {
                    Toast.makeText(RegisterActivity.this, "M???t kh???u ph???i ch???a t??? 8 k?? t??? tr??? l??n", Toast.LENGTH_LONG).show();
                    edtInputPassword.setError("M???t kh???u c???a b???n qu?? y???u");
                    edtInputPassword.requestFocus();
                } else if (TextUtils.isEmpty(textConfirmPassword)) {
                    Toast.makeText(RegisterActivity.this, "Vui l??ng x??c nh???n l???i m???t kh???u c???a b???n", Toast.LENGTH_LONG).show();
                    edtInputConfirmPassWord.setError("B???t bu???c nh???p x??c nh???n l???i m???t kh???u");
                    edtInputConfirmPassWord.requestFocus();
                } else if (!textPassword.equals(textConfirmPassword)) {
                    Toast.makeText(RegisterActivity.this, "Vui l??ng nh???p x??c nh???n m???t kh???u c???a b???n tr??ng v???i m???t kh???u ???? ?????t", Toast.LENGTH_LONG).show();
                    edtInputConfirmPassWord.setError("B???t bu???c x??c nh???n m???t kh???u");
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

    private void RegisterUser(String textFullName, String textPhoneNumber, String textEmail, String textDOB, String textGender, String textPassword) {
        //Register User using the credentials given
            FirebaseAuth auth = FirebaseAuth.getInstance();
           //Create User Profile
            auth.createUserWithEmailAndPassword(textEmail, textPassword).addOnCompleteListener(RegisterActivity.this,
                    new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()){
                                Toast.makeText(RegisterActivity.this, "B???n ???? ????ng k?? th??nh c??ng", Toast.LENGTH_LONG).show();
                                FirebaseUser firebaseUser = auth.getCurrentUser();

                                //Enter User Data into the Firebase Realtime DataBase
                                ReadWriteUserDetails writeUserDetails = new ReadWriteUserDetails(textPhoneNumber, textDOB, textGender);

                                //Extracting User reference from Database for "Register Users"
                                DatabaseReference referenceProfile = FirebaseDatabase.getInstance().getReference("Registerd Users");

                                //Send Verification
                                firebaseUser.sendEmailVerification();

//
//
                                //Update Display Name of User
                                UserProfileChangeRequest profileChangeRequest = new UserProfileChangeRequest.Builder().setDisplayName(textFullName).build();

                                firebaseUser.updateProfile(profileChangeRequest);

                                referenceProfile.child(firebaseUser.getUid()).setValue(writeUserDetails).addOnCompleteListener(new OnCompleteListener<Void>() {
                                    @Override
                                    public void onComplete(@NonNull Task<Void> task) {
                                        if (task.isSuccessful()){

                                            //Send Verification Email
                                            firebaseUser.sendEmailVerification();

                                            Toast.makeText(RegisterActivity.this, "????ng k?? t??i kho???n th??nh c??ng, Vui l??ng x??c nh???n email", Toast.LENGTH_LONG).show();

                                            //Open User profile after successful registation
                                            Intent intent = new Intent(RegisterActivity.this, SetUpAccountActivity.class);
//                                          //To Prevent User from returning back to Register Activity on pressing back button after registration
                                            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                                              startActivity(intent);
                                              finish();
//                                           //to close Register  Activity

                                        }else {

                                            Toast.makeText(RegisterActivity.this, "????ng k?? t??i kho???n th???t b???i, H??y th??? l???i m???t l???n n???a", Toast.LENGTH_LONG).show();

                                        }
                                        //Hide ProgressBar whether User creation is succesful of fail
                                        progressBar.setVisibility(View.GONE);
                                    }
                                });

                            } else {
                                try {
                                    throw task.getException();
                                }catch (FirebaseAuthWeakPasswordException e) {
                                    edtInputPassword.setError("Your password is t?? weak. Kindly use a mix of alphebets");
                                    edtInputPassword.requestFocus();
                                }catch (FirebaseAuthInvalidCredentialsException e) {
                                    edtInputPassword.setError("Your email is invalid or already  in use. Kindly re-enter");
                                    edtInputPassword.requestFocus();
                                }catch (FirebaseAuthUserCollisionException e){
                                    edtInputPassword.setError("User is already registered with this email, Use another email.");
                                    edtInputPassword.requestFocus();
                                }catch (Exception e){
                                    Log.e(TAG,e.getMessage());
                                    Toast.makeText(RegisterActivity.this, e.getMessage(), Toast.LENGTH_LONG).show();
                                }
                                //Hide ProgressBar whether User creation is succesful of fail
                                progressBar.setVisibility(View.GONE);

                            }

//

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
//                    Toast.makeText(RegisterActivity.this, "Ch??c m???ng b???n ???? ????ng k?? th??nh c??ng ||", Toast.LENGTH_SHORT).show();
//
//                }
//                else
//                    Toast.makeText(RegisterActivity.this, "????ng k?? th???t b???i ||", Toast.LENGTH_SHORT).show();
//
//
//            }
//        });
//
//    }


}

