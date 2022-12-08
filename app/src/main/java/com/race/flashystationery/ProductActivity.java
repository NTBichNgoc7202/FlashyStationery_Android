package com.race.flashystationery;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.race.adapters.PhotoAdapter;
import com.race.flashystationery.databinding.ActivityProductBinding;
import com.race.models.Photos;

import java.util.ArrayList;
import java.util.List;

import me.relex.circleindicator.CircleIndicator;

public class ProductActivity extends AppCompatActivity {
    ViewPager viewPager;
    CircleIndicator ccIndicatior;
    PhotoAdapter photoAdapter;
    ActivityProductBinding binding;
    ImageView photoProduct;
    BottomSheetDialog dialogOptionProduct;
    int getQuantityCart;
    TextView txtQuantity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_product);
        binding = ActivityProductBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        //photoProduct = findViewById(R.id.img_Photo);

        viewPager = binding.viewpager;
        ccIndicatior = binding.ccIndicator;

        photoAdapter = new PhotoAdapter(ProductActivity.this, getListPhotos());
        viewPager.setAdapter(photoAdapter);

        ccIndicatior.createIndicators(4,0);
        ccIndicatior.animatePageSelected(2);
        ccIndicatior.setViewPager(viewPager);
        photoAdapter.registerDataSetObserver(ccIndicatior.getDataSetObserver());
        txtQuantity = binding.txtQuantity;
        int quantityCart = Integer.parseInt(txtQuantity.getText().toString());

        addEvents();
    }

    private void setRadioButtonStyle(RadioButton rad) {
        rad.setButtonDrawable(R.drawable.radiobutton_selector);
    }

    private void addEvents() {
        binding.txtAddCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (dialogOptionProduct == null) {
                    dialogOptionProduct = new BottomSheetDialog(ProductActivity.this);
                    dialogOptionProduct.setContentView(R.layout.product_option_dialog);
                    Button btnConfirmPM;
                    RadioButton radBlue, radPink;
                    ImageView imvSelectedItem;
                    TextView txtSelectedCatogery ;
                    btnConfirmPM = dialogOptionProduct.findViewById(R.id.btn_ConfirmPM);
                    radBlue = dialogOptionProduct.findViewById(R.id.rad_blue);
                    radPink = dialogOptionProduct.findViewById(R.id.rad_pink);
                    imvSelectedItem = dialogOptionProduct.findViewById(R.id.imv_SelectedItem);
                    txtSelectedCatogery = dialogOptionProduct.findViewById(R.id.txt_SelectedCategory);



                    setRadioButtonStyle(radBlue);
                    setRadioButtonStyle(radPink);
                    radBlue.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            radBlue.setChecked(true);
                            radPink.setChecked(false);
                            txtSelectedCatogery.setText(radBlue.getText().toString());
                            imvSelectedItem.setImageResource(R.drawable.plan_notebook_blue);
                        }
                    });
                    radPink.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            radPink.setChecked(true);
                            radBlue.setChecked(false);
                            txtSelectedCatogery.setText(radPink.getText().toString());
                            imvSelectedItem.setImageResource(R.drawable.plan_notebook_pink);
                        }
                    });

                }
                dialogOptionProduct.show();

            }
        });
        binding.txtChat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ProductActivity.this, MessageSupport.class);
                startActivity(intent);
            }
        });
        binding.txtBuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ProductActivity.this, OrderPaymentActivity.class);
                startActivity(intent);
            }
        });
    }

    private List<Photos> getListPhotos() {
        List<Photos> list = new ArrayList<>();
        list.add(new Photos(R.drawable.plan_notebook));
        list.add(new Photos(R.drawable.plan_notebook1));
        list.add(new Photos(R.drawable.plan_notebook2));
        list.add(new Photos(R.drawable.plan_notebook3));
        return  list;
    }
}