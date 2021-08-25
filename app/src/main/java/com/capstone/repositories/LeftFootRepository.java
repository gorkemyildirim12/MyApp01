package com.capstone.repositories;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.capstone.entity.FootType;
import com.capstone.sqlHelpers.SqlHelper;

public class LeftFootRepository {
    private SQLiteDatabase database;
    private SqlHelper helper;
    public static final String[] FOOT_COLUMNS = new String[]{"_id", "groundReactForce" ,"strideTime"};

    public LeftFootRepository(Context context){
        helper = new SqlHelper(context);
        database = helper.getWritableDatabase();
    }
    public void close() {
        helper.close();
    }
    public long insert (FootType footType){
        ContentValues values = new ContentValues();
        values.put("groundReactForce" , footType.getLeftFoot().getGroundReactForce());
        values.put("strideTime", footType.getLeftFoot().getStrideTime());
        return database.insert("leftFoot" , null, values);
    }

    public Cursor list() {
        return database.query("leftFoot", FOOT_COLUMNS, null ,null,null,null,null);
    }
}
