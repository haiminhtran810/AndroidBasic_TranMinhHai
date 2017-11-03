package com.example.hcm_102_0006.android_advance1_contentprovinder.local;

import android.provider.BaseColumns;

/**
 * Created by hcm-102-0006 on 03/11/2017.
 */

public class ContactContract {
    public static class ContactEntry implements BaseColumns{
        public static final String TABLE_NAME = "tbl_contact";
        public static final String COLUMN_NAME = "name";
        public static final String COLUMN_PHONE = "phone";
        public static final String COLUMN_ADDRESS = "address";
    }
}
