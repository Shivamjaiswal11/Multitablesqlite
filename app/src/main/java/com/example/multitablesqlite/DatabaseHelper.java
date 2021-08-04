package com.example.multitablesqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME ="product_database";
    private static  final  String TABLE1="table1";
    private static  final  String TABLE2="table2";
    private static  final  String TABLE3="table3";
    public DatabaseHelper(@Nullable Context context ) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String table1 = "CREATE TABLE "+TABLE1+" (id INTEGER PRIMARY KEY ,product TEXT)";
        String table2 = "CREATE TABLE "+TABLE2+"(id integer primary key ,qty text)";
        String table3 = "CREATE TABLE "+TABLE3+"(id integer primary key ,price text)";
         db.execSQL(table1);
         db.execSQL(table2);
         db.execSQL(table3);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
     db.execSQL("DROP TABLE IF EXISTS "+TABLE1);
     db.execSQL("DROP TABLE IF EXISTS "+TABLE2);
     db.execSQL("DROP TABLE IF EXISTS "+TABLE3);
     onCreate(db);
    }
    public boolean insert(String product,String qty,String price) {
        SQLiteDatabase t  = this.getWritableDatabase();
        ContentValues c =new ContentValues();
        c.put("product",product);
        t.insert(TABLE1,null,c);
        ////
        ContentValues c1=new ContentValues();
        c1.put("qty",qty);
        t.insert(TABLE2,null,c1);
        ////
        ContentValues c2 =new ContentValues();
        c2.put("price",price);
        t.insert(TABLE3,null,c2);
        return true;
    }
    public ArrayList getproduct() {
        SQLiteDatabase q = this.getReadableDatabase();
        ArrayList<String> arrayList = new ArrayList<>();
        Cursor cursor = q.rawQuery("select * from " + TABLE1, null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            arrayList.add(cursor.getString(cursor.getColumnIndex("product")));
            cursor.moveToNext();
        }
        return arrayList;
    }
        public ArrayList getqty(){
            SQLiteDatabase q=this.getReadableDatabase();
            ArrayList<String> arrayList =new ArrayList<>();
            Cursor cursor=q.rawQuery("select * from "+TABLE2,null);
            cursor.moveToFirst();
            while (!cursor.isAfterLast()){
                arrayList.add(cursor.getString(cursor.getColumnIndex("qty")));
                cursor.moveToNext();
            }
            return arrayList;
    }
    public ArrayList getprice(){
        SQLiteDatabase q=this.getReadableDatabase();
        ArrayList<String> arrayList =new ArrayList<>();
        Cursor cursor=q.rawQuery("select * from "+TABLE3,null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()){
            arrayList.add(cursor.getString(cursor.getColumnIndex("price")));
            cursor.moveToNext();
        }
        return arrayList;
    }


}
