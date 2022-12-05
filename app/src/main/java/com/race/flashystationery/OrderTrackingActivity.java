package com.race.flashystationery;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TableLayout;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import com.race.adapters.OrderTrackingViewPagerAdapter;
import com.race.flashystationery.databinding.ActivityOrderTrackingBinding;
import com.race.fragment.OrderCancelFragment;
import com.race.fragment.OrderConfirmFragment;
import com.race.fragment.OrderDeliverFragment;
import com.race.fragment.OrderReviewFragment;
import com.race.fragment.OrderTakingFragment;

public class OrderTrackingActivity extends AppCompatActivity {

    ActivityOrderTrackingBinding binding;
    ViewPager2 trackingViewPager;
    TabLayout trackingTabLayout;
    OrderTrackingViewPagerAdapter viewPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_order_tracking);

        binding = ActivityOrderTrackingBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        getSupportActionBar().setTitle("Đơn hàng của tôi");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        customOrderTrackingActivity();
    }

    private void customOrderTrackingActivity() {
        viewPagerAdapter = new OrderTrackingViewPagerAdapter(this);

        trackingViewPager = binding.vpOrderTracking;
        trackingTabLayout = binding.tlOrderTracking;

        trackingViewPager.setAdapter(viewPagerAdapter);
        new TabLayoutMediator(trackingTabLayout, trackingViewPager,
                new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                switch (position){
                    case 0:
                        tab.setText("Chờ xác nhận");
                        break;
                    case 1:
                        tab.setText("Chờ lấy hàng");
                        break;
                    case 2:
                        tab.setText("Đang giao");
                        break;
                    case 3:
                        tab.setText("Đánh giá");
                        break;
                    case 4:
                        tab.setText("Đã huỷ & Trả hàng/Hoàn tiền");
                        break;
                }
            }
        }).attach();

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                this.finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}