package com.ayoub.dosecal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private static int seconds=4000;
    Animation animbotom,animtop;
    ImageView logo;
    TextView appnam,appdesc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
        //link xml element with java variables
        animbotom= AnimationUtils.loadAnimation(this,R.anim.anim_bottom);
        animtop= AnimationUtils.loadAnimation(this,R.anim.anim_top);
        logo=findViewById(R.id.logo);
        appnam=findViewById(R.id.appnam);
        appdesc=findViewById(R.id.appdesc);
        //assign animations to elements
        logo.setAnimation(animbotom);
        appnam.setAnimation(animtop);
        appdesc.setAnimation(animtop);
        //translation
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent=new Intent(MainActivity.this,Home.class);
                startActivity(intent);
                finish();
            }
        },seconds);
    }
}