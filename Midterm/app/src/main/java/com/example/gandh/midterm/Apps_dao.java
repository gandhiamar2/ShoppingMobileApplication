package com.example.gandh.midterm;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;

/**
 * Created by gandh on 3/19/2017.
 */

public class Apps_dao {
    private SQLiteDatabase db;

    public Apps_dao(SQLiteDatabase db) {
        this.db = db;
    }

    ArrayList<Shopping_items> shopfromdb = new ArrayList<>();
    long save(Shopping_items notes)
    {
        ContentValues cv = new ContentValues();
        cv.put(apps_table.coulumn_title,notes.getName());
        cv.put(apps_table.coulmn_price,notes.getSaleprice());
        cv.put(apps_table.coulmn_image,notes.getUrl());
        cv.put(apps_table.coulmn_unique,notes.getUniquer());
        return db.insert(apps_table.tablename,null,cv);
    }

    boolean update(Shopping_items notes)
    {
        ContentValues cv = new ContentValues();
        cv.put(apps_table.coulumn_title,notes.getName());
        cv.put(apps_table.coulmn_price,notes.getSaleprice());
        cv.put(apps_table.coulmn_image,notes.getUrl());
        cv.put(apps_table.coulmn_image,notes.getUniquer());


        return db.update(apps_table.tablename,cv,apps_table.coulmn_id+"=?",new String[]{notes.id+""})>0;
    }

    boolean delete(Shopping_items notes)
    {
        return  db.delete(apps_table.tablename,apps_table.coulmn_id+"=?",new String[]{notes.id+""})>0;
    }

    Shopping_items get(Long id)
    {
        Shopping_items note = null;
        Cursor c=   db.query(true,apps_table.tablename,new String[]{apps_table.coulmn_id,apps_table.coulumn_title,apps_table.coulmn_price,apps_table.coulmn_image}
                ,apps_table.coulmn_id+"=?",new String[]{id+""},null,null,null,null);

        if(c!=null && c.moveToFirst())
        {
            note = notefromcurso(c);
            if(!c.isClosed())
                c.close();
        }

        return note;
    }
    ArrayList<Shopping_items> getall(String uniquerl)
    {

        Cursor c=   db.query(true,apps_table.tablename,new String[]{apps_table.coulmn_id,apps_table.coulumn_title,apps_table.coulmn_price,apps_table.coulmn_image},
                apps_table.coulmn_unique+"=?",new String[]{uniquerl+""},null,null,null,null);

        if(c!=null && c.moveToFirst())
        {
            do {
                Shopping_items note12 = notefromcurso(c);
                if(note12!=null) {

                    shopfromdb.add(note12);

                }

            }while (c.moveToNext());
            if(!c.isClosed())
                c.close();
        }

        return shopfromdb;
    }

    Shopping_items notefromcurso(Cursor c)
    {
        Log.d("test","entered c");
        Shopping_items note = null;
        if(c!=null)
        {
            note = new Shopping_items();
            note.setId(c.getLong(0));
            note.setName(c.getString(1));
            note.setSaleprice(c.getString(2));
            note.setUrl(c.getString(3));
            return note;
        }

        return  null;


    }


}
