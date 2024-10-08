package com.example.randomquotesgenerator;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainViewModel extends ViewModel {

    private static final MutableLiveData<QuotesItem> _quoteData = new MutableLiveData<>();
    public LiveData<QuotesItem> quoteData = _quoteData;

    public void fetchQuote() {
        // Retrofit client se quote item ko fetch karne ka request banati hai.
        RetrofitClient.getInstance().getQuotesItem().enqueue(new Callback<QuotesItem>() {
            @Override
            public void onResponse(Call<QuotesItem> call, Response<QuotesItem> response) {
                if (response.isSuccessful() && response.body() != null) {
                    _quoteData.postValue(response.body());
                }
            }

            @Override
            public void onFailure(Call<QuotesItem> call, Throwable t) {

                Log.d("ViewModel", "Error fetching quote: " + t.getLocalizedMessage());
            }
        });
    }
}
