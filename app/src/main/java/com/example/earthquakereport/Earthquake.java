package com.example.earthquakereport;

public class Earthquake {


    private double mScale;
    private String mCityName;
    private String mData;
    private String mUrl;


    public Earthquake(double scale, String city, String data, String url){
        mScale = scale;
        mData = data;
        mCityName = city;
        mUrl=url;
    }

    public double getScale(){
        return mScale;
    }
    public String getCityName() {
        return mCityName;
    }
    public String getData(){
        return mData;
    }
    public String getUrl(){return mUrl;}

}
