package com.mano.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("ALC 1", "onCreate Activity Main");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("ALC1", "onStart Activity Main");

    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("ALC 1", "onResume Activity Main");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("ALC 1", "onPause Activity Main");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("ALC 1", "onStop Activity Main");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("ALC 1", "onDestroy Activity Main");
    }

    public void openWebPage() {
        changeText();
        Intent intent =  new Intent(MainActivity.this, Activity2.class);
        startActivity(intent);
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putString("value", "asdf");
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        String myString = savedInstanceState.getString("value");
        TextView view = findViewById(R.id.textView);
        view.setText(myString);
    }

    public void changeText()
    {
        TextView view = findViewById(R.id.textView);
        view.setText("Garmiii");
    }

}