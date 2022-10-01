package com.mano.theholyqran;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import androidx.annotation.Nullable;
import androidx.core.database.sqlite.SQLiteDatabaseKt;

import java.text.MessageFormat;
import java.util.ArrayList;

public class DatabaseHelper extends SQLiteOpenHelper
{

    public DatabaseHelper(@Nullable Context context) {
        super(context, "QuranDb.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
    }

    public ArrayList<Index> getSurahIndex()
    {
        ArrayList<Index> surahList = new ArrayList<>();
        String queryString = "SELECT SurahID, SurahNameE, SurahNameU FROM tsurah";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(queryString, null);
        if(cursor.moveToFirst())
        {
             do {
                int surahId  = cursor.getInt(0);
                String nameEnglish  = cursor.getString(1);
                if(nameEnglish!=null) {
                    String[] arr = nameEnglish.split(" ");
                    nameEnglish = arr[0];   //only name of surah in english
                }
                String nameUrdu  = cursor.getString(2);
                Index currentSurah = new Index( surahId , nameUrdu, nameEnglish);
                surahList.add(currentSurah);
            }while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return surahList;
    }

    public ArrayList<Ayat> getSurahAyats(int collectionNumber, String collectiontype) //collection represents whether its a parah or a surah
    {
        ArrayList<Ayat> surahAyats = new ArrayList<Ayat>();
        String idType="";
        if(collectiontype.equals("surah"))
        {
            idType="SuraID";
        }
        else
        {
            idType= "ParaID";
        }
        String queryString = "SELECT ArabicText, MehmoodulHassan, DrMohsinKhan FROM tayah WHERE " + idType +  " = " + collectionNumber ;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(queryString, null);
        if(cursor.moveToFirst())
        {
            do{
                String ayatArabic = cursor.getString(0);
                String translationU = cursor.getString(1);
                String translationE = cursor.getString(2);
                Ayat ayatSet = new Ayat(ayatArabic, translationE, translationU);
                surahAyats.add(ayatSet);
            }
            while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return surahAyats;
    }

    public int getSurahId(String surahName) //get surah Id by its name
    {
        String queryString = "SELECT SurahID FROM tsurah WHERE SurahNameU = " + surahName;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(queryString, null);
        int surahId=1;
        if(cursor.moveToFirst())
        {
            surahId  = cursor.getInt(0);
        }
        cursor.close();
        db.close();
        return surahId;
    }


}