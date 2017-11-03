package com.example.hcm_102_0006.android_advance1_contentprovinder.local;

import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

/**
 * Created by hcm-102-0006 on 03/11/2017.
 */

public class ContactProvider extends ContentProvider {
    public static final String AUTHORITY = "com.example.hcm_102_0006.android_advance1_contentprovinder";
    public static final String SCHEME = "content://";
    public static final String URL_DATA_BASE = SCHEME + AUTHORITY + "/contact";
    public static final Uri CONTENT_URI = Uri.parse(URL_DATA_BASE);
    public static final int URI_CONTACT = 0;
    public static UriMatcher sUriMatcher;

    static {
        sUriMatcher = new UriMatcher(UriMatcher.NO_MATCH);
        sUriMatcher.addURI(AUTHORITY, "contact", URI_CONTACT);
    }

    private DatabaseHelper databaseHelper;
    private SQLiteDatabase sqLiteDatabase;

    @Override
    public boolean onCreate() {
        databaseHelper = new DatabaseHelper(getContext());
        return false;
    }

    @Nullable
    @Override
    public Cursor query(@NonNull Uri uri, @Nullable String[] projection, @Nullable String selection,
                        @Nullable String[] selectionArgs, @Nullable String sortOrder) {
        sqLiteDatabase = databaseHelper.getWritableDatabase();
        switch (sUriMatcher.match(uri)) {
            case URI_CONTACT:
                return sqLiteDatabase.query(
                        ContactContract.ContactEntry.TABLE_NAME, projection,
                        selection, selectionArgs, sortOrder, null, null);
            case UriMatcher.NO_MATCH:
            default:
                throw new IllegalArgumentException("URI Fail " + uri);
        }
    }

    @Nullable
    @Override
    public String getType(@NonNull Uri uri) {
        return null;
    }

    @Nullable
    @Override
    public Uri insert(@NonNull Uri uri, @Nullable ContentValues contentValues) {
        long index;
        sqLiteDatabase = databaseHelper.getWritableDatabase();
        switch (sUriMatcher.match(uri)) {
            case URI_CONTACT:
                index = sqLiteDatabase.insert(ContactContract.ContactEntry.TABLE_NAME, null, contentValues);
                Uri uri1 = null;
                if (index != -1) {
                    uri1 = ContentUris.withAppendedId(CONTENT_URI, index);
                }
                return uri1;
            case UriMatcher.NO_MATCH:
            default:
                throw new IllegalArgumentException("URI Fail " + uri);
        }
    }

    @Override
    public int delete(@NonNull Uri uri, @Nullable String selection, @Nullable String[] selectionArgs) {
        sqLiteDatabase = databaseHelper.getWritableDatabase();
        switch (sUriMatcher.match(uri)) {
            case URI_CONTACT:
                return sqLiteDatabase.delete(ContactContract.ContactEntry.TABLE_NAME,
                        selection, selectionArgs);
            case UriMatcher.NO_MATCH:
            default:
                throw new IllegalArgumentException("URI Fail " + uri);
        }
    }

    @Override
    public int update(@NonNull Uri uri, @Nullable ContentValues values, @Nullable String selection, @Nullable String[] selectionArgs) {
        switch (sUriMatcher.match(uri)) {
            case URI_CONTACT:
                return sqLiteDatabase.update(ContactContract.ContactEntry.TABLE_NAME, values,
                        selection, selectionArgs);
            case UriMatcher.NO_MATCH:
            default:
                throw new IllegalArgumentException("URI Fail " + uri);
        }
    }
}
