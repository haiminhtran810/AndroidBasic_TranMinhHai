package com.example.hcm_102_0006.demo_hmt_recyclerview;

import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.hcm_102_0006.demo_hmt_recyclerview.data.local.ContactDataSource;
import com.example.hcm_102_0006.demo_hmt_recyclerview.data.model.Contact;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    // Press Add (Menu) on the toolbar to add Customer into database
    private RecyclerView rcvShowContact;
    private ContactAdapterRecycleView mAdapter;
    private List<Contact> mContacts;
    private Button btnContextMenu;
    private ContactDataSource mDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Contact");
        mContacts = new ArrayList<>();
        mDatabase = new ContactDataSource(this);
        addContactToListNotDb();
        mAdapter = new ContactAdapterRecycleView(mContacts);
        rcvShowContact = findViewById(R.id.rcvShowContact);
        //rcvShowContact.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,true));
        rcvShowContact.setLayoutManager(new LinearLayoutManager(this));
        rcvShowContact.setAdapter(mAdapter);

        btnContextMenu = findViewById(R.id.btnContextMenu);
        btnContextMenu.setOnClickListener(this );
    }

    private void addContactToListNotDb() {
        mContacts.addAll(mDatabase.getAllContacts());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.context_menu, menu);
        MenuItem searchViewItem = menu.findItem(R.id.menuSearch);
        final SearchView searchView  = (SearchView) MenuItemCompat.getActionView(searchViewItem);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                Toast.makeText(MainActivity.this, "Bạn đang search : " + newText, Toast.LENGTH_SHORT).show();
                return false;
            }
        });
        return true;
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.contact_menu, menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        return super.onContextItemSelected(item);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.menuAdd:
                int randomNumber = new Random().nextInt(100);
                Contact contact = new Contact(
                        0, "Customer " + String.valueOf(randomNumber),
                        "01234567" + String.valueOf(randomNumber),"HCM");

                long rs = mDatabase.insertContactToDatabase(contact);
                if(rs > 0){
                    mContacts.add(contact);
                    mAdapter.notifyDataSetChanged();
                    Toast.makeText(this, "Ok", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(this, "Failed", Toast.LENGTH_SHORT).show();
                }
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnContextMenu:
                PopupMenu popupMenu = new PopupMenu(this,view);
                getMenuInflater().inflate(R.menu.contact_menu,popupMenu.getMenu());
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        Toast.makeText(MainActivity.this, item.getItemId() +  " - " + item.getTitle() , Toast.LENGTH_SHORT).show();
                        return false;
                    }
                });

                popupMenu.setOnDismissListener(new PopupMenu.OnDismissListener() {
                    @Override
                    public void onDismiss(PopupMenu menu) {
                        Toast.makeText(MainActivity.this, "Menu Dismiss", Toast.LENGTH_SHORT).show();
                    }
                });
                popupMenu.show();
                break;
        }
    }
}
