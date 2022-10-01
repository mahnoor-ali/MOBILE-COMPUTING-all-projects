package com.mano.theholyqran;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class AyatAdapter extends ArrayAdapter<Ayat> {

    public AyatAdapter(@NonNull Context context, @NonNull ArrayList<Ayat> list) {
        super(context, 0, list);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Ayat ayat = getItem(position);
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.activity_ayat_list_view, parent, false);
        }
         TextView ayatArabic =  convertView.findViewById(R.id.ayatArabic);
         ayatArabic.setText(ayat.getArabic());

         TextView ayatEnglish =  convertView.findViewById(R.id.translationE);
         ayatEnglish.setText(ayat.getEnglish());

         TextView ayatUrdu =  convertView.findViewById(R.id.translationU);
         ayatUrdu.setText(ayat.getUrdu());

        return  convertView;
    }

}
