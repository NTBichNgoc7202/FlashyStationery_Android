package com.race.flashystationery;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.FirebaseAuthInvalidUserException;

public class ForgotPasswordActivity extends AppCompatActivity {
    private Button btnResetPassword;
    private EditText edtaddressemail;
    private ProgressBar progressBar;
    private FirebaseAuth authProfile;
    private final static String TAG = "ForgotPasswordActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);

        getSupportActionBar().setTitle("Forgot Password");

        edtaddressemail = findViewById(R.id.edt_InputEmailReset);
        btnResetPassword = findViewById(R.id.btn_resetPassword);
        progressBar = findViewById(R.id.progressBar);

        btnResetPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = edtaddressemail.getText().toString();

                if(TextUtils.isEmpty(email)){
                    Toast.makeText(ForgotPasswordActivity.this, "Hãy nhập địa chỉ email bạn đã đăng ký", Toast.LENGTH_SHORT).show();
                    edtaddressemail.setError("Bắt buộc nhập Email");
                    edtaddressemail.requestFocus();
                }else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
                        Toast.makeText(ForgotPasswordActivity.this, "Hãy nhập địa chỉ hợp lệ", Toast.LENGTH_SHORT).show();
                        edtaddressemail.setError("Bắt buộc nhập địa chỉ email hợp lệ");
                        edtaddressemail.requestFocus();
                }else {
                    progressBar.setVisibility(View.VISIBLE);
                    resetPassword(email);
                }
            }
        });
    }

    private void resetPassword(String email) {
        authProfile = FirebaseAuth.getInstance();
        authProfile.sendPasswordResetEmail(email).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
            if(task.isSuccessful()){
                Toast.makeText(ForgotPasswordActivity.this, "Vui lòng kiểm tra hộp thư đến của bạn để biết liên kết đặt lại mật khẩu", Toast.LENGTH_SHORT).show();

                Toast.makeText(ForgotPasswordActivity.this, "Logged Out", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(ForgotPasswordActivity.this, LoginRegisterActivity.class);

                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
                finish();
            }else {
                try {
                    throw task.getException();
                } catch (FirebaseAuthInvalidUserException e){
                    edtaddressemail.setError("Tài khoản không tồn tại. Vui lòng đăng ký tài khoản");
                }catch (Exception e){
                    Log.e(TAG, e.getMessage());
                    Toast.makeText(ForgotPasswordActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                }
            }
            progressBar.setVisibility(View.GONE);
            }
        });
    }
}