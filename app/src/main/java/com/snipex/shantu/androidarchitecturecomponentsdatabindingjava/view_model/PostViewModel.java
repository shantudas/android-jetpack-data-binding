package com.snipex.shantu.androidarchitecturecomponentsdatabindingjava.view_model;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import com.snipex.shantu.androidarchitecturecomponentsdatabindingjava.Constants;
import com.snipex.shantu.androidarchitecturecomponentsdatabindingjava.repository.PostRepository;
import com.snipex.shantu.androidarchitecturecomponentsdatabindingjava.response.PostResponse;

public class PostViewModel extends AndroidViewModel {

    private PostRepository repository;
    private LiveData<PostResponse> postResponseLiveData;

    public PostViewModel(@NonNull Application application) {
        super(application);
        repository = new PostRepository();
        postResponseLiveData = repository.getPostData(Constants.ACCESS_TOKEN);
    }

    public LiveData<PostResponse> getPostResponseLiveData() {
        return postResponseLiveData;
    }
}
