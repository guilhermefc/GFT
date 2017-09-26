package com.gft.listapp.data.repo;

import com.gft.listapp.data.model.News;
import com.gft.listapp.data.ws.RestApi;

import java.io.File;
import java.util.List;

import io.reactivex.Observable;
import io.rx_cache2.EvictProvider;

/**
 * Created by felip on 25/09/2017.
 */

public class NewsRepository extends BaseRepository {

    public NewsRepository(File cacheDir, RestApi restApi) {
        super(cacheDir, restApi);
    }

    public Observable<List<News>> getNews(boolean evict) {
        return providers.getNews(
                restApi.getNews(),
                new EvictProvider(evict)
        );
    }
}
