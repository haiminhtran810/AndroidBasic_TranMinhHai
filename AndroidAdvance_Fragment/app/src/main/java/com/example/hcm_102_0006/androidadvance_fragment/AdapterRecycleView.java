package com.example.hcm_102_0006.androidadvance_fragment;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by hcm-102-0006 on 01/11/2017.
 */

public class AdapterRecycleView  extends  RecyclerView.Adapter<AdapterRecycleView.ViewHolder>{
    private String[] mDemo;
    private LayoutInflater layoutInflater;

    public AdapterRecycleView(String[] mDemo) {
        this.mDemo = mDemo;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if(layoutInflater == null){
            layoutInflater = LayoutInflater.from(parent.getContext());
        }
        View v = layoutInflater.inflate(android.R.layout.simple_expandable_list_item_1,parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.bindData(mDemo[position]);
    }

    @Override
    public int getItemCount() {
        return mDemo.length;
    }

    public class ViewHolder  extends RecyclerView.ViewHolder {
        private TextView mTxtDemo;
        public ViewHolder(View itemView) {
            super(itemView);
            // Do not create layout to custom
            // Use textview in id android.R.id.text1
            mTxtDemo =  (TextView) itemView.findViewById(android.R.id.text1);
        }

        public void bindData(String title){
            if( title != null ){
                mTxtDemo.setText(title);
            }
        }
    }
}
