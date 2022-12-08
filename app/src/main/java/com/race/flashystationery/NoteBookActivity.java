package com.race.flashystationery;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.race.adapters.ItemNoteBookAdapter;
import com.race.flashystationery.databinding.ActivityNoteBookBinding;
import com.race.models.Item;
import com.race.models.ItemNoteBook;

import java.util.ArrayList;

public class NoteBookActivity extends AppCompatActivity {
    ActivityNoteBookBinding binding;
    ItemNoteBookAdapter itemNoteBookAdapter;
    ArrayList<ItemNoteBook> itemNoteBookArrayList;
    ImageView imvPhoto;
    TextView txtNoteName, txtNotePrice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_note_book);

        binding = ActivityNoteBookBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        String extraInfor = getIntent().getStringExtra("noteList");
        if (extraInfor.equals("notebook")){
            loadNoteBook();
        } else if (extraInfor.equals("book")){
            loadBook();
        } else if (extraInfor.equals("learningtool")){
            loadLearingTool();
        } else if (extraInfor.equals("files")) {
            loadFiles();
        }
    }
    private void loadNoteBook() {
        itemNoteBookArrayList = new ArrayList<>();
        itemNoteBookArrayList.add(new ItemNoteBook(R.drawable.planneritem,
                "Sổ kế hoạch lò xo kép Study Planner B5 160 trang",
                75000.0));
        itemNoteBookArrayList.add(new ItemNoteBook(R.drawable.socongbianhua,
                "Sổ Binder File Caro còng sắt B5 26 chấu 80 tờ",
                78000.0));
        itemNoteBookArrayList.add(new ItemNoteBook(R.drawable.notebook1,
                "Sổ lò xo kép Caro 200 trang B5 giấy dày chống lem",
                45000.0));
        itemNoteBookArrayList.add(new ItemNoteBook(R.drawable.soloxodona4,
                "Sổ lò xo đơn Caro (6x6)mm 200 trang A4",
                48000.0));
        itemNoteBookArrayList.add(new ItemNoteBook(R.drawable.soloxodona4300tr,
                "Sổ lò xo đơn Caro (6x6)mm 300 trang A4",
                69000.0));
        itemNoteBookArrayList.add(new ItemNoteBook(R.drawable.soloxokepdot200tr,
                "Sổ lò xo kép Dot Grid B5 200 trang",
                51000.0));
        itemNoteBookArrayList.add(new ItemNoteBook(R.drawable.soloxodot,
                "Sổ lò xo kép Dot Grid B5 200 trang",
                49000.0));
        itemNoteBookArrayList.add(new ItemNoteBook(R.drawable.sovecaocap40to,
                "Sổ vẽ lò xo đa năng Creative Art A5 - 150 GSM - 40 tờ",
                50000.0));
        itemNoteBookArrayList.add(new ItemNoteBook(R.drawable.ruotsocongdot100to,
                "Ruột sổ còng Dot Grid B5 120/76 - 100 tờ",
                34000.0));
        itemNoteBookArrayList.add(new ItemNoteBook(R.drawable.ruotsocongcaro100to,
                "Ruột sổ còng Caro B5 120/76 - 100 tờ",
                34000.0));

        itemNoteBookAdapter = new ItemNoteBookAdapter(NoteBookActivity.this,
                R.layout.notebook_item_list, itemNoteBookArrayList);
        binding.lvNoteBook.setAdapter(itemNoteBookAdapter);
        binding.txtProductType.setText("SỔ");
    }
    private void loadBook() {
        itemNoteBookArrayList = new ArrayList<>();
        itemNoteBookArrayList.add(new ItemNoteBook(R.drawable.book1,
                "Vở kẻ ngang Click cỡ A4 260 trang",
                29000.0));
        itemNoteBookArrayList.add(new ItemNoteBook(R.drawable.vokengang120tr,
                "Vở kẻ ngang Future 120 trang A4",
                17000.0));
        itemNoteBookArrayList.add(new ItemNoteBook(R.drawable.vokengangloxo80tr,
                "Vở kẻ ngang lò xo Lined 80 trang B5",
                20000.0));
        itemNoteBookArrayList.add(new ItemNoteBook(R.drawable.vomaydangay80tr,
                "Vở may dán gáy Lined B5 80 trang",
                16000.0));
        itemNoteBookArrayList.add(new ItemNoteBook(R.drawable.vokengang72tr,
                "Vở kẻ ngang Dream B5 72 trang",
                7000.0));
        itemNoteBookArrayList.add(new ItemNoteBook(R.drawable.vokengangdangay120tr,
                "Vở kẻ ngang may dán gáy Prime B5 120 trang",
                14000.0));
        itemNoteBookArrayList.add(new ItemNoteBook(R.drawable.vomaydangay200tr,
                "Vở may dán gáy Lined 200 trang B5",
                32000.0));
        itemNoteBookArrayList.add(new ItemNoteBook(R.drawable.voloxokepbianhua,
                "Vở lò xo kép bìa nhựa Caro B5 (6x6)mm 120 trang",
                26000.0));
        itemNoteBookAdapter = new ItemNoteBookAdapter(NoteBookActivity.this,
                R.layout.notebook_item_list, itemNoteBookArrayList);
        binding.lvNoteBook.setAdapter(itemNoteBookAdapter);
        binding.txtProductType.setText("VỞ");
    }

    private void loadLearingTool() {
        itemNoteBookArrayList = new ArrayList<>();
        itemNoteBookArrayList.add(new ItemNoteBook(R.drawable.butmura,
                "Bút bi gel Mura ngòi 0.5mm",
                8000.0));
        itemNoteBookArrayList.add(new ItemNoteBook(R.drawable.bangphamauggiay,
                "Bảng pha màu giấy Paper Palette",
                29000.0));
        itemNoteBookArrayList.add(new ItemNoteBook(R.drawable.butbixanh,
                "Bút Bi 0.5 mm Treeden - Thiên Long TL-079 - Mực Xanh",
                5000.0));
        itemNoteBookArrayList.add(new ItemNoteBook(R.drawable.ruotchi2b,
                "Ruột Chì 2B 0.5 mm Gold XQ 502 (70 mm x 30 Ngòi)",
                12000.0));
        itemNoteBookArrayList.add(new ItemNoteBook(R.drawable.butchi,
                "Bút Chì Gỗ 2B Smart Kids Exam Standard SK-092 - Thân Đỏ",
                3000.0));
        itemNoteBookArrayList.add(new ItemNoteBook(R.drawable.butnuocdo,
                "Bút Bi Viết Gel Mực Nước Mini Ngòi 0.5mm - Mực Đỏ",
                7000.0));
        itemNoteBookArrayList.add(new ItemNoteBook(R.drawable.butdaquangvang,
                "Bút Dạ Quang Pastel - Bitex HL05 - Mild Yellow",
                8000.0));
        itemNoteBookAdapter = new ItemNoteBookAdapter(NoteBookActivity.this,
                R.layout.notebook_item_list, itemNoteBookArrayList);
        binding.lvNoteBook.setAdapter(itemNoteBookAdapter);
        binding.txtProductType.setText("DỤNG CỤ HỌC TẬP");
    }
    private void loadFiles() {
        itemNoteBookArrayList = new ArrayList<>();
        itemNoteBookArrayList.add(new ItemNoteBook(R.drawable.filecongsata5,
                "Binder File còng sắt A5",
                28000.0));
        itemNoteBookArrayList.add(new ItemNoteBook(R.drawable.filecongsat30chaua4,
                "Binder File còng sắt 30 chấu A4",
                56000.0));
        itemNoteBookArrayList.add(new ItemNoteBook(R.drawable.filecongnhuab5,
                "Binder File còng nhựa B5",
                39000.0));
        itemNoteBookArrayList.add(new ItemNoteBook(R.drawable.keptailieucaocapa4,
                "Kẹp trình ký cao cấp A4",
                72000.0));
        itemNoteBookArrayList.add(new ItemNoteBook(R.drawable.filecongsat26chaub5,
                "Binder File còng sắt 26 chấu B5",
                45000.0));

        itemNoteBookAdapter = new ItemNoteBookAdapter(NoteBookActivity.this,
                R.layout.notebook_item_list, itemNoteBookArrayList);
        binding.lvNoteBook.setAdapter(itemNoteBookAdapter);
        binding.txtProductType.setText("FILES");
    }

}