package com.gft.listapp.data.repo;

import com.gft.listapp.data.ws.RestApi;

import java.io.File;

import io.rx_cache2.internal.RxCache;
import io.victoralbertos.jolyglot.GsonSpeaker;

public abstract class BaseRepository {

    final RestApi restApi;
    final Providers providers;

    BaseRepository(File cacheDir, RestApi restApi) {
        this.restApi = restApi;
        this.providers = new RxCache.Builder()
                .persistence(cacheDir, new GsonSpeaker())
                .using(Providers.class);
    }

}
