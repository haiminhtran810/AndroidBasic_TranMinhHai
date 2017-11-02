package com.example.hcm_102_0006.android_advance1_thread;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    private final String TAG = getClass().getSimpleName();
    private Handler handler;
    private TextView txtShowNumber;
    private ImageView imgShow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtShowNumber = findViewById(R.id.txtShowNumber);
        imgShow = findViewById(R.id.imgDemo);

        handler = new Handler() {
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                imgShow.setImageBitmap((Bitmap) msg.obj);
            }
        };

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {

                String urlImage = "https://assets.pokemon.com/assets//cms2/img/play-games/_tiles/alolan_volcanic_panic/alolan-volcanic-panic-169.jpg";
                Bitmap bitmap = null;
                try {
                    InputStream inputStream = new URL(urlImage).openStream();
                    bitmap = BitmapFactory.decodeStream(inputStream);
                    Thread.sleep(5000);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                Message message = handler.obtainMessage();
                message.obj = bitmap;
                handler.sendMessage(message);

            }
        });
        thread.start();
    }
}
