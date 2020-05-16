package com.ananddevelopment.fitness_care;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class db_userProfile extends SQLiteOpenHelper {
    private static final String dbname="user_profile";
    private static final String table="user_data";
    private static final String col1="id";
    private static final String col2="Name";
    private static final String col3="Age";
    private static final String col4="Height";
    private static final String col5="Weight";
    private static final String col6="Gender";






    db_userProfile(Context context)
    {
        super(context,dbname,null,1);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table user_data (id integer primary key autoincrement,Name Text,Age integer,Height integer,Weight integer,Gender text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists "+table);
    }
    public Boolean insertData(int id, String Name, String Gender,String Age, String Height, String Weight)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues cv=new ContentValues();
        cv.put(col2,Name);
        cv.put(col3,Gender);
        cv.put(col4,Age);
        cv.put(col5,Height);
        cv.put(col6,Weight);
        db.execSQL("delete from user_data");

        long res=db.insert(table,null,cv);
        db.close();
        if (res >0) {
            return true;
        } else {
            return false;
        }
    }
    public Cursor getData()
    { SQLiteDatabase db=this.getWritableDatabase();
        Cursor cursor=db.rawQuery("Select DISTINCT * from " + table,null);
        return cursor;
    }


}
