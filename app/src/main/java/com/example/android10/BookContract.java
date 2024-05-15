package com.example.android10;

import android.provider.BaseColumns;

public class BookContract {

    public static class BookEntry implements BaseColumns {
        public static final String TABLE_NAME = "book";
        public static final String COLUMN_TITLE = "title";
        public static final String COLUMN_AUTHOR = "author";
        public static final String COLUMN_PUBLISHER = "publisher";
        public static final String COLUMN_PUBLISHED_YEAR = "published_year";
    }
}
