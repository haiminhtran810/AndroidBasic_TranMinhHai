package com.example.hcm_102_0006.android_retrofit_rxj.adapterRecycleView;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.hcm_102_0006.android_retrofit_rxj.model.GitHub;
import com.example.hcm_102_0006.android_retrofit_rxj.R;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by hcm-102-0006 on 10/11/2017.
 */

public class AdapterRecycleView extends RecyclerView.Adapter<AdapterRecycleView.ViewHolder> {
    private LayoutInflater layoutInflater;
    private List<GitHub> mItems;

    public AdapterRecycleView() {
        mItems = new ArrayList<>();
    }

    public AdapterRecycleView(List<GitHub> mItems) {
        this.mItems = mItems;
    }

    public void addData(GitHub gitHub) {
        mItems.add(gitHub);
        notifyDataSetChanged();
    }

    public void clearData() {
        mItems.clear();
        notifyDataSetChanged();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (layoutInflater == null) {
            layoutInflater = LayoutInflater.from(parent.getContext());
        }
        View v = layoutInflater.inflate(R.layout.item_recycleview, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.bindData(mItems.get(position));
    }

    @Override
    public int getItemCount() {
        return mItems == null ? 0 : mItems.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        private TextView txtRepos, txtLogin, txtBlog;

        public ViewHolder(View itemView) {
            super(itemView);
            txtRepos = itemView.findViewById(R.id.txtRepos);
            txtBlog = itemView.findViewById(R.id.txtBlog);
            txtLogin = itemView.findViewById(R.id.txtLogin);
        }

        public void bindData(GitHub gitHub) {
            if (gitHub == null) {
                return;
            }
            txtLogin.setText(gitHub.getLogin());
            txtBlog.setText(gitHub.getBlog());
            txtRepos.setText(gitHub.getPublicRepos()+"");
        }
    }
}
