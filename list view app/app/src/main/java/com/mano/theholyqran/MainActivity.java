package com.mano.theholyqran;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
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
            dialog.show();
            Button search = dialog.findViewById(R.id.searchbutton); //find search button that exists within dialog view
            Button dismiss = dialog.findViewById(R.id.dismiss);
            search.setOnClickListener(view1 -> {
                EditText nameField = (EditText)dialog.findViewById(R.id.surahName);
                String searchItem = nameField.getText().toString();
                intent = new Intent(MainActivity.this, surahView.class);
                intent.putExtra("isSearchResult", 1); //when the intent is from search request
                intent.putExtra("searchedVerse", searchItem);
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

}