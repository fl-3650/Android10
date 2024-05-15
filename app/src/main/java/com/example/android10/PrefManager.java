package com.example.android10;

import android.content.Context;
import android.content.SharedPreferences;

public class PrefManager {
    private SharedPreferences sharedPreferences;

    public PrefManager(Context context) {
        this.sharedPreferences = context.getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
    }

    public void saveUserName(String userName) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("UserName", userName);
        editor.apply();
    }

    public String getUserName() {
        return sharedPreferences.getString("UserName", "DefaultName");
    }

    public void updateUserName(String newName) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("UserName", newName);
        editor.apply();
    }

    public void deleteUserName() {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.remove("UserName");
        editor.apply();
    }
}
