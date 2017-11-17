package place.home.hai.android_advance_realm_db.adapter;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import io.realm.Realm;
import io.realm.RealmResults;
import place.home.hai.android_advance_realm_db.R;
import place.home.hai.android_advance_realm_db.global.Cmns;
import place.home.hai.android_advance_realm_db.model.Book;

/**
 * Created by Hai on 11/17/2017.
 */

public class RecycleAdapter extends RecyclerView.Adapter<RecycleAdapter.MyViewHolder> {
    private List<Book> mBooks;
    private Activity context;
    private LayoutInflater layoutInflater;
    private Realm realm;

    public RecycleAdapter(List<Book> mBooks, Activity context, Realm realm) {
        this.mBooks = mBooks;
        this.context = context;
        this.realm = realm;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (layoutInflater == null) {
            layoutInflater = LayoutInflater.from(context);
        }
        View v = layoutInflater.inflate(R.layout.item_layout, parent, false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.bindData(mBooks.get(position));
    }

    @Override
    public int getItemCount() {
        return mBooks == null ? 0 : mBooks.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private TextView txtShowTitle;
        private ImageView btnDelete;
        private ImageView btnEdit;

        public MyViewHolder(View itemView) {
            super(itemView);
            txtShowTitle = (TextView) itemView.findViewById(R.id.txtShowTitle);
            btnDelete = (ImageView) itemView.findViewById(R.id.btnDelete);
            btnEdit = (ImageView) itemView.findViewById(R.id.btnEdit);
            btnDelete.setOnClickListener(this);
            btnEdit.setOnClickListener(this);

        }

        public void bindData(Book book) {
            if (book == null) return;
            txtShowTitle.setText(book.getTitle());
        }

        @Override
        public void onClick(View view) {
            int position = getAdapterPosition();
            final Book bookTemp = mBooks.get(position);
            switch (view.getId()) {
                case R.id.btnDelete:
                    realm.beginTransaction();
                    realm.where(Book.class).equalTo("id", bookTemp.getId()).findAll().deleteAllFromRealm();
                    realm.commitTransaction();
                    mBooks.clear();
                    mBooks.addAll(getAllBooks());
                    notifyDataSetChanged();
                    break;
                case R.id.btnEdit:
                    showAlertDialog(bookTemp);
                    break;

            }
        }
    }


    public void showAlertDialog(final Book book) {
        LayoutInflater inflater = context.getLayoutInflater();
        View alertLayout = inflater.inflate(R.layout.custom_alerdialog, null);
        final EditText txtEdit = (EditText) alertLayout.findViewById(R.id.txtEdit);
        AlertDialog.Builder alert = new AlertDialog.Builder(context);
        alert.setTitle("Edit Book: ");
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
                    Toast.makeText(context, "Please, Enter Title.", Toast.LENGTH_SHORT).show();
                } else {
                    realm.beginTransaction();
                    book.setTitle("Title : " + title);
                    realm.copyToRealmOrUpdate(book);
                    realm.commitTransaction();
                    mBooks.clear();
                    mBooks.addAll(getAllBooks());
                    notifyDataSetChanged();
                    Toast.makeText(context, "Successfully", Toast.LENGTH_SHORT).show();
                }
            }
        });
        AlertDialog dialog = alert.create();
        dialog.show();
    }

    private List<Book> getAllBooks() {
        List<Book> books = new ArrayList<>();
        RealmResults<Book> results =
                realm.where(Book.class).findAll();
        books.addAll(results);
        return books;
    }
}
