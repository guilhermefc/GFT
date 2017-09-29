package com.gft.listapp;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.List;

/**
 * Created by cleoir on 27/09/2017.
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

    private List<ListItem> listItems;
    private Context context;

    public MyAdapter(List<ListItem> listItems, Context context) {
        this.listItems = listItems;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        final ListItem listItem = listItems.get(position);

        holder.tvId.setText(listItem.getId());
        holder.tvTitulo.setText(listItem.getHead());
        holder.tvDesc.setText(listItem.getDesc());
    }

    @Override
    public int getItemCount() {
        return listItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView tvId;
        public TextView tvTitulo;
        public TextView tvDesc;

        public ViewHolder(View itemView) {
            super(itemView);

            tvId = (TextView) itemView.findViewById(R.id.tvId);
            tvTitulo = (TextView) itemView.findViewById(R.id.tvTitulo);
            tvDesc = (TextView) itemView.findViewById(R.id.tvDesc);

        }
    }

}