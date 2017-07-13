package com.example.gandh.midterm;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
* Created by gandh on 3/19/2017.
*/

public class Adaptor_list extends ArrayAdapter {

 Context context;
    ArrayList<Shopping_items> added_cart;
    public Adaptor_list(Context context,  ArrayList<Shopping_items> added_cart) {
        super(context, R.layout.cartorhist, added_cart);
        this.context = context;
        this.added_cart= added_cart;
    }
   static class holder
    {
        View v;
        TextView tv;
        TextView tv1;
        ImageView iv;
        public holder(View v) {
            this.v = v;
             tv = (TextView) v.findViewById(R.id.title1);
            tv1 = (TextView) v.findViewById(R.id.price1);
             iv = (ImageView) v.findViewById(R.id.imag1);
        }
    }
    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView==null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.cartorhist, parent, false);
            holder h = new holder(convertView);
            convertView.setTag(h);
        }
        holder h = (holder) convertView.getTag();
        h.tv.setText( added_cart.get(position).getName());
        h.tv1.setText("price: "+added_cart.get(position).getSaleprice()+"$");
        Picasso.with(context).load(added_cart.get(position).getUrl()).into(h.iv);


        return convertView;
    }
}
