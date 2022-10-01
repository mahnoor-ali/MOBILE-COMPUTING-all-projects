package com.mano.theholyqran;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class SurahIndex extends AppCompatActivity {
    DatabaseHelper db;
    ListView surahListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_surah_index);
        db = new DatabaseHelper(SurahIndex.this);
        ArrayList<Index> SurahIndexes = db.getSurahIndex();
        ViewAdapter adapter = new ViewAdapter(this, SurahIndexes);
        surahListView = findViewById(R.id.surahList);
        surahListView.setAdapter(adapter);

        surahListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parentView, View view, int position, long l) {
                // show the selected surah
                Index selectedSurah = (Index) parentView.getItemAtPosition(position);
                Intent intent = new Intent(SurahIndex.this, surahView.class);
                intent.putExtra("surahId", selectedSurah.getId());
                String surahName= selectedSurah.getId() + "- " +  " سورة " + selectedSurah.getNameUrdu();
                intent.putExtra("surahName", surahName);
                intent.putExtra("isSurah", 1);
                startActivity(intent);
            }
        });
    }
}