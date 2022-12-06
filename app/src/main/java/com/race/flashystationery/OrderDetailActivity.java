package com.race.flashystationery;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;

import com.race.adapters.AddressAdapter;
import com.race.adapters.OrderDetailStatusAdapter;
import com.race.flashystationery.databinding.ActivityOrderDetailBinding;
import com.race.models.OrderDetailStatus;

import java.util.ArrayList;

public class OrderDetailActivity extends AppCompatActivity {

    ActivityOrderDetailBinding binding;
    OrderDetailStatusAdapter adapter;
    ArrayList<OrderDetailStatus> orderDetailStatuses;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_order_detail);

        binding = ActivityOrderDetailBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        getSupportActionBar().setTitle("Chi tiết đơn hàng");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        binding.lvOrderStatus.setExpanded(true);


        String extraInfo = getIntent().getStringExtra("status");
        if (extraInfo.equals("confirm"))
            loadConfirmData();
        else if (extraInfo.equals("taking"))
            loadTakingData();
        else if (extraInfo.equals("deliver"))
            loadDeliverData();
        else if (extraInfo.equals("success"))
            loadSuccessData();

    }

    private void loadConfirmData() {
        binding.txtOrderStatus.setText("Chờ xác nhận");
        binding.txtOrderDetailDesc.setText("Đơn hàng của bạn đang trong quá trình kiểm duyệt.");
        binding.imvOrderStatus.setImageResource(R.drawable.order_confirm);

        orderDetailStatuses = new ArrayList<>();

        orderDetailStatuses.add(new OrderDetailStatus(R.drawable.order_confirm,
                "18/12/2022 - Đơn hàng đang chờ đóng gói."));

        adapter = new OrderDetailStatusAdapter(OrderDetailActivity.this,
                R.layout.order_detail_status_item_list, orderDetailStatuses);
        binding.lvOrderStatus.setAdapter(adapter);

        addButtons();
    }

    private void loadTakingData() {
        binding.txtOrderStatus.setText("Chờ lấy hàng");
        binding.txtOrderDetailDesc.setText("Đơn hàng của bạn đã được đóng gói và đang trong quá trình chờ đơn vị vận chuyển.");
        binding.imvOrderStatus.setImageResource(R.drawable.order_package);

        orderDetailStatuses = new ArrayList<>();

        orderDetailStatuses.add(new OrderDetailStatus(R.drawable.order_package,
                "20/12/2022 - Đơn hàng đang chờ đơn vị vận chuyển."));
        orderDetailStatuses.add(new OrderDetailStatus(R.drawable.order_package,
                "19/12/2022 - Đơn hàng đã được đóng gói."));

        adapter = new OrderDetailStatusAdapter(OrderDetailActivity.this,
                R.layout.order_detail_status_item_list, orderDetailStatuses);
        binding.lvOrderStatus.setAdapter(adapter);

        addButtons();
    }

    private void loadDeliverData() {
        binding.txtOrderStatus.setText("Đang giao");
        binding.txtOrderDetailDesc.setText("Đơn hàng của bạn đã được giao cho đơn vị vận chuyển và đang trong quá trình vận chuyển đến bạn.");
        binding.imvOrderStatus.setImageResource(R.drawable.shipping);

        orderDetailStatuses = new ArrayList<>();

        orderDetailStatuses.add(new OrderDetailStatus(R.drawable.shipping,
                "26/12/2022 - Đơn hàng sẽ được giao tới bạn trong hôm nay."));
        orderDetailStatuses.add(new OrderDetailStatus(R.drawable.shipping,
                "22/12/2022 - Đơn hàng đang được vận chuyển."));
        orderDetailStatuses.add(new OrderDetailStatus(R.drawable.shipping,
                "21/12/2022 - Đơn vị vận chuyển đã lấy hàng"));


        adapter = new OrderDetailStatusAdapter(OrderDetailActivity.this,
                R.layout.order_detail_status_item_list, orderDetailStatuses);
        binding.lvOrderStatus.setAdapter(adapter);

        addButtons();
    }

    private void loadSuccessData() {
        binding.txtOrderStatus.setText("Giao thành công");
        binding.txtOrderDetailDesc.setText("Thanh toán khi nhận hàng.\nĐơn hàng của bạn đã được giao thành công. Đánh giá ngay bạn nhé!");
        binding.imvOrderStatus.setImageResource(R.drawable.evaluate);

        orderDetailStatuses = new ArrayList<>();

        orderDetailStatuses.add(new OrderDetailStatus(R.drawable.evaluate,
                "26/12/2022 - Giao hàng thành công.\nNgười nhận: Nguyễn Trần Bích Ngọc"));

        adapter = new OrderDetailStatusAdapter(OrderDetailActivity.this,
                R.layout.order_detail_status_item_list, orderDetailStatuses);
        binding.lvOrderStatus.setAdapter(adapter);

        addButtonsSuccess();

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

    private void addButtons(){
        Button btnContact = new Button(this);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);

        btnContact.setText("Liên hệ");
        customButton(btnContact,layoutParams);
        binding.llButton.addView(btnContact);
    }

    private void addButtonsSuccess(){
        Button btnContact = new Button(this);
        Button btnRebuy = new Button(this);
        Button btnReturn = new Button(this);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT,1f);
        layoutParams.setMargins(10,0,10,5);

        btnContact.setText("Liên hệ");
        customButton(btnContact,layoutParams);
        binding.llButton.addView(btnContact);

        btnRebuy.setText("Mua lại");
        customButton(btnRebuy,layoutParams);
        binding.llButton.addView(btnRebuy);

        btnReturn.setText("Trả hàng");
        customButton(btnReturn,layoutParams);
        binding.llButton.addView(btnReturn);
        btnReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(OrderDetailActivity.this,OrderReturnActivity.class));
            }
        });
    }

    private void customButton(Button button, LinearLayout.LayoutParams layoutParams) {
        button.setTextSize(20);
        button.setAllCaps(false);
        button.setTypeface(null, Typeface.BOLD);
        button.setBackground(getDrawable(R.drawable.round_border_1));
        button.setLayoutParams(layoutParams);
    }
}