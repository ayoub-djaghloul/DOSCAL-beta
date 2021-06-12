package com.ayoub.dosecal;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class Medicament extends AppCompatActivity {
Button add;
DBHelper myDB;
Item0list item;
RecyclerView rv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medicament);
        rv = findViewById(R.id.recv1);

        item=new Item0list(R.drawable.medicine,"Doliprane");
        List<Item0list> iii=new ArrayList<>();
        iii.add(item);
        Adaptermed adapter=new Adaptermed(this,iii);
        rv.setAdapter(adapter);
        rv.setLayoutManager(new LinearLayoutManager(Medicament.this));
add=findViewById(R.id.acceder);
        myDB = new DBHelper(Medicament.this);
add.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {

        Intent intent=new Intent(Medicament.this,add_med.class);
        startActivity(intent);
    }
});


}}