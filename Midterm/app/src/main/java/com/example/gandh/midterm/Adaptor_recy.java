package com.example.gandh.midterm;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by gandh on 3/19/2017.
 */

public class Adaptor_recy extends RecyclerView.Adapter {
    Context context;
   ArrayList<Shopping_items> items;
    int i=0;
    onclickcart clicked;

    public Adaptor_recy(Context context,ArrayList<Shopping_items>  items,onclickcart clicked) {

        this.context = context;
        this.items = items;
        this.clicked = clicked;
    }
    interface onclickcart{
        void addtocart(int position);
    }
    class holder extends RecyclerView.ViewHolder
    {
        View v;
        ImageView iv;
        TextView tv1;
        TextView tv2;
        TextView tv3;
        Button b;
        public holder(View v) {
            super(v);
            this.v = v;
            iv = (ImageView) v.findViewById(R.id.image);
            tv1 = (TextView) v.findViewById(R.id.title);
            tv2 = (TextView) v.findViewById(R.id.price);
            tv3 = (TextView) v.findViewById(R.id.discount);
            b = (Button) v.findViewById(R.id.addtocart);


        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View v = inflater.inflate(R.layout.recycler, parent, false);
        holder h = new holder(v);
        return h;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        final holder h = (holder) holder;
        h.tv1.setText("Title "+items.get(position).getName());
        h.tv2.setText("Price: "+items.get(position).getSaleprice());
        h.tv3.setText("Discount: "+items.get(position).getDiscount()+"%");
        Picasso.with(context).load(items.get(position).getUrl()).into(h.iv);
        h.b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                clicked.addtocart(position);
                h.b.setEnabled(false);
            }
        });

    }

    @Override
    public int getItemCount() {
        return items.size();
    }
}
