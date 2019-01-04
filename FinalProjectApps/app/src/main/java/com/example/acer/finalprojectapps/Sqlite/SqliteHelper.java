package com.example.acer.finalprojectapps.Sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class SqliteHelper extends SQLiteOpenHelper {

    public SqliteHelper(Context context) {
        super(context, "FinalProject.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE user(email text primary key, password text)");
        db.execSQL("CREATE TABLE buku(id text primary key AUTOINCREMENT, nama_buku text, review text, rating text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists user");
        db.execSQL("drop table if exists buku");
    }

    //inserting user in database
    public boolean insertuser(String email, String password) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("email", email);
        contentValues.put("password", password);
        long ins = db.insert("user", null, contentValues);
        if (ins == -1) return false;
        else return true;
    }

    //insert review in database
    public boolean insertreview(String nama_buku, String review, String rating) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("nama_buku", nama_buku);
        contentValues.put("review", review);
        contentValues.put("rating", rating);
        long ins = db.insert("buku", null, contentValues);
        if (ins == -1) return false;
        else return true;
    }

    //check if email exists
    public Boolean chkemail(String email) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("Select * from user where email =?", new String[]{email});
        if (cursor.getCount() > 0) return false;
        else return true;
    }

    //checking the email and password
    public Boolean emailpassword(String email, String password) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("select * from user where email=? and password=?", new String[]{email, password});
        if (cursor.getCount() > 0) return true;
        else return false;
    }

    //change password
    public boolean changepassword(String password) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("password", password);
        db.update("buku", contentValues," password=? ",new String[]{password});
        return true;
    }
}