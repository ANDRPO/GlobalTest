package com.example.globaltest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.example.globaltest.CustomAdapters.MyCustomAdapterImage;
import com.example.globaltest.Data.ImageUrl;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class Gallery extends AppCompatActivity {

    private ImageView imageView;
    RecyclerView recyclerView;
    GridLayoutManager gridLayoutManager;
    public static float screen_width;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);
        Log.wtf("Sasga PIDOR", "SASHA GEY");
        imageView = findViewById(R.id.imageView);
        recyclerView = findViewById(R.id.recyclerView);
        gridLayoutManager = new GridLayoutManager(getApplicationContext(), 2);
        recyclerView.setLayoutManager(gridLayoutManager);

        ArrayList<ImageUrl> imageList = new ArrayList<>();
        for(int i = 0; i < getData.JA_users.length(); i++) {
            try {
                JSONObject JO = (JSONObject) getData.JA_users.get(i);
                imageList.add(new ImageUrl(JO.getString("url")));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        DisplayMetrics metrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metrics);
        screen_width = metrics.widthPixels;

        MyCustomAdapterImage dataAdapter = new MyCustomAdapterImage(getApplicationContext(), imageList);
        recyclerView.setAdapter(dataAdapter);
    }
}