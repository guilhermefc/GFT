package com.gft.listapp.data.repo;

import com.gft.listapp.data.model.News;

import java.util.List;

import io.reactivex.Observable;
import io.rx_cache2.EvictProvider;

public interface Providers {
    Observable<List<News>> getNews(Observable<List<News>> apiRequest, EvictProvider evictProvider);
}
