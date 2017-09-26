package com.gft.listapp.ui.news.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.gft.listapp.R;
import com.gft.listapp.data.model.News;

import java.util.List;

/**
 * Created by felip on 25/09/2017.
 */

public class NewsAdapter extends RecyclerView.Adapter {
    private Context mContext;
    private final List<News> mNews;

    public NewsAdapter(Context context, List<News> news) {
        this.mNews = news;
        this.mContext = context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        return new NewsViewHolder(LayoutInflater.from(mContext)
                .inflate(R.layout.news_item, parent, false));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        ((NewsViewHolder) holder).bind(mNews.get(position));
    }

    @Override
    public int getItemCount() {
        return mNews.size();
    }

    class NewsViewHolder extends RecyclerView.ViewHolder {

        private final TextView id;
        private final TextView title;
        private final TextView body;

        public NewsViewHolder(View itemView) {
            super(itemView);

            id = itemView.findViewById(R.id.id);
            title = itemView.findViewById(R.id.title);
            body = itemView.findViewById(R.id.body);
        }

        public void bind(News news) {
            id.setText(String.valueOf(news.getId()));
            title.setText(news.getTitle());
            body.setText(news.getBody());
        }
    }
}
