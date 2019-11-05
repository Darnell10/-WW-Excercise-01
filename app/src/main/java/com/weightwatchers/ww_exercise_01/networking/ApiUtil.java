package com.weightwatchers.ww_exercise_01.networking;

public class ApiUtil {

    public static final String BASE_URL = "https://www.weightwatchers.com/";

    public static WW_Service getApiService(){

        return  RetrofitClient.getRetrofit(BASE_URL).create(WW_Service.class);
    }
}