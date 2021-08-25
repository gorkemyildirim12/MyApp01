package com.capstone.repositories;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.capstone.entity.Patient;
import com.capstone.sqlHelpers.SqlHelper;

public class PatientRepository {
    private SQLiteDatabase database;
    private SqlHelper helper;
    public static final String[] PATIENT_COLUMNS = new String[]{"_id" , "patientName" , "patientSurname" , "patientGender"
     , "email" , "patientAge" , "patientHeight" , "patientWeight" , "patientShoeNumber"};

    public PatientRepository(Context context) {
        helper = new SqlHelper(context);
        database = helper.getWritableDatabase();
    }
    public void close(){
        helper.close();
    }

    public long insert(Patient patient){
        ContentValues values = new ContentValues();
        //values.put("patientId" , patient.getPatientId());
        values.put("patientName" , patient.getPatientName());
        values.put("patientSurname" , patient.getPatientSurname());
        values.put("patientGender" , patient.getPatientGender());
        values.put("email" , patient.getEmail());
        values.put("patientAge" , patient.getPatientAge());
        values.put("patientHeight" , patient.getPatientHeight());
        values.put("patientWeight" , patient.getPatientWeight());
        values.put("patientShoeNumber" , patient.getShoeNumber());
        return database.insert("patient" , null , values);
    }
    public void update(Patient patient){
        ContentValues values = new ContentValues();
        values.put("patientName" , patient.getPatientName());
        values.put("patientSurname" , patient.getPatientSurname());
        values.put("patientGender" , patient.getPatientGender());
        values.put("email" , patient.getEmail());
        values.put("patientAge" , patient.getPatientAge());
        values.put("patientHeight" , patient.getPatientHeight());
        values.put("patientWeight" , patient.getPatientWeight());
        values.put("patientShoeNumber" , patient.getShoeNumber());
        database.update("patient" , values , "_id=" + patient.getPatientId() , null);
    }
    public void delete(Patient patient){
        database.delete("patient" , "_id=" + patient.getPatientId() , null);
    }
    public Cursor find(Patient patient){
        Cursor cursor = database.query("patient" ,  PATIENT_COLUMNS ,"_id=" + patient.getPatientId() ,
                null , null,null , null);
        if(cursor != null){
            cursor.moveToFirst();
        }
        return cursor;
    }

    public Cursor list(){
        return database.query("patient" , PATIENT_COLUMNS , null , null , null , null , null);
    }

}
