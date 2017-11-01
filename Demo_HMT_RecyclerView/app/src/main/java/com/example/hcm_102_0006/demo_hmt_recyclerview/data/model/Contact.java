package com.example.hcm_102_0006.demo_hmt_recyclerview.data.model;

import android.database.Cursor;

import com.example.hcm_102_0006.demo_hmt_recyclerview.data.ContactContract;

/**
 * Created by hcm-102-0006 on 01/11/2017.
 */

public class Contact {
    private int mId;
    private String mName;
    private String mPhone;
    private String mAddress;

    public Contact(int mId, String mName, String mPhone, String mAddress) {
        this.mId = mId;
        this.mName = mName;
        this.mPhone = mPhone;
        this.mAddress = mAddress;
    }

    public Contact() {
    }

    public Contact(Cursor cursor) {
        mId = cursor.getInt(cursor.getColumnIndex(ContactContract.ContactEntry._ID));
        mName = cursor.getString(cursor.getColumnIndex(ContactContract.ContactEntry.COLUMN_NAME));
        mAddress = cursor.getString(cursor.getColumnIndex(ContactContract.ContactEntry.COLUMN_ADDRESS));
        mPhone = cursor.getString(cursor.getColumnIndex(ContactContract.ContactEntry.COLUMN_PHONE));
    }

    public int getmId() {
        return mId;
    }

    public void setmId(int mId) {
        this.mId = mId;
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

    public String toString(){
        return this.getmName() + " - " + this.getmPhone() + " - " + this.getmAddress();
    }
}
