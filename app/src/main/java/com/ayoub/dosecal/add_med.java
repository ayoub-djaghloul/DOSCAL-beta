package com.ayoub.dosecal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class add_med extends AppCompatActivity {

    private EditText nommed;
    private CheckBox cl,tgo;
    private Button suivant,cancel;
    private int st;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_med);
        suivant=findViewById(R.id.addmed);
        cancel=findViewById(R.id.returnmed);
        nommed=findViewById(R.id.nommed);
        cl=findViewById(R.id.clID);
        tgo=findViewById(R.id.tgoID);

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(add_med.this, "Mediacament not Added!", Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(add_med.this,Medicament.class);
                startActivity(intent);
            }
        });
        suivant.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(cl.isChecked()==true&&tgo.isChecked()==false){st=1;}
               else if(tgo.isChecked()==true&&cl.isChecked()==false){st=2;}
               else if(cl.isChecked()==true&&tgo.isChecked()==true)st=3;
                DBHelper myDB = new DBHelper(add_med.this);
                myDB.addmed(nommed.getText().toString().trim(),st);
                Intent intent=new Intent(add_med.this,add_regle.class);
                intent.putExtra("medname",nommed.getText().toString());
                startActivity(intent);
//                Toast.makeText(add_med.this, "Ajouter Les Regles de votre medicament", Toast.LENGTH_SHORT).show();
            }
        });

    }
}