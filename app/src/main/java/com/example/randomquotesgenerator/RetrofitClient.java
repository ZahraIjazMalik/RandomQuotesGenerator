package com.example.randomquotesgenerator;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {

    public static final String BASE_URL = "https://dummyjson.com/";
    private static ApiService apiService = null;

    public static ApiService getInstance() {

        if (apiService == null) {
            apiService = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                    .create(ApiService.class);
        }
        return apiService;
    }
}
