package com.example.gandh.midterm;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;

import org.json.JSONException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

/**
 * Created by gandh on 2/23/2017.
 */

public class Async_apps extends AsyncTask<String,Void,ArrayList<Shopping_items>> {
    Shopping_util util = new Shopping_util();
    list_gen activity;

    public Async_apps(list_gen activity) {
        this.activity = activity;
    }

    @Override
    protected ArrayList<Shopping_items> doInBackground(String... params) {
        try {
            URL url = new URL(params[0]);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            BufferedReader bfr = new BufferedReader(new InputStreamReader(con.getInputStream()));
            StringBuilder sb = new StringBuilder();
            String add = "";
            while((add=bfr.readLine())!=null)
            {
                sb.append(add);
            }

            return util.parser(sb.toString());

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    protected void onPostExecute(ArrayList<Shopping_items> items) {
        activity.list_generator(items);
    }

    interface list_gen{

        void list_generator(ArrayList<Shopping_items> items);
    }
}
