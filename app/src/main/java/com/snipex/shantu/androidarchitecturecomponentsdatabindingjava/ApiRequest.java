package com.snipex.shantu.androidarchitecturecomponentsdatabindingjava;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiRequest {

    @GET("v1/users/self/")
    Call<UserResponse> getUserData(
            @Query("access_token") String query
    );
}
