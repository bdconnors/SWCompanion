package edu.rit.connors.brandon.swcompanion.ui.news.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import edu.rit.connors.brandon.swcompanion.R;
import edu.rit.connors.brandon.swcompanion.adapters.SearchListAdapter;
import edu.rit.connors.brandon.swcompanion.models.NetworkItem;
import edu.rit.connors.brandon.swcompanion.adapters.NetworkListAdapter;
import edu.rit.connors.brandon.swcompanion.models.NewsNetworkItem;
import edu.rit.connors.brandon.swcompanion.util.HttpRequestClient;

public class NewsListAdapter extends NetworkListAdapter {
    public NewsListAdapter(Context context, ArrayList<NetworkItem> items) {
        super(context, items);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        // Create a new view.
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.search_list_item, viewGroup, false);

        return new SearchListAdapter.SearchItemViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int position) {
        NewsItemViewHolder holder = (NewsItemViewHolder) viewHolder;
        NewsNetworkItem item = (NewsNetworkItem) items.get(position);
        HttpRequestClient client = HttpRequestClient.getInstance(context);

        client.loadImageView(item.getImgURL(),holder.getImageView());
        holder.getPrimaryTextView().setText(item.getTitle());
        holder.getSecondaryTextView().setText(item.getSecondaryTitle());
        holder.getBodyTextView().setText(item.getContentBody());
        holder.itemView.setTag(position);
        holder.itemView.setOnClickListener(this);
    }
    public static class NewsItemViewHolder extends RecyclerView.ViewHolder {
        private final ImageView imageView;
        private final TextView primaryTextView;
        private final TextView secondaryTextView;
        private final TextView bodyTextView;

        public NewsItemViewHolder(@NonNull View view) {
            super(view);
            imageView = view.findViewById(R.id.imageView);
            primaryTextView = view.findViewById(R.id.primaryTextView);
            secondaryTextView = view.findViewById(R.id.secondaryTextView);
            bodyTextView = view.findViewById(R.id.bodyTextView);
        }

        public ImageView getImageView() {
            return imageView;
        }

        public TextView getPrimaryTextView() {
            return primaryTextView;
        }

        public TextView getSecondaryTextView() {
            return secondaryTextView;
        }

        public TextView getBodyTextView() {
            return bodyTextView;
        }
    }
}
