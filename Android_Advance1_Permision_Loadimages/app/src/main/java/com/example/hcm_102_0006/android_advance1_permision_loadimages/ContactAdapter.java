package com.example.hcm_102_0006.android_advance1_permision_loadimages;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by hcm-102-0006 on 02/11/2017.
 */

public class ContactAdapter extends RecyclerView.Adapter<ContactAdapter.ViewHolder> {
    private List<Contact> mContacts;
    private LayoutInflater layoutInflater;

    public ContactAdapter(List<Contact> mContacts) {
        this.mContacts = mContacts;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (layoutInflater == null) {
            layoutInflater = LayoutInflater.from(parent.getContext());
        }
        View v = layoutInflater.inflate(R.layout.item_show_contact, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.bindData(mContacts.get(position));
    }

    @Override
    public int getItemCount() {
        return mContacts == null ? 0 : mContacts.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView txtName, txtPhone;

        public ViewHolder(View itemView) {
            super(itemView);
            txtName = itemView.findViewById(R.id.txtName);
            txtPhone = itemView.findViewById(R.id.txtPhone);
        }

        public void bindData(Contact contact) {
            if (contact != null) {
                txtPhone.setText(contact.getmPhone());
                txtName.setText(contact.getmName());
            }
        }
    }
}
