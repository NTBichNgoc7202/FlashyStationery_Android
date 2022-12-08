package com.race.flashystationery;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class RegisterDatabaseHelper extends SQLiteOpenHelper {
    public static final String DATA_NAME = "USER_RECORD";
    public static final int DATA_VERSON = 1;

    public static final String TABLE_NAME = "USER_DATA";

    public static final String COL_1 = "ID";
    public static final String COL_2 = "USERNAME";
    public static final String COL_3 = "PHONENUMBER";
    public static final String COL_4 = "EMAIL";
    public static final String COL_5 = "DOB";
    public static final String COL_6 = "GENDER";
    public static final String COL_7 = "PASSWORD";

    public RegisterDatabaseHelper(@Nullable Context context) {

        super(context, DATA_NAME, null, DATA_VERSON);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS "
                + TABLE_NAME + "(" +
                COL_1 + "INTEGER PRIMARY KEY AUTOINCREMENT,"
        + COL_2 + " VARCHAR(30), "
        +COL_3 + " VARCHAR(10), "
        +COL_4 + " VARCHAR(50), "
        +COL_5 + " VARCHAR(10), " +COL_6 + " VARCHAR(1), " + COL_7 +
                " VARCHAR(20))");

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(sqLiteDatabase);

    }
    //SELECT
    public Cursor getData(){
        SQLiteDatabase db = getReadableDatabase();
        return db.rawQuery("SELECT * FROM " + TABLE_NAME, null);
    }

    //INSERT, UPDATE, DELETE
    public void execSql(String sql){
        SQLiteDatabase dB = getWritableDatabase();
        dB.execSQL(sql);
    }

    public int getNumberOfRows(){
        Cursor cursor = getData();
        int numberOfRows = cursor.getCount();
        cursor.close();
        return numberOfRows;
    }
    public void createSampleData(){
        if (getNumberOfRows() == 0){
            execSql("INSERT INTO " + TABLE_NAME + " VALUES(null, 'Nguyễn Trần Bích Ngọc', " +
                    "'0123456789', 'trinhvtn20411c@gmail.com', " +
                    "'123abcxxyz')");
        }
    }
    
    public boolean registerUserFlashyApp(String username, String email, String phonenumber, String password){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COL_2, username);
        values.put(COL_3,phonenumber);
        values.put(COL_4, email);
        values.put(COL_5, password);

        long result = sqLiteDatabase.insert(TABLE_NAME, null, values);
        if(result == -1)
            return false;
        else
            return true;

    }
    public boolean checkUser(String username, String password){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        String [] colums = {COL_1};
        String selection = COL_2 +"=?" + " and" + COL_5 + "=?";
        String [] seclectionargs = {username, password};
        Cursor cursor = sqLiteDatabase.query(TABLE_NAME, colums, selection, seclectionargs, null, null, null);
        int count = cursor.getCount();
        if (count > 0)
            return true;
        else
            return false;
    }


}
