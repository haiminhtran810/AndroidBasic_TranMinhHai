package com.example.hcm_102_0006.android_advance1_retrofit.Model;


import com.google.gson.annotations.SerializedName;

/**
 * Created by hcm-102-0006 on 03/11/2017.
 */

public class Currently {
    @SerializedName("temperature")
    private double mTemperature;
    @SerializedName("humidity")
    private double mHumidity;
    @SerializedName("windSpeed")
    private double mWindSpeed;

    public Currently(double mTemperature, double mHumidity, double mWindSpeed) {
        this.mTemperature = mTemperature;
        this.mHumidity = mHumidity;
        this.mWindSpeed = mWindSpeed;
    }

    public double getmTemperature() {
        return mTemperature;
    }

    public void setmTemperature(double mTemperature) {
        this.mTemperature = mTemperature;
    }

    public double getmHumidity() {
        return mHumidity;
    }

    public void setmHumidity(double mHumidity) {
        this.mHumidity = mHumidity;
    }

    public double getmWindSpeed() {
        return mWindSpeed;
    }

    public void setmWindSpeed(double mWindSpeed) {
        this.mWindSpeed = mWindSpeed;
    }
}
