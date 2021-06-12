package com.ayoub.dosecal;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class DBHelper extends SQLiteOpenHelper {
    private Context context;
    private static String DATABASE_NAME="Userdata.db";
    private static String TABLE_NAME="Patient";
    private static String COLUMN_id="_id";
    private static String COLUMN_nom="nom";
    private static String COLUMN_prenom="prenom";
    private static String COLUMN_age="age";
    private static String COLUMN_poids="poids";
    private static String COLUMN_sexe="sexe";


    public DBHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, 1);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase DB) {
        String Table_Patient="create Table "+TABLE_NAME+
                " ("+ COLUMN_id +" INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_nom+" TEXT, "+
                COLUMN_prenom+" TEXT, "+
                COLUMN_age+" INTEGER, "+
                COLUMN_poids+" INTEGER, "+
                COLUMN_sexe+" TEXT);";
        DB.execSQL(Table_Patient);
        String Table_Med="create Table Medicament"+
                " ("+ "nommed Text PRIMARY KEY, "+
                "bilan INTEGER);";
        DB.execSQL(Table_Med);
        String Table_regles="create Table Regles"+
                " ("+ "idregle INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "nommed_regle TEXT, "+
                "nombilan TEXT, "+
                "min INTEGER, "+
                "max INTEGER, "+
                "result TEXT);";
        DB.execSQL(Table_regles);


    }

    @Override
    public void onUpgrade(SQLiteDatabase DB, int oldVersion, int newVersion) {
        DB.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        DB.execSQL("DROP TABLE IF EXISTS Medicament");
        DB.execSQL("DROP TABLE IF EXISTS Regles");
        onCreate(DB);
    }

    void deleteAllData(){
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("DELETE FROM " + TABLE_NAME);
    }
    void addpatient(String nom,String prenom,int age,int poids,String sexe){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(COLUMN_nom,nom);
        cv.put(COLUMN_prenom,prenom);
        cv.put(COLUMN_age,age);
        cv.put(COLUMN_poids,poids);
        cv.put(COLUMN_sexe,sexe);
        long result=db.insert(TABLE_NAME,null,cv);
        if(result==-1) {
            Toast.makeText(context,"failed",Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(context,"Added successfully!",Toast.LENGTH_SHORT).show();
        }
    }
    void addmed(String nom,int bilan){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("nommed",nom);
        cv.put("bilan",bilan);
        long result=db.insert("Medicament",null,cv);
        if(result==-1) {
            Toast.makeText(context,"Med failed",Toast.LENGTH_LONG).show();
        }
        else { Toast.makeText(context,"Added successfully!",Toast.LENGTH_LONG).show();}
    }
    void addregle(String nommed_regle,String nombilan,int min,int max,String results){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("nommed_regle", nommed_regle);
        cv.put("nombilan", nombilan);
        cv.put("min", min);
        cv.put("max", max);
        cv.put("result", results);
        long result = db.insert("Regles",null, cv);
        if(result == -1){
            Toast.makeText(context, "Regle Failed", Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(context, "Added Successfully!", Toast.LENGTH_SHORT).show();
        }
    }
    void deleteOneRow(String row_id){
        SQLiteDatabase db = this.getWritableDatabase();
        long result = db.delete(TABLE_NAME, "_id=?", new String[]{row_id});
        if(result == -1){
            Toast.makeText(context, "Failed to Delete", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(context, "Successfully Deleted", Toast.LENGTH_SHORT).show();
        }
    }
    public Cursor readAllData(){
        String query = "SELECT * FROM " + TABLE_NAME;
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = null;
        if(db != null){
            cursor = db.rawQuery(query, null);
        }
        return cursor;
    }

    void updateData(String _id,String nom,String prenom,int age,int poids,String sexe){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(COLUMN_nom,nom);
        cv.put(COLUMN_prenom,prenom);
        cv.put(COLUMN_age,age);
        cv.put(COLUMN_poids,poids);
        cv.put(COLUMN_sexe,sexe);

        long result = db.update(TABLE_NAME, cv, "_id=?", new String[]{_id});
        if(result == -1){
            Toast.makeText(context, "Failed", Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(context, "Updated Successfully!", Toast.LENGTH_SHORT).show();
        }

    }


    }

