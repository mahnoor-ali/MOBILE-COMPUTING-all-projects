package com.mano.contest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView parahListView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ArrayList<String> paraList = new ArrayList<String>();
        for (int i=0; i<30; i++)
        {
            String number = "Parah -- " + i;
            paraList.add(number);
        }
        MyViewAdapter adapter = new MyViewAdapter(this, paraList);
        parahListView = findViewById(R.id.parahsList);
        parahListView.setAdapter(adapter);
    }
}