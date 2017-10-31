package com.example.hcm_102_0006.maytinhbotui_lession2_project2;

import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SearchView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity  implements View.OnClickListener{

    private Button btn0, btn1, btn2, btn3,btn4, btn5,btn6, btn7, btn8,btn9;
    private Button btnSum, btnSub, btnMul, btnDiv;
    private Button btnShowResult, btnC, btnAC, btnNeVsPo, btnPoint;
    private EditText txtEnterNumber;
    private String valuesNumber1 = "";
    private String valuesNumber2 = "";
    private int calculation = 1;
    private boolean isChangeValues = false;
    float result = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtEnterNumber = findViewById(R.id.txtEnterNumber);

        //  Number
        btn0 =findViewById(R.id.btn0);
        btn0.setOnClickListener(this);

        btn1 =findViewById(R.id.btn1);
        btn1.setOnClickListener(this);

        btn2 =findViewById(R.id.btn2);
        btn2.setOnClickListener(this);

        btn3 =findViewById(R.id.btn3);
        btn3.setOnClickListener(this);

        btn4 =findViewById(R.id.btn4);
        btn4.setOnClickListener(this);

        btn5 =findViewById(R.id.btn5);
        btn5.setOnClickListener(this);

        btn6 =findViewById(R.id.btn6);
        btn6.setOnClickListener(this);

        btn7=findViewById(R.id.btn7);
        btn7.setOnClickListener(this);

        btn8=findViewById(R.id.btn8);
        btn8.setOnClickListener(this);

        btn9=findViewById(R.id.btn9);
        btn9.setOnClickListener(this);

        // Calculation
        btnSum=findViewById(R.id.btnSum);
        btnSum.setOnClickListener(this);

        btnSub=findViewById(R.id.btnSub);
        btnSub.setOnClickListener(this);

        btnMul=findViewById(R.id.btnMul);
        btnMul.setOnClickListener(this);

        btnDiv=findViewById(R.id.btnDiv);
        btnDiv.setOnClickListener(this);
        //

        btnShowResult = findViewById(R.id.btnShowResult);
        btnShowResult.setOnClickListener(this);

        btnC = findViewById(R.id.btnC);
        btnC.setOnClickListener(this);

        btnAC = findViewById(R.id.btnAC);
        btnAC.setOnClickListener(this);

        btnNeVsPo = findViewById(R.id.btnNeVsPo);
        btnNeVsPo.setOnClickListener(this);

        btnPoint = findViewById(R.id.btnPoint);
        btnPoint.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()){
            // Show number
            case R.id.btn0:
                if(!isChangeValues){
                    valuesNumber1 += String.valueOf(0);
                    txtEnterNumber.setText(valuesNumber1);
                }else{
                    valuesNumber2 += String.valueOf(0);
                    txtEnterNumber.setText(valuesNumber2);
                }

                break;
            case R.id.btn1:
                if(!isChangeValues){
                    valuesNumber1 += String.valueOf(1);
                    txtEnterNumber.setText(valuesNumber1);
                }else{
                    valuesNumber2 += String.valueOf(1);
                    txtEnterNumber.setText(valuesNumber2);
                }
                break;
            case R.id.btn2:
                if(!isChangeValues){
                    valuesNumber1 += String.valueOf(2);
                    txtEnterNumber.setText(valuesNumber1);
                }else{
                    valuesNumber2 += String.valueOf(2);
                    txtEnterNumber.setText(valuesNumber2);
                }
                break;
            case R.id.btn3:
                if(!isChangeValues){
                    valuesNumber1 += String.valueOf(3);
                    txtEnterNumber.setText(valuesNumber1);
                }else{
                    valuesNumber2 += String.valueOf(3);
                    txtEnterNumber.setText(valuesNumber2);
                }
                break;
            case R.id.btn4:
                if(!isChangeValues){
                    valuesNumber1 += String.valueOf(4);
                    txtEnterNumber.setText(valuesNumber1);
                }else{
                    valuesNumber2 += String.valueOf(4);
                    txtEnterNumber.setText(valuesNumber2);
                }
                break;
            case R.id.btn5:
                if(!isChangeValues){
                    valuesNumber1 += String.valueOf(5);
                    txtEnterNumber.setText(valuesNumber1);
                }else{
                    valuesNumber2 += String.valueOf(5);
                    txtEnterNumber.setText(valuesNumber2);
                }
                break;
            case R.id.btn6:
                if(!isChangeValues){
                    valuesNumber1 += String.valueOf(6);
                    txtEnterNumber.setText(valuesNumber1);
                }else{
                    valuesNumber2 += String.valueOf(6);
                    txtEnterNumber.setText(valuesNumber2);
                }
                break;
            case R.id.btn7:
                if(!isChangeValues){
                    valuesNumber1 += String.valueOf(7);
                    txtEnterNumber.setText(valuesNumber1);
                }else{
                    valuesNumber2 += String.valueOf(7);
                    txtEnterNumber.setText(valuesNumber2);
                }
                break;
            case R.id.btn8:
                if(!isChangeValues){
                    valuesNumber1 += String.valueOf(8);
                    txtEnterNumber.setText(valuesNumber1);
                }else{
                    valuesNumber2 += String.valueOf(8);
                    txtEnterNumber.setText(valuesNumber2);
                }
                break;
            case R.id.btn9:
                if(!isChangeValues){
                    valuesNumber1 += String.valueOf(9);
                    txtEnterNumber.setText(valuesNumber1);
                }else{
                    valuesNumber2 += String.valueOf(9);
                    txtEnterNumber.setText(valuesNumber2);
                }
                break;
                // Calculation
            case R.id.btnSum:
                //if(!isChangeValues){
                txtEnterNumber.setText("0");
                //}
                isChangeValues = true;
                calculation = 1;

                break;
            case R.id.btnSub:
                //if(!isChangeValues){
                txtEnterNumber.setText("0");
                //}
                isChangeValues = true;
                calculation = 2;

                break;
            case R.id.btnMul:
                isChangeValues = true;
                calculation = 3;
                txtEnterNumber.setText("0");
                break;
            case R.id.btnDiv:
                isChangeValues = true;
                calculation = 4;
                txtEnterNumber.setText("0");
                break;

            case R.id.btnC:
                txtEnterNumber.setText("0");
                break;
                //

            case R.id.btnPoint:

                if(!isChangeValues){
                    if(!valuesNumber1.contains(".")){
                        valuesNumber1 += String.valueOf(".");
                        txtEnterNumber.setText(valuesNumber1);
                    }else{
                        Toast.makeText(this, "Bạn đã có kí tự này trong giá trị nhập", Toast.LENGTH_SHORT).show();
                    }
                }else{
                    if(!valuesNumber1.contains(".")){
                        valuesNumber2 += String.valueOf(".");
                        txtEnterNumber.setText(valuesNumber2);
                    }else{
                        Toast.makeText(this, "Bạn đã có kí tự này trong giá trị nhập", Toast.LENGTH_SHORT).show();
                    }
                }
                break;

            case R.id.btnNeVsPo:
                if(!isChangeValues){
                    if(!valuesNumber1.contains("-")){
                        valuesNumber1 = "-" + valuesNumber1;
                        txtEnterNumber.setText(valuesNumber1);
                    }else{
                        valuesNumber1 = valuesNumber1.replace("-","");
                        txtEnterNumber.setText(valuesNumber1);
                    }
                }else{
                    if(!valuesNumber2.contains("-")){
                        valuesNumber2 = "-" + valuesNumber2;
                        txtEnterNumber.setText(valuesNumber2);
                    }else{
                        valuesNumber2 = valuesNumber2.replace("-","");
                        txtEnterNumber.setText(valuesNumber2);
                    }
                }

                break;
            case R.id.btnAC:
                isChangeValues = false;
                valuesNumber1 = "";
                valuesNumber2 = "";
                result = 0;
                txtEnterNumber.setText("0");
                break;
            case R.id.btnShowResult:

                float number1;
                float number2;
                try {
                    number1 = Float.parseFloat(valuesNumber1);
                    number2 = Float.parseFloat(valuesNumber2);
                }catch (NumberFormatException ex ){
                    Toast.makeText(this, "Giá trị bạn nhập không đúng định dạng. Vui lòng nhập lại giá trí. ", Toast.LENGTH_SHORT).show();
                    return;
                }
                if(calculation == 1){
                    sum(number1, number2);
                }else if(calculation == 2){
                    sub(number1, number2);
                }else if(calculation == 3){
                    mul(number1, number2);
                }else if(calculation == 4){
                    div(number1, number2);
                }

                valuesNumber1 = String.valueOf(result);
                txtEnterNumber.setText(String.valueOf(result));
                valuesNumber2  = "";
                break;
        }
    }

    public void sum(float a, float b){
        result = a + b;
    }

    public void sub(float a, float b){
        result = a - b;
    }

    public void div(float a, float b){

        if(b == 0){
            Toast.makeText(this, " Số thứ 2 bằng 0 . Không thể chia ở biểu thức này. ", Toast.LENGTH_SHORT).show();
        }else{
            result = a/b;
        }
    }

    public void mul(float a, float b){
        result = a * b;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.my_menu, menu);
        MenuItem searchViewItem = menu.findItem(R.id.search);
        final SearchView searchViewAndroidActionBar = (SearchView) MenuItemCompat.getActionView(searchViewItem);
        searchViewAndroidActionBar.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                Toast.makeText(MainActivity.this, "Bạn đang search : " +  newText, Toast.LENGTH_SHORT).show();
                return false;
            }
        });
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu1:
                Toast.makeText(this, "Bạn đang chọn menu 1", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.menu2:
                Toast.makeText(this, "Bạn đang chọn menu 2", Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }

}
