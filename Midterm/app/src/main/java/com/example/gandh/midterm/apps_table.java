package com.example.gandh.midterm;

import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by gandh on 3/19/2017.
 */

public class apps_table {

    static String tablename= "apps";
    static String coulmn_id = "id";
    static   String coulumn_title = "name";
    static  String coulmn_price = "price";
    static  String coulmn_image = "image";
    static  String coulmn_unique = "uniquer";


    public static void onCreate(SQLiteDatabase db) {
        StringBuilder sb = new StringBuilder();
        sb.append("CREATE TABLE " +tablename+"(");
        sb.append(coulmn_id+" integer primary key autoincrement,");
        sb.append(coulumn_title+" text not null,");
        sb.append(coulmn_price+" text not null,");
        sb.append(coulmn_image+" text not null,");
        sb.append(coulmn_unique +" text not null );");
        try {
            db.execSQL(sb.toString());
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }


    }


    public static void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE if EXISTS "+tablename);
        apps_table.onCreate(db);
    }
}
