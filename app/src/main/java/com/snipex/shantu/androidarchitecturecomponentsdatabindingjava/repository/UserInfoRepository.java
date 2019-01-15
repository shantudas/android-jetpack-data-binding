package com.snipex.shantu.androidarchitecturecomponentsdatabindingjava.repository;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;

import com.snipex.shantu.androidarchitecturecomponentsdatabindingjava.ApiRequest;
import com.snipex.shantu.androidarchitecturecomponentsdatabindingjava.RetrofitRequest;
import com.snipex.shantu.androidarchitecturecomponentsdatabindingjava.response.UserResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UserInfoRepository {

    private static final String TAG = UserInfoRepository.class.getSimpleName();
    private ApiRequest apiRequest;

    public UserInfoRepository() {
        apiRequest =RetrofitRequest.getInstance().getApi();
    }

    public LiveData<UserResponse> getUserInfodata(String access_token) {
        final MutableLiveData<UserResponse> data = new MutableLiveData<>();

        apiRequest.getUserData(access_token).enqueue(new Callback<UserResponse>() {
            @Override
            public void onResponse(Call<UserResponse> call, Response<UserResponse> response) {
                data.setValue(response.body());
            }

            @Override
            public void onFailure(Call<UserResponse> call, Throwable t) {

            }
        });

        return data;
    }
}
