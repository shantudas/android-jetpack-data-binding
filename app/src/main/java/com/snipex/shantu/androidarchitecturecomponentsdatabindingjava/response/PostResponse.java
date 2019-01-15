package com.snipex.shantu.androidarchitecturecomponentsdatabindingjava.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.snipex.shantu.androidarchitecturecomponentsdatabindingjava.model.Post;

import java.util.ArrayList;

public class PostResponse {

    @SerializedName("data")
    @Expose
    private ArrayList<Post> posts;

    public ArrayList<Post> getPosts() {
        return posts;
    }

    public void setPosts(ArrayList<Post> posts) {
        this.posts = posts;
    }
}








