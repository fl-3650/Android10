package com.example.android10;

import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SharedPreferences sharedPreferences = getSharedPreferences("myPrefs", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("username", "User123");
        editor.putInt("sessionCount", 5);
        editor.putBoolean("loggedIn", true);
        editor.apply();

        sharedPreferences =
                getSharedPreferences("myPreferences", MODE_PRIVATE);
        String username = sharedPreferences.getString("username", "defaultUsername");
        int sessionCount = sharedPreferences.getInt("sessionCount", 0);
        boolean isLoggedIn = sharedPreferences.getBoolean("loggedIn", false);

        editor = sharedPreferences.edit();
        editor.remove("username");
        editor.clear();
        editor.apply();
    }
}