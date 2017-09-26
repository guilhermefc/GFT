package com.gft.listapp.data.ws;

import com.gft.listapp.data.model.News;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;

/**
 * Created by felipepadilha on 02/08/17.
 */
public interface RestApi {
    @GET("posts")
    Observable<List<News>> getNews();
}
