package com.example.hcm_102_0006.adndroid_thread_hanlder_asyntask;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class MainActivity extends AppCompatActivity implements OnClickListener{

    private ImageView imgShowResult;
    private EditText txtEnterUrl;
    private Button btnGetImage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imgShowResult = findViewById(R.id.imgShowResult);
        txtEnterUrl = findViewById(R.id.txtEnterUrl);
        btnGetImage = findViewById(R.id.btnGetImage);
        btnGetImage.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnGetImage:

                new GetImgaeFromIntenet().execute(txtEnterUrl.getText().toString());
                break;
        }
    }

    public class GetImgaeFromIntenet extends AsyncTask<String,Void,Bitmap>{
        @Override
        protected Bitmap doInBackground(String... strings) {
            String urlImage = strings[0].toString();
            Bitmap bitmap = null;
            try {
                InputStream inputStream = new URL(urlImage).openStream();
                bitmap = BitmapFactory.decodeStream(inputStream);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return bitmap;
        }

        @Override
        protected void onPostExecute(Bitmap bitmap) {
            super.onPostExecute(bitmap);
            if (bitmap!= null){
                imgShowResult.setImageBitmap(bitmap);
            }else{
                Toast.makeText(MainActivity.this, "Please check your path.", Toast.LENGTH_SHORT).show();
            }
        }
    }


}
