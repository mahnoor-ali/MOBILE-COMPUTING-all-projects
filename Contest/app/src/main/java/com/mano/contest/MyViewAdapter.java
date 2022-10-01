package com.mano.contest;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.ArrayList;

public class MyViewAdapter extends ArrayAdapter<String> {
    public MyViewAdapter(@NonNull Context context, ArrayList<String> parahList) {
        super(context, 0, parahList);
    }


    @Override public View getView(int position, View convertView, @NonNull ViewGroup parent) {
                String paraNum = getItem(position);
                convertView = LayoutInflater.from(getContext()).inflate(R.layout.activity_parahs, parent, false);
                TextView textViewName =  convertView.findViewById(R.id.parahIndex);
                textViewName.setText(paraNum);
                return convertView;
    }
}
