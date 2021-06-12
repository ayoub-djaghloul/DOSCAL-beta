package com.ayoub.dosecal;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.WindowManager;

import java.util.ArrayList;
import java.util.List;

public class Home extends AppCompatActivity {
    RecyclerView rv;
    List<element> elements;

    @Override
    public void onBackPressed() {
        final AlertDialog.Builder builder=new AlertDialog.Builder(Home.this);
        builder.setMessage("Are you sure you want to Exit ")
        .setTitle("Close The APP !")
        .setCancelable(true);
        builder.setIcon(getDrawable(R.drawable.ic_add));
        builder.setNegativeButton("NO", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        })
                .setPositiveButton("YES", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                });
        AlertDialog alertDialog=builder.create();
        alertDialog.show();


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_home);
    elements=new ArrayList<>();
    elements.add(new element("Patient",R.drawable.patient));
    elements.add(new element("Medicament",R.drawable.medicine));
    elements.add(new element("Calculate",R.drawable.calculator));
    elements.add(new element("About",R.drawable.accurate));

    rv=findViewById(R.id.rvID);
    AdapterHome adapterRecyclers =new AdapterHome(elements, this);
    rv.setLayoutManager(new GridLayoutManager(this,2));
    rv.setAdapter(adapterRecyclers);

}}