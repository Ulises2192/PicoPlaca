package com.example.picoyplaca;

import android.app.Application;

import com.example.picoyplaca.db.DatabaseManager;


public class PicoPlacaApplication extends Application {

    public static DatabaseManager databaseManager;

    @Override
    public void onCreate() {
        super.onCreate();

        databaseManager = DatabaseManager.getInstance(getApplicationContext());
    }
}
