package com.example.hcm_102_0006.demo_hmt_recyclerview.data;

import android.provider.BaseColumns;

/**
 * Created by hcm-102-0006 on 01/11/2017.
 */

public class ContactContract {
    public class ContactEntry implements BaseColumns{
        public static final String TABLE_NAME = "table_contact";
        public static final String COLUMN_NAME = "name";
        public static final String COLUMN_PHONE = "phone";
        public static final String COLUMN_ADDRESS = "address";
    }

}
