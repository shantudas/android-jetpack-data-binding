package com.snipex.shantu.androidarchitecturecomponentsdatabindingjava;

import android.databinding.BindingAdapter;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class User {

    private String username;
    private String full_name;
    private String profile_picture;
    private String bio;
    private Counts counts;


    public User(String username, String full_name, String profile_picture, String bio) {
        this.username = username;
        this.full_name = full_name;
        this.profile_picture = profile_picture;
        this.bio = bio;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    public String getProfile_picture() {
        return profile_picture;
    }

    public void setProfile_picture(String profile_picture) {
        this.profile_picture = profile_picture;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public Counts getCounts() {
        return counts;
    }

    public void setCounts(Counts counts) {
        this.counts = counts;
    }

    @BindingAdapter("profile_picture")
    public static void loadImage(ImageView view, String profile_picture) {
        Glide.with(view.getContext())
                .load(profile_picture)
                .into(view);
    }


    public class Counts{
        private String media;
        private String follows;
        private String followed_by;

        public String getMedia() {
            return media;
        }

        public void setMedia(String media) {
            this.media = media;
        }

        public String getFollows() {
            return follows;
        }

        public void setFollows(String follows) {
            this.follows = follows;
        }

        public String getFollowed_by() {
            return followed_by;
        }

        public void setFollowed_by(String followed_by) {
            this.followed_by = followed_by;
        }
    }
}

