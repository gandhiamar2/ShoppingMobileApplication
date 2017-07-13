package com.example.gandh.midterm;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by gandh on 3/20/2017.
 */

public class Apps_manager {

    Context context;
    private apps_openhelper openHelper;
    private SQLiteDatabase db;
    static  Apps_dao notedad;

    public Apps_manager(Context context) {
        this.context = context;
        openHelper = new apps_openhelper(context);
        db = openHelper.getWritableDatabase();
        //  openHelper.onCreate(db);
        notedad = new Apps_dao(db);
    }

    public static Apps_dao getNotedad() {
        return notedad;
    }
    void close(){
        if(db!=null)
        {
            db.close();
        }
    }
}
