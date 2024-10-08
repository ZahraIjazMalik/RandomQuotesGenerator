package com.example.randomquotesgenerator;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {


    @GET("quotes/random")
    Call<QuotesItem> getQuotesItem();

}
