package com.example.healthcareproject.DataBase;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class DataBase extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "HealthCare";
    private static final int DATABASE_VERSION = 1;


    public DataBase(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        /*----------------------------------------There is create Users Table--------------------------------------------------------------*/
        sqLiteDatabase.execSQL("CREATE TABLE users(Username TEXT,Email TEXT,Password TEXT);");

        /*----------------------------------------There is create Cart Table--------------------------------------------------------------*/
        sqLiteDatabase.execSQL("CREATE TABLE cart(Username TEXT,Product TEXT,Price INTEGER, OrderType TEXT );");

        /*----------------------------------------There is create Order Table--------------------------------------------------------------*/
        sqLiteDatabase.execSQL("CREATE TABLE orders(Username TEXT,fullname TEXT,address TEXT,contactNo TEXT,pincode INTEGER,date TEXT,time TEXT,Amount FLOAT,OrderType TEXT);");

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS users");
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS cart");
        onCreate(sqLiteDatabase);
    }

    public void register(String username, String email, String password) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("username", username);
        cv.put("email", email);
        cv.put("password", password);
        db.insert("users", null, cv);
        db.close();
    }

    public int login(String username, String password) {
        int result = 0;
        SQLiteDatabase db = this.getReadableDatabase();
        String[] str = new String[2];
        str[0] = username;
        str[1] = password;
        @SuppressLint("Recycle") Cursor c = db.rawQuery("SELECT * FROM users WHERE username =? AND password =?", str);
        if (c.moveToNext()) {
            result = 1;
        }
        return result;
    }

    public int userNameCheck(String username) {
        int result = 0;
        SQLiteDatabase db = this.getReadableDatabase();
        String[] str = new String[1];
        str[0] = username;
        @SuppressLint("Recycle") Cursor c = db.rawQuery("SELECT * FROM users WHERE username =?", str);
        if (c.moveToNext()) {
            result = 1;
        }
        return result;
    }

    public void addCart(String userName, String product, float price, String oType) {
        ContentValues cv = new ContentValues();
        cv.put("username", userName);
        cv.put("product", product);
        cv.put("price", price);
        cv.put("ordertype", oType);
        SQLiteDatabase db = getWritableDatabase();
        db.insert("cart", null, cv);
        db.close();
    }

    public int checkCart(String username, String product) {
        int result = 0;
        String[] str = new String[2];
        str[0] = username;
        str[1] = product;
        SQLiteDatabase db = getReadableDatabase();
        @SuppressLint("Recycle") Cursor c = db.rawQuery("SELECT * FROM cart WHERE username=? AND product=?", str);
        if (c.moveToNext()) {
            result = 1;
        }
        db.close();
        return result;
    }

    public void removeCart(String username, String oType) {
        String[] str = new String[2];
        str[0] = username;
        str[1] = oType;
        SQLiteDatabase db = getWritableDatabase();
        db.delete("cart", "username =? AND orderType =?", str);
        db.close();
    }

    public ArrayList getCartData(String username, String oType) {
        ArrayList<String> arr = new ArrayList<>();
        SQLiteDatabase db = getReadableDatabase();
        String[] str = new String[2];
        str[0] = username;
        str[1] = oType;
        @SuppressLint("Recycle") Cursor c = db.rawQuery("SELECT * FROM cart WHERE username=? AND orderType=?", str);
        if (c.moveToFirst()) {
            do {
                String product = c.getString(1);
                String price = c.getString(2);
                arr.add(product + "#" + price);
            } while (c.moveToNext());
        }
        db.close();
        return arr;
    }

    public void addOrder(String username, String fullname, String address, String contact, int pincode, String date, String time, float amount, String orderType) {
        ContentValues cv = new ContentValues();
        cv.put("username", username);
        cv.put("fullname", fullname);
        cv.put("address", address);
        cv.put("contactno", contact);
        cv.put("pincode", pincode);
        cv.put("date", date);
        cv.put("time", time);
        cv.put("amount", amount);
        cv.put("orderType", orderType);
        SQLiteDatabase db = getWritableDatabase();
        db.insert("orders", null, cv);
        db.close();

    }


    public ArrayList getOrderData(String username) {
        ArrayList<String> arr = new ArrayList<>();
        SQLiteDatabase db = getReadableDatabase();
        String[] str = new String[1];
        str[0] = username;
        @SuppressLint("Recycle") Cursor c = db.rawQuery("SELECT * FROM orders WHERE username=?", str);
        if (c.moveToFirst()) {
            do {
                arr.add(c.getString(1) + "$" + c.getString(2) + "$" + c.getString(3) + "$" + c.getString(4) + "$" + c.getString(5) + "$" + c.getString(6) + "$" + c.getString(7) + "$" + c.getString(8));
            } while (c.moveToNext());
        }
        db.close();
        return arr;
    }

    public int checkAppointmentExists(String username, String fullname, String address, String contact, String date, String time) {
        int result = 0;
        String[] str = new String[6];
        str[0] = username;
        str[1] = fullname;
        str[2] = address;
        str[3] = contact;
        str[4] = date;
        str[5] = time;
        SQLiteDatabase db=getReadableDatabase();
        @SuppressLint("Recycle") Cursor c = db.rawQuery("SELECT * FROM orders WHERE username=? AND fullname =? AND Address=? AND contactNo=? AND Date=? AND Time=? ", str);
        if(c.moveToFirst()){
            result=1;
        }
        db.close();
        return result;
    }


}