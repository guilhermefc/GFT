package com.gft.listapp.ui.splash;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.gft.listapp.ui.news.NewsActivity;

/**
 * Created by felipepadilha on 02/08/17.
 */
public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        startActivity(new Intent(this, NewsActivity.class));
        finish();
    }
}