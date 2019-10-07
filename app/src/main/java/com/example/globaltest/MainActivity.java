package com.example.globaltest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    JSONObject JO;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView mListView = findViewById(R.id.listView);
        ArrayList<MyDataUsers> userList = new ArrayList<>();
        for(int i = 0; i < getData.JA.length(); i++)
        {
            try {
                JO = (JSONObject) getData.JA.get(i);
                userList.add(new MyDataUsers(
                        JO.getInt("id"),
                        JO.getString("first_name"),
                        JO.getString("second_name"),
                        JO.getString("last_name"),
                        JO.getString("city"),
                        JO.getString("age")));
                Log.e("HPL ME PLS", JO.getString("first_name"));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }



        MyCustomAdapter adapter = new MyCustomAdapter(this, userList);
        mListView.setAdapter(adapter);
    }
}
