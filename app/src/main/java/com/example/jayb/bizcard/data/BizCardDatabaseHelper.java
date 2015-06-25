package com.example.jayb.bizcard.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by jayb on 6/24/15.
 */
public class BizCardDatabaseHelper {
    private static final int DATABASE_VERSION = 3;
    private static final String DATABASE_NAME = "bizcard.db";
    private static final String TABLE_NAME  = "contact_records";

    private static final String  BIZCARD_COLUMN_ID = "_id";
    private static final String  BIZCARD_COLUMN_NAME = "Name";
    private static final String  BIZCARD_COLUMN_TITLE = "Title";
    private static final String  BIZCARD_COLUMN_URL = "url";
    private static final String  BIZCARD_COLUMN_CELL = "cell";
    private static final String  BIZCARD_COLUMN_EMAIL = "email";

    private BizCardOpenHelper openHelper;
    private SQLiteDatabase database;

    public BizCardDatabaseHelper(Context context){
        openHelper = new BizCardOpenHelper(context);
        database = openHelper.getWritableDatabase();
    }

    public void saveContacts(String name,String cell,String title,String url,String email){
        ContentValues contentValues = new ContentValues();
        contentValues.put(BIZCARD_COLUMN_NAME,name);
        contentValues.put(BIZCARD_COLUMN_TITLE,title);
        contentValues.put(BIZCARD_COLUMN_URL,url);
        contentValues.put(BIZCARD_COLUMN_CELL,cell);
        contentValues.put(BIZCARD_COLUMN_EMAIL,email);

        database.insert(TABLE_NAME,null,contentValues);
    }

    public Cursor getAllRecords(){
        return database.rawQuery("select * from "+ TABLE_NAME,null);
    }

    private class BizCardOpenHelper extends SQLiteOpenHelper {

        public BizCardOpenHelper(Context context) {
            super(context, "bizcard.db", null, 1);
        }


        @Override
        public void onCreate(SQLiteDatabase db){
            db.execSQL("CREATE TABLE " + TABLE_NAME + " ( " +
                            BIZCARD_COLUMN_ID + " INTEGER PRIMARY KEY," +
                            BIZCARD_COLUMN_NAME + " TEXT, " +
                            BIZCARD_COLUMN_TITLE + " TEXT, " +
                            BIZCARD_COLUMN_URL + " TEXT, " +
                            BIZCARD_COLUMN_CELL + " TEXT, " +
                            BIZCARD_COLUMN_EMAIL + " TEXT" + ")"
            );
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL("DROP TABLE IF NOT EXISTS " + TABLE_NAME);
            onCreate(db);
        }


    }

}
