package com.example.hcm_102_0006.demo_hmt_recyclerview.data.local;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.hcm_102_0006.demo_hmt_recyclerview.data.ContactContract;

/**
 * Created by hcm-102-0006 on 01/11/2017.
 */

public class DatabaseHelper extends SQLiteOpenHelper
{
    private final static String DB_NAME = "contact.db";
    private final static int DB_VERSION = 1;

    private final static String CREATE_CONTACT_TABLE = "CREATE TABLE "
            + ContactContract.ContactEntry.TABLE_NAME
            +  "( "
            + ContactContract.ContactEntry._ID
            + " INTEGER PRIMARY KEY NOT NULL, "
            + ContactContract.ContactEntry.COLUMN_NAME
            + " TEXT, "
            + ContactContract.ContactEntry.COLUMN_ADDRESS
            + " TEXT, "
            + ContactContract.ContactEntry.COLUMN_PHONE
            + " TEXT ) ";

    private final static String DELETE_CONTACT_TABLE =
            "DROP TABLE " + ContactContract.ContactEntry.TABLE_NAME;

    public DatabaseHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CREATE_CONTACT_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL(DELETE_CONTACT_TABLE);
        sqLiteDatabase.execSQL(CREATE_CONTACT_TABLE);
    }
}
