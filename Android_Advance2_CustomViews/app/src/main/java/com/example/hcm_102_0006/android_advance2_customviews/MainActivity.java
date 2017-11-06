package com.example.hcm_102_0006.android_advance2_customviews;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.example.hcm_102_0006.android_advance2_customviews.customview.DrawOnTheView;

public class MainActivity extends AppCompatActivity {

    private DrawOnTheView drawOnTheView;
    private Button btnDeleteAll;
    private LinearLayout lnGreen, lnBlue;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        drawOnTheView = findViewById(R.id.drawView);
        btnDeleteAll = findViewById(R.id.btnDeleteAll);
        btnDeleteAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                drawOnTheView.deleteAll();
            }
        });

        lnGreen = findViewById(R.id.lnGreen);
        lnBlue = findViewById(R.id.lnBlue);

        lnBlue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                drawOnTheView.changeColor(Color.BLUE);
            }
        });

        lnGreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                drawOnTheView.changeColor(Color.GREEN);

            }
        });
    }
}
