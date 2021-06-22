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
import edu.rit.connors.brandon.swcompanion.ui.core.models.ListItem;
import edu.rit.connors.brandon.swcompanion.ui.core.adapters.ListAdapter;
import edu.rit.connors.brandon.swcompanion.ui.core.models.NewsListItem;
import edu.rit.connors.brandon.swcompanion.ui.core.HttpRequestClient;

public class NewsListAdapter extends ListAdapter {

    public NewsListAdapter(Context context, ArrayList<ListItem> items) {
        super(context, items);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        // Create a new view.
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.news_list_item, viewGroup, false);

        return new NewsItemViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int position) {
        NewsItemViewHolder holder = (NewsItemViewHolder) viewHolder;
        NewsListItem item = (NewsListItem) items.get(position);
        HttpRequestClient client = HttpRequestClient.getInstance();

        client.loadImageView(item.getImgURL(),holder.getImageView());
        holder.getPrimaryTextView().setText(item.getTitle());
        holder.getBodyTextView().setText(item.getBodyText());
        holder.getAuthorTextView().setText(item.getAuthor());
        holder.getFooterTextView().setText(item.getFooterText());
        holder.itemView.setTag(position);
        holder.itemView.setOnClickListener(this);
    }
    public static class NewsItemViewHolder extends RecyclerView.ViewHolder {
        private final ImageView imageView;
        private final TextView primaryTextView;
        private final TextView bodyTextView;
        private final TextView authorTextView;
        private final TextView footerTextView;

        public NewsItemViewHolder(@NonNull View view) {
            super(view);
            imageView = view.findViewById(R.id.imageView);
            primaryTextView = view.findViewById(R.id.primaryTextView);
            bodyTextView = view.findViewById(R.id.bodyTextView);
            authorTextView = view.findViewById(R.id.authorTextView);
            footerTextView = view.findViewById(R.id.footerTextView);
        }

        public ImageView getImageView() {
            return imageView;
        }

        public TextView getPrimaryTextView() {
            return primaryTextView;
        }

        public TextView getBodyTextView() {
            return bodyTextView;
        }

        public TextView getFooterTextView() {
            return footerTextView;
        }

        public TextView getAuthorTextView() {
            return authorTextView;
        }
    }
}
