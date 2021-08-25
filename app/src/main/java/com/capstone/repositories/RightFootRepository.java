package com.capstone.repositories;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.capstone.entity.FootType;
import com.capstone.sqlHelpers.SqlHelper;

public class RightFootRepository {

    private SQLiteDatabase database;
    private SqlHelper helper;
    public static final String[] FOOT_COLUMNS = new String[]{"_id", "groundReactForce" ,"strideTime"};

    public RightFootRepository(Context context) {
        helper = new SqlHelper(context);
        database = helper.getWritableDatabase();
    }
    public void close(){
        helper.close();
    }

    public long insert(FootType footType){
        ContentValues values = new ContentValues();
        values.put("groundReactForce" , footType.getRightFoot().getGroundReactForce());
        values.put("strideTime" , footType.getRightFoot().getStrideTime());
        return database.insert("rightFoot" , null , values);
    }

    public Cursor list() {
        return database.query("rightFoot", FOOT_COLUMNS, null ,null,null,null,null);
    }

}
