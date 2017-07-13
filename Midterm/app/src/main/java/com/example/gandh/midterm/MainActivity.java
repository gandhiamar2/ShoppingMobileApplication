package com.example.gandh.midterm;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements  Async_apps.list_gen,Adaptor_recy.onclickcart {
ProgressBar pb;
    RecyclerView rv;
    Adaptor_recy recy;

    ArrayList<Shopping_items> added_cart;
    ArrayList<Shopping_items> items;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       Toolbar t=(Toolbar)findViewById(R.id.tool_bar);
        setSupportActionBar(t);
        pb = (ProgressBar) findViewById(R.id.pb1);
        rv = (RecyclerView) findViewById(R.id.rc1);
        GridLayoutManager grid = new GridLayoutManager(this,3);
        rv.setLayoutManager(grid);
        if(isconnected())
        {
            added_cart = new ArrayList<>();
            new Async_apps(this).execute("http://52.90.79.130:8080/MidTerm/get/products");

        }

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.cart:
                if (added_cart.size() != 0) {
                    Intent ic = new Intent(this, Cart.class);
                    ic.putExtra("key", added_cart);
                    startActivityForResult(ic, 200);
                } else
                    Toast.makeText(this, "No items on cart", Toast.LENGTH_SHORT);
                break;
            case R.id.history:
                if (Cart.order.size() != 0){
                    final String[] cs = new String[Cart.order.size()];
                for (int j = 0; j < cs.length; j++) {
                    cs[j] = "order" + j;
                }
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setTitle("Pick a Movie")
                        .setItems(cs, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Intent iE = new Intent(MainActivity.this, History.class);

                                iE.putExtra("indexE", Cart.order.get(which));

                                startActivity(iE);
                            }
                        });
                builder.create().show();
                 }
        else
                    Toast.makeText(this, "No orders", Toast.LENGTH_SHORT);

                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }


    boolean isconnected()
    {
        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo nw = cm.getActiveNetworkInfo();
        if(nw.isConnected() && nw!=null)
        {
            return true;
        }
        else
            return false;
    }

    @Override
    public void list_generator(ArrayList<Shopping_items> items) {
        pb.setVisibility(pb.INVISIBLE);
        this.items = items;
        recy = new Adaptor_recy(this,items,MainActivity.this);
        rv.setAdapter(recy);
    }

    @Override
    public void addtocart(int position) {
    added_cart.add(items.get(position));
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 200) {
            if (getIntent() != null && getIntent().getExtras() != null) {
                if (data.getExtras().get("key1") != null) {
                    added_cart = new ArrayList<>();
                    new Async_apps(this).execute("http://52.90.79.130:8080/MidTerm/get/products");

                }
                super.onActivityResult(requestCode, resultCode, data);
            }
        }
    }

}
