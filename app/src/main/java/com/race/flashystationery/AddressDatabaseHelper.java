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
                + COL_PHONE + " VARCHAR(10), "
                + COL_ADDRESS + " VARCHAR(100), "
                + COL_DETAIL + " VARCHAR(150), "
                + COL_TYPE + " VARCHAR(10), "
                + COL_DEFAULT + " VARCHAR(1))");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TBL_NAME);
        onCreate(sqLiteDatabase);
    }

    //SELECT
    public Cursor getData(){
        SQLiteDatabase db = getReadableDatabase();
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
            execSql("INSERT INTO " + TBL_NAME + " VALUES(null, 'Nguy???n Tr???n B??ch Ng???c', " +
                    "'0123456789', 'TP.H??? Ch?? Minh, Th??nh Ph??? Th??? ?????c, ph?????ng Linh Trung', " +
                    "'KTX Khu B', 'Nh?? ri??ng', 'x')");
        }
    }
}
