package com.example.globaltest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.globaltest.CustomAdapters.MyCustomAdapterForComments;
import com.example.globaltest.Data.MyDataComments;
import com.squareup.picasso.Picasso;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class Person_list extends AppCompatActivity {
    JSONObject JO_comments;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sasha_list);

        Bundle arguments = getIntent().getExtras();
        int pos = (Integer) arguments.get("id");
        TextView tv_first_name = findViewById(R.id.mi_tv_first_name);
        TextView tv_second_name = findViewById(R.id.mi_tv_second_name);
        TextView tv_last_name = findViewById(R.id.mi_tv_last_name);
        TextView tv_city = findViewById(R.id.mi_tv_city);
        TextView tv_age = findViewById(R.id.mi_tv_age);

        try {
            JSONObject JO = (JSONObject) getData.JA_users.get(pos);
            Picasso.with(this)
                    .load(JO.getString("url"))
                    .resize(170,170)
                    .placeholder(R.drawable.wait)
                    .error(R.drawable.error)
                    .into((ImageView) findViewById(R.id.mi_img_avatar));
            tv_first_name.append(" " + JO.getString("first_name"));
            tv_second_name.append(" " + JO.getString("second_name"));
            tv_last_name.append(" " + JO.getString("last_name"));
            tv_city.append(" " + JO.getString("city"));
            tv_age.append(" " + JO.getString("age"));

        } catch (JSONException e) {
            e.printStackTrace();
        }

        ListView mListView_comments = findViewById(R.id.listView_comments);
        ArrayList<MyDataComments> commentList = new ArrayList<>();

        for(int i = 0; i < getData.JA_comments.length(); i++){
            try {
                JO_comments = (JSONObject) getData.JA_comments.get(i);
                commentList.add(new MyDataComments(
                        JO_comments.getInt("id"),
                        JO_comments.getString("body")));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        Button b_gallery = findViewById(R.id.b_gallery);
        b_gallery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Person_list.this, Gallery.class));
                finish();
            }
        });

        MyCustomAdapterForComments adapter = new MyCustomAdapterForComments(this, commentList);
        mListView_comments.setAdapter(adapter);

    }
}
