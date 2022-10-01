package com.mano.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class Activity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);
        Log.d("ALC 2", "onCreate Activity2");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("ALC 2", "onStart Activity2");

    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("ALC 2", "onResume Activity2");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("ALC 2", "onPause Activity2");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("ALC 2", "onStop Activity2");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("ALC 2", "onDestroy Activity2");
    }



}