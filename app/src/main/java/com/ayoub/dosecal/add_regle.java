package com.ayoub.dosecal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class add_regle extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    EditText min,max,resultat;
    Button add,confirm;
    public String text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_regle);

        min=findViewById(R.id.minID);
        max=findViewById(R.id.maxID);
        resultat=findViewById(R.id.resultatiD);

        Spinner spinner = findViewById(R.id.spinner1);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
        R.array.names, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter (adapter);
        spinner.setOnItemSelectedListener(this);
        add=findViewById(R.id.addregle);
        confirm=findViewById(R.id.confirmregle);
        Bundle ii=getIntent().getExtras();
        String s=ii.getString("medname");
        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(add_regle.this, "Medicament Added", Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(add_regle.this,Medicament.class);
                intent.putExtra("medname",s);
                startActivity(intent);
            }
        });
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Toast.makeText(add_regle.this, text+"  "+s+" Added", Toast.LENGTH_LONG).show();
                DBHelper myDB = new DBHelper(add_regle.this);
               /* myDB.addregle(s,text,Integer.valueOf(min.getText().toString().trim()),Integer.valueOf(max.getText().toString().trim())
                        ,resultat.getText().toString().trim());*/
               /* min.setText("");
                max.setText("");
                resultat.setText("");*/
            }
        });
    }

    @Override
    public  void  onItemSelected ( AdapterView <?>  parent , View  view , int  position , long  id ) {
        text = parent . getItemAtPosition (position) . toString ();
       //Toast.makeText(parent.getContext(), text, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

}
