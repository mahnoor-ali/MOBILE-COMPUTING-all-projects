package com.mano.customizedlistview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class MyAdapter extends ArrayAdapter<Student> {
    public MyAdapter(@NonNull Context context, int resource, @NonNull List<Student> objects) {
        super(context, resource, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        //isi class m jb hm n resources get krny thy tw get context k through kam kia tha. so, in order to use intent
        // and move from current activity to another activity, the current activity is get through getContect()
        LayoutInflater.from(getContext(),);

        return super.getView(position, convertView, parent);

    }
//listView ki ek entry/entity ka parent group ListView ha.. that's the parent in combrty BORE
    // studentView that is a physical xml file is attached to the code using Layout inflator.
    //jese main activity k sath xml ko attach krny k lie setContenView k through connect krty hn.
    //isi tarah yaha convertView k through us xml ko is code s associate kia.. jb k mainActivity wly case m diectly use krlety hn





}
