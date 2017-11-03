package com.example.hcm_102_0006.android_advance1_contentprovinder.model;

import android.content.ContentValues;
import android.database.Cursor;

import com.example.hcm_102_0006.android_advance1_contentprovinder.local.ContactContract;

/**
 * Created by hcm-102-0006 on 03/11/2017.
 */

public class Contact {
    private int mID;
    private String mName;
    private String mPhone;
    private String mAddress;

    public Contact(String mName, String mPhone, String mAddress) {
        this.mName = mName;
        this.mPhone = mPhone;
        this.mAddress = mAddress;
    }

    public Contact(Cursor cursor) {
        mName = cursor.getString(cursor.getColumnIndex(ContactContract.ContactEntry.COLUMN_NAME));
        mPhone = cursor.getString(
                cursor.getColumnIndex(ContactContract.ContactEntry.COLUMN_PHONE));
        mAddress = cursor.getString(
                cursor.getColumnIndex(ContactContract.ContactEntry.COLUMN_ADDRESS));
        mID = cursor.getInt(cursor.getColumnIndex(ContactContract.ContactEntry._ID));
    }

    public ContentValues getContentValues() {
        ContentValues contentValues = new ContentValues();
        if (mName != null) {
            contentValues.put(ContactContract.ContactEntry.COLUMN_NAME, mName);
        }
        if (mAddress != null) {
            contentValues.put(ContactContract.ContactEntry.COLUMN_ADDRESS, mAddress);
        }
        if (mPhone != null) {
            contentValues.put(ContactContract.ContactEntry.COLUMN_PHONE, mPhone);
        }
        if (mID != 0) {
            contentValues.put(ContactContract.ContactEntry._ID, mID);
        }
        return contentValues;
    }

    public int getmID() {
        return mID;
    }

    public void setmID(int mID) {
        this.mID = mID;
    }

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public String getmPhone() {
        return mPhone;
    }

    public void setmPhone(String mPhone) {
        this.mPhone = mPhone;
    }

    public String getmAddress() {
        return mAddress;
    }

    public void setmAddress(String mAddress) {
        this.mAddress = mAddress;
    }

    @Override
    public String toString() {
        return this.mID + " - " + this.mName + "  -  " + this.mPhone +  " - " + this.mAddress  ;
    }
}
