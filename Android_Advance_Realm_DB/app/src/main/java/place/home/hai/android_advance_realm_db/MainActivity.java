package place.home.hai.android_advance_realm_db;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import io.realm.Realm;
import io.realm.RealmResults;
import place.home.hai.android_advance_realm_db.adapter.RecycleAdapter;
import place.home.hai.android_advance_realm_db.global.Cmns;
import place.home.hai.android_advance_realm_db.model.Book;

public class MainActivity extends AppCompatActivity {
    private RecyclerView rcyShow;
    private RecycleAdapter recycleAdapter;
    private List<Book> mBooks;
    private Realm realm;
    private Button btnAddBook;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        realm = Realm.getDefaultInstance(); // opens "htm.realm in RealmApplication"
        mBooks = new ArrayList<>();
        addValuesToRealmDb();
        mBooks.addAll(getAllBooks());
        rcyShow = (RecyclerView) findViewById(R.id.rcyShow);
        rcyShow.setLayoutManager(new LinearLayoutManager(this));
        recycleAdapter = new RecycleAdapter(mBooks, this,realm);
        rcyShow.setAdapter(recycleAdapter);
        btnAddBook = (Button) findViewById(R.id.btnAddBook);
        btnAddBook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showAlertDialog();
            }
        });
    }

    private void addValuesToRealmDb() {
        realm.beginTransaction();
        for (int i = 0; i < 10; i++) {
            Book book = realm.createObject(Book.class, String.valueOf(Cmns.getKeyID(i)));
            book.setTitle("Title : Book " + i);
        }
        realm.commitTransaction();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        realm.close();
    }

    private List<Book> getAllBooks() {
        List<Book> books = new ArrayList<>();
        RealmResults<Book> results =
                realm.where(Book.class).findAll();
        books.addAll(results);
        return books;
    }

    public void showAlertDialog() {
        LayoutInflater inflater = this.getLayoutInflater();
        View alertLayout = inflater.inflate(R.layout.custom_alerdialog, null);
        final EditText txtEdit = (EditText) alertLayout.findViewById(R.id.txtEdit);
        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setTitle("Add Book: ");
        alert.setView(alertLayout);
        alert.setCancelable(false);
        alert.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
            }
        });
        alert.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String title = txtEdit.getText().toString();
                if (title == null || title.equals("")) {
                    Toast.makeText(MainActivity.this, "Please, Enter Title.", Toast.LENGTH_SHORT).show();
                } else {
                    realm.beginTransaction();
                    Book book = realm.createObject(Book.class, String.valueOf(Cmns.getKeyID(new Random(100).nextInt())));
                    book.setTitle("Title : Book " + title);
                    realm.commitTransaction();
                    mBooks.clear();
                    mBooks.addAll(getAllBooks());
                    recycleAdapter.notifyDataSetChanged();
                    Toast.makeText(MainActivity.this, "Successfully", Toast.LENGTH_SHORT).show();
                }
            }
        });
        AlertDialog dialog = alert.create();
        dialog.show();
    }

}
