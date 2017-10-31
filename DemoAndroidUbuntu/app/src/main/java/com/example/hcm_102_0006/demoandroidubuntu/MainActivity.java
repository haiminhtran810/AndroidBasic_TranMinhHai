package com.example.hcm_102_0006.demoandroidubuntu;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private float result = 0;
    private EditText txtNumber1, txtNumber2, txtResult;
    private Button btnSum, btnSub, btnMul, btnDiv, btnResult, btnAC;
    private TextView txtCalculation;
    private int calculation = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtNumber1 = findViewById(R.id.txtNumber1);
        txtNumber2 = findViewById(R.id.txtNumber2);
        txtResult = findViewById(R.id.txtResult);
        btnSum = findViewById(R.id.btnSum);
        btnSub = findViewById(R.id.btnSub);
        btnMul = findViewById(R.id.btnMul);
        btnDiv = findViewById(R.id.btnDiv);
        btnResult = findViewById(R.id.btnResult);
        btnAC = findViewById(R.id.btnAC);
        txtCalculation= findViewById(R.id.txtCalculation);
        txtCalculation.setText("Phép cộng ");
        addEvents();

    }

    private void addEvents() {
        btnSum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                float a,b;
                try {
                    a = Float.parseFloat(txtNumber1.getText().toString());
                    b = Float.parseFloat(txtNumber2.getText().toString());
                }catch (NumberFormatException ex){
                    Toast.makeText(MainActivity.this,"Bạn kiểm tra lại kết quả bạn nhập",Toast.LENGTH_LONG).show();
                    return;
                }

                sum(a, b);
                calculation = 1;
                txtCalculation.setText("Phép cộng ");
            }
        });

        btnSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                float a,b;
                try {
                    a = Float.parseFloat(txtNumber1.getText().toString());
                    b = Float.parseFloat(txtNumber2.getText().toString());
                }catch (NumberFormatException ex){
                    Toast.makeText(MainActivity.this,"Bạn kiểm tra lại kết quả bạn nhập",Toast.LENGTH_LONG).show();
                    return;
                }

                sub(a, b);
                calculation = 2;
                txtCalculation.setText("Phép Trừ ");
            }
        });

        btnMul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                float a,b;
                try {
                    a = Float.parseFloat(txtNumber1.getText().toString());
                    b = Float.parseFloat(txtNumber2.getText().toString());
                }catch (NumberFormatException ex){
                    Toast.makeText(MainActivity.this,"Bạn kiểm tra lại kết quả bạn nhập",Toast.LENGTH_LONG).show();
                    return;
                }

                mul(a, b);
                calculation = 3;
                txtCalculation.setText("Phép Nhân ");
            }
        });

        btnDiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                float a,b;
                try {
                    a = Float.parseFloat(txtNumber1.getText().toString());
                    b = Float.parseFloat(txtNumber2.getText().toString());
                }catch (NumberFormatException ex){
                    Toast.makeText(MainActivity.this,"Bạn kiểm tra lại kết quả bạn nhập",Toast.LENGTH_LONG).show();
                    return;
                }

                div(a, b);
                calculation = 4;
                txtCalculation.setText("Phép chia ");
            }
        });

        btnAC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txtResult.setText("");
                txtNumber2.setText("");
                txtNumber1.setText("");
            }
        });

        btnResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                float a,b;
                try {
                    a = Float.parseFloat(txtNumber1.getText().toString());
                    b = Float.parseFloat(txtNumber2.getText().toString());
                }catch (NumberFormatException ex){
                    Toast.makeText(MainActivity.this,"Bạn kiểm tra lại kết quả bạn nhập",Toast.LENGTH_LONG).show();
                    return;
                }
                switch (calculation){
                    case 1:
                        sum(a, b);
                        break;
                    case 2:
                        sub(a, b);
                        break;
                    case 3:
                        mul(a, b);
                        break;
                    case 4:
                        div(a, b);
                        break;
                }
            }
        });
    }

    public void sum(float a, float b){
        result = a + b;
        txtResult.setText(String.format("%.02f", result));
    }

    public void sub(float a, float b){
        result = a - b;
        txtResult.setText(String.format("%.02f", result));
    }

    public void div(float a, float b){

        if(b == 0){
            Toast.makeText(this, " Số thứ 2 bằng 0 . Không thể chia ở biểu thức này. ", Toast.LENGTH_SHORT).show();
        }else{
            result = a/b;
            txtResult.setText(String.format("%.02f", result));
        }
    }

    public void mul(float a, float b){
        result = a * b;
        txtResult.setText(String.format("%.02f", result));
    }
}
