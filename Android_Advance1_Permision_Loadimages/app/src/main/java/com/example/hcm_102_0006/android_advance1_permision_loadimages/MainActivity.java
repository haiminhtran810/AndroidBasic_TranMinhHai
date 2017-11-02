package com.example.hcm_102_0006.android_advance1_permision_loadimages;

import android.Manifest;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.provider.ContactsContract;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private static final int REQUEST_READ_STORAGE = 1;
    private static final int REQUEST_READ_CONTACT = 2;
    private RecyclerView rcDisplayResult;
    private ContactAdapter contactAdapter;
    private List<Contact> mContacts;
    private List<String> mPathImages;
    private ImageAdapter imageAdapter;
    private ImageView imgDemo;
    private String PATH = "https://www.destructoid.com//ul/400082-pmdy2395.jpg";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mContacts = new ArrayList<>();
        mPathImages = new ArrayList<>();
        rcDisplayResult = findViewById(R.id.rcDisplayResult);
        contactAdapter = new ContactAdapter(mContacts);
        imageAdapter = new ImageAdapter(mPathImages);
        mPathImages = new ArrayList<>(mPathImages);
        findViewById(R.id.btnShowContact).setOnClickListener(this);
        findViewById(R.id.btnShowImage).setOnClickListener(this);
        imgDemo = findViewById(R.id.imgDemo);
        PicassoImage();
        //GlideImage();
    }
    public void PicassoImage(){
        Picasso.with(MainActivity.this).load(PATH).into(imgDemo);
    }
    public void GlideImage(){
        Glide
                .with(MainActivity.this)
                .load(PATH).centerCrop()
                .error(R.mipmap.ic_launcher).into(imgDemo);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnShowContact:
                requestContactPermission();
                break;
            case R.id.btnShowImage:
                requestImagePermission();
                break;
        }
    }

    private void requestImagePermission() {
        int permissionCheck = ContextCompat.checkSelfPermission(
                MainActivity.this, "Manifest" +
                ".permission.READ_EXTERNAL_STORAGE");
        if (permissionCheck == PackageManager.PERMISSION_GRANTED) {
            showImages();
        }else if (permissionCheck == PackageManager.PERMISSION_DENIED){
            if (ActivityCompat.shouldShowRequestPermissionRationale(MainActivity.this, Manifest
                    .permission.READ_EXTERNAL_STORAGE)){
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("Request Image Permission")
                        .setMessage("We want to access to your external storage to get image")
                        .setPositiveButton("YES", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                ActivityCompat
                                        .requestPermissions(MainActivity.this,
                                                new String[]{Manifest.permission
                                                        .READ_EXTERNAL_STORAGE}, REQUEST_READ_STORAGE);
                            }
                        })
                        .setNegativeButton("NO", null);
                builder.create().show();
            }
        }
    }

    private void showImages() {
        mPathImages.clear();
        mPathImages.addAll(getImagePath());
        imageAdapter.notifyDataSetChanged();
        rcDisplayResult.setLayoutManager(new GridLayoutManager(this, 2));
        rcDisplayResult.setAdapter(imageAdapter);
    }

    private List<String> getImagePath() {
        Uri uri = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
        String getValues[] = {MediaStore.Images.Media.DATA};
        Cursor cursor = getContentResolver().query(uri, getValues, null, null, null);
        List<String> path = new ArrayList<>();
        if (cursor != null && cursor.moveToFirst()) {
            do {
                path.add(cursor.getString(cursor.getColumnIndexOrThrow(MediaStore.Images.Media
                        .DATA)));
            } while (cursor.moveToNext());
            cursor.close();
        }
        return path;
    }

    private void requestContactPermission() {
        int permissionCheck = ContextCompat.checkSelfPermission(this, "Manifest.permission" +
                ".READ_CONTACTS");
        if (permissionCheck == PackageManager.PERMISSION_GRANTED) {
            showContacts();
        } else if (permissionCheck == PackageManager.PERMISSION_DENIED) {
            if (ActivityCompat.shouldShowRequestPermissionRationale(MainActivity.this, Manifest
                    .permission.READ_CONTACTS)) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("Request Contact Permission")
                        .setMessage("We want to access to your contacts data")
                        .setPositiveButton("YES", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                ActivityCompat
                                        .requestPermissions(MainActivity.this,
                                                new String[]{Manifest.permission
                                                        .READ_CONTACTS}, REQUEST_READ_CONTACT);
                            }
                        })
                        .setNegativeButton("NO", null);
                builder.create().show();
            } else {
                ActivityCompat
                        .requestPermissions(MainActivity.this, new String[]{Manifest.permission
                                .READ_CONTACTS}, REQUEST_READ_CONTACT);
            }

        }
    }

    private void showContacts() {
        mContacts.clear();
        mContacts.addAll(getContacts());
        contactAdapter.notifyDataSetChanged();
        rcDisplayResult.setLayoutManager(new LinearLayoutManager(this));
        rcDisplayResult.setAdapter(contactAdapter);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {
            case REQUEST_READ_STORAGE:
                if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    showImages();
                } else {
                    Toast.makeText(this, "Permission Deny", Toast.LENGTH_SHORT).show();
                }
                break;
            case REQUEST_READ_CONTACT:
                if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    showContacts();
                } else {
                    Toast.makeText(this, "Permission Deny", Toast.LENGTH_SHORT).show();
                }
                break;
            default:
                break;
        }
    }

    public List<Contact> getContacts() {
        Uri uri = ContactsContract.CommonDataKinds.Phone.CONTENT_URI;
        List<Contact> contacts = new ArrayList<>();
        String colName = ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME;
        String colNumber = ContactsContract.CommonDataKinds.Phone.NUMBER;
        String getColumns[] = {colName, colNumber};
        Cursor cursor = getContentResolver().query(uri, getColumns, null, null, null);
        if (cursor != null && cursor.moveToFirst()) {
            do {
                String name = cursor.getString(0);
                String phone = cursor.getString(1);
                contacts.add(new Contact(name, phone));
            } while (cursor.moveToNext());
            cursor.close();
        }
        return contacts;
    }
}
