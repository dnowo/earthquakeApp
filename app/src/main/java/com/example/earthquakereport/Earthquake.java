package com.example.earthquakereport;

public class Earthquake {


    private String mScale;
    private String mCityName;
    private String mData;


    public Earthquake(String scale, String city, String data){
        mScale = scale;
        mData = data;
        mCityName = city;
    }

    public String getScale(){
        return mScale;
    }
    public String getCityName() {
        return mCityName;
    }
    public String getData(){
        return mData;
    }

}
