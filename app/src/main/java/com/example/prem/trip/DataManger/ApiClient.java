package com.example.prem.trip.DataManger;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {
    //home ip
   public static final String BASE_URL = "http://192.168.10.61/Tripn/";
    //office ip
  // public static final String BASE_URL = "http://192.168.1.83/Tripn/";
    private static Retrofit retrofit= null;

    public static Retrofit getRetrofit() {
        if(retrofit==null){
            retrofit = new Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();
        }
        return retrofit;
    }
}
