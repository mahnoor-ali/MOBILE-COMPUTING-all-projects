package com.mano.theholyqran;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Intent intent;
    Button paraBtn;
    Button surahBtn;
    Button searchBtn;
    Button knowMore;
    DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        paraBtn = findViewById(R.id.parah);
        surahBtn = findViewById(R.id.surah);
        searchBtn = findViewById(R.id.search);
        knowMore = findViewById(R.id.know);


        paraBtn.setOnClickListener(view -> {
            intent = new Intent(MainActivity.this, ParaIndex.class);
            startActivity(intent);
        });

        surahBtn.setOnClickListener(view -> {
            intent = new Intent(MainActivity.this, SurahIndex.class);
            startActivity(intent);
        });

        searchBtn.setOnClickListener(view -> {
            Dialog dialog = new Dialog(MainActivity.this);
            dialog.setContentView(R.layout.activity_search_popup);
            // dialog.setCancelable(false);
            Button search = dialog.findViewById(R.id.searchbutton); //find search button that exists within dialog view
            Button dismiss = dialog.findViewById(R.id.dismiss);
            EditText nameField = dialog.findViewById(R.id.surahName);
            String surahName = nameField.getText().toString();
            dialog.show();
            search.setOnClickListener(view1 -> {
                intent = new Intent(MainActivity.this, surahView.class);
                int surahId = getSurahId(surahName);
                intent.putExtra("surahId", surahId);
                intent.putExtra("surahName", surahName);
                intent.putExtra("isSurah", 1);
                MainActivity.this.startActivity(intent);
            });
            dismiss.setOnClickListener(view2 -> {
                dialog.dismiss();
            });
         });

        knowMore.setOnClickListener(view -> {
            intent = new Intent(MainActivity.this, KnowMore.class);
            startActivity(intent);
         });

    }

    public int getSurahId(String name){
        int surahId = 0;
        db = new DatabaseHelper(MainActivity.this);
        surahId =  db.getSurahId(name);
        return surahId;
    }

}