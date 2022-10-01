package com.mano.theholyqran;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class surahView extends AppCompatActivity {
        ArrayList<Ayat> surah;
        ListView surahListView;
        DatabaseHelper db;
        TextView title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_surah_view);

        Intent intent = getIntent();
        int isPara = intent.getIntExtra("isPara", -1);
        int isSurah = intent.getIntExtra("isSurah", -1);
        int paraId = intent.getIntExtra("paraId", 1);
        String paraName = intent.getStringExtra("paraName");
        int surahId = intent.getIntExtra("surahId", 1);
        String surahName = intent.getStringExtra("surahName");
        int id=0;
        String collectionType="";
        title=findViewById(R.id.title);

        if(isPara==1) //if the intent to start new activity is from paraIndex activity, show ayats by para number
        {
          id=paraId;
          collectionType="para";
          title.setText(paraName);
        }
        else if(isSurah==1) //if the intent to start new activity is from surah Index activity, show ayats by surah number
        {
            id=surahId;
            collectionType="surah";
            title.setText(surahName);
        }

        db = new DatabaseHelper(surahView.this);
        surah = db.getSurahAyats(id, collectionType);

        AyatAdapter adapter = new AyatAdapter(this, surah);
        surahListView = findViewById(R.id.surah);
        surahListView.setAdapter(adapter);


    }
}