package com.gft.listapp.ui.news;

import com.gft.listapp.data.model.News;
import com.gft.listapp.data.repo.NewsRepository;
import com.hannesdorfmann.mosby3.mvp.MvpBasePresenter;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

public class NewsPresenter extends MvpBasePresenter<INewsView> {

    private final NewsRepository mNewsRepository;

    public NewsPresenter(NewsRepository newsRepository) {
        this.mNewsRepository = newsRepository;
    }

    public void getNews() {
        if (isViewAttached()) getView().showLoading();
        mNewsRepository.getNews(getView().hasInternetConnection())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableObserver<List<News>>() {

                    @Override
                    public void onNext(List<News> news) {
                        if (isViewAttached()) {
                            getView().dismissLoading();
                            getView().fillNewsAdapter(news);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        if (isViewAttached()) {
                            getView().showError();
                        }
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
