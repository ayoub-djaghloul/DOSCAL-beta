package com.ayoub.dosecal;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class AdapterHome extends RecyclerView.Adapter<AdapterHome.myViewHolder> {
    private List<element> mData;
    private Context mcontext;

    public AdapterHome(List<element> mData, Context mcontext) {
        this.mData = mData;
        this.mcontext = mcontext;
    }

    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        LayoutInflater mInflater=LayoutInflater.from(mcontext);
        view=mInflater.inflate(R.layout.cardview,parent,false);
        return new myViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myViewHolder holder, int position) {
    holder.imgID.setImageResource(mData.get(position).getImg());
    holder.nameID.setText(mData.get(position).getName());
    holder.cardView.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (mData.get(position).getName()){
            case "Patient":{Intent sqsq=new Intent(mcontext,Patient.class);
            mcontext.startActivity(sqsq);
            break;}
            case "Medicament":{Intent inte1=new Intent(mcontext,Medicament.class);
                mcontext.startActivity(inte1);
                break;}
            case "Calculate":{Intent inte2=new Intent(mcontext,Calculator.class);
                mcontext.startActivity(inte2);
                break;}
            case "About":{Intent inte3=new Intent(mcontext,About.class);
                mcontext.startActivity(inte3);
                break;}
                default:;
            }
            }

    });
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static class myViewHolder extends  RecyclerView.ViewHolder{
        private TextView nameID;
        private ImageView imgID;
        private CardView cardView;
        public myViewHolder(@NonNull View itemView) {
            super(itemView);
            nameID=itemView.findViewById(R.id.nameID);
            imgID=itemView.findViewById(R.id.imgID);
            cardView=itemView.findViewById(R.id.cardview);
        }
    }
}
