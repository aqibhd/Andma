package com.netlify.aqib.andmaapp;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.netlify.aqib.andma.Andma;

public class HomeActivity extends AppCompatActivity {
    TextView typeShow;
    Boolean isDARK=true;
    int THEME;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ImageView custom_btn,default_btn,theme_btn,success_btn,info_btn,warning_btn,error_btn;
        custom_btn=findViewById(R.id.btn_custom);
        theme_btn=findViewById(R.id.btn_theme);
        default_btn=findViewById(R.id.btn_default);
        success_btn=findViewById(R.id.btn_success);
        info_btn=findViewById(R.id.btn_info);
        warning_btn=findViewById(R.id.btn_warning);
        error_btn=findViewById(R.id.btn_error);
        typeShow=findViewById(R.id.typeShow);
        theme_btn.setOnClickListener(v->isDARK=!isDARK);
        custom_btn.setOnClickListener(v->{
            THEME=checkTheme();
            Andma.show(HomeActivity.this,"This is a custom type Andma",THEME,Andma.INFO);
            typeShow.setText("custom");
            typeShow.setVisibility(View.VISIBLE);
            reset();

        });
        success_btn.setOnClickListener(v->{
            THEME=checkTheme();
            Andma.show(HomeActivity.this,"This is a success type Andma",THEME,Andma.SUCCESS);
            typeShow.setText("success");
            typeShow.setVisibility(View.VISIBLE);
            reset();

        });
        info_btn.setOnClickListener(v->{
            THEME=checkTheme();
            Andma.show(HomeActivity.this,"This is a info type Andma",THEME,Andma.INFO);
            typeShow.setText("info");
            typeShow.setVisibility(View.VISIBLE);
            reset();

        });
        default_btn.setOnClickListener(v->{
            THEME=checkTheme();
            Andma.show(HomeActivity.this,"This is a default type Andma",THEME,Andma.DEFAULT);
            typeShow.setText("default");
            typeShow.setVisibility(View.VISIBLE);
            reset();
        });
        warning_btn.setOnClickListener(v->{
            THEME=checkTheme();
            Andma.show(HomeActivity.this,"This is a warning type Andma",THEME,Andma.WARNING);
            typeShow.setText("warning");
            typeShow.setVisibility(View.VISIBLE);
            reset();
        });
        error_btn.setOnClickListener(v->{
            THEME=checkTheme();
            Andma.show(HomeActivity.this,"This is a error type Andma",THEME,Andma.ERROR);
            typeShow.setText("error");
            typeShow.setVisibility(View.VISIBLE);
            reset();
        });
    }
    public void reset()
    {
        Handler hd=new Handler();
        hd.postDelayed(() -> typeShow.setVisibility(View.INVISIBLE), 3000);

    }
    public int checkTheme()
    {
        if(isDARK)
        {
            return Andma.DARK;
        }
        else return Andma.LIGHT;
    }
}