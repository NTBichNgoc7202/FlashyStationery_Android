package com.race.flashystationery;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.race.adapters.OnboardingAdapter;
import com.race.flashystationery.databinding.ActivityOnboardingBinding;

public class OnboardingActivity extends AppCompatActivity {

    ActivityOnboardingBinding binding;

    private ViewPager viewPager;
    private OnboardingAdapter adapter;
    private LinearLayout layoutDots;
    private TextView[] txtDots;
    private Button btnOnboardingAction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_onboarding);

        binding = ActivityOnboardingBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        viewPager = binding.onboardingViewPager;
        layoutDots = binding.layoutDots;
        btnOnboardingAction = binding.btnOnboardingAction;

        adapter = new OnboardingAdapter(OnboardingActivity.this);
        viewPager.setAdapter(adapter);

        addDots(0);

        btnOnboardingAction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (viewPager.getCurrentItem() + 1 < 3){
                    viewPager.setCurrentItem(viewPager.getCurrentItem() + 1);
                } else {
                    startActivity(new Intent(getApplicationContext(), LoginRegisterActivity.class));
                    finish();
                }
            }
        });

        makeStatusbarTransparent();


        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                addDots(position);
                editButton(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
}

    private void addDots(int position) {
        txtDots = new TextView[3];
        layoutDots.removeAllViews();
        for (int i = 0; i < txtDots.length; i++){
            txtDots[i] = new TextView(OnboardingActivity.this);
            txtDots[i].setText(Html.fromHtml("&#9679;"));
            txtDots[i].setTextSize(15);
            txtDots[i].setTextColor(Color.parseColor("#FBD3CA"));
            txtDots[i].setPadding(30,0,30,0);

            layoutDots.addView(txtDots[i]);
        }
        if (txtDots.length > 0){
            txtDots[position].setTextSize(20);
            txtDots[position].setTextColor(Color.parseColor("#D8BDC1"));
        }
    }

    private void editButton(int position) {
        if (position == 0){
            btnOnboardingAction.setText(R.string.onboarding_next);
            btnOnboardingAction.setBackgroundResource(R.drawable.round_button_1);
        } else if (position == 1) {
            btnOnboardingAction.setText(R.string.onboarding_next);
            btnOnboardingAction.setBackgroundResource(R.drawable.round_button_2);
        } else {
            btnOnboardingAction.setText(R.string.onboarding_start);
            btnOnboardingAction.setBackgroundResource(R.drawable.round_button_1);
        }
    }

    private void makeStatusbarTransparent() {
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE |
                View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN |
                View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION |
                View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);

        Window window = getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.setStatusBarColor(Color.TRANSPARENT);
        window.setNavigationBarColor(Color.TRANSPARENT);
    }
}