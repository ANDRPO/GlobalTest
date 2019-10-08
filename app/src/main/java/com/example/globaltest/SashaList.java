package com.example.globaltest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import org.json.JSONException;
import org.json.JSONObject;

public class SashaList extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sasha_list);

        Bundle arguments = getIntent().getExtras();
        int pos = (Integer) arguments.get("id");
        TextView tv_fi_n = findViewById(R.id.fi_n);
        TextView tv_se_n = findViewById(R.id.se_n);
        TextView tv_la_n = findViewById(R.id.la_n);
        TextView tv_city = findViewById(R.id.tv_city);
        TextView tv_age = findViewById(R.id.tv_age);

        try {
            JSONObject JO = (JSONObject) getData.JA.get(pos);
            Picasso.get()
                    .load(JO.getString("url"))
                    .resize(500,500)
                    .into((ImageView) findViewById(R.id.img_avatar));
            Log.e("HLP ME PLS",JO.getString("url"));
            tv_fi_n.append(JO.getString("first_name"));
            tv_se_n.append(JO.getString("second_name"));
            tv_la_n.append(JO.getString("last_name"));
            tv_city.append(JO.getString("city"));
            tv_age.append(JO.getString("age"));
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }
}
