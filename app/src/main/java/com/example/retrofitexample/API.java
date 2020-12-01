package com.example.retrofitexample;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class API {

    public static final String BASE_URL = "https://jsonplaceholder.typicode.com";
    public static Retrofit retrofit;
    public static OkHttpClient okHttpClient;
    public static Gson gson;

    public static Retrofit getRetrofitClient(){
        if(retrofit == null){
            gson = new GsonBuilder().setLenient().create();
            okHttpClient = new OkHttpClient.Builder().build();
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .client(okHttpClient)
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .build();
        }
        return retrofit;
    }


}
