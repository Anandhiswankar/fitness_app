package com.ananddevelopment.fitness_care;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DataBaseHelper extends SQLiteOpenHelper {
    private static final String dbname = "db";
    private static final String table = "data";
    private static final String col1 = "id";
    private static final String col2 = "task";
    DataBaseHelper dbh;


    DataBaseHelper(Context context) {
        super(context, dbname, null, 1);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table data (_id INTEGER PRIMARY KEY AUTOINCREMENT,task Text )");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists " + table);
    }
    public boolean updateData(int id,String task) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
            cv.put(col2, task);
            db.execSQL("delete from data");
           long res1=  db.insert(table,null,cv);
          // int res = db.update(table, cv,"id =?",new String[]{String.valueOf(id)});
            db.close();
            if (res1 >0) {
                return true;
            } else {
                return false;
            }
    }
    public Cursor getData()
    { SQLiteDatabase db=this.getWritableDatabase();
        Cursor cursor=db.rawQuery("Select DISTINCT * from "+ table,null);
        return cursor;
    }

}




















