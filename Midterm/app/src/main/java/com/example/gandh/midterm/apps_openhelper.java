package com.example.gandh.midterm;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by gandh on 3/19/2017.
 */

public class apps_openhelper extends SQLiteOpenHelper {

    static String name = "apps.db";
    static  int version = 3;

    public apps_openhelper(Context context)
    {
        super(context, name, null, version);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        apps_table.onCreate(db);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        apps_table.onUpgrade(db,oldVersion,newVersion);
    }
}
