package com.example.libraryapp;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteQuery;

import androidx.annotation.Nullable;

public class MyDatabaseHelper extends SQLiteOpenHelper {

   private Context context;
   private static final String Database_Name="BookLibrary.db";
   private static final int version =1;
   private static final String Table_Name ="myLibrary";
   private static final String Column_id ="_id";
   private static final String Column_Title ="book_title";
   private static final String Column_Author ="book_author";
   private static final String Column_Page ="book_pages";

    public MyDatabaseHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, Database_Name, null, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query=
                "CREATE TABLE "+Table_Name+
                        " ("+Column_id+" INTEGER PRIMARY KEY AUTOINCREMENT, "+
                        Column_Title+" TEXT, "+
                        Column_Author+" TEXT, "+
                        Column_Page+" INTEGER);";
        db.execSQL(query);


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL("DROP TABLE IF EXISTS "+Table_Name);
            onCreate(db);
    }
}
