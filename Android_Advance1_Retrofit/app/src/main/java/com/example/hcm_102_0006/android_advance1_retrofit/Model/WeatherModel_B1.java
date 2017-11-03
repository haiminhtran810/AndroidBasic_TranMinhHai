package com.example.hcm_102_0006.android_advance1_retrofit.Model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by hcm-102-0006 on 03/11/2017.
 */

public class WeatherModel_B1 {
    @SerializedName("latitude")
    private double mLatitude;
    @SerializedName("longitude")
    private double mLongitude;
    @SerializedName("timezone")
    private String mTimezone;
    @SerializedName("currently")
    private Currently mCurrently;

    public WeatherModel_B1(double mLatitude, double mLongitude, String mTimezone, Currently mCurrently) {
        this.mLatitude = mLatitude;
        this.mLongitude = mLongitude;
        this.mTimezone = mTimezone;
        this.mCurrently = mCurrently;
    }

    public double getmLatitude() {
        return mLatitude;
    }

    public void setmLatitude(double mLatitude) {
        this.mLatitude = mLatitude;
    }

    public double getmLongitude() {
        return mLongitude;
    }

    public void setmLongitude(double mLongitude) {
        this.mLongitude = mLongitude;
    }

    public String getmTimezone() {
        return mTimezone;
    }

    public void setmTimezone(String mTimezone) {
        this.mTimezone = mTimezone;
    }

    public Currently getmCurrently() {
        return mCurrently;
    }

    public void setmCurrently(Currently mCurrently) {
        this.mCurrently = mCurrently;
    }
}
