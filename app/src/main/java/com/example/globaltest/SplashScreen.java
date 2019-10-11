package com.example.globaltest;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class SplashScreen extends AppCompatActivity {
    public int timing = 0;
    public boolean b = false;
    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        getData get = new getData();
        get.execute();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                while(getData.JA_users.length() == 0 && getData.JA_comments.length() == 0){
                    try {
                        Thread.sleep(1000);
                        timing++;
                        if(timing > 10){
                            b = true;
                            break;
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                if(!b) {
                    startActivity(new Intent(SplashScreen.this, MainActivity.class));
                    finish();
                }
                else {
                    startActivity(new Intent(SplashScreen.this, ErrorConnect.class));
                    finish();
                }
            }
        },3000);
    }
}