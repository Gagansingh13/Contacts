
package com.example.gagan.contacts;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;



public class DatabaseHelper extends SQLiteOpenHelper {


    public static final String DATABASE_NAME ="contact.db";
    public static final String TABLE_NAME ="contacts";
    public static final String COLUMN_ID = "ID";
    public static final String COLUMN_first = "FIRST_NAME";
    public static final String COLUMN_last = "LAST_NAME";
    public static final String COLUMN_phone = "PHONE_NUMBER";
    public static final String COLUMN_email = "EMAIL_ADDRESS";


    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {


        String createTable = "CREATE TABLE " + TABLE_NAME + " (ID INTEGER PRIMARY KEY AUTOINCREMENT, " +
                " FIRST_NAME TEXT, LAST_NAME TEXT, PHONE_NUMBER TEXT, EMAIL_ADDRESS TEXT)";
        db.execSQL(createTable);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXIST " + TABLE_NAME);
        onCreate(db);
    }


    public boolean addData(String fName, String lName, String pNumber, String eAddress){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COLUMN_first, fName);
        contentValues.put(COLUMN_last, lName);
        contentValues.put(COLUMN_phone, pNumber);
        contentValues.put(COLUMN_email, eAddress);

        long result = db.insert(TABLE_NAME, null, contentValues);

        if (result == -1){
            return false;
        } else {
            return true;
        }
    }


    public Cursor getData(){
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT * FROM " + TABLE_NAME;
        Cursor data = db.rawQuery(query, null);
        return data;
    }



}
