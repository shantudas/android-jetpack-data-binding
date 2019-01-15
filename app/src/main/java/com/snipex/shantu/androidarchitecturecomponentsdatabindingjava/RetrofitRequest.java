package com.snipex.shantu.androidarchitecturecomponentsdatabindingjava;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitRequest {
    private static Retrofit retrofit;
    private static RetrofitRequest mInstance;
    private static final String BASE_URL = Constants.API_BASE_URL;

    private RetrofitRequest() {
        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public static synchronized RetrofitRequest getInstance() {
        if (mInstance == null) {
            mInstance = new RetrofitRequest();
        }
        return mInstance;
    }

    public ApiRequest getApi() {
        return retrofit.create(ApiRequest.class);
    }
}
