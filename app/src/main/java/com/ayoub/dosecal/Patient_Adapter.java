package com.ayoub.dosecal;

import android.app.Activity;
import android.content.Context;

import android.content.Intent;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;


public class Patient_Adapter extends RecyclerView.Adapter<Patient_Adapter.Viewholder> {
    private Context context;
    private Activity activity;
    private ArrayList patient_id, patient_nom, patient_prenom,patient_sexe;

    public Patient_Adapter(Context context, Activity activity, ArrayList patient_id, ArrayList patient_nom, ArrayList patient_prenom, ArrayList patient_sexe) {
        this.context = context;
        this.activity = activity;
        this.patient_id = patient_id;
        this.patient_nom = patient_nom;
        this.patient_prenom = patient_prenom;
        this.patient_sexe = patient_sexe;
    }

    @NonNull
    @Override
    public Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.itemlist, parent, false);
        return new Viewholder(view);
    }
    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public void onBindViewHolder(@NonNull Viewholder holder, int position) {
        holder.nome.setText(String.valueOf(patient_nom.get(position)));
        holder.prenome.setText(String.valueOf(patient_prenom.get(position)));
        holder.img.setImageResource(R.drawable.medicine);
        Toast.makeText(context, position+"---"+patient_sexe.get(position).toString()+"---", Toast.LENGTH_LONG).show();
        if(patient_sexe.get(position).toString()=="homme"){holder.img.setImageResource(R.drawable.papa);}
        if(patient_sexe.get(position).toString()=="femme"){holder.img.setImageResource(R.drawable.maman);}
        holder.delete_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DBHelper myDB = new DBHelper(context);
                myDB.deleteOneRow(
                         patient_id.get(position).toString());
            }
        });
        holder.itemv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(context, update_pat.class);
                intent.putExtra("id", String.valueOf(patient_id.get(position)));
                intent.putExtra("nom", String.valueOf(patient_nom.get(position)));
                intent.putExtra("prenom", String.valueOf(patient_prenom.get(position)));
                activity.startActivityForResult(intent, 1);
            }
        });
    }

    @Override
    public int getItemCount() {return patient_id.size();}

    public class Viewholder extends RecyclerView.ViewHolder{
        ImageView img;
        TextView nome, prenome;
        Button delete_button;
        LinearLayout itemv;

        public Viewholder(@NonNull View itemView) {
            super(itemView);
            img=itemView.findViewById(R.id.imgitem);
            delete_button=itemView.findViewById(R.id.delete_button);
            nome = itemView.findViewById(R.id.namID);
            prenome = itemView.findViewById(R.id.prenamID);
            itemv=itemView.findViewById(R.id.itemv);
            Animation translate_anim = AnimationUtils.loadAnimation(context, R.anim.translate_anim);
            itemv.setAnimation(translate_anim);
        }
    }
}