package com.snipex.shantu.androidarchitecturecomponentsdatabindingjava;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.snipex.shantu.androidarchitecturecomponentsdatabindingjava.databinding.ActivityMainBinding;
import com.snipex.shantu.androidarchitecturecomponentsdatabindingjava.model.Post;
import com.snipex.shantu.androidarchitecturecomponentsdatabindingjava.response.PostResponse;
import com.snipex.shantu.androidarchitecturecomponentsdatabindingjava.response.UserResponse;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getSimpleName();
    ActivityMainBinding binding;
    RecyclerView recyclerView;
    PostAdapter postAdapter;
    ApiRequest apiRequest;
    ArrayList<Post> postArrayList = new ArrayList<Post>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        apiRequest = RetrofitRequest.getRetrofitInstance().create(ApiRequest.class);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        recyclerView = binding.recyclerViewPosts;
        recyclerView.setLayoutManager(new GridLayoutManager(this, 3));



        getUserData();

        getUsersMedia();
    }

    private void getUsersMedia() {
        apiRequest.getUserMediaData(getResources().getString(R.string.access_token_instagram)).enqueue(new Callback<PostResponse>() {

            @Override
            public void onResponse(Call<PostResponse> call, Response<PostResponse> response) {
                Log.d(TAG, " response getUsersMedia:: " + response.toString());
                if (response.body() != null) {
                    postArrayList = response.body().getPosts();

                    postAdapter = new PostAdapter(MainActivity.this,postArrayList);
                    recyclerView.setAdapter(postAdapter);

                    for(int i = 0; i<postArrayList.size(); i++){
                        Log.d(TAG, " post id:: " + postArrayList.get(i).getId());
                        Log.d(TAG, " likes:: " + postArrayList.get(i).getLikes().getCount());
                        Log.d(TAG, " imageURL:: " + postArrayList.get(i).getPostImages().getThumbnail().getImageUrl());

                    }
                }
            }

            @Override
            public void onFailure(Call<PostResponse> call, Throwable t) {
                Log.d(TAG, " response :: " + t);
            }
        });
    }

    private void getUserData() {
        apiRequest.getUserData(getResources().getString(R.string.access_token_instagram)).enqueue(new Callback<UserResponse>() {
            @Override
            public void onResponse(Call<UserResponse> call, Response<UserResponse> response) {
                Log.d(TAG, " response getUserData:: " + response.toString());
                if (response.body() != null) {
                    // bind user to data
                    binding.setUser(response.body().getUser());

                }

            }

            @Override
            public void onFailure(Call<UserResponse> call, Throwable t) {
                Log.d(TAG, " response :: " + t);
            }
        });


    }

   /* private ArrayList<Post> getPosts() {
        ArrayList<Post> posts = new ArrayList<>();
        for (int i = 1; i < 10; i++) {
            Post post = new Post();
            post.setImageUrl("https://api.androidhive.info/images/nature/" + i + ".jpg");

            posts.add(post);
        }

        return posts;
    }*/
}
