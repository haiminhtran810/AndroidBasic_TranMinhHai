package com.example.hcm_102_0006.demo_hmt_recyclerview;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.hcm_102_0006.demo_hmt_recyclerview.data.model.Contact;

import java.util.List;

/**
 * Created by hcm-102-0006 on 01/11/2017.
 */

public class ContactAdapterRecycleView extends RecyclerView.Adapter<ContactAdapterRecycleView.ViewHolder> {

    private LayoutInflater layoutInflater;
    private List<Contact> mContacts;

    public ContactAdapterRecycleView(List<Contact> mContacts) {
        this.mContacts = mContacts;
    }

    //This is done by inflate the layout using LayoutInflater, passing the output to the constructor function of the custom ViewHolder.

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if(layoutInflater == null){
            layoutInflater = LayoutInflater.from(parent.getContext());
        }
        View v = layoutInflater.inflate(R.layout.custom_item_contract,parent, false);
        return new ViewHolder(v);
    }

    // Determine the contents of each element of the recycleview ( Same getView in ListView)
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.bindData(mContacts.get(position));
    }

    @Override
    public int getItemCount() {
        return mContacts == null ? 0 : mContacts.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnLongClickListener,View.OnClickListener {
        private TextView txtShowName;
        private TextView txtShowPhone;
        private TextView txtShowAddress;
        public ViewHolder(View itemView) {
            super(itemView);
            txtShowName= itemView.findViewById(R.id.txtShowName);
            txtShowAddress = itemView.findViewById(R.id.txtShowAddress);
            txtShowPhone = itemView.findViewById(R.id.txtShowPhone);
            itemView.setOnClickListener(this);
            itemView.setOnLongClickListener(this);
        }

        public void bindData(Contact contact){
            if(contact == null) return;
            txtShowName.setText(contact.getmName());
            txtShowAddress.setText(contact.getmAddress());
            txtShowPhone.setText(contact.getmPhone());
        }

        @Override
        public boolean onLongClick(View view) {
            int positionItem = getPosition();
            Contact contact = mContacts.get(positionItem);
            Toast.makeText(view.getContext(), "on Long Click : Position " + positionItem + " / " + contact.toString() ,Toast.LENGTH_LONG).show();
            return false;
        }

        @Override
        public void onClick(View view) {
            int positionItem = getPosition();
            Contact contact = mContacts.get(positionItem);
            Toast.makeText(view.getContext(), "on Click : Position " + positionItem + " / " + contact.toString() ,Toast.LENGTH_LONG).show();
        }
    }
}
