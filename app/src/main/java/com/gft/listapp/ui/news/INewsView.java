package com.gft.listapp.ui.news;

import com.gft.listapp.data.model.News;
import com.hannesdorfmann.mosby3.mvp.MvpView;

import java.util.List;

public interface INewsView extends MvpView {

    boolean hasInternetConnection();

    void showError();

    void fillNewsAdapter(List<News> news);

    void showLoading();
    void dismissLoading();
}
