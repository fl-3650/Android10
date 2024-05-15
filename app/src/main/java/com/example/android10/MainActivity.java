package com.example.android10;

import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        PrefManager prefManager = new PrefManager(this);
        prefManager.saveUserName("John Doe");
        String userName = prefManager.getUserName();
        prefManager.updateUserName("New Name");
        prefManager.deleteUserName();
    }
}