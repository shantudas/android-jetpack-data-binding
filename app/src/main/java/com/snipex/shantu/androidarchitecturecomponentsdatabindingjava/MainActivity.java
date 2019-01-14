package com.snipex.shantu.androidarchitecturecomponentsdatabindingjava;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.snipex.shantu.androidarchitecturecomponentsdatabindingjava.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        User user = new User("Shantu", "Chandra", "Dash");
        binding.setUser(user);

    }
}
