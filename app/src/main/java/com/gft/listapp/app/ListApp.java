package com.gft.listapp.app;

import android.app.Application;

import com.gft.listapp.data.repo.NewsRepository;
import com.gft.listapp.data.ws.RestApi;
import com.gft.listapp.data.ws.RestClient;

/**
 * Created by felip on 25/09/2017.
 */

public class ListApp extends Application {

    private static ListApp instance;

    private RestApi mRestApi;

    private NewsRepository mNewsRepository;

    public static ListApp getInstance() {
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        instance = this;

        mRestApi = new RestClient().getApi();

        mNewsRepository = new NewsRepository(getFilesDir(), getRestApi());

    }

    public RestApi getRestApi() {
        return mRestApi;
    }

    public NewsRepository getNewsRepository() {
        return mNewsRepository;
    }
}
