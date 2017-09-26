package com.gft.listapp.data.ws;

import com.gft.listapp.BuildConfig;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by felipepadilha on 02/08/17.
 */
public class RestClient {

    private RestApi api;

    private OkHttpClient httpClient;

    private Retrofit retrofitClient;

    public RestClient() {

        if (BuildConfig.DEBUG) {
            HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
            loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

            httpClient = new OkHttpClient.Builder()
                    //Http authorize interceptor
                    .addInterceptor(loggingInterceptor)
                    .build();
        } else {
            httpClient = new OkHttpClient.Builder()
                    .build();
        }

        Gson gson = new GsonBuilder()
                .create();

        retrofitClient = new Retrofit.Builder()
                .baseUrl(BuildConfig.HOST + "/")
                .client(httpClient)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();

        api = retrofitClient.create(RestApi.class);
    }

    public RestApi getApi() {
        return api;
    }

}
