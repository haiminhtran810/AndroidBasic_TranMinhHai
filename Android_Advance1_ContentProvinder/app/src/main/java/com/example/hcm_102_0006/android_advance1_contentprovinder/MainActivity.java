package com.example.hcm_102_0006.android_advance1_contentprovinder;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.example.hcm_102_0006.android_advance1_contentprovinder.local.ContactProvider;
import com.example.hcm_102_0006.android_advance1_contentprovinder.model.Contact;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private List<Contact> mContacts;
    private ListView lstContact;
    private Button btnContact;
    private ArrayAdapter<Contact> mAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnContact = findViewById(R.id.btnContact);
        btnContact.setOnClickListener(this);
        mContacts = getValues();
        lstContact = findViewById(R.id.lstContact);
        mAdapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,mContacts);
        lstContact.setAdapter(mAdapter);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId())
        {
            case R.id.btnContact:
                addNewContact();
                break;
        }
    }

    private void addNewContact() {
        int id = new Random().nextInt(1000);
        Contact contact = new Contact("Name " + id, "Phone " + id , "Address " + id);
        {
            if (getContentResolver().insert(ContactProvider.CONTENT_URI, contact.getContentValues())!= null){
                mContacts.clear();
                mContacts.addAll(getValues());
                mAdapter.notifyDataSetChanged();
            }else{
                Toast.makeText(this, "Insert Failed", Toast.LENGTH_SHORT).show();
            }
        }
    }

    public List<Contact> getValues() {
        List<Contact> mContactsTemp = new ArrayList<>();
        Cursor cursor = getContentResolver().query(ContactProvider.CONTENT_URI, null, null, null, null);
        if(cursor!= null && cursor.moveToFirst()){
            do {
                mContactsTemp.add(new Contact(cursor));
            }while (cursor.moveToNext());
        }
        return mContactsTemp;
    }
    
    
}
