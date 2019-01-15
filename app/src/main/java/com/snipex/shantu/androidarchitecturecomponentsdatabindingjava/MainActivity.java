package com.snipex.shantu.androidarchitecturecomponentsdatabindingjava;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.snipex.shantu.androidarchitecturecomponentsdatabindingjava.databinding.ActivityMainBinding;
import com.snipex.shantu.androidarchitecturecomponentsdatabindingjava.model.Post;
import com.snipex.shantu.androidarchitecturecomponentsdatabindingjava.response.PostResponse;
import com.snipex.shantu.androidarchitecturecomponentsdatabindingjava.response.UserResponse;
import com.snipex.shantu.androidarchitecturecomponentsdatabindingjava.view_model.PostViewModel;
import com.snipex.shantu.androidarchitecturecomponentsdatabindingjava.view_model.UserInfoViewModel;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getSimpleName();
    ActivityMainBinding binding;
    RecyclerView recyclerView;
    PostAdapter postAdapter;
    ArrayList<Post> postArrayList = new ArrayList<Post>();
    private UserInfoViewModel userInfoViewModel;
    private PostViewModel postViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initialization();

        getUserInfo();

        getUserPosts();

    }

    private void initialization() {
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        recyclerView = binding.recyclerViewPosts;
        recyclerView.setLayoutManager(new GridLayoutManager(this, 3));

        userInfoViewModel = ViewModelProviders.of(this).get(UserInfoViewModel.class);
        postViewModel = ViewModelProviders.of(this).get(PostViewModel.class);
    }

    private void getUserInfo() {
        userInfoViewModel.getUserResponseLiveData().observe(this, new Observer<UserResponse>() {
            @Override
            public void onChanged(@Nullable UserResponse userResponse) {
                if (userResponse != null) {
                    binding.setUser(userResponse.getUser());
                }
            }
        });
    }

    private void getUserPosts() {
        postViewModel.getPostResponseLiveData().observe(this, new Observer<PostResponse>() {
            @Override
            public void onChanged(@Nullable PostResponse postResponse) {
                if (postResponse != null) {
                    postArrayList = postResponse.getPosts();

                    postAdapter = new PostAdapter(MainActivity.this, postArrayList);
                    recyclerView.setAdapter(postAdapter);
                }
            }
        });
    }
}
