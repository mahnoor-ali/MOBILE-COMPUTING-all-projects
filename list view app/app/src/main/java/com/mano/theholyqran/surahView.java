package com.mano.theholyqran;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class surahView extends AppCompatActivity {
    ArrayList<Ayat> surah;
      //  ListView surahListView;
    RecyclerView surahListView;
    RecyclerView.LayoutManager layoutManager;
    RecyclerView.Adapter adapter;
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
        String searchedVerse = intent.getStringExtra("searchedVerse");
        int isSearchResult = intent.getIntExtra("isSearchResult", 0);

        int id=0;
        String collectionType="";
        title=findViewById(R.id.title);
         if(isSearchResult==1) //get list of ayahs if intent is from search result
         {
             title.setText("Searched: " + searchedVerse);
             db = new DatabaseHelper(surahView.this);
             surah = db.searchVerse(searchedVerse);
        }
         else {  //get surah or parah if intent is from surah index or parah index respectively

             if (isPara == 1) //if the intent to start new activity is from paraIndex activity, show ayats by para number
             {
                 id = paraId;
                 collectionType = "para";
                 title.setText(paraName);
             } else if (isSurah == 1) //if the intent to start new activity is from surah Index activity, show ayats by surah number
             {
                 id = surahId;
                 collectionType = "surah";
                 title.setText(surahName);
             }

             db = new DatabaseHelper(surahView.this);
             surah = db.getSurahAyats(id, collectionType);
         }

         //set the recycler view with the arrayList got from query
        surahListView = findViewById(R.id.surah);
        surahListView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(surahView.this);
        surahListView.setLayoutManager(layoutManager);
        adapter = new AyatListAdapter(surah) ;
        surahListView.setAdapter(adapter);
    }
}