package com.example.globaltest;

import android.content.Intent;
import android.os.Process;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class ErrorConnect extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_error_connect);

        Button exit = findViewById(R.id.b_exit);
        Button to_retry = findViewById(R.id.b_retry);

        ImageView error_img = findViewById(R.id.img_error);
        Picasso.with(this)
                .load(R.drawable.grystnii_smailik)
                .resize(220,220)
                .transform(new MyCustomTransformers())
                .into(error_img);

        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                android.os.Process.killProcess(Process.myPid());
                System.exit(1);
                finish();
            }
        });

        to_retry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ErrorConnect.this, SplashScreen.class));
                finish();
            }
        });
    }
}
