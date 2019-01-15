package com.snipex.shantu.androidarchitecturecomponentsdatabindingjava.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.snipex.shantu.androidarchitecturecomponentsdatabindingjava.model.User;

public class UserResponse {

    @SerializedName("data")
    @Expose
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}

