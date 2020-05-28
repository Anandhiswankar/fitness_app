package com.ananddevelopment.fitness_care;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class ReminderDB extends SQLiteOpenHelper {
    private static final String dbname="reminderDB";
    private static final String table="RemData";
    private static final String table2="RemData2";
    private static final String table3="RemData3";
    private static final String table4="RemData4";
    private static final String col1="id";
    private static final String col2="rem";
    private static final String col3="hour";
    private static final String col4="min";
    private static final String col5="amPm";


    ReminderDB(Context context)
    {
        super(context,dbname,null,1);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table RemData(id integer primary key autoincrement,rem Text,hour integer ,min integer,amPm Text)");
        db.execSQL("create table RemData2(id integer primary key autoincrement,rem Text,hour integer ,min integer,amPm Text)");
        db.execSQL("create table RemData3(id integer primary key autoincrement,rem Text,hour integer ,min integer,amPm Text)");
        db.execSQL("create table RemData4(id integer primary key autoincrement,rem Text,hour integer ,min integer,amPm Text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists " +table);
        db.execSQL("drop table if exists " +table2);
        db.execSQL("drop table if exists " +table3);
        db.execSQL("drop table if exists " +table4);


    }

    public boolean insertData( String rem, String hour,String min,String amPm)
    {
        int Hour= Integer.parseInt(hour);
        int Min= Integer.parseInt(min);
        String AM_PM;
        if(Hour>12){
            Hour -=12;
            AM_PM= "PM";
        }
        else  if(Hour==0){
            Hour+=12;
            AM_PM="AM";
        }
        else if(Hour==12){
            AM_PM="PM";
        }else {
            AM_PM="AM";
        }
        String min1="";
        if(Min<10){
            min1="0"+Min;
        }
        else min1=String.valueOf(Min);
        String time=new StringBuilder().append(Hour).append(':').append(min1).append("").append(AM_PM).toString();
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues cv=new ContentValues();
        cv.put(col2,rem);
        cv.put(col3,Hour);
        cv.put(col4,Min);
        cv.put(col5,amPm);
        db.execSQL("delete from remData");
        long res=db.insert(table,null,cv);
        db.close();
        if(res==-1)
        {
            return false;
        }else {
            return true;
        }
    }
    public boolean insertData2( String rem, String hour,String min,String amPm)
    {
        int Hour= Integer.parseInt(hour);
        int Min= Integer.parseInt(min);
        String AM_PM;
        if(Hour>12){
            Hour -=12;
            AM_PM= "PM";
        }
        else  if(Hour==0){
            Hour+=12;
            AM_PM="AM";
        }
        else if(Hour==12){
            AM_PM="PM";
        }else {
            AM_PM="AM";
        }
        String min1="";
        if(Min<10){
            min1="0"+Min;
        }
        else min1=String.valueOf(Min);
        String time=new StringBuilder().append(Hour).append(':').append(min1).append("").append(AM_PM).toString();
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues cv=new ContentValues();
        cv.put(col2,rem);
        cv.put(col3,Hour);
        cv.put(col4,Min);
        cv.put(col5,amPm);
        db.execSQL("delete from remData2");
        long res=db.insert(table2,null,cv);
        db.close();
        if(res==-1)
        {
            return false;
        }else {
            return true;
        }
    }
    public boolean insertData3( String rem, String hour,String min,String amPm)
    {
        int Hour= Integer.parseInt(hour);
        int Min= Integer.parseInt(min);
        String AM_PM;
        if(Hour>12){
            Hour -=12;
            AM_PM= "PM";
        }
        else  if(Hour==0){
            Hour+=12;
            AM_PM="AM";
        }
        else if(Hour==12){
            AM_PM="PM";
        }else {
            AM_PM="AM";
        }
        String min1="";
        if(Min<10){
            min1="0"+Min;
        }
        else min1=String.valueOf(Min);
        String time=new StringBuilder().append(Hour).append(':').append(min1).append("").append(AM_PM).toString();
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues cv=new ContentValues();
        cv.put(col2,rem);
        cv.put(col3,Hour);
        cv.put(col4,Min);
        cv.put(col5,amPm);
        db.execSQL("delete from remData3");
        long res=db.insert(table3,null,cv);
        db.close();
        if(res==-1)
        {
            return false;
        }else {
            return true;
        }

    }    public Boolean insertData4(String rem, String hour, String min, String amPm) {
        int Hour= Integer.parseInt(hour);
        int Min= Integer.parseInt(min);
        String AM_PM;
        if(Hour>12){
            Hour -=12;
            AM_PM= "PM";
        }
        else  if(Hour==0){
            Hour+=12;
            AM_PM="AM";
        }
        else if(Hour==12){
            AM_PM="PM";
        }else {
            AM_PM="AM";
        }
        String min1="";
        if(Min<10){
            min1="0"+Min;
        }
        else min1=String.valueOf(Min);
        String time=new StringBuilder().append(Hour).append(':').append(min1).append("").append(AM_PM).toString();
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues cv=new ContentValues();
        cv.put(col2,rem);
        cv.put(col3,Hour);
        cv.put(col4,Min);
        cv.put(col5,amPm);
        db.execSQL("delete from remData4");
        long res=db.insert(table4,null,cv);
        db.close();
        if(res==-1)
        {
            return false;
        }else {
            return true;
        }

    }



    public Cursor getData()
    {
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor cursor=db.rawQuery("Select DISTINCT * from " + table,null);
        return cursor;
    }
    public Cursor getData2()
    {
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor cursor=db.rawQuery("Select DISTINCT * from " +table2,null);
        return cursor;
    }
    public Cursor getData3()
    {
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor cursor=db.rawQuery("Select DISTINCT * from " +table3,null);
        return cursor;
    }

    public Cursor getData4()
    {
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor cursor=db.rawQuery("Select DISTINCT * from " +table4,null);
        return cursor;
    }


    public Integer DeleteData(String id)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        db.execSQL("delete from RemData");
        int i=db.delete(table,"id=?",new String[]{id});
        return i ;
    }
    public Integer DeleteData2(String id)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        db.execSQL("delete from RemData2");
        int i=db.delete(table2,"id=?",new String[]{id});
        return i;
    }
    public Integer DeleteData3(String id)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        db.execSQL("delete from RemData3");
        int i=db.delete(table3,"id=?",new String[]{id});
        return i;
    }

    public Integer DeleteData4(String id)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        db.execSQL("delete from RemData4");
        int i=db.delete(table4,"id=?",new String[]{id});
        return i;
    }


}
