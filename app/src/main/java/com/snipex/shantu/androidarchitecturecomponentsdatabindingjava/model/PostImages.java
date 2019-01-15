package com.snipex.shantu.androidarchitecturecomponentsdatabindingjava.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PostImages {

    @SerializedName("thumbnail")
    @Expose
    private Thumbnail thumbnail;

    public Thumbnail getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(Thumbnail thumbnail) {
        this.thumbnail = thumbnail;
    }
}
