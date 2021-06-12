package com.ayoub.dosecal;

import android.app.AlertDialog;
import android.content.Context;

import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;



public class Adaptermed extends RecyclerView.Adapter<Adaptermed.Viewholder> {
    Context context;
    List<Item0list> listitems;

    public Adaptermed(Context context, List<Item0list> listitems) {
        this.context = context;
        this.listitems = listitems;
    }

    @NonNull
    @Override
    public Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.itemlist,parent,false);
        return new Viewholder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull Viewholder holder, int position) {
        Item0list listitem= listitems.get(position);
        holder.img.setImageResource(R.drawable.medicine);
        holder.t1.setText(listitem.getName());
        holder.t2.setText("");
        /*holder.itemv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(context, add_med.class);
                intent.putExtra("name", String.valueOf(listitem.getName()));
                intent.putExtra("desc", "djdj");
                context.startActivity(intent);
            }
        });*/
        holder.delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder ss=new AlertDialog.Builder(context);
                ss.setMessage("Are you to delete this item ?")
                        .setTitle("Delete !")
                        .setCancelable(true);
                ss.setIcon(R.drawable.ic_add);
                ss.setNegativeButton("NO", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                })
                        .setPositiveButton("YES", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                listitems.remove(position);
                                notifyItemRemoved(position);
                                notifyItemRangeChanged(position,listitems.size());
                            }
                        });
                AlertDialog s=ss.create();
                s.show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return listitems.size();
    }

    public class Viewholder extends RecyclerView.ViewHolder{
        ImageView img;
        Button delete;
        LinearLayout itemv;
        TextView t1,t2;
        Button add;
        public Viewholder(@NonNull View itemView) {
            super(itemView);
            itemv=itemView.findViewById(R.id.itemv);
            img=itemView.findViewById(R.id.imgitem);
            t1=itemView.findViewById(R.id.namID);
            t2= itemView.findViewById(R.id.prenamID);
            add=itemView.findViewById(R.id.add);
            delete= itemView.findViewById(R.id.delete_button);
        }
    }
}