package com.example.hcm_102_0006.android_advance1_permision_loadimages;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import java.util.List;

/**
 * Created by hcm-102-0006 on 02/11/2017.
 */

public class ImageAdapter extends RecyclerView.Adapter<ImageAdapter.ViewHolder> {
    private List<String> mPathImages;
    private LayoutInflater layoutInflater;

    public ImageAdapter(List<String> mPathImages) {
        this.mPathImages = mPathImages;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (layoutInflater == null) {
            layoutInflater = LayoutInflater.from(parent.getContext());
        }
        View v = layoutInflater.inflate(R.layout.item_show_image, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.bindData(mPathImages.get(position));
    }

    @Override
    public int getItemCount() {
        return mPathImages == null ? 0 : mPathImages.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView imgShow;

        public ViewHolder(View itemView) {
            super(itemView);
            imgShow = itemView.findViewById(R.id.imgShow);
        }

        public void bindData(String path) {
            if (path != null) {
                Glide
                        .with(itemView.getContext())
                        .load(path).centerCrop()
                        .error(R.mipmap.ic_launcher).into(imgShow);
            }
        }
    }
}
