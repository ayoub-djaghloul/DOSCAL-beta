package com.ayoub.dosecal;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class Patient extends AppCompatActivity {

    RecyclerView recyclerView;
    FloatingActionButton add_button;
    ImageView empty_imageview;
    TextView no_data;
    DBHelper myDB;
    ArrayList<String> patient_id, patient_nom, patient_prenom, patient_age,patient_poids,patient_sexe;
    Patient_Adapter patientAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient);

        recyclerView = findViewById(R.id.recv);
        add_button = findViewById(R.id.bbb);
        empty_imageview = findViewById(R.id.empty_imageview);
        no_data = findViewById(R.id.no_data);
        add_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Patient.this, add_pat.class);
                startActivity(intent);
            }
        });



        myDB = new DBHelper(Patient.this);
        patient_id = new ArrayList<>();
        patient_nom = new ArrayList<>();
        patient_prenom = new ArrayList<>();
        patient_age = new ArrayList<>();
        patient_poids=new  ArrayList<>();
        patient_sexe=new  ArrayList<>();

        patientAdapter = new Patient_Adapter(Patient.this,this,patient_id,
                patient_nom,patient_prenom,patient_sexe);

        recyclerView.setAdapter(patientAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(Patient.this));

        storeDataInArrays();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 1){
            recreate();
        }
    }

    void storeDataInArrays(){
        Cursor cursor = myDB.readAllData();
        int i=0;
        if(cursor.getCount() == 0){
            Toast.makeText(this, "empty", Toast.LENGTH_SHORT).show();
            empty_imageview.setVisibility(View.VISIBLE);
            no_data.setVisibility(View.VISIBLE);
        }else{
            while (cursor.moveToNext()){i++;
                patient_id.add(cursor.getString(0));
                patient_nom.add(cursor.getString(1));
                patient_prenom.add(cursor.getString(2));
                patient_age.add(cursor.getString(3));
                patient_poids.add(cursor.getString(4));
                patient_sexe.add(cursor.getString(5));
                Toast.makeText(this, "test "+patient_id.get(0)+" "+patient_nom.get(0)+" "+patient_prenom.get(0)+" "+patient_age.get(0)+" "+patient_poids.get(0)+" "+patient_sexe.get(0), Toast.LENGTH_SHORT).show();
            }
            Toast.makeText(this, "Nombres des patients : "+i+" Patient", Toast.LENGTH_SHORT).show();
            empty_imageview.setVisibility(View.GONE);
            no_data.setVisibility(View.GONE);
            patientAdapter.notifyDataSetChanged();
        }
    }
}
