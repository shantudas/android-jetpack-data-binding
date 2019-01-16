package com.snipex.shantu.androidarchitecturecomponentsdatabindingjava.model;

import android.databinding.BindingAdapter;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Post {

    /*
     * This class is for getting a post of instagram
     *
     * */


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


    /**
     * This class is for getting Likes count
     */
    public class Likes {
        @SerializedName("count")
        @Expose
        private String count;

        public String getCount() {
            return count;
        }

        public void setCount(String count) {
            this.count = count;
        }
    }

    /*
     *   This class is for getting different size of images
     * */
    public class PostImages {
        /*
         *   This class is for getting different size of images
         *   There are three different size of images provide by instagram
         *   First, thumbnail height = 150, width = 150
         *   second, low resolution height = 320, width = 320
         *   third, standard resolution height = 640, width = 640
         *
         *   Here, in this project i used low resolution
         * */

        @SerializedName("low_resolution")
        @Expose
        private LowResolution lowResolution;

        public LowResolution getLowResolution() {
            return lowResolution;
        }

        public void setLowResolution(LowResolution lowResolution) {
            this.lowResolution = lowResolution;
        }

    }


}
