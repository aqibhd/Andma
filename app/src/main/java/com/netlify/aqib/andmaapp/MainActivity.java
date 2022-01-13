package com.netlify.aqib.andmaapp;


import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Handler hd=new Handler();
        hd.postDelayed(() -> {
            startActivity(new Intent(MainActivity.this,HomeActivity.class));
            finish();
        },5000);
    }
}