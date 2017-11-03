package com.example.hcm_102_0006.android_advance1_retrofit;

import com.example.hcm_102_0006.android_advance1_retrofit.Model.WeatherModel_B1;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;


/**
 * Created by hcm-102-0006 on 03/11/2017.
 */

public interface WeatherService_B2 {
    //https://darksky.net/dev/docs
    @GET("forecast/{key}/{latitude},{longitude}")
    Call<WeatherModel_B1> getDbWeather(@Path("key") String key, @Path("latitude") double latitude, @Path("longitude") double longitude);
}
