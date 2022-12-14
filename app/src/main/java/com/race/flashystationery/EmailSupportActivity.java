package com.race.flashystationery;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.race.flashystationery.databinding.ActivityCustomerSupportBinding;
import com.race.flashystationery.databinding.ActivityEmailSupportBinding;
import com.race.fragments.AccountFragment;

public class EmailSupportActivity extends AppCompatActivity {
    ActivityEmailSupportBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_email_support);
        binding = ActivityEmailSupportBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        getSupportActionBar().setTitle("PHẢN HỒI QUA EMAIL");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        addEvents();
    }

    private void addEvents() {
        binding.btnSendFeedback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Email, Feedback;
                Email = binding.edtEmailAdress.getText().toString();
                Feedback = binding.edtFeedbackContent.getText().toString();
                if (Email.isEmpty() || Feedback.isEmpty()) {
                    Toast.makeText(EmailSupportActivity.this, "Bạn cần nhập đủ thông tin", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(EmailSupportActivity.this, "Gửi thành công! \n Cảm ơn phản hồi của bạn, Flashy sẽ liên hệ bạn nhanh nhất có thể", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                Intent intent = new Intent(this, CustomerSupport.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                this.finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
