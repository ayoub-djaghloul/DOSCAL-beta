package com.ayoub.dosecal;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

public class add_pat extends AppCompatActivity {
    private EditText nom,prenom,age,poids;
    private RadioButton homme,femme;
    private Button add_button;
    String st;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patients);
        nom=findViewById(R.id.nomID);
        prenom=findViewById(R.id.prenomID);
        age=findViewById(R.id.ageID);
        poids=findViewById(R.id.poidsID);
        homme=findViewById(R.id.hommeID);femme=findViewById(R.id.femmeID);
        add_button=findViewById(R.id.add_btn);

        add_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(homme.isChecked()==true){st="homme";}
                if(femme.isChecked()==true){st="femme";}
                DBHelper myDB = new DBHelper(add_pat.this);
                myDB.addpatient(
                        nom.getText().toString().trim(),
                        prenom.getText().toString().trim(),
                        Integer.valueOf(age.getText().toString().trim()),
                        Integer.valueOf(poids.getText().toString().trim()),
                        st.trim());
            }
        });


    }
}