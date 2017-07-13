package com.example.gandh.midterm;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.UUID;

/**
 * Created by gandh on 3/20/2017.
 */

public class Cart extends AppCompatActivity {
    ArrayList<Shopping_items> added_cart;
     Adaptor_list list;

    Button cancel, checkout;
    Apps_manager manager;
    static ArrayList<String> order = new ArrayList<>();
    Apps_dao dao;
    ListView lv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cart);
        cancel = (Button) findViewById(R.id.cancel);
        checkout = (Button) findViewById(R.id.checkout);
        //added_cart = new ArrayList<>();
        added_cart = (ArrayList<Shopping_items>) getIntent().getExtras().getSerializable("key");
        lv = (ListView) findViewById(R.id.lv1);
        list = new Adaptor_list(this,added_cart);
        lv.setAdapter(list);
        list.setNotifyOnChange(true);
        lv.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                list.remove(added_cart.get(position));


                return false;
            }
        });
        manager = new Apps_manager(this);
        dao = manager.getNotedad();
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        checkout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String idOne = UUID.randomUUID().toString();
                for (Shopping_items it :
                        added_cart) {
                    it.setUniquer(idOne);
                    dao.save(it);
                }
               order.add(idOne);
                Intent i = new Intent();
                i.putExtra("key1","done");
                finish();

            }
        });
    }

}
