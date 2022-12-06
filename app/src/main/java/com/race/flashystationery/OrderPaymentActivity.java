package com.race.flashystationery;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.RadioButton;

import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.race.adapters.ItemAdapter;
import com.race.adapters.ItemOrderAdapter;
import com.race.adapters.PaymentMethodAdapter;
import com.race.flashystationery.databinding.ActivityOrderPaymentBinding;
import com.race.models.Item;
import com.race.models.PaymentMethod;

import java.util.ArrayList;

public class OrderPaymentActivity extends AppCompatActivity {

    ActivityOrderPaymentBinding binding;
    ItemOrderAdapter orderAdapter;
    PaymentMethodAdapter paymentMethodAdapter;
    ArrayList<PaymentMethod> methods;
    ArrayList<Item> items;
    BottomSheetDialog bottomSheetPM, bottomSheetShip;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // setContentView(R.layout.activity_order_payment);
        binding = ActivityOrderPaymentBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        getSupportActionBar().setTitle("Kiểm tra");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
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
        binding.includeOrderFooter.btnConfirmOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(OrderPaymentActivity.this, OrderSuccessActivity.class);
                startActivity(intent);
            }
        });
        binding.txtPaymentMethodView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (bottomSheetPM == null) {
                    bottomSheetPM = new BottomSheetDialog(OrderPaymentActivity.this);
                    bottomSheetPM.setContentView(R.layout.payment_method_dialog_list);
                    Button btnConfirmPM;
                    RadioButton radCash, radMomo, radZalo, radBank;
                    btnConfirmPM = bottomSheetPM.findViewById(R.id.btn_ConfirmPM);
                    radCash = bottomSheetPM.findViewById(R.id.rad_Cash);
                    radMomo = bottomSheetPM.findViewById(R.id.rad_Momo);
                    radZalo = bottomSheetPM.findViewById(R.id.rad_Zalo);
                    radBank = bottomSheetPM.findViewById(R.id.rad_Bank);

                    setRadioButtonStyle(radZalo);
                    setRadioButtonStyle(radMomo);
                    setRadioButtonStyle(radBank);
                    setRadioButtonStyle(radCash);
//                    GRadioGroup radPM = new GRadioGroup(radCash, radMomo, radZalo, radBank);
                    radCash.setChecked(true);
                    btnConfirmPM.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            bottomSheetPM.dismiss();
                        }
                    });
                    radCash.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            radCash.setChecked(true);
                            radBank.setChecked(false);
                            radMomo.setChecked(false);
                            radZalo.setChecked(false);
                        }
                    });
                    radMomo.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            radCash.setChecked(false);
                            radBank.setChecked(false);
                            radMomo.setChecked(true);
                            radZalo.setChecked(false);
                        }
                    });
                    radZalo.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            radCash.setChecked(false);
                            radBank.setChecked(false);
                            radMomo.setChecked(false);
                            radZalo.setChecked(true);
                        }
                    });
                    radBank.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            radCash.setChecked(false);
                            radBank.setChecked(true);
                            radMomo.setChecked(false);
                            radZalo.setChecked(false);
                        }
                    });
                }
                bottomSheetPM.show();
            }
        });
        binding.txtShipmentView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (bottomSheetShip == null) {
                    bottomSheetShip = new BottomSheetDialog(OrderPaymentActivity.this);
                    bottomSheetShip.setContentView(R.layout.shipment_dialog);
                    Button btnConfirmShip;
                    RadioButton radStandard, radFast;
                    btnConfirmShip = bottomSheetShip.findViewById(R.id.btn_ConfirmShip);
                    radStandard = bottomSheetShip.findViewById(R.id.rad_Standard);
                    radFast = bottomSheetShip.findViewById(R.id.rad_Fast);

                    setRadioButtonStyle(radFast);
                    setRadioButtonStyle(radStandard);
//                    GRadioGroup radShip = new GRadioGroup(radStandard, radFast);
                    radStandard.setChecked(true);
                    radStandard.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            radStandard.setChecked(true);
                            radFast.setChecked(false);

                        }
                    });
                    radFast.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            radStandard.setChecked(false);
                            radFast.setChecked(true);
                        }
                    });
                    btnConfirmShip.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            bottomSheetShip.dismiss();
                        }
                    });
                }
                    bottomSheetShip.show();
            }
        });
    }

    private void setRadioButtonStyle(RadioButton rad) {
        rad.setButtonDrawable(R.drawable.radiobutton_selector);
    }

    @Override
    protected void onResume() {
        loadItemData();
        loadData();
        loadMethodData();
        super.onResume();
    }

    private void loadData() {
        double preTotalPrice = 0, totalPrice = 0;
        for (int position = 0; position < items.size(); position++){
            preTotalPrice += items.get(position).getItemPrice();
        }
        totalPrice = preTotalPrice + 16000;
        binding.txtPreTotalPrice.setText(preTotalPrice + "đ");
        binding.txtTotalPrice.setText( totalPrice + "đ");
        binding.includeOrderFooter.txtFinalTotalPrice.setText(totalPrice + " đ");
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

    public void loadItemData() {
        items = new ArrayList<>();
        items.add(new Item(R.drawable.notebook, "1", "Sổ Tay Ghi Chép giấy kraft Nâu Có Dòng Kẻ", "Phân loại: 100 trang, Mẫu: 05", "SALE: kết thúc 31 thg 12 23:59:59", 48000));
        items.add(new Item(R.drawable.notebook4, "2", "Sổ Tay Ghi Chép giấy kraft Nâu Có Dòng Kẻ", "Phân loại: 100 trang, Mẫu: 05", null, 96000));

        orderAdapter = new ItemOrderAdapter(OrderPaymentActivity.this, R.layout.order_payment_item_list, items);
        binding.lvOrderPaymentItem.setAdapter(orderAdapter);
        binding.lvOrderPaymentItem.setExpanded(true);
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