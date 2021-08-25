package com.capstone.sqlHelpers;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import androidx.annotation.Nullable;

public class SqlHelper extends SQLiteOpenHelper {

    public SqlHelper(@Nullable Context context) {
        super(context, "Patient",null , 26);
}

    @Override
    public void onCreate(SQLiteDatabase database) {

        String createPatientDB = "create table patient(" +
                "_id integer primary key autoincrement , " +
                "patientName varchar(100) not null ," +
                "patientSurname varchar(100) not null ," +
                "patientGender varchar(20) not null , " +
                "email varchar(200) not null," +
                "patientAge integer not null," +
                "patientHeight float not null ," +
                "patientWeight float not null, " +
                "patientShoeNumber integer not null)";
        database.execSQL(createPatientDB);

        String createLeftFootDB = "create table leftFoot(" +
                "_id integer primary key autoincrement , " +
                "strideTime float not null ," +
                "groundReactForce float not null)";
        database.execSQL(createLeftFootDB);

        String createRightFootDB = "create table rightFoot(" +
                "_id integer primary key autoincrement , " +
                "strideTime float not null ," +
                "groundReactForce float not null)";
        database.execSQL(createRightFootDB);
    }

    @Override
    public void onUpgrade(SQLiteDatabase database, int oldVersion, int newVersion) {
        String dropPatientDB = "drop table if exists patient";
        database.execSQL(dropPatientDB);
        onCreate(database);

        String dropLeftFootDB = "drop table if exists leftFoot";
        database.execSQL(dropLeftFootDB);
        onCreate(database);

        String dropRightFootDB = "drop table if exists rightFoot";
        database.execSQL(dropRightFootDB);
        onCreate(database);
    }
}
