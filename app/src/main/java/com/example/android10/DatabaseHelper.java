package com.example.android10;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "library.db";
    private static final int DATABASE_VERSION = 1;

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String SQL_CREATE_BOOKS_TABLE = "CREATE TABLE " + BookContract.BookEntry.TABLE_NAME + " ("
                + BookContract.BookEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + BookContract.BookEntry.COLUMN_TITLE + " TEXT NOT NULL, "
                + BookContract.BookEntry.COLUMN_AUTHOR + " TEXT NOT NULL, "
                + BookContract.BookEntry.COLUMN_PUBLISHER + " TEXT NOT NULL, "
                + BookContract.BookEntry.COLUMN_PUBLISHED_YEAR + " INTEGER NOT NULL);";

        db.execSQL(SQL_CREATE_BOOKS_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String SQL_DELETE_BOOKS_TABLE = "DROP TABLE IF EXISTS " + BookContract.BookEntry.TABLE_NAME;
        db.execSQL(SQL_DELETE_BOOKS_TABLE);
        onCreate(db);
    }
}
