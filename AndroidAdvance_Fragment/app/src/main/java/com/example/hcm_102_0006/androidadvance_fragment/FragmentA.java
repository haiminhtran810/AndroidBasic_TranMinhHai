package com.example.hcm_102_0006.androidadvance_fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by hcm-102-0006 on 01/11/2017.
 */

public class FragmentA extends Fragment {
    private String[] mTitles = {
            "A", "B", "C", "D", "E", "F", "G", "H", "E", "J",
            "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T",
            "U", "V", "X", "Y", "Z", "W"
    };

    public FragmentA() {

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.layout_fragment,container,false);
        RecyclerView recyclerView = v.findViewById(R.id.rcySample);
        recyclerView.setLayoutManager(new LinearLayoutManager(v.getContext()));
        AdapterRecycleView adapterRecycleView = new AdapterRecycleView(mTitles);
        recyclerView.setAdapter(adapterRecycleView);
        return v;
    }
}
