package com.mano.theholyqran;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Typeface;
import android.os.Build;
import android.os.Bundle;
import android.widget.TextView;

public class ayat_list_view extends AppCompatActivity {
    TextView ayatArabic;

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ayat_list_view);

        ayatArabic =  findViewById(R.id.ayatArabic);
        Typeface typeface = getResources().getFont(R.font.noorehuda);
        ayatArabic.setTypeface(typeface);
    }
}