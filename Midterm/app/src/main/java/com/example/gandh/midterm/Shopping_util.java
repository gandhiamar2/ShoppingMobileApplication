package com.example.gandh.midterm;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by gandh on 3/20/2017.
 */

public class Shopping_util {

    ArrayList<Shopping_items> items ;
    Shopping_items shopitem;

    ArrayList<Shopping_items> parser(String data) throws JSONException {
        items = new ArrayList<>();
        JSONArray a1 = new JSONArray(data);
        for (int i=0; i<a1.length();i++) {
            shopitem = new Shopping_items();
            JSONObject o1 = a1.getJSONObject(i);
            shopitem.setName(o1.getString("name"));
            JSONObject o2 = o1.getJSONObject("image_urls");
           JSONArray a2 = o2.getJSONArray("300x400");
            JSONObject o3 = a2.getJSONObject(0);
            shopitem.setUrl(o3.getString("url"));
            JSONArray a3 = o1.getJSONArray("skus");
            JSONObject o4 = a3.getJSONObject(0);
            shopitem.setMsrpprice(o4.getString("msrp_price"));
            shopitem.setSaleprice(o4.getString("sale_price"));
            Double disc = (Double.parseDouble(shopitem.getMsrpprice())-Double.parseDouble(shopitem.getSaleprice()))*100/(Double.parseDouble(shopitem.getMsrpprice()));
            String str = String.format("%1.2f", disc);
            shopitem.setDiscount(str);


            Log.d("demo",shopitem.toString());
        items.add(shopitem);
        }

        return  items;
    }
}
