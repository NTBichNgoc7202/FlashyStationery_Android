package com.race.flashystationery;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.RadioButton;

import com.race.adapters.ItemAdapter;
import com.race.adapters.ItemOrderAdapter;
import com.race.adapters.PaymentMethodAdapter;
import com.race.flashystationery.databinding.ActivityOrderPaymentBinding;
import com.race.models.Item;
import com.race.models.PaymentMethod;
import com.race.radiobuttonsupport.GRadioGroup;

import java.util.ArrayList;

public class OrderPaymentActivity extends AppCompatActivity {

    ActivityOrderPaymentBinding binding;
    ItemOrderAdapter orderAdapter;
    PaymentMethodAdapter paymentMethodAdapter;
    ArrayList<PaymentMethod> methods;
    ArrayList<Item> items;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // setContentView(R.layout.activity_order_payment);
        binding = ActivityOrderPaymentBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        getSupportActionBar().setTitle("Kiểm tra");
        addEvents();
    }

    private void addEvents() {
        binding.llAddressDetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(OrderPaymentActivity.this, AddressListActivity.class);
                startActivity(intent);
            }
        });
        binding.txtPaymentMethodView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Dialog dialogPM = new Dialog(OrderPaymentActivity.this);
                dialogPM.setContentView(R.layout.payment_method_dialog_list);
                Button btnConfirmPM;
                RadioButton radCash, radMomo, radZalo, radBank;
                btnConfirmPM = dialogPM.findViewById(R.id.btn_ConfirmPM);
                radCash = dialogPM.findViewById(R.id.rad_Cash);
                radMomo = dialogPM.findViewById(R.id.rad_Momo);
                radZalo = dialogPM.findViewById(R.id.rad_Zalo);
                radBank = dialogPM.findViewById(R.id.rad_Bank);

                GRadioGroup radPM = new GRadioGroup(radCash, radMomo, radZalo, radBank);
                btnConfirmPM.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialogPM.dismiss();
                    }
                });
                dialogPM.show();
            }
        });
        binding.txtShipmentView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Dialog dialogShip = new Dialog(OrderPaymentActivity.this);
                dialogShip.setContentView(R.layout.shipment_dialog);
                Button btnConfirmShip;
                RadioButton radStandard, radFast;
                btnConfirmShip = dialogShip.findViewById(R.id.btn_ConfirmShip);
                radStandard = dialogShip.findViewById(R.id.rad_Standard);
                radFast = dialogShip.findViewById(R.id.rad_Fast);

                GRadioGroup radShip = new GRadioGroup(radStandard, radFast);
                btnConfirmShip.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialogShip.dismiss();
                    }
                });
                dialogShip.show();
            }
        });
    }

    @Override
    protected void onResume() {
        loadItemData();
        loadMethodData();
        super.onResume();
    }

    private void loadMethodData() {
        methods = new ArrayList<>();
        methods.add(new PaymentMethod(R.drawable.cash, "COD", "Thanh toán khi nhận hàng"));
        methods.add(new PaymentMethod(R.drawable.momo, "******9808", "MoMo"));
        methods.add(new PaymentMethod(R.drawable.zalo, "******9808", "ZaloPay"));
        methods.add(new PaymentMethod(R.drawable.credit_card, "Thẻ ngân hàng", "BIDV"));

        paymentMethodAdapter = new PaymentMethodAdapter(OrderPaymentActivity.this, R.layout.payment_method_list, methods);
        binding.gvPaymentMethod.setAdapter(paymentMethodAdapter);
        binding.gvPaymentMethod.setSelection(0);
        binding.gvPaymentMethod.setItemChecked(0, true);
    }

    private void loadItemData() {
        items = new ArrayList<>();
        items.add(new Item(R.drawable.notebook, "1", "Sổ Tay Ghi Chép giấy kraft Nâu Có Dòng Kẻ", "Phân loại: 100 trang, Mẫu: 05", "SALE: kết thúc 31 thg 12 23:59:59", 48000));
        items.add(new Item(R.drawable.notebook4, "2", "Sổ Tay Ghi Chép giấy kraft Nâu Có Dòng Kẻ", "Phân loại: 100 trang, Mẫu: 05", null, 96000));

        orderAdapter = new ItemOrderAdapter(OrderPaymentActivity.this, R.layout.order_payment_item_list, items);
        binding.lvOrderPaymentItem.setAdapter(orderAdapter);
        binding.lvOrderPaymentItem.setExpanded(true);
    }
}