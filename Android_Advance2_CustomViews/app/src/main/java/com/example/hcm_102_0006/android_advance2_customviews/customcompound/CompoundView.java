package com.example.hcm_102_0006.android_advance2_customviews.customcompound;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.hcm_102_0006.android_advance2_customviews.R;

/**
 * Created by hcm-102-0006 on 06/11/2017.
 */

public class CompoundView extends LinearLayout {


    public CompoundView(Context context) {
        super(context,null);
    }

    public CompoundView(Context context, @Nullable AttributeSet attrs) {
        this(context,attrs,0);
    }

    public CompoundView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setAttribute(context,attrs);
    }

    private void setAttribute(Context context, AttributeSet attributeSet) {
        TypedArray typedArray =
                context.obtainStyledAttributes(attributeSet, R.styleable.CompoundView, 0, 0);
        String titleText = typedArray.getString(R.styleable.CompoundView_titleText);
        @SuppressLint("ResourceAsColor")
        int valueColor =
                typedArray.getColor(R.styleable.CompoundView_valueColor, android.R.color.holo_blue_light);
        typedArray.recycle();

        final View v = LayoutInflater.from(context).inflate(R.layout.custom_compound, this, true);
        TextView txtTitle = v.findViewById(R.id.txtTitle);
        txtTitle.setText(titleText);
        View v_Color = v.findViewById(R.id.viewColor);
        v_Color.setBackgroundColor(valueColor);
    }
}
