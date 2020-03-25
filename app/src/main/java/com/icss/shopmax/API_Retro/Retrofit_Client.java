package com.icss.shopmax.API_Retro;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Retrofit_Client {

    private static Retrofit retrofit = null;

    public static Retrofit getClient(String baseUrl)  {

        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        if (retrofit==null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(baseUrl)
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .build();
        }
        return retrofit;
    }

    public static Api_Para getAPIService(){
        return Retrofit_Client.getClient(BaseUrl.BaseUrl).create(Api_Para.class);
    }

}
