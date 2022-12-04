package com.race.flashystationery;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class AddressDatabaseHelper extends SQLiteOpenHelper {

    public static final String DB_NAME = "address.sqlite";
    public static final int DB_VERSION = 1;

    public static final String TBL_NAME = "Address";
    public static final String COL_ID = "AddressId";
    public static final String COL_NAME = "UserName";
    public static final String COL_PHONE = "PhoneNumber";
    public static final String COL_DETAIL = "AddressDetail";
    public static final String COL_ADDRESS = "Address";
    public static final String COL_TYPE = "AddressType";
    public static final String COL_DEFAULT = "DefaultAddress";

    public AddressDatabaseHelper(@Nullable Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS " + TBL_NAME + "( "
                + COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + COL_NAME + " VARCHAR(30), "
                + COL_PHONE + " INTEGER, "
                + COL_ADDRESS + " VARCHAR(100), "
                + COL_DETAIL + " VARCHAR(150), "
                + COL_TYPE + " VARCHAR(10), "
                + COL_DEFAULT + " INTEGER)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TBL_NAME);
        onCreate(sqLiteDatabase);
    }

    //SELECT
    public Cursor getData(){
        SQLiteDatabase db = getWritableDatabase();
        return db.rawQuery("SELECT * FROM " + TBL_NAME, null);
    }

    //INSERT, UPDATE, DELETE
    public void execSql(String sql){
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL(sql);
    }

    public int getNumberOfRows(){
        Cursor cursor = getData();
        int numberOfRows = cursor.getCount();
        cursor.close();
        return numberOfRows;
    }

    public void createSampleData(){
        if (getNumberOfRows() == 0){
            execSql("INSERT INTO " + TBL_NAME + " VALUES(null, 'Nguyễn Trần Bích Ngọc', " +
                    "'0123456789', 'TP.Hồ Chí Minh, Thành Phố Thủ Đức, phường Linh Trung', " +
                    "'KTX Khu B', 'Nhà riêng', 1)");

        }
    }
}
