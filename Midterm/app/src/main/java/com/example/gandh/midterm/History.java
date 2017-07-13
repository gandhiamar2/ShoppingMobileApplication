package com.example.gandh.midterm;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

import static android.R.id.list;

/**
 * Created by gandh on 3/20/2017.
 */

public class History extends AppCompatActivity {

    Button cancel;
    Adaptor_list list;
    ArrayList<Shopping_items> added_cart;
    Apps_manager manager;
    Apps_dao dao;
    ListView lv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.history);
        CharSequence cs= getIntent().getExtras().getCharSequence("indexE");
        String s = cs+"";
        cancel = (Button) findViewById(R.id.cancelonhistory);
        manager = new Apps_manager(this);
        dao = manager.getNotedad();
        added_cart = dao.getall(s);
        lv = (ListView) findViewById(R.id.lv2);
        list = new Adaptor_list(this,added_cart);

        lv.setAdapter(list);

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }
}
