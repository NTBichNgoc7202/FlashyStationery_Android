package com.race.flashystationery;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.text.TextUtils;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.FirebaseAuthInvalidUserException;
import com.google.firebase.auth.FirebaseUser;

public class LoginActivity extends AppCompatActivity {

    private EditText edtInputLoginName, edtInputPassword;
    private ProgressBar progressBar;
    private FirebaseAuth authProfile;
    private static final String TAG="LoginActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        edtInputLoginName = findViewById(R.id.edt_InputLoginName);
        edtInputPassword = findViewById(R.id.edt_InputPassword);
        progressBar = findViewById(R.id.progressBar);

        authProfile = FirebaseAuth.getInstance();

        TextView txtForgotPassword = findViewById(R.id.txt_ForgotPassword);
        txtForgotPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(LoginActivity.this, "H??y l???y l???i m???t kh???u ngay b??y gi???", Toast.LENGTH_SHORT ).show();
                startActivity(new Intent(LoginActivity.this, ForgotPasswordActivity.class));
            }
        });

        //Show Hide Password using Eye Icon
        ImageView imvShowHidePassword = findViewById(R.id.imv_ShowHidePasswordicon);
        imvShowHidePassword.setImageResource(R.drawable.password_hide_icon);
        imvShowHidePassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (edtInputPassword.getTransformationMethod().equals(HideReturnsTransformationMethod.getInstance())){
                    // If password is  visible then Hide is
                    edtInputPassword.setTransformationMethod(PasswordTransformationMethod.getInstance());
                    //Change  Icon
                    imvShowHidePassword.setImageResource(R.drawable.password_hide_icon);
                }else {
                    edtInputPassword.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                    imvShowHidePassword.setImageResource(R.drawable.password_show_icon);
                }
            }
        });

        //Sign In User
        Button btnSignIn = findViewById(R.id.btn_SignIn);
        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String textEmail = edtInputLoginName.getText().toString();
                String textPassword = edtInputPassword.getText().toString();

                if (TextUtils.isEmpty(textEmail)){
                    Toast.makeText(LoginActivity.this, "H??y nh???p ?????a ch??? email c???a b???n", Toast.LENGTH_SHORT).show();
                    edtInputLoginName.setError("B???t bu???c nh???p email");
                    edtInputLoginName.requestFocus();
                } else if (!Patterns.EMAIL_ADDRESS.matcher(textEmail).matches()){
                    Toast.makeText(LoginActivity.this, "H??y nh???p l???i ?????a ch??? email c???a b???n", Toast.LENGTH_SHORT).show();
                    edtInputLoginName.setError("?????a ch??? Email kh??ng ch??nh x??c");
                    edtInputLoginName.requestFocus();
                } else if (TextUtils.isEmpty(textPassword)){
                    Toast.makeText(LoginActivity.this, "H??y nh???p m???t kh???u c???a b???n", Toast.LENGTH_SHORT).show();
                    edtInputPassword.setError("B???t bu???c nh???p m???t kh???u");
                    edtInputPassword.requestFocus();
                } else {
                    progressBar.setVisibility(View.VISIBLE);
                    signInUser(textEmail, textPassword);
                }
            }
        });
    }
    private void signInUser(String email, String password) {
        authProfile.signInWithEmailAndPassword(email, password).addOnCompleteListener(LoginActivity.this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()){
                    Toast.makeText(LoginActivity.this, "B???n v???a ????ng nh???p th??nh c??ng", Toast.LENGTH_SHORT).show();
                 //Get instrance  of the curent User
                    FirebaseUser firebaseUser = authProfile.getCurrentUser();
                    //Check if email  is verified before user can acccess their profile
                    if (firebaseUser.isEmailVerified()){
                        Toast.makeText(LoginActivity.this, "B???n v???a ????ng nh???p", Toast.LENGTH_SHORT).show();
                    //Open User Profile
                    // Start the SetUpAccountActivity
                    startActivity(new Intent(LoginActivity.this, SetUpAccountActivity.class));
                    finish();//Close LoginActivity

                    }else {
                        firebaseUser.sendEmailVerification();
                        authProfile.signOut();//Sign out user
                        showAlertDialog();
                        
                    }

                }else {
                    try {
                        throw task.getException();
                    }catch (FirebaseAuthInvalidUserException e) {
                        edtInputLoginName.setError("T??i kho???n kh??ng t???n t???i ho???c kh??ng s??? d???ng trong th???i gian d??i. Vui l??ng t???o t??i kho???n m???i");
                        edtInputLoginName.requestFocus();
                    }catch (FirebaseAuthInvalidCredentialsException e) {
                        edtInputLoginName.setError("Th??ng tin kh??ng h???p l???, vui l??ng ki???m tra v?? nh???p l???i");
                        edtInputLoginName.requestFocus();
                    }catch (Exception e){
                        Log.e(TAG, e.getMessage());
                        Toast.makeText(LoginActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }
                progressBar.setVisibility(View.GONE);
            }
        });
    }

    private void showAlertDialog() {
        //Setup the Alert Builder
       AlertDialog.Builder builder = new AlertDialog.Builder(LoginActivity.this);
        builder.setTitle("Email kh??ng ???????c x??c nh???n");
        builder.setMessage("Vui l??ng x??c nh???n email c???a b???n ngay b??y gi???. B???n kh??ng th??? ????ng nh???p n???u kh??ng x??c nh???n email");
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
    //Check if User is already logged in. In such case, straightaway take the user to the user's profile

    @Override
    protected void onStart() {
        super.onStart();
        if(authProfile.getCurrentUser() !=null){
            Toast.makeText(LoginActivity.this, "S???n s??n ????ng nh???p!", Toast.LENGTH_SHORT).show();
        //Start the SetUpAccountActivity
//            startActivity(new Intent(LoginActivity.this, SetUpAccountActivity.class));
//       finish();//Close LoginActivity
        }
        else {
            Toast.makeText(LoginActivity.this, "B???n c?? th??? ????ng nh???p ngay b??y gi???!", Toast.LENGTH_SHORT).show();
        }
    }
}