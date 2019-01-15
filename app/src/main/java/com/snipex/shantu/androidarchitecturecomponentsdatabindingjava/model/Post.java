package com.snipex.shantu.androidarchitecturecomponentsdatabindingjava.model;

import android.databinding.BindingAdapter;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Post {

    /*@SerializedName("url")
    @Expose
    private String imageUrl;

    @BindingAdapter("imageUrl")
    public static void loadImage(ImageView view, String imageUrl) {
        Glide.with(view.getContext())
                .load(imageUrl)
                .into(view);
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }*/


    /* for getting ID */
    @SerializedName("id")
    @Expose
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


    /* For Likes */
    @SerializedName("likes")
    @Expose
    private Likes likes;

    public Likes getLikes() {
        return likes;
    }

    public void setLikes(Likes likes) {
        this.likes = likes;
    }



    /* For Image url */
    @SerializedName("images")
    @Expose
    private PostImages postImages;

    public PostImages getPostImages() {
        return postImages;
    }

    public void setPostImages(PostImages postImages) {
        this.postImages = postImages;
    }
}
