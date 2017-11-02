package com.example.hcm_102_0006.android_advance1_permision_loadimages;

/**
 * Created by hcm-102-0006 on 02/11/2017.
 */

public class Contact {
    private String mName;
    private String mPhone;

    public Contact(String mName, String mPhone) {
        this.mName = mName;
        this.mPhone = mPhone;
    }

    public Contact() {
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
}
