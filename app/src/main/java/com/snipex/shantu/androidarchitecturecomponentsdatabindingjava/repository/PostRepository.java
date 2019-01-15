package com.snipex.shantu.androidarchitecturecomponentsdatabindingjava.repository;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;

import com.snipex.shantu.androidarchitecturecomponentsdatabindingjava.ApiRequest;
import com.snipex.shantu.androidarchitecturecomponentsdatabindingjava.RetrofitRequest;
import com.snipex.shantu.androidarchitecturecomponentsdatabindingjava.response.PostResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PostRepository {

    private static final String TAG = PostRepository.class.getSimpleName();
    private ApiRequest apiRequest;

    public PostRepository() {
        apiRequest =RetrofitRequest.getInstance().getApi();
    }

    public LiveData<PostResponse> getPostData(String access_token){
        final MutableLiveData<PostResponse> data = new MutableLiveData<>();

        apiRequest.getUserMediaData(access_token).enqueue(new Callback<PostResponse>() {
            @Override
            public void onResponse(Call<PostResponse> call, Response<PostResponse> response) {
                data.setValue(response.body());
            }

            @Override
            public void onFailure(Call<PostResponse> call, Throwable t) {

            }
        });

        return data;
    }
}
