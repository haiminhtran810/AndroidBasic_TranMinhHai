package com.example.hcm_102_0006.demomvvm;

import android.databinding.DataBindingUtil;
import android.databinding.ObservableField;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.hcm_102_0006.demomvvm.databinding.ItemRecycleBinding;
import com.example.hcm_102_0006.demomvvm.model.ValueText;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by hcm-102-0006 on 08/11/2017.
 */

public class AdapterRecycleView extends RecyclerView.Adapter<AdapterRecycleView.MyViewHolder> {
    private List<ValueText> mList = new ArrayList<>();

    public AdapterRecycleView(List<ValueText> mList) {
        this.mList = mList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ItemRecycleBinding binding =
                DataBindingUtil.inflate(
                        LayoutInflater.from(parent.getContext()),
                        R.layout.item_recycle, parent, false);
        return new MyViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.setBinding(mList.get(position).getText().toString());
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        public ObservableField<String> mText = new ObservableField<>();
        public ItemRecycleBinding mBinding;

        public MyViewHolder(ItemRecycleBinding binding) {
            super(binding.getRoot());
            this.mBinding = binding;
        }


        public void setBinding(String s) {
            if (mBinding.getItemView() == null) {
                mBinding.setItemView(this);
            }
            mText.set(s);
        }
    }

}
