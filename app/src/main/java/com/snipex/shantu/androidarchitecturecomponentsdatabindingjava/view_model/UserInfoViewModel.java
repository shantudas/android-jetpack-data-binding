package com.snipex.shantu.androidarchitecturecomponentsdatabindingjava.view_model;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import com.snipex.shantu.androidarchitecturecomponentsdatabindingjava.Constants;
import com.snipex.shantu.androidarchitecturecomponentsdatabindingjava.repository.UserInfoRepository;
import com.snipex.shantu.androidarchitecturecomponentsdatabindingjava.response.UserResponse;

public class UserInfoViewModel extends AndroidViewModel {

    private static final String TAG = UserInfoViewModel.class.getSimpleName();
    private UserInfoRepository repository;
    private LiveData<UserResponse> userResponseLiveData;

    public UserInfoViewModel(@NonNull Application application) {
        super(application);

        repository = new UserInfoRepository();
        userResponseLiveData = repository.getUserInfodata(Constants.ACCESS_TOKEN);
    }

    public LiveData<UserResponse> getUserResponseLiveData() {
        return userResponseLiveData;
    }
}
