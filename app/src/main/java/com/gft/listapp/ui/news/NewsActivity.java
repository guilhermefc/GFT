package com.gft.listapp.ui.news;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.gft.listapp.R;
import com.gft.listapp.app.ListApp;
import com.gft.listapp.data.model.News;
import com.gft.listapp.ui.news.adapter.NewsAdapter;
import com.gft.listapp.utils.ConnectionUtils;
import com.hannesdorfmann.mosby3.mvp.MvpActivity;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by felip on 25/09/2017.
 */

public class NewsActivity extends MvpActivity<INewsView, NewsPresenter> implements INewsView {

    @BindView(R.id.errorMessage)
    TextView errorMessage;

    @BindView(R.id.progressBar)
    ProgressBar progressBar;

    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;

    @BindView(R.id.refresh)
    Button refresh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);

        ButterKnife.bind(this);

        setTitle(R.string.title_news);

        getPresenter().getNews();
    }

    @NonNull
    @Override
    public NewsPresenter createPresenter() {
        return new NewsPresenter(ListApp.getInstance().getNewsRepository());
    }

    @Override
    public boolean hasInternetConnection() {
        return ConnectionUtils.isOnline(this);
    }

    @Override
    public void showError() {
        progressBar.setVisibility(View.INVISIBLE);
        errorMessage.setVisibility(View.VISIBLE);
    }

    @Override
    public void fillNewsAdapter(List<News> news) {
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        recyclerView.setAdapter(new NewsAdapter(this, news));
    }

    @Override
    public void showLoading() {
        progressBar.setVisibility(View.VISIBLE);
        errorMessage.setVisibility(View.INVISIBLE);

        refresh.setEnabled(false);
    }

    @Override
    public void dismissLoading() {
        progressBar.setVisibility(View.INVISIBLE);

        refresh.setEnabled(true);
    }

    @OnClick(R.id.refresh)
    void onRefreshClick() {
        getPresenter().getNews();
    }
}
