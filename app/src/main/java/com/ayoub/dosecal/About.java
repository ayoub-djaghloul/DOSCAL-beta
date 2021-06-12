package com.ayoub.dosecal;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class About extends AppCompatActivity {
    Button bbb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        bbb=findViewById(R.id.b2);
        bbb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(About.this,Home.class);
                startActivity(intent);
            }
        });
    }
}