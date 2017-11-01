package com.example.hcm_102_0006.demo_hmt_recyclerview.data.local;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.hcm_102_0006.demo_hmt_recyclerview.data.ContactContract;
import com.example.hcm_102_0006.demo_hmt_recyclerview.data.model.Contact;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hcm-102-0006 on 01/11/2017.
 */

public class ContactDataSource extends DatabaseHelper {
    public ContactDataSource(Context context) {
        super(context);
    }

    public List<Contact> getAllContacts(){
        List<Contact> mContacts = new ArrayList<>();
        String[] columns = {
                ContactContract.ContactEntry._ID,
                ContactContract.ContactEntry.COLUMN_NAME,
                ContactContract.ContactEntry.COLUMN_PHONE,
                ContactContract.ContactEntry.COLUMN_ADDRESS
        };
        // Open Db
        SQLiteDatabase database = getWritableDatabase();
        String oderBy = ContactContract.ContactEntry._ID + " DESC";
        // query to get cursor
        Cursor cursor = database.query(
                ContactContract.ContactEntry.TABLE_NAME,columns,
                null,null,null,null,oderBy,null);
        // parse cursor  to get the result
        if(cursor!= null && cursor.moveToFirst()){
            do {
                Contact contact = new Contact(cursor);
                mContacts.add(contact);
            }while (cursor.moveToNext());
            cursor.close();
        }
        database.close();
        return mContacts;
    }

    public long insertContactToDatabase(Contact contact){
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(ContactContract.ContactEntry.COLUMN_NAME,contact.getmName());
        contentValues.put(ContactContract.ContactEntry.COLUMN_ADDRESS,contact.getmAddress());
        contentValues.put(ContactContract.ContactEntry.COLUMN_PHONE,contact.getmPhone());
        long result = sqLiteDatabase.insert(ContactContract.ContactEntry.TABLE_NAME,null,contentValues);
        sqLiteDatabase.close();
        return result;
    }

    public boolean deleteContact(int id){
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        String sql = ContactContract.ContactEntry._ID + " = ? ";
        String[] dk = {String.valueOf(id)};
        long result = sqLiteDatabase.delete(ContactContract.ContactEntry.TABLE_NAME,sql,dk);
        sqLiteDatabase.close();
        return result > 0;
    }

    public boolean updateContact(Contact contact) {
        // 1 open db
        SQLiteDatabase database = getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put(ContactContract.ContactEntry.COLUMN_NAME, contact.getmName());
        values.put(ContactContract.ContactEntry.COLUMN_PHONE, contact.getmPhone());
        values.put(ContactContract.ContactEntry.COLUMN_ADDRESS, contact.getmAddress());


        String sql = ContactContract.ContactEntry._ID + " =?";
        String[] dk = { String.valueOf(contact.getmId()) };

        int result = database.update(ContactContract.ContactEntry.TABLE_NAME,
                values, sql, dk);

        database.close();

        return result > 0;
    }
}
