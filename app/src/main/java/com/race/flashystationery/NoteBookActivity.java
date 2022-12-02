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
        if (extraInfor.equals("itemnotebook")){
            loadNoteBook();
        }
    }

    private void loadNoteBook() {
        itemNoteBookArrayList = new ArrayList<>();
        itemNoteBookArrayList.add(new ItemNoteBook(R.drawable.planneritem,
                "Sổ kế hoạch lò xo kép Study Planner B5 160 trang",
                75000.0));
        itemNoteBookArrayList.add(new ItemNoteBook(R.drawable.notebook2,
                "Sổ Binder File Caro còng sắt B5 26 chấu 80 tờ",
                78000.0));

        itemNoteBookAdapter = new ItemNoteBookAdapter(NoteBookActivity.this,
                R.layout.notebook_item_list, itemNoteBookArrayList);
        binding.gvItemNoteBook.setAdapter(itemNoteBookAdapter);
    }
}