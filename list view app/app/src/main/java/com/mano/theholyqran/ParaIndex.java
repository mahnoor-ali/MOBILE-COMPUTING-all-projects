package com.mano.theholyqran;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ParaIndex extends AppCompatActivity {
    ListView parahListView;
    ParahNames para;
    ArrayList<Index> paraNames;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_para_index);
        paraNames = new ArrayList<Index>();
        para = new ParahNames();
        for (int i = 0; i < 30; i++)
        {
            Index paraa = new Index(i+1, para.UrduParahName[i], para.englishParahName[i]);
            paraNames.add(paraa);
        }
        ViewAdapter adapter = new ViewAdapter(this, paraNames);
        parahListView = findViewById(R.id.paraList);
        parahListView.setAdapter(adapter);

        parahListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parentView, View view, int position, long l) {
                // show the selected surah
                Index selectedPara = (Index) parentView.getItemAtPosition(position);
                Intent intent = new Intent(ParaIndex.this, surahView.class);
                intent.putExtra("paraId", selectedPara.getId());
                String paraName = selectedPara.getId() + "- " + selectedPara.getNameUrdu() ;
                intent.putExtra("paraName", paraName);
                intent.putExtra("isPara", 1);
                startActivity(intent);
            }
        });


    }

}