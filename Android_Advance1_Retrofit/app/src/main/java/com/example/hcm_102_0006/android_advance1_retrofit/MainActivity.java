package com.example.hcm_102_0006.android_advance1_retrofit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.hcm_102_0006.android_advance1_retrofit.Model.WeatherModel_B1;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private final String KEY_VALUES = "e9d8a85323ae7c4fa0bb85987cabfab4";
    private final double LATITUDE = 37.8267;
    private final double LONGITUDE = -122.4233;
    private TextView txtShowResult;
    private Button btnGetData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtShowResult = findViewById(R.id.txtShowResult);
        btnGetData = findViewById(R.id.btnGetData);
        btnGetData.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnGetData:
                WeatherService_B2 weatherService_b2 = WeatherService_B3.createService(WeatherService_B2.class);
                weatherService_b2.getDbWeather(KEY_VALUES, LATITUDE, LONGITUDE).enqueue(new Callback<WeatherModel_B1>() {
                    @Override
                    public void onResponse(Call<WeatherModel_B1> call, Response<WeatherModel_B1> response) {
                        WeatherModel_B1 weatherModel_b1 = response.body();
                        String result =
                                "Latitude : " + weatherModel_b1.getmLatitude() + "\n"
                                        + "Longitude : " + weatherModel_b1.getmLongitude() + "\n"
                                        + "Timezone : " + weatherModel_b1.getmTimezone() + "\n"
                                        + "WindSpeed : " + weatherModel_b1.getmCurrently().getmWindSpeed() + "\n"
                                        + "Temperature : " + weatherModel_b1.getmCurrently().getmTemperature() + "\n"
                                        + "Humidity : " + weatherModel_b1.getmCurrently().getmHumidity();
                        txtShowResult.setText(result);
                    }

                    @Override
                    public void onFailure(Call<WeatherModel_B1> call, Throwable t) {
                        Toast.makeText(MainActivity.this, "Failed", Toast.LENGTH_SHORT).show();
                    }
                });
                break;
        }
    }

    // Step3 : Get values

}
