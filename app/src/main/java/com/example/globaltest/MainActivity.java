package com.example.globaltest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.globaltest.CustomAdapters.MyCustomAdapter;
import com.example.globaltest.Data.MyDataUsers;

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
        for(int i = 0; i < getData.JA_users.length(); i++)
        {
            try {
                JO = (JSONObject) getData.JA_users.get(i);
                userList.add(new MyDataUsers(
                        JO.getInt("id"),
                        JO.getString("first_name"),
                        JO.getString("second_name"),
                        JO.getString("last_name"),
                        JO.getString("city"),
                        JO.getString("url"),
                        JO.getString("age")));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        MyCustomAdapter adapter = new MyCustomAdapter(this, userList);
        mListView.setAdapter(adapter);

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent showData = new Intent(MainActivity.this, Person_list.class);
                showData.putExtra("id", position);
                startActivity(showData);
            }
        });
    }
}
