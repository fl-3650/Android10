package com.example.android10;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.android10.BookContract;

public class DatabaseManager {

    private DatabaseHelper databaseHelper;

    public DatabaseManager(Context context) {
        databaseHelper = new DatabaseHelper(context);
    }

    public long insertBook(String title, String author, String publisher, int publishedYear) {
        SQLiteDatabase db = databaseHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(BookContract.BookEntry.COLUMN_TITLE, title);
        values.put(BookContract.BookEntry.COLUMN_AUTHOR, author);
        values.put(BookContract.BookEntry.COLUMN_PUBLISHER, publisher);
        values.put(BookContract.BookEntry.COLUMN_PUBLISHED_YEAR, publishedYear);
        return db.insert(BookContract.BookEntry.TABLE_NAME, null, values);
    }

    public Cursor searchBook(String title) {
        SQLiteDatabase db = databaseHelper.getReadableDatabase();
        String[] projection = {
                BookContract.BookEntry._ID,
                BookContract.BookEntry.COLUMN_TITLE,
                BookContract.BookEntry.COLUMN_AUTHOR,
                BookContract.BookEntry.COLUMN_PUBLISHER,
                BookContract.BookEntry.COLUMN_PUBLISHED_YEAR
        };
        String selection = BookContract.BookEntry.COLUMN_TITLE + " LIKE ?";
        String[] selectionArgs = { "%" + title + "%" };
        return db.query(
                BookContract.BookEntry.TABLE_NAME,
                projection,
                selection,
                selectionArgs,
                null,
                null,
                null
        );
    }

    public int updateBook(String title, String newAuthor, String newPublisher, int newPublishedYear) {
        SQLiteDatabase db = databaseHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(BookContract.BookEntry.COLUMN_AUTHOR, newAuthor);
        values.put(BookContract.BookEntry.COLUMN_PUBLISHER, newPublisher);
        values.put(BookContract.BookEntry.COLUMN_PUBLISHED_YEAR, newPublishedYear);
        String selection = BookContract.BookEntry.COLUMN_TITLE + " LIKE ?";
        String[] selectionArgs = { title };
        return db.update(
                BookContract.BookEntry.TABLE_NAME,
                values,
                selection,
                selectionArgs
        );
    }

    public int deleteBook(String title) {
        SQLiteDatabase db = databaseHelper.getWritableDatabase();
        String selection = BookContract.BookEntry.COLUMN_TITLE + " LIKE ?";
        String[] selectionArgs = { title };
        return db.delete(
                BookContract.BookEntry.TABLE_NAME,
                selection,
                selectionArgs
        );
    }
}
